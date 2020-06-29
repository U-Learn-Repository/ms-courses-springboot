FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD u_learn-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./johan","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]