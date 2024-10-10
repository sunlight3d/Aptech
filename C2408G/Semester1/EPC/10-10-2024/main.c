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

int main() {
	int numberOfItems = 0;
	int i = 0;
	printf("enter number of items: ");scanf("%d", &numberOfItems);
	int *numbers = (int *)malloc(numberOfItems * sizeof(int *));
	for(i = 0; i < numberOfItems; i++) {
		printf("Enter element %d \n", i+1); scanf("%d", numbers+i);
	}
	printf("sum is : %d", sumArray(numbers, numberOfItems));
	return 0;
}
