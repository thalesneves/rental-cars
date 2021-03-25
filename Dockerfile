FROM openjdk:11
MAINTAINER Thales da Silva Neves
WORKDIR /app
COPY target/rental-cars-0.0.1-SNAPSHOT.jar /app/rental-cars.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "rental-cars.jar"]