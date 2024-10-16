//
//  bai003.cpp
//  myapp
//
//  Created by Nguyen Duc Hoang on 25/3/24.
//

#include <stdio.h>
#include <iostream>
using namespace std;

int main3() {
    double weight, height, bmi;
    int gender; //1 male, 2 female
    cout << "Input gender(1 male, 0 female): ";
    cin >> gender;
    
    //input weight, height from keyboard
    cout << "Enter weight(kg): "; //50
    cin >> weight;
    
    cout << "Enter height(m): "; //1.65
    cin >> height;
    bmi = weight / (height * height);
    //su dung switch, if
    /*
    switch(gender) {
        case 0: // Female
            if(bmi <= 19) {
                printf("You are a little skinny\n");
            } else if(bmi > 19 && bmi <= 24) {
                printf("You are in good shape\n");
            } else if(bmi > 24) {
                printf("You are a little big\n");
            }
        case 1: // Male
                if(bmi <= 20) {
                    printf("You are a little skinny\n");
                } else if(bmi > 20 && bmi <= 25) {
                    printf("You are in good shape\n");
                } else if(bmi > 25) {
                    printf("You are a little big\n");
                }
            break;
        default:
            printf("Invalid gender\n");
            break;
    }
*/
    if(gender == 0) {
        if(bmi <= 19) {
            printf("You are a little skinny\n");
        } else if(bmi > 19 && bmi <= 24) {
            printf("You are in good shape\n");
        } else if(bmi > 24) {
            printf("You are a little big\n");
        }
    }else if(gender == 1) {
        if(bmi <= 20) {
            printf("You are a little skinny\n");
        } else if(bmi > 20 && bmi <= 25) {
            printf("You are in good shape\n");
        } else if(bmi > 25) {
            printf("You are a little big\n");
        }
    }else {
        printf("Invalid gender\n");
    }
       
    return 0;
}
