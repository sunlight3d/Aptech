//
//  bai011.cpp
//  myapp
//
//  Created by Nguyen Duc Hoang on 27/3/24.
//

#include <stdio.h>
#include <iostream>
using namespace std;
struct Triangle {
    int a,b, c;
    int isTriangle() {
        if(a < b + c && b < c + a && c < a + b) {
            return 1;
        }
        return 0;
    }
};

int main011() {
    Triangle triangleA;
    triangleA.a = 10;
    triangleA.b = 10000;
    triangleA.c = 15;
    if(triangleA.isTriangle() == 1) {
        cout << "is triangle";
    } else {
        cout << "NOT triangle";
    }
    cout << endl;
    return 0;
}
