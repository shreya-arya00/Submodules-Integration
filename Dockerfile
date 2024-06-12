FROM bellsoft/liberica-openjdk-alpine-musl:17
VOLUME /tmp
COPY target/SubmodulesIntegration-1.0-SNAPSHOT.jar my-integration-project.jar
ENTRYPOINT ["java","-jar","/my-integration-project.jar"]
