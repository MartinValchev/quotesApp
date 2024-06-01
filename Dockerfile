FROM bellsoft/liberica-runtime-container:jre-17-stream-musl
COPY target/QuotesApp-0.0.1-SNAPSHOT.jar quotesApp.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/quotesApp.jar"]
