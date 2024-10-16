#Dockerfile de tao ra image rieng tu cac image san co
#docker rmi maven-image:1.0
#docker build . -t maven-image:1.0
#docker rm -f maven-jdk16-container
#docker run -it --name=maven-jdk16-container maven-image:1.0
FROM maven:3.8.1-adoptopenjdk-16
WORKDIR /home/app/src
COPY javaspringdemo/src /home/app/src
COPY javaspringdemo/pom.xml /home/app
#RUN mvn -f /home/app/pom.xml package
#RUN mvn install
# RUN ls -la
# CMD ["/opt/java/openjdk/bin/java", "-jar", "-Dspring.profiles.active=test", "/app.jar"]
#CMD ["mvn","spring-boot:run"]
CMD bash