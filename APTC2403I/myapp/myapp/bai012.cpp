//
//  bai012.cpp
//  myapp
//
//  Created by Nguyen Duc Hoang on 27/3/24.
//

#include <stdio.h>
#include <iostream>
using namespace std;
struct Student {
    char name[20];
    int eng; //English grade [0, 100]
    int maths; //maths grade [0, 100]
};
int main12() {
    Student* students = new Student[5];
    // For example, you can assign values to the fields of each student
    students[0].eng = 90;
    students[0].maths = 60;
    strcpy(students[0].name, "Hoang"); // Copy the string "Hoang" into students[0].name
    
    students[1].eng = 60;
    students[1].maths = 50;
    strcpy(students[1].name, "Jenny");
    
    students[2].eng = 50;
    students[2].maths = 40;
    strcpy(students[2].name, "Tonny");
    
    students[3].eng = 50;
    students[3].maths = 40;
    strcpy(students[3].name, "John");
    
    
    students[4].eng = 100;
    students[4].maths = 100;
    strcpy(students[4].name, "Marry");
    int max = 0;
    int min = 500;
    int numberOfStudents = 5;
    for(int i = 0; i < numberOfStudents; i++) {
        if(students[i].maths + students[i].eng > max) {
            max = students[i].maths + students[i].eng;
        }
        if(students[i].maths + students[i].eng < min) {
            min = students[i].maths + students[i].eng;
        }
    }
    cout << "max = " << max<< endl;
    cout << "min = " << min<< endl;
    
    for(int i = 0; i < numberOfStudents; i++) {
        if(students[i].maths + students[i].eng == max || students[i].maths + students[i].eng == min) {
            cout << "Student " << i + 1 << ":\n";
            cout << "Name: " << students[i].name << endl;
            cout << "English Grade: " << students[i].eng << endl;
            cout << "Math Grade: " << students[i].maths << endl;
            cout << endl;
        }
    }
    return 0;
}
