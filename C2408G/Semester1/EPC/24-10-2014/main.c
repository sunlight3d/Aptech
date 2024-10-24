#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
void question01() {
	char studentNumber[5];
	char fullName[100];

	strcpy(studentNumber, "A1234");	
	strcpy(fullName, "Nguyen Van A");
	printf("student's number is : %s, fullname is : %s \n", studentNumber, fullName);

	int n, i, m;
	int sumEvenNumbers = 0;
	int numberOfDoubleDigits = 0;
	int numberOfDivisors = 0;
	printf("Enter a number with 2 digits: ");scanf("%d", &n);
	for(i = 1; i <= n; i++) {
		//sumEvenNumbers += (i % 2 == 0) ? i : 0;		
		if(i % 2 == 0) {
			sumEvenNumbers = sumEvenNumbers + i;
		}
		if(i % 11 == 0) {
			printf("%d, ", i);
		}		
	}
	printf("Sum of even's numbers : %d \n", sumEvenNumbers);	
	do {
		printf("Enter m = "); scanf("%d", &m);
		if(m <= 0 || m >= n) {
			printf("Please enter  0 < m < n \n");
		}
	}while (m <= 0 || m >= n);
	//}while (!(m > 0 && m < n));
	for(i = 2; i <= m ; i ++) {
		if(m % i == 0 && n % i == 0) {
			printf("Divisor = %d \n", i);
			numberOfDivisors ++;
		}
	}
	printf("numberOfDivisors = %d", numberOfDivisors);
	float result = 0.0;
	for(i = 1 ; i <= n - m; i++) {
		result += pow(-1, i) /(float)(i);
	}
	printf("result = %f \n", result);
}
int main(int argc, char *argv[]) {
	question01();
	return 0;
}
