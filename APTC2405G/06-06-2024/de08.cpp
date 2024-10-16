#include <iostream>
#include<string.h>
#include <map>
using namespace std;
const int CURRENT_YEAR = 2024;

struct Product {    
    char name[20];
    char provider[25];
    int published_year; 
    float price;
    void display() {//method
        cout <<"name: "<< name<<", ";
        cout <<"provider: "<< provider<<", ";
        cout <<"price: "<< price<<", ";
        cout <<"birth_year: "<<published_year<<endl;
    }
};
struct KeyValuePair {
    char key[50];
    int value;
};
void save(Product* products, int count, const char* filename) {
    FILE* out = fopen(filename, "wb"); // Mở file với quyền ghi nhị phân
    if (out == NULL) {
        cout <<"Cannot open file for writing";
        return;
    }

    for (int i = 0; i < count; i++) {
        fwrite(&products[i], sizeof(Product), 1, out);
    }
    fclose(out); // Đóng file
}
void load(Product* products, const char *filename)
{
    FILE* inputFile = fopen(filename, "rb"); // Mở file với quyền đọc nhị phân
    if (inputFile == NULL)
    {
        cout <<" Cannot open file for reading";
        return;
    }

    // Định vị đến cuối file để xác định kích thước
    fseek(inputFile, 0, SEEK_END);
    long size = ftell(inputFile);
    int count = size / sizeof(Product);
    fseek(inputFile, 0, SEEK_SET); // Quay lại đầu file

    fread(products, sizeof(Product), count, inputFile);
    fclose(inputFile); // Đóng file
}
void input(Product* products, int count) {
    //Địa chỉ của mảng(list) là địa chỉ của phần tử đầu tiên trong mảng
    /**
     char name[20];
    char provider[25];
    int published_year; 
    float price;
    */
    for (int i = 0; i < count; i++) {
        cout << "Enter details for product " << i+1 << ":\n";
        //Product eachProduct = products[i];//assign
        Product* eachProduct = &products[i];//reference

        cout << "Name: ";        
        cin.getline(eachProduct->name, 25);        

        cout << "Provider: ";
        cin.getline(eachProduct->provider, 25);

        while (true)
        {
            cout << "Enter published year: ";
            cin >> eachProduct->published_year;
            cin.ignore();            
            if (CURRENT_YEAR - eachProduct->published_year > 10 || 
                CURRENT_YEAR - eachProduct->published_year < 0)
            {                
                cout << "Product publish year must less than 10 and greater than 0 ";
            }
            else
            {                
                break;
            }             
        }

        while (true)
        {
            cout << "Price: ";
            cin >> eachProduct->price;
            cin.ignore();

            if (eachProduct->price < 100 || eachProduct->price > 500)
            {
                cout << "Product price must less than 500 and greater than 100 ";
            }
            else
            {
                break;
            }
        }
        //products[i] = eachProduct;
    }
}

void sort(Product* products, int count) {    
    //đã sắp xếp thì phải "so sánh"
    //đã so sánh thì phải có tiêu chí(theo property nào)
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {
            //sắp xếp nổi bọt - bubble sort            
            if (products[i].price > products[j].price) {
                Product temp = products[i];
                products[i] = products[j];
                products[j] = temp;
            }
        }
    }
}
void display(Product* products, int count) {  
    sort(products, count);
    for (int i = 0; i < count; i++) {
        /*
        Product eachProduct = products[i];
        eachProduct.display();
        */
       products[i].display();
    }
}
void find(Product* products, int count) {  
    int min_value;
    char provider[25];
    cout << "Enter min (in billion USD): ";    
    cin >> min_value;
    cin.ignore();

    cout << "Provider: ";
    cin.getline(provider, 25);


    for (int i = 0; i < count; i++) {        
        Product eachProduct = products[i];        
        if(strcmp(eachProduct.provider, provider) == 0 && 
            eachProduct.price >= min_value) {
            eachProduct.display();            
        }
        
    }
}
void calculateFibonacy() {
    int n;
    cout << "n = "<<endl;
    cin >> n;
    cin.ignore();
    int x0 = 0;
    int x1 = 1;
    for(int i = 0; i < n; i++) {
        if(i > 1) {
            int sum = x0 + x1;
            x0 = x1;
            x1 = sum;
            cout << sum<<", ";
        } else {
            if(i == 1) {
                cout << x1<<", ";
            }
        }
    }
}
int main()
{

    int choice = 0;
    string answer = "";
    int numberOfProducts = 0;
    Product* products;
    Product *products2;
    char fileName[100];
    //bool hasChoose1 = false;
    calculateFibonacy();
    while (choice != 7)
    {
        cout << "+------------------------------------------------------------------+" << endl;
        cout << "| Product Mananagement System |" << endl;
        cout << "+------------------------------------------------------------------+" << endl;
        cout << "|1. Input product |2. Display product | 3. Save |4. Open |5. Exit |" << endl;
        cout << "+------------------------------------------------------------------+" << endl;
        cout << "Enter your choice(1-7):" << endl;
        cin >> choice;
        cin.ignore();
        
        switch (choice)
        {
        case 1:
            cout << "1. Input" << endl;
            cout<<"How many products: "<<endl;
            cin>>numberOfProducts;
            cin.ignore();
            //Tạo ra một mảng với numberOfProducts phần tử rỗng
            products = new Product[numberOfProducts];//địa chỉ đến phần tử đầu tiên trong mảng
            input(products, numberOfProducts);    
            display(products, numberOfProducts);  
            //hasChoose1 = true;
            break;
        case 2:
            cout << "2. Display" << endl;                        
            display(products, numberOfProducts);        

            break;
        
        case 3:
            
            cout << "3. Save" << endl;
            cout << "Enter file name: ";
            
            cin.getline(fileName, 100);
            save(products, numberOfProducts, fileName);
            break;
        case 4:
            cout << "4. Open" << endl;
            products2 = new Product[numberOfProducts];
            //products2 = (Product *)malloc(numberOfProducts * sizeof(Product));
            load(products2, fileName);   
            display(products2, numberOfProducts);           
            break;
        case 5:
            cout << "5. Exit" << endl;
            
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
       if (answer == "y" || answer == "Y") {
            // Tiếp tục thực hiện chương trình
            continue;
        } else if (answer == "n" || answer == "N") {
            // Thoát chương trình
            break;
        } else if (answer == "c" || answer == "C") {
            // Xóa màn hình
            system("cls");
        } else {
            // Thông báo khi nhập không hợp lệ
            cout << "Please enter y, n, c" << endl;
        }
        
    }
}