FROM openjdk:17-alpine

ADD target/*.jar currency-service.jar

ENTRYPOINT ["java", "-jar", "currency-service.jar"]