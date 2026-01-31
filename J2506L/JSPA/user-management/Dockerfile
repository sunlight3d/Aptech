#Stage 1: BUILD
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
#Tên stage là build → dùng lại ở stage sau, Không nên dùng image này để chạy app,Vì rất nặng (~600–700MB)
WORKDIR /app
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY src ./src
RUN mvn clean package -DskipTests
#Tạo file:target/your-app.jar, -DskipTests: Bỏ test khi build Docker,CI/CD thường test trước đó (GitHub Actions)
#Stage 2: RUN (Production Image)
FROM eclipse-temurin:21-jre 
#Chỉ có JRE(Java Runtime Environment), Không có Maven, không có compiler, Image nhẹ (~200MB)
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080 
#Copy jar đã build xong, Từ stage build
ENTRYPOINT ["java","-jar","app.jar"]
