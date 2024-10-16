#include <iostream>
#include <stdio.h>
#include <cstring> 
#include "validations.h"

//g++ bai02.cpp validations.cpp -o bai02
//linker
using namespace std;
int main() {    
    int i=5,j=2;
    if(++i>j++||i++>j++) 
        printf("%d",i+j);
    
    return 0;
}   