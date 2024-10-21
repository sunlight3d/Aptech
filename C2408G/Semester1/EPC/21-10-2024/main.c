#include <stdio.h>
#include <stdlib.h>
void bai01() {
	int numberOfItems, i;
	printf("Nhập số lượng số Fibonacci cần tạo: ");scanf("%d", &numberOfItems);
	int output[100];
	for(i = 0; i < numberOfItems; i++) {
		if(i == 0 || i == 1) {
			output[i] = i;
			printf("%d, ", i);
		} else {
			output[i] = output[i - 1] + output[i - 2];
			printf("%d, ", output[i]);
		}
	}
}
void bai02(char *inputString) {
	int i;
	char* t; // first copy the pointer to not change the original
    for (t = inputString; *t != '\0'; t++) {

    }
	strcpy(t, ".txt");
	printf(inputString);
}
int main(int argc, char *argv[]) {
	//bai01();
	char name[100]; 
	printf("Input string: ");scanf(" %[^\n]", name);
	bai02(name);	
	return 0;
}
