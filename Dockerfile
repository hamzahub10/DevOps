FROM openjdk:17-jdk-alpine
EXPOSE 8089
ADD target/tpfoyer17-5.0.0.jar tpfoyer17-5.0.0.jar
ENTRYPOINT ["java","-jar","/tpfoyer17-5.0.0.jar"]