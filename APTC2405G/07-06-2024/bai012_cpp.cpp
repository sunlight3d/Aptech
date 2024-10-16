#include <iostream>
#include<string.h>
#include <map>
using namespace std;
const int CURRENT_YEAR = 2024;

struct Student {    
    char name[20];
    char country[25];
    int birth_year; 
    float mark;
    void display() {//method
        cout <<"name: "<< name<<", ";
        cout <<"country: "<< country<<", ";
        cout <<"mark: "<< mark<<", ";
        cout <<"birth_year: "<<birth_year<<endl;
    }
};
struct KeyValuePair {
    char key[50];
    int value;
};
void bai02() {
    int* someNumbers = new int[5]; 
    int* someNumbers2 = new int[5];
    cout << "Enter 5 numbers: " << endl;
    for (int i = 0; i < 5; i++) {
        cout<<"number "<<i+1<<endl;
        cin >> someNumbers[i];  
    }

    cout << "Reverse list number you inputted: ";
    for (int i = 4; i >= 0 ; i--) {
        //cout <<"i = "<<i<<endl;
        //cout << someNumbers[i] << " ";
        someNumbers2[4-i] = someNumbers[i];
    }
    for(int i = 0; i < 5; i++) {
        cout << someNumbers2[i] << " ";
    }
    cout << endl;

    delete[] someNumbers;  
    delete[] someNumbers2;  
}
void save(Student* students, int count, const char* filename) {
    FILE* out = fopen(filename, "wb"); // Mở file với quyền ghi nhị phân
    if (out == NULL) {
        cout <<"Cannot open file for writing";
        return;
    }

    for (int i = 0; i < count; i++) {
        fwrite(&students[i], sizeof(Student), 1, out);
    }
    fclose(out); // Đóng file
}
void load(Student* students, const char *filename)
{
    FILE* inputFile = fopen(filename, "rb"); // Mở file với quyền đọc nhị phân
    if (inputFile == NULL)
    {
        cout <<" Cannot open file for reading";
        return;
    }

    // Định vị đến cuối file để xác định kích thước
    fseek(inputFile, 0, SEEK_END);
    long size = ftell(inputFile);
    int count = size / sizeof(Student);
    fseek(inputFile, 0, SEEK_SET); // Quay lại đầu file

    fread(students, sizeof(Student), count, inputFile);
    fclose(inputFile); // Đóng file
}
void input(Student* students, int count) {

    for (int i = 0; i < count; i++) {
        cout << "Enter details for students " << i+1 << ":\n";
        Student* eachStudent = &students[i];//reference

        cout << "Name: ";        
        cin.getline(eachStudent->name, 25);        

        cout << "Provider: ";
        cin.getline(eachStudent->country, 25);

        while (true)
        {
            cout << "Enter birth year: ";
            cin >> eachStudent->birth_year;
            cin.ignore();            
            if (CURRENT_YEAR - eachStudent->birth_year > 18 && 
                CURRENT_YEAR - eachStudent->birth_year < 6)
            {                
                cout << " Student age must less than 18 years old and greater than 6 years old ";
            }
            else
            {                
                break;
            }             
        }

        while (true)
        {
            cout << "Mark: ";
            cin >> eachStudent->mark;
            cin.ignore();

            if (eachStudent->mark < 0 && eachStudent->mark > 10)
            {
                cout << " Student mark must less than 10 and greater than 0  ";
            }
            else
            {
                break;
            }
        }
        //students[i] = eachStudent;
    }
}

void sort(Student* students, int count) {    
    //đã sắp xếp thì phải "so sánh"
    //đã so sánh thì phải có tiêu chí(theo property nào)
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {
            //sắp xếp nổi bọt - bubble sort               
            if(strcmp(students[i].name, students[j].name) > 0) {
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
    }
}
void display(Student* students, int count) {  
    sort(students, count);
    for (int i = 0; i < count; i++) {
        /*
        Student eachStudent = students[i];
        eachStudent.display();
        */
       students[i].display();
    }
}
void find(Student* students, int count) {  
    int min_value;
    char country[25];
    cout << "Enter min (in billion USD): ";    
    cin >> min_value;
    cin.ignore();

    cout << "Provider: ";
    cin.getline(country, 25);


    for (int i = 0; i < count; i++) {        
        Student eachStudent = students[i];        
        if(strcmp(eachStudent.country, country) == 0 && 
            eachStudent.mark >= min_value) {
            eachStudent.display();            
        }
        
    }
}

int main()
{

    int choice = 0;
    string answer = "";
    int numberOfStudents = 0;
    Student* students;
    Student *students2;
    char fileName[100];
    //bool hasChoose1 = false;
    bai02();
    while (choice != 7)
    {
        cout << "+------------------------------------------------------------------+" << endl;
        cout << "| Student Mananagement System |" << endl;
        cout << "+------------------------------------------------------------------+" << endl;
        cout << "|1. Input students |2. Display students | 3. Save |4. Open |5. Exit |" << endl;
        cout << "+------------------------------------------------------------------+" << endl;
        cout << "Enter your choice(1-7):" << endl;
        cin >> choice;
        cin.ignore();
        
        switch (choice)
        {
        case 1:
            cout << "1. Input" << endl;
            cout<<"How many students: "<<endl;
            cin>>numberOfStudents;
            cin.ignore();
            //Tạo ra một mảng với numberOfStudents phần tử rỗng
            students = new Student[numberOfStudents];//địa chỉ đến phần tử đầu tiên trong mảng
            input(students, numberOfStudents);    
            display(students, numberOfStudents);  
            //hasChoose1 = true;
            break;
        case 2:
            cout << "2. Display" << endl;                        
            display(students, numberOfStudents);        

            break;
        
        case 3:
            
            cout << "3. Save" << endl;
            cout << "Enter file name: ";
            
            cin.getline(fileName, 100);
            save(students, numberOfStudents, fileName);
            break;
        case 4:
            cout << "4. Open" << endl;
            students2 = new Student[numberOfStudents];
            //students2 = (Student *)malloc(numberOfStudents * sizeof(Student));
            load(students2, fileName);   
            display(students2, numberOfStudents);           
            break;
        case 5:
            cout << "5. Exit" << endl;
            delete[] students2;  
            delete[] students;  //Garbage Collections
            break;
        default:
            break;
        }
        cout << "Do you want to continue ?" << endl;
        cout << "- Yes, I do. (press 'y', 'Y')" << endl;
        cout << "- No, I don't. (press 'n', 'N')" << endl;
        cout << "- Please clear the screen ! (press 'c', 'C')" << endl;
        cout << "Your choice:" << endl;
        getline(cin, answer);
       if (answer == "y" || answer == "Y") {
            // Tiếp tục thực hiện chương trình
            continue;
        } else if (answer == "n" || answer == "N") {
            // Thoát chương trình
            break;
        } else if (answer == "c" || answer == "C") {
            // Xóa màn hình
            system("cls");
        } else {
            // Thông báo khi nhập không hợp lệ
            cout << "Please enter y, n, c" << endl;
        }
        
    }
}