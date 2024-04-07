FROM eclipse-temurin:17.0.10_7-jdk
RUN mkdir -p /opt/app
WORKDIR /opt/app
COPY target/*.jar app.jar
ENTRYPOINT [ "java","-jar","/opt/app/app.jar" ] 