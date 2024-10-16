#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;
int main() {
    cout<<"Enter radius: ";
    float radius = 0.0;
    cin >> radius;
    float area = M_PI * radius * radius;
    float perimeter = M_PI * 2 * radius;
    //cout <<"Value of area is: "<<area;
    printf("Value of area is: %f", area);
    cout << "perimeter = "<<perimeter;
}
