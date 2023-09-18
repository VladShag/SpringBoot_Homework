FROM openjdk:17-oracle

EXPOSE 8081

ADD target/SpringBoot_Homework-0.0.1-SNAPSHOT.jar dockerHomework.jar

CMD ["java","-jar", "dockerHomework.jar"]