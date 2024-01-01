FROM arm64v8/eclipse-temurin:17-jdk
EXPOSE 8080
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
