FROM amazoncorretto:17.0.8-alpine3.18

WORKDIR /app

COPY target/DigitalMindWebServices-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "DigitalMindWebServices-0.0.1-SNAPSHOT.jar"]