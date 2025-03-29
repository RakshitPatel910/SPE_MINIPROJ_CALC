FROM openjdk:17-jdk-slim

WORKDIR /app

RUN apt-get update && apt-get install -y bash

COPY target/SPE_MINIPROJ_CALC-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]