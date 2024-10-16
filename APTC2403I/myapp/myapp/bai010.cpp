//
//  bai010.cpp
//  myapp
//
//  Created by Nguyen Duc Hoang on 27/3/24.
//

#include <stdio.h>
#include <iostream>
using namespace std;

void partition(int arr[], int size, int pivot) {
    // Insert pivot into arr
    arr[size - 1] = pivot;

    // Sort arr in ascending order using bubble sort
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    // Print the sorted array
    cout << "Sorted Array: ";
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main010() {
    int arr[] = {5, 10, 30, 19, 28, 73, 6, 22, 11};
    
    int pivot = 0;
    cout << "Enter pivot = ";
    cin >> pivot;
    partition(arr, sizeof(arr) / sizeof(arr[0]), pivot);
    
    /*
    int leftArray[9]; // Maximum size would be the same as arr
    int rightArray[9]; // Maximum size would be the same as arr
    int pivot = 0;
    int leftIndex = 0;
    int rightIndex = 0;

    cout << "Enter pivot = ";
    cin >> pivot;

    // Iterate through the array and push elements into left or right array
    for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++) {
        if (arr[i] > pivot) {
            rightArray[rightIndex++] = arr[i]; // Push to rightArray
        } else {
            leftArray[leftIndex++] = arr[i]; // Push to leftArray
        }
    }

    // Print leftArray
    cout << "Left Array: ";
    for (int i = 0; i < leftIndex; i++) {
        cout << leftArray[i] << " ";
    }
    cout << endl;

    // Print rightArray
    cout << "Right Array: ";
    for (int i = 0; i < rightIndex; i++) {
        cout << rightArray[i] << " ";
    }
    cout << endl;
     */
    
    return 0;
}
