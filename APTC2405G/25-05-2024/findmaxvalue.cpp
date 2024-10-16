#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;
int main() {
    
    int a = 12;    
    int b = 16;
    int c = 11;
    int d = 6;
    int e = 9;
    int f = 22;
    int g = 33;
    int h = 34;


    int max = a;
    if (b > max) {
        max = b;
    }
    if(c > max) {
        max = c;
    }
    if(d > max) {
        max = d;
    }
    if(e > max) {
        max = e;
    }
    if(f > max) {
        max = f;
    }
    if(g > max) {
        max = g;
    }
    if(h > max) {
        max = h;
    }
    cout << "Max value is : "<<max<<endl;

    int someNumbers[8] = {12, 16, 11, 6, 9, 22,33, 34};
    //i: index, iterate
    for(int i = 0; i <= 7; i++) {
        //cout << "i = "<<i<<endl;
        //cout << "value is : "<<someNumbers[i] << endl;
        if(someNumbers[i] > max) {
            max = someNumbers[i];
        }
    }

    cout << "Max valueeee is : "<<max;
    return 0;
}