#include <stdio.h>
#include <stdlib.h>
struct Product {
	char name[100];
	char description[200];
	float price;
};
struct Person {
	char name[100];
	int age;
};
struct Employee {
	char name[100];
	char position[50];
	int age;
};
void bai01() {
	struct Product iphone15;
	strcpy(iphone15.name, "iphone 15 128Gb 2024");
	strcpy(iphone15.description, "this is test iphone");
	iphone15.price = 812.36;

	struct Person* mrA;
	mrA = (struct Person*)malloc(sizeof(struct Person));
	strcpy(mrA->name, "Nguyen Van A");
	mrA->age = 20;
	//nhap so nguoi tu ban phim
	//tao ra 1 array co N nguoi nhap tu ban phim
	int numberOfPersons;
	int i;
	struct Person* persons;
	printf("Enter number of persons: ");scanf("%d", &numberOfPersons);
	persons = (struct Person*)malloc(numberOfPersons * sizeof(struct Person));
	for(i = 0; i < numberOfPersons; i++){
		struct Person* eachPerson = persons+i; 
		printf("Enter information for person %d ", i+1);
		printf("Enter name: ");scanf("%s", eachPerson->name);
		printf("Enter age : ");scanf("%d", &(eachPerson->age));
		printf("haha");
	}
	printf("output:\n");
	for(i = 0; i < numberOfPersons; i++){
		struct Person* eachPerson = persons+i; 
		printf("Name: %s, age = %d\n", eachPerson->name, eachPerson->age);
	}
}
int main(int argc, char *argv[]) {
	//bai01();
	struct Employee employee01;
	struct Employee employee02;
	employee01.age = 11;
	employee02 = employee01;//assign = clone
	employee01.age = 22;
	printf("employee02's age is : %d", employee02.age);//11

	struct Employee* employee03 = (struct Employee*)malloc(sizeof(struct Employee));
	struct Employee* employee04 = (struct Employee*)malloc(sizeof(struct Employee));
	employee03->age = 11;
	//employee04 = employee03;//reference 
	employee04 = memcpy(employee04, employee03, sizeof(struct Employee));
	employee03->age = 22;
	
	printf("employee04's age is : %d", employee04->age);
	
	return 0;
}
