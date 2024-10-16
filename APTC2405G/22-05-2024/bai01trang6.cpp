#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;
int main() {
    int a, b, c;//variable declarations
    int sum;
    cout << "Enter a = ";
    cin >> a;

    cout << "Enter b = ";
    cin >> b;

    cout << "Enter c = ";
    cin >> c;

    sum = a + b + c;
    cout << "Value of sum is: "<<sum;
    return 0;
}