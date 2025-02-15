FROM openjdk:21-slim

WORKDIR /app

COPY target/linkedin-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]