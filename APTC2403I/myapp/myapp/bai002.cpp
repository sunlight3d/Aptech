#include <iostream>
using namespace std;

int main2(int argc, const char * argv[]) {
    int x, y, z;
    cout << "Enter x = ";
    cin >> x;
    cout << "Enter y = ";
    cin >> y;
    cout << "Enter z = ";
    cin >> z;
    
    int max = x;
    if(y > max) {
        max = y;
    }
    if(z > max) {
        max = z;
    }
    cout << "Max number is : ";
    cout << max;
    cout << endl;
    return 0;
}
