FROM openjdk:11-jdk
COPY . /


FROM openjdk:11-jdk
COPY --from=0 target/td1-0.0.1-SNAPSHOT.jar app.jar
ENV SERVER_PORT=8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8000

