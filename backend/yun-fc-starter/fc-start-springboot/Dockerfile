FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} fc-start-springboot.jar
ENTRYPOINT ["java","-jar","/fc-start-springboot.jar"]