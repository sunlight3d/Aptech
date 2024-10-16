//
//  bai006.cpp
//  myapp
//
//  Created by Nguyen Duc Hoang on 25/3/24.
//

#include <stdio.h>
#include <iostream>
using namespace std;

int main6() {
    int min = 0;
    int max = 0;
    double average = 0.0;
    int sum = 0;
    int i = 0;
    while(true) {
        int x;
        cout<<"Enter a positive integer:";
        cin >> x;
        if(x <= 0) {
            break;
        } else {
            i = i + 1;
            sum = sum + x;
            if(x > max) {
                max = x;
            }
            if(x < min) {
                min = x;
            }
        }
    }
    average = sum / i;
    cout<<"min = "<<min<<", max = "<<max<<", average = "<< average<<"\n";
    return 0;
}

