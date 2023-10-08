FROM openjdk:17-jdk-slim
# mismo nombre que en el pom.xml
ADD target/*.jar micro-docker.jar
EXPOSE 8080
CMD java -jar micro-docker.jar
# ENTRYPOINT ["java","-jar","micro-docker.jar"]