
# creer une image en se basant l'image alpine
#FROM openjdk:17-jdk-alpine

# Exposer le port 8080, qui est le port par défaut pour Spring Boot
#conteneur est accessible de l'exterieur par le port 8089
# dans notre app, on trouve le port dans propreties
#EXPOSE 8089

# Copier le fichier JAR généré par Maven dans le conteneur
# Assurez-vous que le JAR est généré avant cette étape, par exemple avec 'mvn clean install'
#récupérer le livrable de target
#COPY target/tpFoyer-17-0.0.1-SNAPSHOT.jar /tpFoyer-17.jar

# Démarrer l'application Spring Boot avec le fichier JAR copié
#ENTRYPOINT ["java", "-jar", "/tpFoyer-17.jar"]
FROM openjdk:17-jdk-alpine
EXPOSE 8089
ADD target/tpfoyer-17-5.0.0.jar tpfoyer-17-5.0.0.jar
ENTRYPOINT ["java","-jar","/tpfoyer-17-5.0.0.jar"]