#include<iostream>
#include<string>
using namespace std;
void bai01() {
    string myString;
    cout<<"Enter your string: ";cin>>myString;
    //cout<<myString[0]<<", length = "<<myString.length()<<endl;
    //cout<<"haha";
    int numberOfVowers = 0;
    //for(int i = 0; i < myString.length(); i++){
    for (char temp : myString) { 
        //char temp = myString[i];
        if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o'|| temp == 'u'||
            temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O'|| temp == 'U') {
            numberOfVowers = numberOfVowers + 1;
            cout<<temp<<endl;
        }
    }
    cout<<"There are "<<numberOfVowers<<" vowels"<<endl;
}
void bai02() {
    string myString;
    cout<<"Enter your string: "<<endl;
    cin>>myString;
    //for(int i = 0; i < myString.length(); i++) {
    for(int i = myString.length() - 1; i >= 0 ; i--) {
        cout<<myString[i]<<endl;
    }
    
}
void bai03() {
    int someNumbers[6] = {10, 4, 5, 9, 2, 1};
    for(int i = 0; i < 5; i++){
        for(int j = i+1; j < 6; j++){
            if(someNumbers[i] > someNumbers[j]) {
                int temp = someNumbers[i];
                someNumbers[i] = someNumbers[j];
                someNumbers[j] = temp;
            }
        }
    }
    for(int i = 0; i < 6; i++){
        cout<<someNumbers[i]<<", "<<endl;
    }
}
int main() {
    //bai01();
    //bai02();
    bai03();
}