# chrono-climate-api -- (Spring Boot Project)

## Overview

This repository contains a **Spring Boot--based backend API
application** developed as a structured backend engineering task.\
The application exposes multiple RESTful endpoints that perform:

1.  Date difference calculation without using date libraries\
2.  Number-to-English-words conversion\
3.  Weather-based temperature statistics for Dhaka

The project emphasizes **clean architecture**, **input validation**,
**global exception handling**, **unit testing**, and **Docker-based
deployment**.

------------------------------------------------------------------------

## Technology Stack

-   **Language:** Java 11\
-   **Framework:** Spring Boot 2.7.18\
-   **Build Tool:** Maven\
-   **Testing:** JUnit 5, Spring MockMvc\
-   **External API:** Open-Meteo (Weather data)\
-   **Containerization:** Docker

------------------------------------------------------------------------

## Project Structure

    chrono-climate-api
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   │   └── com.example.backend_apis
    │   │   │       ├── controller
    │   │   │       ├── service
    │   │   │       ├── dto
    │   │   │       │   ├── request
    │   │   │       │   └── response
    │   │   │       ├── util
    │   │   │       └── exception
    │   │   └── resources
    │   └── test
    │       └── java
    │           └── com.example.backend_apis
    │               ├── controller
    │               ├── service
    │               └── util
    ├── Dockerfile
    ├── pom.xml
    └── README.md

------------------------------------------------------------------------

## API Endpoints

### 1. Number of Days Between Two Dates

**Endpoint**\
POST `/api/number-of-days`

**Input**

``` json
{
  "startDate": "2024-01-01",
  "endDate": "2024-01-10"
}
```

**Output**

``` json
{
  "days": 9
}
```

**Notes** - Date format: `YYYY-MM-DD` - Date calculation implemented
without date libraries - Regex-based input validation

------------------------------------------------------------------------

### 2. Number to Words

**Endpoint**\
POST `/api/number-to-words`

**Input**

``` json
{
  "number": "36.40"
}
```

**Output**

``` json
{
  "words": "thirty six point four zero"
}
```

**Constraints** - `0 ≤ number < 1000` - Maximum 2 decimal places -
Lowercase output - No hyphens or conjunctions

------------------------------------------------------------------------

### 3. Temperature Statistics for Dhaka

**Endpoint**\
POST `/api/temperature-stats-for-dhaka`

**Input**

``` json
{
  "startDate": "2024-01-01",
  "endDate": "2024-01-05"
}
```

**Output**

``` json
{
  "min": -5.4,
  "max": 1.3,
  "average": -1.44,
  "minText": "minus five point four",
  "maxText": "positive one point three",
  "averageText": "minus one point four four"
}
```

**Notes** - Weather data fetched from Open-Meteo - Dhaka coordinates:
`23.8103, 90.4125` - Text conversion reuses Number-to-Words logic -
Proper floating-point rounding applied

------------------------------------------------------------------------

## Input Validation

-   Regex-based validation for dates and numbers
-   Invalid input returns **HTTP 400 Bad Request**
-   Centralized validation utilities

------------------------------------------------------------------------

## Global Exception Handling

-   Implemented using `@RestControllerAdvice`
-   Consistent JSON error responses
-   Handles validation, illegal arguments, and runtime exceptions

------------------------------------------------------------------------

## Testing

**Coverage** - Controller tests (MockMvc) - Service tests -
Utility/Validator tests

**Run Tests**

``` bash
mvn clean test
```

------------------------------------------------------------------------

## Running the Application

``` bash
mvn spring-boot:run
```

Application runs at `http://localhost:8080`

------------------------------------------------------------------------

## Docker Support

**Build Image**

``` bash
docker build -t backend_apis .
```

**Run Container**

``` bash
docker run -p 8080:8080 backend_apis
```

------------------------------------------------------------------------

## Design Highlights

-   Constructor-based dependency injection
-   Clear separation of concerns
-   Reusable utilities
-   CI-ready, build-breaking tests

------------------------------------------------------------------------

## Possible Enhancements

-   Swagger / OpenAPI documentation
-   Integration testing with Testcontainers
-   Weather API response caching
-   CI/CD pipeline setup
