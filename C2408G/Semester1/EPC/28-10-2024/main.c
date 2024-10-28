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
	printf("author : %s, ", book.author);
	printf("publicationYear : %d, ", book.publicationYear);
	printf("price : %.2f\n", book.price);
}
int main(int argc, char *argv[]) {
	struct Book books[10]; 
	//struct Book *books = (struct Book *)malloc(10 * sizeof(struct Book));	
	int currentIndex = 0;
	int choice = 0;
	int i;
	struct Book newBook;
	struct Book* foundBook;
	char title[100];			
	do {
		printf("1. Add a new book\n");
		printf("2. Display all books\n");
		printf("3. Update book price by title\n");
		printf("4. Quit\n");
		printf("Enter your choice(1-4) : \n");scanf("%d", &choice);
		switch (choice)
		{
		case 1:			
			printf("Enter title : ");scanf(" %[^\n]", newBook.title); 
			printf("Enter author : ");scanf(" %[^\n]", newBook.author); 
			printf("Enter publicationYear : ");scanf("%d", &newBook.publicationYear); 
			printf("Enter price : ");scanf("%f", &newBook.price); 
			books[currentIndex] = newBook;
			currentIndex++;
			break;
		case 2:
			for(i = 0; i < currentIndex; i++) {
				displayBook(books[i]);
			}
			
			break;
		case 3:
			//find a book with title(input from keyboard)			
			printf("which book do you like to search ?");scanf(" %[^\n]", title);
			for(i = 0; i < currentIndex; i++) {
				if(strcmp(books[i].title, title) == 0) {
					foundBook = &books[i];
					//update that book
					printf("Enter title : ");scanf(" %[^\n]", foundBook->title); 
					printf("Enter author : ");scanf(" %[^\n]", foundBook->author); 
					printf("Enter publicationYear : ");scanf("%d", &foundBook->publicationYear); 
					printf("Enter price : ");scanf("%f", &foundBook->price); 
				} 
			}

			//update that book
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
