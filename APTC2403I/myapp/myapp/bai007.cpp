//
//  bai007.cpp
//  myapp
//
//  Created by Nguyen Duc Hoang on 25/3/24.
//

#include <stdio.h>
#include <iostream>
using namespace std;

int main7() {
    int age = 0;
    int numberOfAttempts = 0;
    while(true) {
        numberOfAttempts++;
        cout<<"Enter age:";
        cin >> age;
        if(age < 1 || age > 100) {
            
        } else {
            cout << "Your age is :"<<age<<endl;
        }
        cout<<"Number of attempts :" << numberOfAttempts<<endl;;
    }
    return 0;
}
