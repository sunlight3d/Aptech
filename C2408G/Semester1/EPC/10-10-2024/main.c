#include <stdio.h>
#include <stdlib.h>
int sumArray(int *array, int size) {
	int i = 0;
	int sum = 0;
	for(i = 0; i < size; i++) {
		sum += *(array+i);
	}
	return sum;
}
void bai01(){
	int numberOfItems = 0;
	int i = 0;
	printf("enter number of items: ");scanf("%d", &numberOfItems);
	int *numbers = (int *)malloc(numberOfItems * sizeof(int *));
	for(i = 0; i < numberOfItems; i++) {
		printf("Enter element %d \n", i+1); scanf("%d", numbers+i);
	}
	printf("sum is : %d", sumArray(numbers, numberOfItems));
}
reverseArray(int* arr, int* temp, int size) {
	//int *temp = (int *)malloc(size * sizeof(int *));
	int i = 0;
	for(i = size - 1; i >= 0; i--) {
		int j = size - i - 1;
		*(temp + j) = *(arr + i);
	}
	printf("Result: \n");
	/*
	for(i = 0; i < size; i++) {
		printf("%d, ", *(temp+i));
	}
	*/
}
void printArray(int* inputArray, int size) {
	int i;
	for(i = 0; i < size; i++) {
		printf("%d, ", *(inputArray+i));
	}
}
void printString(char *str) {
    int i = 0;
    // Lặp qua từng ký tự của chuỗi cho đến khi gặp ký tự null ('\0')
    while (str[i] != '\0') {
        printf("%c", str[i]);  // In ra ký tự hiện tại
        i++;                   // Tăng chỉ số để duyệt ký tự tiếp theo
    }
    printf("\n");  // Xuống dòng sau khi in xong chuỗi
}
void bai02(){
	/*
	int *numbers = (int *)malloc(6 * sizeof(int *));
	*numbers = 3;
	*numbers = 6;
	*numbers = 9;
	*numbers = 10;
	*numbers = 12;
	*/
	int numbers[] = {3,6,9,10, 12, 13};
	int *result =  (int *)malloc(6 * sizeof(int *));
	reverseArray(&numbers,result, 6);
	
	printf("input: \n");
	printArray(&numbers, 6);
	printf("result: \n");
	printArray(result, 6);
	
}
int main() {
	//bai01();
	bai02();
	char name[] = "Hoang";
	printString(name);
	return 0;
}
