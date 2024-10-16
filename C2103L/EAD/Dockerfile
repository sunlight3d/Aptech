# Sử dụng image chứa Java và Maven để xây dựng dự án
FROM maven:3.8.4-openjdk-17 AS build

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép tệp pom.xml để tách lớp phụ thuộc
COPY shopapp/pom.xml .

# Tải các phụ thuộc của dự án
RUN mvn dependency:go-offline

# Sao chép mã nguồn dự án
COPY shopapp/src ./src

# Xây dựng dự án
RUN mvn package -DskipTests

# Sử dụng image OpenJDK chứa Java để chạy ứng dụng
#FROM openjdk:17-jre-slim

# Sao chép tệp .jar từ image build trước
COPY /app/target/shopapp-*.jar /app/shopapp.jar

# Chạy ứng dụng
CMD ["java", "-jar", "/app/shopapp.jar"]
