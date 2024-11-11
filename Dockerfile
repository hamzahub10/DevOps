#FROM openjdk:17-jdk-alpine
#EXPOSE 8089
#ADD target/tp-foyer-5.0.0.jar tp-foyer-5.0.0.jar
#ENTRYPOINT ["java","-jar","/tp-foyer-5.0.0.jar"]

FROM openjdk:17-jdk-alpine
ADD target/tpFoyer-17-0.0.1.jar tpFoyer-17-0.0.1.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/tpFoyer-17-0.0.1.jar"]
