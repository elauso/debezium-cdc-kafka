FROM openjdk:12-alpine

VOLUME /tmp

EXPOSE 8080

RUN mkdir -p /app/

RUN mkdir -p /app/logs/

ADD build/libs/debezium-cdc-kafka-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "/app/app.jar"]