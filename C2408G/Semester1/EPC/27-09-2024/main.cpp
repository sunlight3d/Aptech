#include <iostream>
#include <vector>
#include <string>
#include "stdio.h"
#include "stdlib.h"

using namespace std;
void sayHello() {
    cout<<"Hello";
}
void checkOddEven() {
    int x, y;
    cout << "Enter x = "; cin>>x;
    if(x % 2 == 0) {
        cout <<"This is even";
    } else {
        cout <<"This is odd";
    }
}
int main() {
    int x = 10;
    //cout << "Hello World"<<endl;
    //cout << "x = "<<x;
    printf("Hello World\n");
    printf("x = %d", x);
    //Nhap 2 so a va b tu ban phim
    //tinh tong
    float a, b;
    //printf("enter a = "); scanf("%d", &a);
    cout << "Enter a: "<<endl;cin>>a;
    //printf("enter b = "); scanf("%d", &b);
    cout<<"Enter b: "<<endl; cin>>b;
    float sum = a + b;
    //printf("sum = %d", sum);
    cout<<"sum = "<<sum;
    int numberOfStudents = 20;
    //int number_of_students = 20;
    //sayHello();
    //checkOddEven();
    return 0;
}