#!/usr/bin/env bash

echo 'DEPENDENCIES SETUP'
docker-compose down
docker-compose up -d
echo 'WAITING LOCALSTACK BE HEALTHY...'
while [[ $(docker inspect --format='{{json .State.Health.Status}}' sample_localstack) != "\"healthy\"" ]]; do
  :
done
echo 'LOCALSTACK IS HEALTHY!'

echo 'STARTING MICROSERVICE'
mvn clean install -DskipTests
java -jar -Dspring.profiles.active=local target/*.jar
