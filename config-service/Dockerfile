FROM openjdk:17-alpine

ADD target/*.jar config-service.jar
ADD src/main/resources/config/ /config/

ENTRYPOINT ["java", "-jar", "config-service.jar"]