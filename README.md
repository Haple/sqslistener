# Sample - SQS Listener
Just a sample project to test a SQS Listener.

# Requirements

* [Java Open JDK 8](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-18-04)
* [Maven](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-18-04)
* [Docker](https://docs.docker.com/engine/install/ubuntu/#installation-methods)
* [Docker Compose](https://docs.docker.com/compose/install/#install-compose-on-linux-systems)


# How to run on your machine

### Start the infrastructure
```
docker-compose up
```

### Start the server
```
mvn spring-boot:run -Dspring-boot.run.profiles=local
``` 

# How to run on your machine - easy mode :)
```
./start-me.sh
```

# Testing

There are a Postman collection in the root of this project (`SampleSQSListener.postman_collection.json`).
It has two requests that will send payloads to the queue and invoke the SampleListener.


