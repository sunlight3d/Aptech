#include <iostream>
#include <vector>
#include <string>

using namespace std;

string calculate(int mark) {
    if (mark > 10 || mark < 0) {
        return "Invalid mark";
    } else if (mark <= 10 && mark >= 8) {
        return "Excellent";
    } else if (mark > 5 || mark < 8) {
        return "Normal";
    } else {
        return "Not good";
    }
}
int main()
{
    string result = calculate(9);    
    cout << result;
    cout << endl;
    //example of switch-case
    int choice = 0;
    cout << "Please choose 1 - 3: "; // Prompt the user for input
    cin >> choice; // Read user input into the choice variable
    switch (choice)
    {
        case 1:
            cout <<"You choose 1";
            break;
        case 2:
            cout <<"You choose 2";
            break;
        case 3:
            cout <<"You choose 3";
            break;    
    default:
        break;
    }
    return 0;
}