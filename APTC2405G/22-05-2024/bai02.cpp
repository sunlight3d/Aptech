#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;
int main() {
    int mark;
    cout << "enter mark = ";
    cin >> mark;
    if(mark > 8 && mark <=10) {
        cout << "Very good";
    } else if(mark <= 8 && mark > 5) {
        cout << "Good or normal";
    } else if(mark <= 5 && mark >=0) {
        cout << "Bad";
    } else {
        cout << "Invalid value";
    }
}