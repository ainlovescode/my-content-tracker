# My Content Tracker

## Why a content tracker?
I use multiple websites to track my content partnership - negotiation, content creation rates, video briefs and production process, and
follow-up.

To make it more convenient and build my fullstack software development skills, this application will be a WIP to make my
life (and possibly those of other content creators) much easier.

## About the ```backend```
This `backend` repository serves as the backend Java Spring Boot application responsible for database transactions 
regarding partnership information and user credentials.

There is currently only one type of data - ```partnership```:
```shell
{
  "partnerName": "John Doe LLC",
  "partnershipFee": 1000
}
```

## Project setup & tests
### Setup dependencies
```shell
./gradlew clean build
```

### Run the application
This project sets the port of the server application to 8081, as defined in ```main/resources/application.properties```

```shell
./gradlew bootrun
```

### Test the application
```shell
./gradlew clean test
```

## Demo
After running the application, you can use the following commands to interact with the embedded JpaRepository.

### CREATE NEW PARTNERSHIP
```shell
curl -X POST -H "Content-Type: application/json" -d '{"partnerName": "John Doe LLC", "partnershipFee": 400}' http://localhost:8081/partnerships
```

### GET ALL PARTNERSHIPS
```shell
curl http://localhost:8081/partnerships   -H "Accept: application/json"
```