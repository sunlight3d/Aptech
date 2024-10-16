#include <iostream>
#include <stdio.h>
#include <math.h>
using namespace std;
//ham tinh tong 2 so
int sumTwoNumbers(int a, int b) {
    return a + b;
}
int minusTwoNumbers(int a, int b) {
    //input params
    return a - b;
}
void sayHello(string yourName) {
    //ham ko tra ve gia tri
    cout << "xin chao ban "<<yourName<<endl;    
}

float doSomething(float a, float b, char op) {
    //ham tra ve gia tri
    if(op == '+') {
        return a + b;
    } else if(op == '-') {
        return a - b;
    } else if(op == 'x') {
        return a * b;
    }  else if(op == ':') {
        /*
        if(b == 0) {
            return 0;
        }
        return a / b;        
        */
       return b == 0 ? 0 : a / b; //ternary
    }
    return 0;
}

int getMaxValue(int numbers[10]) {
    int maxValue = numbers[0];
     for(int i = 0; i < 10; i++) {
        if(numbers[i] > maxValue) {
            maxValue = numbers[i];
        }       
    }
    return maxValue;
}
bool checkPalindrome(string name) {
    int length = name.length();
    cout << "length = "<<length<<endl;
    for (int i = 0; i < length / 2; ++i) {
        if (name[i] != name[length - 1 - i]) {
            return false;
        }
    }
    return true;
}
int main() { 
    int numbers[10] = {5,10,6,22,9,4,1,30,21,10};    
    /*
    int maxValue = numbers[0];
    int minValue = numbers[0];
    for(int i = 0; i < 10; i++) {
        if(numbers[i] > maxValue) {
            maxValue = numbers[i];
        }
        if(numbers[i] < minValue) {
            minValue = numbers[i];
        }
    }
    cout<<"min value is: "<<minValue<<endl;
    cout<<"max value is: "<<maxValue<<endl;
    */
    cout <<"5 chia 0 = "<<doSomething(5, 0, ':')<< endl;
    cout<<"max value is: "<<getMaxValue(numbers)<<endl;
    cout << "sum of 3 and 5 is: "<< sumTwoNumbers(3, 5)<< endl;
    cout << "minus of 10 and 15 is: "<< minusTwoNumbers(10, 15)<< endl;
    cout <<"5 chia 3 = "<<doSomething(5, 3, ':')<< endl;
    cout <<"8 nhan 9 = "<<doSomething(8, 9, 'x')<< endl;
    cout <<"8 - 9 = "<<doSomething(8, 9, '-')<< endl;
    cout <<"8 + 9 = "<<doSomething(8, 9, '+')<< endl;
    sayHello("Hoang");
    //cout<<checkPalindrome("abccba")<<endl;
    //cout<<checkPalindrome("chaoban")<<endl;
    bool isPalindrome = checkPalindrome("abcba");
    if(isPalindrome == true) {
        cout <<"Day la xau doi xung";
    } else {
        cout <<"Day KO PHAI la xau doi xung";
    }

    return 0;

}