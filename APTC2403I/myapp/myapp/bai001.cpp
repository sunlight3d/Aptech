
#include <iostream>
using namespace std;

int main1(int argc, const char * argv[]) {
    int year = 0;
    cout << "Enter a year : ";
    cin >> year;
    if(year % 4 == 0 && year % 100 != 0 && year % 400 != 0) {
        cout << "This is a LEAP year";
    } else {
        cout << "This is NOT a LEAP year";
    }
    cout << endl;
    return 0;
}
