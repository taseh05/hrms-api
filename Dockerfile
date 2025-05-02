FROM openjdk:17-jdk
COPY ./target/hrms-api-1.0.0.jar app.jar
CMD ["java", "-jar", "app.jar"]
