FROM maven:3.6.1-jdk-8-alpine
COPY matchmaker-server /tmp/matchmaker-server
WORKDIR /tmp/matchmaker-server

RUN mvn install

FROM openjdk:8-jre-slim

COPY --from=0 /tmp/matchmaker-server/target/matchmaker-server-0.0.1-SNAPSHOT.jar /var/app

CMD ["java", "-jar", "/var/app/matchmaker-server-0.0.1-SNAPSHOT.jar"]