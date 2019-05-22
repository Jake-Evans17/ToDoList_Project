FROM maven:latest as maven
COPY . /build
WORKDIR /build
RUN mvn clean package
FROM openjdk:8-alpine3.9
WORKDIR /opt/todo-back
COPY --from=maven /build/target/IndividualProject-0.0.1-SNAPSHOT.jar app.jar
COPY startup.sh .
RUN chmod +x startup.sh
RUN apk add bash netcat-openbsd
ENTRYPOINT ["./startup.sh"]
