FROM openjdk:17-alpine

ADD target/*.jar discovery-service.jar

ENTRYPOINT ["java", "-jar", "discovery-service.jar"]