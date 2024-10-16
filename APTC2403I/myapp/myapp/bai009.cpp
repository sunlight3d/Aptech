//
//  bai009.cpp
//  myapp
//
//  Created by Nguyen Duc Hoang on 27/3/24.
//

#include <stdio.h>
#include <iostream>
using namespace std;


int main9() {
    const int N = 5;
    int multiply1 = 1;
    int multiply2 = 1;
    
    int arr[N][N] = {
            {1, 2, 3, 4, 80},
            {5, 6, 7, 8, 7},
            {9, 10, 11, 12, 9},
            {13, 14, 15, 16, 2},
            {34, 24, 90, 17, 23},
        };
    
        // Print the array
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                //cout << "i = "<<i<<",j = "<<j<<" => "<<arr[i][j] << " ";
                if(i == j) {
                    multiply1 = multiply1 * arr[i][j];
                } else if(i + j == N - 1) {
                    multiply2 = multiply2 * arr[i][j];
                }
            }
        }
    cout << "Multiply1 = "<<multiply1<<endl;
    cout << "Multiply2 = "<<multiply2<<endl;
    return 0;
}
