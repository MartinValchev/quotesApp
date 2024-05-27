FROM bellsoft/liberica-runtime-container:jre-17-stream-musl
COPY target/QuotesProject-0.0.1-SNAPSHOT.jar quotesProject.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/quotesProject.jar"]
