#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;
int main() {
    int a;
    cout <<"Enter number: "<<endl;
    cin >> a;
    //int firstNumber = 5;
    /*
    for(int i = 0; i < a; i++) {
        cout << 5 + i * 5 <<", ";
    }
    */
   int i = 0;
   while (i < a) {        
    if(i == a -1) {
        //last element
        cout << 5 + i * 5;
    } else {
        cout << 5 + i * 5 <<", ";
    }    
    i = i + 1;
   }
   
   
    return 0;
}