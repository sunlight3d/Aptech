#include <stdio.h>
#include <stdlib.h>
struct Course {
	char authorName[50];
	char courseName[100];
	unsigned int price;
	char address[150];
	char description[200];
	char startedDate[15];//yyyy-mm-dd
};
void inputCourses(struct Course* courses, int numberOfCourses) {
	int i;
	for(i = 0; i < numberOfCourses; i++) {
		printf("");
	}
}
void sort(struct Course* courses, int numberOfCourses) {

}
void menu() {
	printf("1. Enter detail courses \n");
	printf("2. Sort and show details \n");
	printf("3. Exit \n");
	int choice = 0;
	struct Course* courses = (struct Course*)malloc(100 * sizeof(struct Course));	
	int numberOfCourses = 0;	
	
	while (choice != 3)
	{
		printf("Enter your choice(1-3): \n");scanf("%d", &choice);
		switch (choice)
		{
		case 1:
			printf("Enter detail courses \n");			
			do {
				printf("Number of courses: ");scanf("%d", &numberOfCourses);
			}while (numberOfCourses > 100 || numberOfCourses < 0);
									
			inputCourses(courses, numberOfCourses);
			break;
		case 2:
			printf("Sort and show detail \n");
			break;
		default:
			if(choice < 1 || choice > 3) {
				printf("Please choose 1-3 to continue !\n");
			}
			break;
		}
	}
	
}

void showCourses(struct Course* courses, int numberOfItems) {
	int i;
	for(i = 0; i < numberOfItems; i++){
		struct Course* selectedCourse = courses+i;
		printf("Author's name: %s", selectedCourse->authorName);
		printf("course's name: %s", selectedCourse->courseName);
		printf("Price: %d", selectedCourse->price);
		printf("Address: %s", selectedCourse->address);
		printf("Description: %s", selectedCourse->description);
		printf("startedDate: %s", selectedCourse->startedDate);
	}
}
int main(int argc, char *argv[]) {
	menu();
	return 0;
}
