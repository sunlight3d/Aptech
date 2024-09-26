#include <iostream>
#include <vector>
#include <string>

using namespace std;

int sum2Numbers(int x, int y) {
    return x + y;
}
/*Tinh tong hai so */
void sayHello(string message){
    cout<<"hello "<<message;
}
int main()
{
    int x = 100;
    cout << "hello  chao cac ban"<<endl;
    cout << "Gia tri cua x = "<<x<<endl;
    int a = 2;
    int b = 3;
    cout << "sum 2 numbers is: "<<sum2Numbers(a, b);
    cout << endl;
    sayHello("Hoang");
    return 0;
}
