FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY LogChain-0.0.4.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]