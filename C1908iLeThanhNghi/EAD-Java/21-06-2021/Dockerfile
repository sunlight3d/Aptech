#Dockerfile de tao ra image rieng tu cac image san co
#docker build --tag=maven-image:1.0 .
#docker run -it --name=maven-container-c1908i maven-image:1.0
#buoi sau config not mysql trong container
FROM maven:3.8.1-adoptopenjdk-16
WORKDIR /home/app
COPY javaspringdemo/src /home/app/src
COPY javaspringdemo/pom.xml /home/app
RUN mvn compile
CMD ["mvn", "exec:java","-Dexec.mainClass=com.aptech.demo.DemoApplication"]
