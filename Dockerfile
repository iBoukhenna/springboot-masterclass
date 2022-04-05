FROM openjdk:11.0
COPY ./target/springboot-masterclass-0.0.1-SNAPSHOT.jar springboot-masterclass-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "springboot-masterclass-0.0.1-SNAPSHOT.jar"]
