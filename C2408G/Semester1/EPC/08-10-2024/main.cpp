#include<iostream>


using namespace std;
extern "C" void bai01();

//overloading = same name, parameters differ    
void doSomething(float x) {
    x = 124;
}
void doSomething(int* x) {
    *x = 224;
}
void doSomething(int x, int y) {
    
}
// Hàm tính tổng hai số nguyên
int add(int a, int b) {
    return a + b;
}
void bai01(){
    int n; //nếu nhập số âm thì số đó = 0
    cout<<"Enter n = "<<endl;
    cin>>n;
    int *numbers = new int[n];
    int sum = 0;
    //float average = 0;
    float* average = new float(0);
    for(int i = 0; i < n; i++){
        cout<<"Enter value for "<<i+1<<endl;
        cin>>numbers[i];
        /*
        if(numbers[i] < 0) {
            numbers[i] = 0;
        }
        */
       numbers[i] = numbers[i] < 0 ? 0 : numbers[i]; //ternary 
        sum += *(numbers + i);
    }
    *average = (float)sum / (float)n;
    cout<<"Bigger than evarage"<<endl;
    for(int i = 0; i < n; i++){
        if(*(numbers + i) > *average){
            cout<<numbers[i]<<", ";
        }
    }
    cout<<"Average = "<<*average<<endl;
}

int main() {
    //call by value
    float x = 123;
    doSomething(x);
    cout<<x<<endl;
    //call by reference
    int y = 223;
    doSomething(&y);
    cout<<y<<endl;

    int (*sum1)(int, int);
    int (*sum2)(int, int);
    int (*sum3)(int, int);
    sum1 = &add;
    sum2 = &add;
    sum3 = &add;
    //sum1 = NULL;
    cout<<sum3(2,3)<<endl;
    cout<<sum1(2,3)<<endl;
    cout<<sum2(2,3)<<endl;
    bai01();
    return 0;
}