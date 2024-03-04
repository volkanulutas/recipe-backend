#
# Build stage
#
FROM maven:3.8.7-eclipse-temurin-19 AS build
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM openjdk:19-jdk-slim
COPY --from=build /target/.jar recipe.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","recipe.jar"]