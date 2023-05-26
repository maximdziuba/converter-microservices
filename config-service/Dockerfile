FROM openjdk:17-alpine

ADD target/*.jar config-service.jar

ENTRYPOINT ["java", "-jar", "config-service.jar"]