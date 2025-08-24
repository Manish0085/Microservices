FROM openjdk:17-jdk-slim
LABEL authors="manis"

LABEL MAINTAINER="eazybytes.com"

COPY target/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "loans-0.0.1-SNAPSHOT.jar"]