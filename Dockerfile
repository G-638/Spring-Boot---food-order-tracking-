#FROM maven:openjdk:16.0.1-jdk
#EXPOSE 8080
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT [ "java", "-jar", "/app.jar" ]

FROM openjdk:16.0.1-jdk
EXPOSE 8080
WORKDIR /app
COPY target/demo-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "demo-0.0.1-SNAPSHOT.jar" ]
