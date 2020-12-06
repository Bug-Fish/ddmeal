FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/ddmeal.jar ddmeal.jar
ENTRYPOINT ["java","-jar","/ddmeal.jar", "&"]
