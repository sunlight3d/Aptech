#include <iostream>
#include <stdio.h>
#include <cstring> 
#include "validations.h"
//g++ bai02.cpp validations.cpp -o bai02
//linker
using namespace std;
#define MAX_NUMBER_OF_MOBILES 100

struct Mobile {
    char name[25]; //"samsung galaxy s23"=>18 character
    char manufacturer[25];
    int released_year;
    float price;
};

int main() {
    int numberOfMobiles = 0;
    Mobile mobiles[MAX_NUMBER_OF_MOBILES];
    while (numberOfMobiles <= 0 || numberOfMobiles > MAX_NUMBER_OF_MOBILES)
    {
        cout << "Enter number of mobiles: ";
        cin >> numberOfMobiles;
        cin.ignore();
        if (numberOfMobiles <= 0 || numberOfMobiles > MAX_NUMBER_OF_MOBILES)
        {
            cout << "Please enter positive number and <= "<<MAX_NUMBER_OF_MOBILES<<endl;
        }
    }
        cout <<"Start input data"<<endl;
    
    for(int i = 0; i < numberOfMobiles; i++) {
        Mobile newMobile;
        cout <<" Input data of mobile HAHA "<<i+1<<": "<<endl;
        cout << " Enter mobile's name: ";
        cin.getline(newMobile.name, 50);
        
        cout << " Enter manufacturer: ";
        cin.getline(newMobile.manufacturer, 100);
        
        /*
        newMobile.released_year = 0;
        while (newMobile.released_year < 1999)
        {
            cout << " Enter release year: ";
            cin>>newMobile.released_year;
            cin.ignore();    
            if(newMobile.released_year < 1999) {
                cout << "Released year must be >= 1999";
            }
        }
        */
       newMobile.released_year = 0;
        while (isInvalidReleaseYear(newMobile.released_year))
        {
            cout << " Enter release year: ";
            cin>>newMobile.released_year;
            cin.ignore();    
            if(isInvalidReleaseYear(newMobile.released_year)) {
                cout << "Released year must be >= 1999";
            }
        }       
        /*
        newMobile.price = 0;        
        while (newMobile.price < 500 || newMobile.price > 6000)
        {
            cout << " Enter price: ";
            cin>>newMobile.price;
            cin.ignore();    
            if(newMobile.price < 500 || newMobile.price > 6000) {
                cout << "Price must be >= 500 and <=6000";
            }
        }
        */             
       newMobile.price = 0;        
        while (isInvalidPrice(newMobile.price))
        {
            cout << " Enter price: ";
            cin>>newMobile.price;
            cin.ignore();    
            if(isInvalidPrice(newMobile.price)) {
                cout << "Price must be >= 500 and <=6000";
            }
        }   
        mobiles[i] = newMobile;        
    }
    for (int i = 0; i < numberOfMobiles; i++)
    {
        Mobile mobile = mobiles[i];
        cout <<"mobile "<<i+1<<": ";
        cout<<" Name: "<< mobile.name<<", ";
        cout<<" Manufacturer: "<< mobile.manufacturer<<", ";
        cout<<" Released year: "<< mobile.released_year<<", ";
        cout<<" Price: "<< mobile.price<<endl;        
    }
    
    return 0;
}   