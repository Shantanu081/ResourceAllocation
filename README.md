# Resource Allocation

Developed using Java.

## Requirements
* Java 8
* Maven

## How to build the application
Checkout the project from this repository, then run
```
    mvn clean install
```

## How to run the application
Build the application or use the [fat jar], then run
```
    java -jar target/productcatalogue-0.0.1-SNAPSHOT.jar
```
The application runs on port 9090


## How to use the application

## Request
POST: http://localhost:9090/productcatalogue/getWorkforce
{
	"rooms" : [35, 99, 21],
	"senior" : 10,
	"junior" : 6
}

## Response

[
    {
        "senior": 3,
        "junior": 1
    },
    {
        "senior": 9,
        "junior": 2
    },
    {
        "senior": 2,
        "junior": 1
    }
]
