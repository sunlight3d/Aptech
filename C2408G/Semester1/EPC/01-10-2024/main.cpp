#include <iostream>
#include <vector>
#include <string>

using namespace std;
void bai01() {
    int x, y;
    int result;
    char myoperator;
    printf("Enter x = "); scanf("%d", &x);
    printf("Enter y = "); scanf("%d", &y);
    
    printf("Which operator(+, -, x, :) ");
    //fflush(stdin);
    //myoperator = getchar();
    cin>>myoperator;
    switch (myoperator)
    {
    case '+':
        /* code */
        result = x + y;
        break;
    case '-':
        /* code */
        result = x - y;
        break;
    case 'x':
        /* code */
        result = x * y;
        break;
    case ':':
        /* code */
        result = x / y;
        break;
    default:
        printf("Please input +, -, x, :");
        break;
    }
    printf("Result is : %d", result);
}
void bai02() {
    int mark;
    
    while (true)
    {
        cout<<"Enter your mark: "<<endl;
        cin>>mark;
        /*
        if(mark < 0 || mark > 10) {
            cout << "Please enter a value from 0 to 10"<<endl;
        } else {
            break;
        }
        */
       if((mark >= 0 && mark <= 10)) {
            break;
       } else {
            cout << "Please enter a value from 0 to 10"<<endl;
       }
    }
    
    if(mark >= 9) {
        cout <<"Excellent";
    } else if(mark >= 8 && mark < 9) {
        cout << "Very good";
    } else if(mark >= 6.5 && mark < 8) {
        cout << "Good";
    } else if(mark >= 5.0 && mark < 6.5) {
        cout << "Medium";
    } else if(mark >= 3.5 && mark < 5.0) {
        cout << "Bad";
    } else if(mark < 3.5 ) {
        cout << "Very bad";
    }
}
void bai03(){
    cout<<"Mời bạn chọn món ăn:"<<endl;
    cout<<"1. Phở"<<endl;
    cout<<"2. Bún chả"<<endl;
    cout<<"3. Cơm tấm"<<endl;
    cout<<"4. Bánh mì"<<endl;
    cout<<"5. Thoát"<<endl;
    char choice;
    do {
        cout << "Enter your choice(1-4) : ";
        cin >> choice;
        if(choice == '5') {
            break;
        }
        switch (choice)
        {
        case '1':
            cout<<"Phở"<<endl;
            break;
        case '2':
            cout<<"Bún chả"<<endl;
            break;
        case '3':
            cout<<"Cơm tấm"<<endl;
            break;

        case '4':
            cout<<"Bánh mì"<<endl;
            break;
        default:
            break;
        }
    } while (true);
   
    
}
void bai04(){
    float km;
    float fare;

    do {
        printf("Nhập vào số km đã đi: ");
        scanf("%f", &km);

        if (km <= 0) {
            printf("Số km không hợp lệ. Vui lòng nhập lại.\n");
        }
    } while (km <= 0);

    if (km <= 1) {
        fare = 14000.0;
    } else if (km <= 5) {
        fare = 14000.0 + (km - 1) * 10000.0;
    } else {
        fare = 14000.0 + 4 * 10000.0 + (km - 5) * 8500.0;
    }

    printf("Số tiền phải trả: %.2f đồng\n", fare);
}
int main() {
    //bai01();
    // int a, b;
    // a = 9;
    // b = 2;
    // cout<<(float)a/(float)b;
    //bai02();
    //bai03();
    
}