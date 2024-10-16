/*
void fun1(int n);
If 0<= n <= 9, function reads the number n, otherwise do nothing (4 points)
Example: n = 0 – print: zero, n = 1 – print: one, n = 2 – print: two…

void fun2(int n);
If n <100 function reads the number n. Otherwise do nothing. (4 points)
Example: n = 9 – print: nine, n=15 – print: fifteen, n = 25 – print: twenty five
Test your functions with the following main()
*/
#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;
void fun1(int n)
{
    int input[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    string ouput[10] = {"Zero",
                        "One",
                        "Two",
                        "Three",
                        "Four",
                        "Five",
                        "Six",
                        "Seven",
                        "Eight",
                        "Nine"};
    if (n >= 0 && n <= 9)
    {
        /*
        switch (n)
        {
        case 0:
            cout << "Zero";
            break;
        case 1:
            cout << "One";
            break;
        case 2:
            cout << "Two";
            break;
        case 3:
            cout << "Three";
            break;
        case 4:
            cout << "Four";
            break;
        case 5:
            cout << "Five";
            break;
        case 6:
            cout << "Six";
            break;
        case 7:
            cout << "Seven";
            break;
        case 8:
            cout << "Eight";
            break;        
        case 9:
            cout << "Nine";
            break;        
        default:
            break;
        }
        */
       cout << ouput[n];
    }
    //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
    //0 1 2 3 4 5 6 7 8 9 a b c d e f
}

void fun2(int n) {
    if (n >= 100 || n <= 0) {
        return;
    }

    // Arrays holding the string representation of numbers
    std::string ones[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    std::string teens[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    std::string tens[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    std::string result;

    if (n < 10) {
        result = ones[n];
    } else if (n < 20) {
        result = teens[n - 10];
    } else {
        result = tens[n / 10];
        if (n % 10 != 0) {
            result += " " + ones[n % 10];
        }
    }

    std::cout << result << std::endl;
}
int main() {
    //fun1(5);    
    fun2(23);
    return 0;
}