#include <iostream>
#include<string.h>
using namespace std;
const int CURRENT_YEAR = 2024;
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
    void display() {//method
        cout <<"name: "<< name<<", ";
        cout <<"nationality: "<< nationality<<", ";
        cout <<"net_worth: "<< net_worth<<", ";
        cout <<"birth_year: "<<birth_year<<endl;
    }
};
void save(Person* people, int count, const char* filename) {
    FILE* out = fopen(filename, "wb"); // Mở file với quyền ghi nhị phân
    if (out == NULL) {
        cout <<"Cannot open file for writing";
        return;
    }

    for (int i = 0; i < count; i++) {
        fwrite(&people[i], sizeof(Person), 1, out);
    }
    fclose(out); // Đóng file
}
void input(Person* people, int count) {
    //Địa chỉ của mảng(list) là địa chỉ của phần tử đầu tiên trong mảng
    for (int i = 0; i < count; i++) {
        cout << "Enter details for person " << i+1 << ":\n";
        cout << "Name: ";        
        cin.getline(people[i].name, 25);        

        cout << "Nationality: ";
        cin.getline(people[i].nationality, 25);

        while (true)
        {
            cout << "Birth Year: ";
            cin >> people[i].birth_year;
            cin.ignore();

            int age = CURRENT_YEAR - people[i].birth_year;
            if (age <= 30)
            {                
                cout << "Person age must be greater than 30 in the current year.";
            }
            else
            {                
                break;
            }             
        }

        while (true)
        {
            cout << "Net Worth (in billion USD): ";
            cin >> people[i].net_worth;
            cin.ignore();

            if (people[i].net_worth < 1 || people[i].net_worth > 100)
            {
                cout << "Net worth must be between 1 (billion USD) and 100 (billion USD).";
            }
            else
            {
                break;
            }
        }
    }
}
void sort(Person* people, int count) {    
    //đã sắp xếp thì phải "so sánh"
    //đã so sánh thì phải có tiêu chí(theo property nào)
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {
            //sắp xếp nổi bọt - bubble sort
            //if (people[i].net_worth < people[j].net_worth) {
            //sap xep theo age;    
            int age1 = CURRENT_YEAR - people[i].birth_year;
            int age2 = CURRENT_YEAR - people[j].birth_year;
            if (age1 > age2) {
                Person temp = people[i];
                people[i] = people[j];
                people[j] = temp;
            }
        }
    }
}
void display(Person* people, int count) {  
    for (int i = 0; i < count; i++) {
        /*
        Person eachPerson = people[i];
        eachPerson.display();
        */
       people[i].display();
    }
}
void find(Person* people, int count) {  
    int min_value;
    char nationality[25];
    cout << "Enter min (in billion USD): ";    
    cin >> min_value;
    cin.ignore();

    cout << "Nationality: ";
    cin.getline(nationality, 25);


    for (int i = 0; i < count; i++) {        
        Person eachPerson = people[i];        
        if(strcmp(eachPerson.nationality, nationality) == 0 && 
            eachPerson.net_worth >= min_value) {
            eachPerson.display();
            /*    
            cout <<"name: "<< eachPerson.name<<", ";
            cout <<"nationality: "<< eachPerson.nationality<<", ";
            cout <<"net_worth: "<< eachPerson.net_worth<<", ";
            cout <<"birth_year: "<< eachPerson.birth_year<<endl;
            */
        }
        
    }
}
int main()
{

    int choice = 0;
    string answer = "";
    int numberOfPeople;
    Person* people;
    char fileName[100];
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
            display(people, numberOfPeople);  
            //hasChoose1 = true;
            break;
        case 2:
            /*
            if(hasChoose1 == false) {
                break;
            }
            */
            cout << "2. Sort" << endl;            
            sort(people, numberOfPeople);      
            display(people, numberOfPeople);        
            //lấy ra people truyền vào hàm sort
            break;
        case 3:
            cout << "3. Analyze" << endl;
            break;
        case 4:
            cout << "3. Find" << endl;
            find(people, numberOfPeople);      
            break;
        case 5:
            
            cout << "5. Save" << endl;
            cout << "Enter file name: ";
            
            cin.getline(fileName, 100);
            save(people, numberOfPeople, fileName);
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