#include <stdio.h>
#include <stdlib.h>
// Định nghĩa struct lưu trữ thông tin sách với typedef
typedef struct {
    char title[100];       // Tiêu đề sách
    char author[50];       // Tác giả
    int publicationYear;   // Năm xuất bản
	float price;
} Book;
//function with parameter as a struct / (pointer to a struct)
void inputBooks(Book* books, int numberOfBooks){
	int i = 0;
	for(i = 0; i < numberOfBooks; i++) {
		Book* eachBook = (books+i);
		printf("Enter title: ");;
		// Dùng scanf để nhập chuỗi cho title
   		 scanf(" %[^\n]", eachBook->title); 
		
		
		printf("Enter author: ");
		scanf(" %[^\n]", eachBook->author); 

		printf("Enter publicationYear: ");scanf("%d", &(eachBook->publicationYear));

		printf("Enter price: ");scanf("%f", &(eachBook->price));
	}
}
void printBooks(Book* books, int numberOfBooks) {
	int i = 0;
	for(i = 0; i < numberOfBooks; i++) {
		Book* eachBook = (books+i);
		printf("Title: %s, ", eachBook->title);
		printf("author: %s, ", eachBook->author);
		printf("publicationYear: %d, ", eachBook->publicationYear);
		printf("price: %f \n", eachBook->price);
	}
}
void sort(Book *books, int numberOfBooks)
{
	int i, j;
	for (i = 0; i < numberOfBooks - 1; i++)
	{
		for (j = i + 1; j < numberOfBooks; j++)
		{
			//Book* book1 = (books+i);//not work
			//Book* book2 = (books+j);//not work			
			//compare and swap
			if((books+i)->publicationYear < (books+j)->publicationYear) {				
				/*
				Book* temp = book1;
				book1 = book2;
				book2 = temp;
				*/
				Book temp = *(books+i);
				*(books+i) = *(books+j);
				*(books+j) = temp;
			}
		}
	}
}
int main(int argc, char *argv[]) {
	int numberOfBooks;
	printf("How many books? : "); scanf("%d", &numberOfBooks);
	Book *books;

	books = (Book*)malloc(numberOfBooks * sizeof(Book));
	inputBooks(books, numberOfBooks);
	printf("Before sorting\n");
	printBooks(books, numberOfBooks);
	printf("after sorting\n");
	sort(books, numberOfBooks);
	printBooks(books, numberOfBooks);
	return 0;
}
