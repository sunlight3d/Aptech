//
//  bai008.cpp
//  myapp
//
//  Created by Nguyen Duc Hoang on 25/3/24.
//

#include <stdio.h>
#include <iostream>
using namespace std;

int countDiv3(int arr[], int size) {
    int numberOfElements = 0;
    for (int i = 0; i < size; i++) {
        int item = arr[i];
        if(item % 3 == 0) {
            numberOfElements++;
        }
    }
    return numberOfElements;
}

int main8() {
    int arr[] = {1, 3, 5, 6, 9, 12, 15, 90, 111, 22};
    int x = countDiv3(arr, 10);
    cout << "there are "<<x<<" elements divisible by 3"<<endl;
    return 0;
}
