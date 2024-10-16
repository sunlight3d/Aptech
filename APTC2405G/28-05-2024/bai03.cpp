/*
Question 03: Write a program to find length of a string using loop without using in-built library function strlen() in C programming. (6 points)

Example
Input
Input string: I love programming. I love Aptech.
Output
Length of string: 34
*/
#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;
int getStringLength(string sentence)
{
    int length = 0;
    for (int i = 0; sentence[i] != '\0'; i++)
    {
        length = length + 1;
        // length++;
        //cout << sentence[i] << endl;
    }
    return length;
}
int main() {
    string sentence;
    cout<<"Input string: ";
    int length;
    getline (cin, sentence);
    /*
    for (int i = 0; sentence[i] != '\0'; i++){
        length = length + 1;
        //length++;
        cout << sentence[i]<<endl;
    }
    */
    length = getStringLength(sentence);
    cout << "string's length is : "<<length;
    return 0;
}

