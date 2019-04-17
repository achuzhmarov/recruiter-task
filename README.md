This is a web-service application solving a test task from a recruiter. It consumes external API and translates result to the inner model.

Main execution path works like this:

    CarMakeController -> CarService -> CarApiService

Each class has a simple corresponding integration test.

There are also two additional helper classes with separate unit tests:
* CarApiResponseParser - api response parsing logic
* CarShowsApiToCarMakeMapper - transformation logic

Most important classes can be easily run from tests.
Top level exception handling is omitted for simplicity.

### Prerequisites
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Gradle](https://gradle.org/gradle-download/) (optional)

### Running locally

    gradle bootRun

If you do not have gradle installed, you can use
    
    ./gradlew bootRun

You can use curl to send some requests:

    curl http://localhost:8080/api/v1/car_makes
    curl http://localhost:8080/api/v1/car_makes/json

### Running the tests
Unit tests:

    gradle test