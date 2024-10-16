#include <iostream>
#include <string>
using namespace std;
int main() {
    float math_mark, physics, chemistry;//variables
    float sum, average;

    cout<<"Enter math: ";
    cin>>math_mark;

    cout<<"Enter physics: ";
    cin>>physics;

    cout<<"Enter chemistry: ";
    cin>>chemistry;

    sum = math_mark + physics + chemistry;
    average = sum / 3;
    cout <<"sum = "<<sum<<", and average = "<<average;

    //cout 
}