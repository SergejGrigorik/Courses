#FROM bellsoft/liberica-openjre-alpine:23 AS layers
#WORKDIR /application
#COPY target/*.jar app.jar
#RUN java -Djarmode=layertools -jar app.jar extract
#
#FROM bellsoft/liberica-openjre-alpine:23
#VOLUME /tmp
#RUN adduser -S spring-user
#USER spring-user
#COPY --from=layers /application/dependencies/ ./
#COPY --from=layers /application/spring-boot-loader/ ./
#COPY --from=layers /application/snapshot-dependencies/ ./
#COPY --from=layers /application/application/ ./
#
#ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]


#FROM maven:3.9.9-sapmachine-17 as build
#COPY pom.xml .
#COPY src src
#RUN mvn clean package -DskipTests
#
#FROM tomcat:jdk17-openjdk-slim-buster
#COPY --from=build target/SenlaCourse-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
#CMD ["catalina.sh","run"]


FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY . /app/.
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "/app/*.jar"]

