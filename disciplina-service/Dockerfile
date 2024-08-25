FROM openjdk:17-jdk-slim
VOLUME /top
COPY target/disciplina-service-0.0.1-SNAPSHOT.jar disciplina-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/disciplina-service.jar"]