FROM eclipse-temurin:21-jdk-alpine
WORKDIR testing1Dir
COPY target/Testing1-0.0.1-SNAPSHOT.jar /testing1Dir/Testing1.jar
CMD ["java","-jar","Testing1.jar"]