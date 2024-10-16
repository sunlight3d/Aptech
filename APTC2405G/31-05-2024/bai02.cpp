#include <iostream>
#include<string.h>
using namespace std;
struct Person {    
    char name[25];
    char nationality[25];
    int birth_year; 
    float net_worth;
};
int main() {     
    Person* people[2];
    Person* mrHoang;
    mrHoang = new Person;
    //mrHoang->name = "Hoang";//chi lam duoc new name la string
    strcpy(mrHoang->name, "Hoang"); //string copy - strcpy
    strcpy(mrHoang->nationality, "Vietnam");
    mrHoang->birth_year = 2000;
    mrHoang->net_worth = 500000;

    Person* mrHuy = new Person;
    strcpy(mrHuy->name, "Hoang"); //string copy - strcpy
    strcpy(mrHuy->nationality, "US");
    mrHuy->birth_year = 2001;
    mrHuy->net_worth = 100000;

    people[0] = mrHoang;
    people[1] = mrHuy;
    Person* mrA = mrHoang;
    delete mrA;
    delete mrHoang; // Don't forget to delete allocated memory    
    delete mrHuy;
    return 0;    
}   