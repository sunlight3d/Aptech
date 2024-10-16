#include <iostream>
#include <stdio.h>
#include <math.h>
using namespace std;
int main() { 
   // Khai báo và khởi tạo các biến
    float a = 10, b = 7, c = 15.75, d = 4, e = 2, f = 5.6;
    float z;

    // Thực hiện phép tính
    z = a * b + (c / d) - e * f;

    // In giá trị của z
    cout << "Giá trị của z là: " << z << endl;
    return 0;

}
