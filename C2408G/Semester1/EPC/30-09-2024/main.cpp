#include <iostream>
#include <vector>
#include <string>

using namespace std;
int main() {
    char gender = 'm';
    int age = 18;
    string name = "nguyen van a";
    //cout<<gender<<endl;
    cout<<"Name = "<<name<<",age = "<<age<<"gender = "<<gender<<endl;
    float x = 12.34;
    float y = 23.45;
    float result = x / y;
    //cout<<"result ="<<result<<endl;
    printf("result = %5.3f", result);
    float a;
    printf("Enter a = ");scanf("%f", &a);
    printf("a is : %f \n", a);
    printf("address of a is : %p \n", &a);
    printf("chu nay la gi \" %% \\n"); 
    return 0;
}