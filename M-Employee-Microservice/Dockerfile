FROM openjdk:8
EXPOSE 8080
ADD target/employee-microservice-docker.jar employee-microservice-docker.jar
ENTRYPOINT ["java",".jar","/employee-microservice-docker.jar"]