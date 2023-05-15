FROM openjdk:19
ARG WAR_FILE=target/*.war
COPY target/BloodLink-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java", "-jar","app.war"]