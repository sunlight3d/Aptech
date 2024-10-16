#include <iostream>
#include<string.h>
using namespace std;
/*
typedef struct {
    char name[25];
    char nationality[25];
    int birth_year;
    float net_worth;
} Person;
*/
struct Person {    
    char name[25];
    char nationality[25];
    int birth_year; 
    float net_worth;
};
void input(Person* people, int count) {
    //Địa chỉ của mảng(list) là địa chỉ của phần tử đầu tiên trong mảng
    for (int i = 0; i < count; i++) {
        cout << "Enter details for person " << i+1 << ":\n";
        cout << "Name: ";        
        cin.getline(people[i].name, 25);        

        cout << "Nationality: ";
        cin.getline(people[i].nationality, 25);

        cout << "Birth Year: ";
        cin >> people[i].birth_year;
        cin.ignore();

        cout << "Net Worth (in USD): ";
        cin >> people[i].net_worth;
        cin.ignore();
    }
}
void sort(Person* people, int count) {    
    //đã sắp xếp thì phải "so sánh"
    //đã so sánh thì phải có tiêu chí(theo property nào)
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {
            //sắp xếp nổi bọt - bubble sort
            //if (people[i].net_worth < people[j].net_worth) {
            if (people[i].net_worth > people[j].net_worth) {
                Person temp = people[i];
                people[i] = people[j];
                people[j] = temp;
            }
        }
    }
}
int main()
{

    int choice = 0;
    string answer = "";
    int numberOfPeople;
    Person* people;
    //bool hasChoose1 = false;
    while (choice != 7)
    {
        cout << "+------------------------------------------------------------------+" << endl;
        cout << "| BILLIONAIRES PROFILE MANAGEMENT PROGRAM |" << endl;
        cout << "+------------------------------------------------------------------+" << endl;
        cout << "|1. Input |2. Sort |3. Analyze |4. Find |5. Save |6. Open |7. Exit |" << endl;
        cout << "+------------------------------------------------------------------+" << endl;
        cout << "Enter your choice(1-7):" << endl;
        cin >> choice;
        cin.ignore();
        
        switch (choice)
        {
        case 1:
            cout << "1. Input" << endl;
            cout<<"How many people: "<<endl;
            cin>>numberOfPeople;
            cin.ignore();
            //Tạo ra một mảng với numberOfPeople phần tử rỗng
            people = new Person[numberOfPeople];//địa chỉ đến phần tử đầu tiên trong mảng
            input(people, numberOfPeople);    
            //hasChoose1 = true;
            break;
        case 2:
            /*
            if(hasChoose1 == false) {
                break;
            }
            */
            cout << "2. Sort" << endl;
            if(people)
            sort(people, numberOfPeople);
            //lấy ra people truyền vào hàm sort
            break;
        case 3:
            cout << "3. Analyze" << endl;
            break;
        case 4:
            cout << "3. Find" << endl;
            break;
        case 5:
            cout << "5. Save" << endl;
            break;
        case 6:
            cout << "6. Open" << endl;
            break;
        case 7:
            cout << "7. Exit" << endl;
            break;
        default:
            break;
        }
        cout << "Do you want to continue ?" << endl;
        cout << "- Yes, I do. (press 'y', 'Y')" << endl;
        cout << "- No, I don't. (press 'n', 'N')" << endl;
        cout << "- Please clear the screen ! (press 'c', 'C')" << endl;
        cout << "Your choice:" << endl;
        getline(cin, answer);
        if (answer == "y" || answer == "Y")
        {
        }
        else if (answer == "n" || answer == "N")
        {
            break;
        }
        else if (answer == "c" || answer == "C")
        {
            // clear man hinh
        }
        else
        {
            cout << "Please enter y, n, c";
        }
    }
}