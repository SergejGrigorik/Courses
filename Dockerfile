FROM maven:3.9.9-sapmachine-17 as build
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

FROM tomcat:jdk17-openjdk-slim-buster
COPY --from=build target/SenlaCourse-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]


