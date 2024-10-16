#include <stdio.h>
#include <stdlib.h>
void bai01(){
	char myString[100];  // Khai b�o m?ng k� t? c� k�ch thu?c 100

    // Nh?p chu?i t? b�n ph�m
    printf("Enter a string: ");
    gets(myString);  // S? d?ng gets d? nh?p c? d�ng

    // In ra chu?i v?a nh?p
    //printf("You entered: %s\n", myString);
    puts(myString);
    
    char firstName[100] = "Nguyen ";
    char lastName[100] = "Van A";
    puts(strcat(firstName, lastName));
    //"1" + "1" = "11"
    //"1" + 1 = 2
}
void bai02(){
	char str1[100];
	char str2[100];
	int i;
	//str1 = "john";
	strcpy(str1, "john");
	printf("Length of str1 is : %d", strlen(str1));
	//strcpy(str2, str1);
	for(i = 0; i < strlen(str1); i++) {
		printf(i == (strlen(str1) - 1) ? "%c" : "%c - ", str1[i]);
	} 
}
void listFruits(char fruits[10][100]) {
	
}
int main(int argc, char *argv[]) {
	//bai01();
	//bai02();
	char fruits[10][100];
	int i;
	strcpy(fruits[0], "Apple");
	strcpy(fruits[1], "Banana");
	strcpy(fruits[2], "Lemon");
	strcpy(fruits[3], "Orange");
	for(i = 0; i < strlen(fruits); i ++) {
		if(strlen(fruits[i]) < 2) {//check empty string 
			continue;
		}	
	}
	return 0;
}
