#include<iostream>
using namespace std;

void swap(int* x, int* y) {
    int temp = *x;
    *x = *y;
    *y = temp;
    cout<<"end swap"<<endl;
}
int main() {
    int* x = (int*)malloc(1 * sizeof(int));
    //int* x; //NULL or nil
    *x = 123;
    int y = 345;
    cout<<x<<endl;
    //int *x;

    //reference
    int* a = x;
    int* b = x;
    a = NULL;
    x = NULL;
    b = NULL;

    a = &y;
    b = &y;

    int* numbers = (int*)malloc(5 * sizeof(int)); //tạo ra 1 mảng chứa địa chỉ
    *numbers = 99;
    *(numbers+1) = 88;
    *(numbers+2) = 77;
    *(numbers+3) = 66;
    *(numbers+4) = 55;
    //int* xx = numbers+2;
    /*
    for(int i = 0; i < 5; i++){
        cout<<*(numbers + i)<<endl;
    }
    */
    for(int i = 4; i > 0; i--){
        cout<<*(numbers + i)<<endl;
    }
    //Tạo ra 1 mảng chứa giá trị, dùng con trỏ để duyệt
    float someFloats[5] = {1, 4, 6, 9, 8};
    for(int i = 0; i < 5; i++) {
        cout<<&someFloats[i]<<endl;
    }
    int number1 = 1;
    int number2 = 2;
    swap(&number1, &number2);
    cout<<number1<<"   =>   "<<number2<<endl;
    return 0;
}