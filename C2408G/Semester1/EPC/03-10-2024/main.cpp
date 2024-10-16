#include<iostream>
#include "stdlib.h"
#include "stdio.h"
#include "string.h"
using namespace std;
void arrayExamples() {
int numbers[5] = {9, 3, 5, 6, 7};
    int x = numbers[0];
    cout <<  "element 1 is : "<<&x<<endl;

    float someFloats;
    cout<<"someFloats is: "<<&someFloats<<endl;

    int array1[3] = {3, 2, 4};
    int array2[3] = {4, 5, 6};
    //array1 = array2;
    for(int i = 0; i < 3; i ++){
        array1[i] = array2[i];
    }
    //nhap 5 phan tu tu ban phim, tim ra gia tri lon nhat, va tinh tong
    int someIntegers[5];
    int maxValue;
    int sum = 0;
    float average;
    //input
    for(int i = 0; i < 5; i++){
        cout<<"Enter element "<<i+1<<" : "<<endl;
        cin>>someIntegers[i];
    }
    //calculate sum, max
    maxValue = someIntegers[0];
    for(int i = 0; i < 5; i++){
        if(someIntegers[i] > maxValue) {
            maxValue = someIntegers[i];
        }
        //sum = sum + someIntegers[i];
        sum += someIntegers[i];
    }
    average = ((float)sum)/5;
    cout<<"max is : "<<maxValue<<endl;
    cout<<"sum is : "<<sum<<endl;
    cout<<"average is : "<<average<<endl;
    cout <<"End program"<<endl;
}
int main() {
    int i = 0;
    /*
    for(i = 0; i < 10; i++) {
       
        if(i == 4){
            //continue;
            //break;
            //exit(0);
        }
        printf("i = %d\n", i);
    }
    */
    //arrayExampl es();
    string name = "Hoang";
    cout<<name<<endl;
    char yourName[10];
    //yourName = "Hoang"; //cannot cast string to array of characters !
    //strcpy(yourName, "Henry");
    //cout<<yourName<<endl;
    string stringA = "Nguyen ";
    string stringB = "Van A";
    cout<<stringA+stringB<<endl;
    string stringX = "hello";
    string stringY = "hello";
    if(stringX == stringY) {
        cout <<"Equal.....";
    }
    cout<<"haha";
}
