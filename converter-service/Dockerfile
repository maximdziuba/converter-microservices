FROM openjdk:17-alpine

ADD target/*.jar converter-service.jar

ENTRYPOINT ["java", "-jar", "converter-service.jar"]