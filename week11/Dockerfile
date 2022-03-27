FROM openjdk:11
ARG FILE_NAME=target/cardealership-0.0.1-SNAPSHOT.jar
ADD ${FILE_NAME} cardealership.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cardealership.jar"]