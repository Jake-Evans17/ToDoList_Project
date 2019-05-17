FROM maven:latest as maven
COPY . /build
WORKDIR /build
RUN mvn clean package
FROM java:8
WORKDIR /opt/todo-back
COPY --from=maven /build/target/IndividualProject-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
