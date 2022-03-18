FROM openjdk:11-jdk
EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} guusto-balance.jar
ENTRYPOINT ["java","-jar","guusto-service.jar"]