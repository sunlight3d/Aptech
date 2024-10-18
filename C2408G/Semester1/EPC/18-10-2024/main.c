#include <stdio.h>
#include <stdlib.h>

typedef struct {
	char name[20];
	char country[20];
	char birthyear;
	float mark;
} Student;
void menu() {
	
	int choice = 0;
	do {
		printf("Student management system\n");
		printf("1. Input students   |2. Display Students | 3. exit\n");
		printf("Enter your choice(1,2,3): ");scanf("%d", &choice);
		switch (choice)
		{
		case 1:
			printf("You chose 1\n");
			break;
		case 2:
			printf("You chose 2\n");
			break;
		default:
			if(choice < 0 || choice > 3) {
				printf("please choose 1-3\n");
				break;
			}
			break;
		}
	}while (choice != 3);
	
	

}
void question01() {
	int number1 = 0;
	int number2 = 0;
	int i = 0;
	while (number1 >= number2)
	{
		printf("Enter number1 = ");scanf("%d", &number1);
		printf("Enter number2 = ");scanf("%d", &number2);
		if(number1 >= number2) {
			printf("number2 must be > number1");
		}
	}	
	//chac chan: number2 > number1
	int total = 0;
	int numberOfOdds = 0;
	for(i = number1; i <= number2; i++){
		//total += i;
		total = total + i;
		if(i % 2 != 0) {
			numberOfOdds += 1;
		}
	}
	printf("\nThe sum of numbers between %d and %d is: %d", number1, number2, total);
	printf("\nTotal count of odd numbers between %d and %d is: %d", number1, number2, numberOfOdds);	
}	
/*
void question02() {
	int numberOfIntegers = 5;
	int i;
	int* numbers = (int *) malloc(numberOfIntegers * sizeof(int));
	printf("Input 5 numbers : \n");
	for(i =0; i < numberOfIntegers; i++) {
		printf("Enter number %d : ", i+1);scanf("%d", numbers+i);
	}
	for(i = numberOfIntegers - 1; i >=0; i--) {
		printf("%d, ", *(numbers + i));
	}
}
*/
void question02() {
	int numberOfIntegers = 5;
	int i;
	int numbers[5];
	printf("Input 5 numbers : \n");
	for(i =0; i < numberOfIntegers; i++) {
		printf("Enter number %d : ", i+1);scanf("%d", &numbers[i]);
	}
	/*
	for(i = numberOfIntegers - 1; i >=0; i--) {
		printf("%d, ", numbers[i]);
	}
	*/
	for(i =0; i < numberOfIntegers; i++) {
		printf("%d, ", numbers[numberOfIntegers - 1 - i]);
	}
}

int main(int argc, char *argv[]) {
	//question01();
	//question02();
	menu();
	return 0;
}
