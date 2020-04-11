# API Testing

This project is performing the end two end (e2e) business rules application and it's also having some error scenarios

## Getting Started

### Prerequisites

Before running, dependencies must be downloaded and then project compiled with Maven

```
 mvn clean install
```

## Running the tests

The project may be run by the class TestRunner

### Monitoring tests

The execution may be monitored by the console, the script is constantly throwing logs which can easily be noticed

```
{ "ERROR" : "Ops... We were not waiting for it" }
2020-04-11 17:38:44.377 ERROR 5768 --- [pool-2-thread-1] b.c.e.pom.controllers.ErrorScenarios     : { "ERROR" : "Ops... We were not waiting for it" }
```

## Built With

* [JBehave](https://jbehave.org//) - BDD design stories framework.
* [Maven](https://maven.apache.org/) - Dependency Management.
* [Spring](https://spring.io/why-spring) - Spring makes programming Java quicker, easier, and safer for everybody.
* [Rest-Assured](http://rest-assured.io/) - Testing and validating REST services in Java.

## Authors

* **Guilherme Rosset** - *Initial work* - [guirosset](https://github.com/guirosset)

## License

This project is licensed under the Apache License

