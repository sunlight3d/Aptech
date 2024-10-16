#include <stdio.h>
#include <ctype.h>  // Thư viện để dùng hàm tolower

int main() {
    char myString[100];  // Khai báo mảng ký tự với kích thước tối đa 100
    int numberOfVowels = 0;

    // Nhập chuỗi
    printf("Enter your string: ");
    scanf("%s", myString);  // Nhập chuỗi (không nhận khoảng trắng)

    // Lặp qua từng ký tự của chuỗi
    for (int i = 0; myString[i] != '\0'; i++) {  // Duyệt đến khi gặp ký tự null ('\0')
        char temp = myString[i];

        // Kiểm tra ký tự có phải là nguyên âm
        if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u' ||
            temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') {
            numberOfVowels++;
            printf("%c\n", temp);  // In ra nguyên âm
        }
    }

    // In ra số lượng nguyên âm
    printf("There are %d vowels.\n", numberOfVowels);

    return 0;
}
