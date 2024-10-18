#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct {
	char name[20];
	char country[20];
	int birthyear;
	float mark;
} Student;
void displayStudents(Student *students, int numberOfStudents)
{
	int i;
	for (i = 0; i < numberOfStudents; i++)
	{
		Student *student = students + i;
		printf("Name: %s, country: %s, birth year : %d, mark : %f \n", 
				student->name,
				student->country,
				student->birthyear,
				student->mark
		);
	}
}
void sort(Student *students, int numberOfStudents) {
	int i,j;
	for (i = 0; i < numberOfStudents - 1; i++)
	{
		for (j = i + 1; j < numberOfStudents; j++)
		{
			bool condition = strcmp((students+i)->name, (students+j)->name) > 0;
			if(condition == true) {
				Student temp = *(students+i);
				*(students+i) = *(students+j);
				*(students+j) = temp;
			}
		}
	}
}
void menu()
{
	int choice = 0;
	int numberOfStudents = 0;
	Student *students = (Student *)malloc(100 * sizeof(Student));
	do
	{
		printf("Student management system\n");
		printf("1. Input students   |  2. Sort | 3. Display Students | 4. exit\n");
		printf("Enter your choice(1-4): ");
		scanf("%d", &choice);		
		int i = 0;
		switch (choice)
		{
		case 1:
			do
			{
				printf("Enter number of students: \n");
				scanf("%d", &numberOfStudents);
			} while (numberOfStudents < 0 || numberOfStudents > 100);
			for(i = 0; i < numberOfStudents; i++){
				Student* student = students + i;
				printf("Enter name: ");scanf(" %[^\n]", student->name);
				printf("Enter country: ");scanf(" %[^\n]", student->country);
				printf("Enter birthyear: ");scanf("%d", &(student->birthyear));
				printf("Enter mark: ");scanf("%f", &(student->mark));				
			}
			break;
		case 2:
			sort(students, numberOfStudents);
			break;
		case 3:
			displayStudents(students, numberOfStudents);
			break;
		default:
			if (choice < 0 || choice > 4)
			{
				printf("please choose 1-4\n");
				break;
			}
			break;
		}
	} while (choice != 4);
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
