FROM java:11-alpine
COPY ./target/springboot-masterclass-0.0.1-SNAPSHOT.jar springboot-masterclass-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "springboot-masterclass-0.0.1-SNAPSHOT.jar"]
