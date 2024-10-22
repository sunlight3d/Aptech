#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void bai01() {
	FILE *file;
    char *buffer;
    long file_size;    
	int i;
	// Mở tệp văn bản cần đọc
    file = fopen("data.txt", "r");

    // Dịch chuyển con trỏ tệp đến cuối để lấy kích thước tệp
    fseek(file, 0, SEEK_END);
    file_size = ftell(file); // Lấy kích thước tệp
    rewind(file); // Đặt lại con trỏ tệp về đầu

    // Cấp phát bộ nhớ cho buffer đủ lớn để chứa toàn bộ nội dung tệp
    buffer = (char *)malloc(sizeof(char) * (file_size + 1)); // +1 để chứa ký tự null kết thúc chuỗi
    if (buffer == NULL) {
        printf("Không đủ bộ nhớ để cấp phát\n");
        fclose(file);
        return 1;
    }

    // Đọc nội dung tệp vào buffer
    fread(buffer, sizeof(char), file_size, file);
    // Thêm ký tự null ở cuối chuỗi để đảm bảo buffer là một chuỗi hợp lệ
    buffer[file_size] = '\0';

	//Data is in buffer
    // Đóng tệp và giải phóng bộ nhớ
	int numberOfWords = 0;
	int numberOfLines = 0;
	int numberOfCharacters = 0;
	for(i = 0; i <= strlen(buffer); i++){
		if(buffer[i] == 32) {
			numberOfWords += 1;
		} else if(buffer[i] == '\n' || buffer[i] == '\0') {
			numberOfLines += 1;
			numberOfWords += 1;
			printf("%c, ",buffer[i]);
		} else {
			numberOfCharacters += 1;
		}
	}
	printf("numberOfWords = %d, numberOfLines = %d, numberOfCharacters = %d", numberOfWords, numberOfLines, numberOfCharacters);
    fclose(file);
    free(buffer);
}
int main(int argc, char *argv[]) {
	bai01();
	return 0;
}
