#include <stdio.h>
#include <stdlib.h>
struct Book {
	char title[100];
	char author[100];
	int publicationYear;
	float price;
};
void displayBook(struct Book book) {
	printf("Title : %s, ", book.title);
	printf("Title : %s, ", book.author);
	printf("Title : %d, ", book.publicationYear);
	printf("Title : %.2f, ", book.price);
}
int main(int argc, char *argv[]) {
	struct Book books[10]; 
	//struct Book *books = (struct Book *)malloc(10 * sizeof(struct Book));
	int choice = 0;
	do {
		printf("Add a new book");
		printf("Display all books");
		printf("Update book price by title");
		printf("Quit");
		switch (choice)
		{
		case 1:
			struct Book newBook;
			printf("Enter title : ");scanf(" %[^\n]", newBook.title); 
			printf("Enter author : ");scanf(" %[^\n]", newBook.author); 
			printf("Enter publicationYear : ");scanf("%d", newBook.publicationYear); 
			printf("Enter price : ");scanf("%f", newBook.price); 
			break;
		case 2:
			break;
		case 3:
			break;
		
		default:
			if(choice != 4) {
				printf("Please choose 1-4");
			}
			break;
		}

	}while(choice != 4);
	return 0;
}
