#include <iostream>
#include <cstring>

using namespace std;

struct Student
{
    char name[100];
    int age;
    float gpa;

    void display()
    {
        cout << "Name: " << name
                  << ", Age: " << age
                  << ", GPA: " << gpa << endl;
    }
};

void displayStudent(Student *student)
{
    cout << "Name: " << student->name
              << ", Age: " << student->age
              << ", GPA: " << student->gpa << endl;
}
Student *findOldestStudent(Student *students, int count)
{            
    Student *oldestStudent = &students[0];//coi sinh viên đầu tiên là già nhất
    for (int i = 1; i < count; i++)
    {
        if (students[i].age > oldestStudent->age)
        {
            oldestStudent = &students[i];
        }
    }
    return oldestStudent;
}
float calculateAverageGPA(const Student *students, int count)
{
    if (count == 0) {
        return 0.0;
    }
        
    float sum = 0;
    for (int i = 0; i < count; i++)
    {
        //sum += students[i].gpa;
        sum = sum + students[i].gpa;
    }
    return sum / count;
}
int main() {
    Student students[5];
    int numberOfStudents = 0;
    int choice = 0;

    // Initialize choice
    cout << "1. Add a new student\n"
         << "2. Display student information\n"
         << "3. Find the oldest student\n"
         << "4. Calculate the average GPA\n"
         << "5. Quit\n";
    cout << "Enter your choice(1-5): ";
    cin >> choice;
    cin.ignore(); // to handle newline

    while (choice != 5) {
        switch (choice) {
        case 1:
            if (numberOfStudents < 5) {
                cout << "Enter name: ";
                cin.getline(students[numberOfStudents].name, 100);
                cout << "Enter age: ";
                cin >> students[numberOfStudents].age;
                cout << "Enter GPA: ";
                cin >> students[numberOfStudents].gpa;
                cin.ignore(); // to handle newline
                numberOfStudents++;
            } else {
                cout << "Array is full.\n";
            }
            break;
        case 2:
            for(int i = 0; i< numberOfStudents; i++) {
                displayStudent(&students[i]);
            }
            break;
        case 3:
            if (numberOfStudents > 0) {
                Student* oldestStudent = findOldestStudent(students, numberOfStudents);
                oldestStudent->display();
            } else {
                cout << "No students data available.\n";
            }
            break;
        case 4:
            if (numberOfStudents > 0) {
                float averageGPA = calculateAverageGPA(students, numberOfStudents);
                cout << "Average GPA: " << averageGPA << endl;
            } else {
                cout << "No students data available.\n";
            }
            break;
        case 5:
            cout << "Quitting...\n";
            break;
        default:
            cout << "Invalid option. Please try again.\n";
        }

        if (choice != 5) {
            cout << "Enter your choice(1-5): ";
            cin >> choice;
            cin.ignore(); // to handle newline
        }
    }

    return 0;
}