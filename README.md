# Playermaker home assignment
To build the project: 
mvn clean package -DskipTests
or
mvn clean package

To build the docker:
docker build -t player-participation-counter .

To run the docker:
docker run -p 8080:8080 player-participation-counter