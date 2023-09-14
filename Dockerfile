FROM openjdk:8-jdk-alpine

EXPOSE 8080

ADD target/SpringBoot_Homework-0.0.1-SNAPSHOT.jar dockerHomework.jar

CMD ["java","-jar", "dockerHomework.jar"]