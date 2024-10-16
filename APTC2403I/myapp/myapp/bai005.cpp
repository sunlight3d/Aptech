//
//  bai005.cpp
//  myapp
//
//  Created by Nguyen Duc Hoang on 25/3/24.
//

#include <stdio.h>
#include <iostream>
using namespace std;

int main5() {
    int sum = 0;
    for (int i = 9; i <= 300; i++) {
        //cout << "i = "<< i << endl;
        //if(i % 7 == 0 && i % 63 != 0) {
        if(i % 2 == 0) {
            sum = sum + i;
        }
        
    }
    cout << "sum = "<<sum<<"\n";
    return 0;
}
