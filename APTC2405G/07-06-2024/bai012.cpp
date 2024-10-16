#include <iostream>
//#include <cstdio>
#include "stdio.h"
#include <cstring>
#include <map>

using namespace std;

const int CURRENT_YEAR = 2024;

struct Student {
    char name[20];
    char country[25];
    int birth_year;
    float mark;

    void display() {
        //string concatenation
        //%0.2f, lay 2 so sau dau phay, f = float
        //%d = decimal
        printf("name: %s, country: %s, mark: %.2f, birth_year: %d\n", name, country, mark, birth_year);
    }
};

void input(Student* students, int count) {
    for (int i = 0; i < count; i++) {
        printf("Enter details for student %d:\n", i+1);
        printf("Name: ");
        fgets(students[i].name, 20, stdin);
        students[i].name[strcspn(students[i].name, "\n")] = 0;  // Remove newline character after fgets

        printf("Country: ");
        fgets(students[i].country, 25, stdin);
        students[i].country[strcspn(students[i].country, "\n")] = 0;  // Remove newline character

        while (true) {
            printf("Enter birth year: ");
            scanf("%d", &students[i].birth_year);
            getchar();  // Consume newline character left by scanf

            int age = CURRENT_YEAR - students[i].birth_year;
            if (age < 6 || age > 18) {
                printf("Student age must be less than 18 and greater than 6 years old.\n");
            } else {
                break;
            }
        }

        while (true) {
            printf("Mark: ");
            scanf("%f", students[i].mark);//cin
            getchar();  // Consume newline character            

            if (students[i].mark < 0 || students[i].mark > 10) {
                printf("Student mark must be between 0 and 10.\n");
            } else {
                break;
            }
        }
    }
}

int main() {
    int numberOfStudents;
    printf("How many students: ");
    scanf("%d", &numberOfStudents);
    getchar();  // Consume newline character

    Student* students = new Student[numberOfStudents];
    input(students, numberOfStudents);
    
    for (int i = 0; i < numberOfStudents; i++) {
        students[i].display();
    }

    delete[] students;  // Clean up
    return 0;
}
