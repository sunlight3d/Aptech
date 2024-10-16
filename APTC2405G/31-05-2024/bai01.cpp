#include <iostream>
using namespace std;
void doSomething(int x) {
    //call by value
    x = 999;
}

void doSomething2(int* x) {
    //call by reference using pointer
    *x = 999;
}

void swap2Numbers(int x, int y) {
    int z = x;
    x = y;
    y = z;
}

void swap2Numbers2(int* x, int* y) {
    int z = *x;
    *x = *y;
    *y = z;
}
int sum2Numbers(int *x, int *y) {
    return *x + *y;
}
int main() {                
    int* x = new int;
    *x = 123;

    cout << "x's value is :" << *x << endl; // Print the value of x
    //int x = 123;
    cout<<"x's value is :"<<*x;
    int a = 888;
    doSomething(a);
    cout << "a = " << a << endl; // Value remains unchanged outside the function
    
    cout<<"a = "<<a;
     int b = 111;
    doSomething2(&b);
    cout << "value of b = " << b << endl; // Value changes to 999 because the function modifies the memory directly

     int c = 10;
    int d = 11;
    swap2Numbers(c, d);
    cout << "c = " << c << endl; // c remains 10
    cout << "d = " << d << endl; // d remains 11

    int e = 10;
    int f = 11;
    swap2Numbers2(&e, &f);
    cout<<"e = "<<e<<endl;
    cout<<"f = "<<f<<endl;
    
    int g = 100;
    int h = 200;
    cout<<"sum of 100 and 200 is: "<<sum2Numbers(&g, &h);

    int *m = new int;
    int *n = new int;
    *m = 300;
    *n = 400;
    cout<<"sum of 300 and 400 is: "<<sum2Numbers(m, n);
    delete x; // Don't forget to delete allocated memory
    return 0;
}   