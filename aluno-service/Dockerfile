FROM openjdk:17-jdk-slim
VOLUME /top
COPY target/aluno-service-0.0.1-SNAPSHOT.jar aluno-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/aluno-service.jar"]