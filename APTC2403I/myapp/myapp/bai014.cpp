#include <iostream>
#include <string>

using namespace std;

// Định nghĩa cấu trúc Sinh viên
struct Student {
    string name;
    double maths[5]; // Giả sử có 5 môn học
};

// Hàm nhập dữ liệu của sinh viên
void inputStudentData(Student& student) {
    cout << "Enter student name: ";
    cin >> student.name;
    cout << "Enter grades for 5 maths subjects: ";
    for (int i = 0; i < 5; ++i) {
        cin >> student.maths[i];
    }
}

// Hàm tính điểm trung bình của sinh viên
double calculateAverageGrade(const Student& student) {
    double total = 0;
    for (int i = 0; i < 5; ++i) {
        total += student.maths[i];
    }
    return total / 5;
}

// Hàm hiển thị kết quả của sinh viên
void displayStudentResult(const Student& student) {
    cout << "Student Name: " << student.name << endl;
    cout << "Maths Grades: ";
    for (int i = 0; i < 5; ++i) {
        cout << student.maths[i] << " ";
    }
    cout << endl;
}


int main() {
    Student student;

    // Nhập dữ liệu của sinh viên
    inputStudentData(student);

    // Tính điểm trung bình
    double averageGrade = calculateAverageGrade(student);

    // Hiển thị kết quả của sinh viên
    displayStudentResult(student);
    cout << "Average Grade: " << averageGrade << endl; // Thêm dòng này để hiển thị điểm trung bình

    return 0;
}
