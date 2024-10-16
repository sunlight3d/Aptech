#include <iostream>
#include <stdio.h>
using namespace std;

struct Student {
    string name;
    //char name[200];
    int age;
    float score;
};
int main() {
    Student studentA;
    Student studentB;

    studentA.name = "Nguyen Van a";
    studentA.age = 20;
    studentA.score = 8.5;

    studentB.name = "Nguyen Van BB";
    studentB.age = 18;
    studentB.score = 9.0;

    cout << "StudentA' information: ";
    cout<<"name = "<<studentA.name<<",age = "<<studentA.age<<", score: "<<studentA.score<<endl;
    return 0;
}