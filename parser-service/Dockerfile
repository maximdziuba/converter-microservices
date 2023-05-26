FROM openjdk:17-alpine

ADD target/*.jar parser-service.jar

ENTRYPOINT ["java", "-jar", "parser-service.jar"]