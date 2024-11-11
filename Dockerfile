
# Utiliser l'image officielle de OpenJDK 17 comme base
FROM openjdk:17-jdk-alpine

# Exposer le port 8080, qui est le port par défaut pour Spring Boot
EXPOSE 8089

# Copier le fichier JAR généré par Maven dans le conteneur
# Assurez-vous que le JAR est généré avant cette étape, par exemple avec 'mvn clean install'
COPY target/tpFoyer-17-0.0.1-SNAPSHOT.jar /tpFoyer-17.jar

# Démarrer l'application Spring Boot avec le fichier JAR copié
ENTRYPOINT ["java", "-jar", "/tpFoyer-17.jar"]
