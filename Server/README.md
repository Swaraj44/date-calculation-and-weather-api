# Chrono Climate Api (Spring Boot Project)

## Overview

This repository contains a **Spring Boot--based backend API application** developed as a structured backend engineering task.
The application exposes multiple RESTful endpoints that perform:

1.  Date difference calculation without using date libraries
2.  Number-to-English-words conversion
3.  Weather-based temperature statistics for Dhaka

The project emphasizes **clean architecture**, **input validation**,**global exception handling**, **unit testing**, and **Docker-based deployment**.

------------------------------------------------------------------------

## Technology Stack

-   **Language:** Java 11
-   **Framework:** Spring Boot 2.7.18
-   **Build Tool:** Maven 3.9.6
-   **Testing:** JUnit 5, Spring MockMvc
-   **External API:** Open-Meteo (Weather data)
-   **Containerization:** Docker

------------------------------------------------------------------------

## Server Structure

    server
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   │   └── com.example.chrono_climate_api
    |   |   |       ├── config
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
    │           └── com.example.chrono_climate_api
    │               ├── controller
    │               ├── service
    │               └── util
    ├── Dockerfile
    ├── pom.xml
    └── README.md

------------------------------------------------------------------------

## API Endpoints

### 1. Number of Days Between Two Dates

**Endpoint**
POST `/api/number-of-days`

**Input**

``` json
{
  "startDate": "2025-01-01",
  "endDate": "2025-01-10"
}
```

**Output**

``` json
{
  "days": 9
}
```

**Notes** - Date format: `YYYY-MM-DD` - Date calculation implemented without date libraries - Regex-based input validation

------------------------------------------------------------------------

### 2. Number to Words

**Endpoint**
POST `/api/number-to-words`

**Input**

``` json
{
  "number": "46.40"
}
```

**Output**

``` json
{
  "words": "forty six point four zero"
}
```

**Constraints** - `0 ≤ number < 1000` - Maximum 2 decimal places -
Lowercase output - No hyphens or conjunctions

------------------------------------------------------------------------

### 3. Temperature Statistics for Dhaka

**Endpoint**
POST `/api/temperature-stats-for-dhaka`

**Input**

``` json
{
  "startDate": "2025-01-01",
  "endDate": "2025-01-06"
}
```

**Output**

``` json
{
  "min": -1.4,
  "max": 3.3,
  "average": 1.44,
  "minText": "minus one point four",
  "maxText": "positive three point three",
  "averageText": "positive one point four four"
}
```

**Notes** - Weather data fetched from Open-Meteo - Dhaka coordinates:
`23.8103, 90.4125` - Text conversion reuses Number-to-Words logic -
Proper floating point rounding applied

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

**Coverage** - Controller tests (MockMvc) - Service tests - Utility/Validator tests

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
## DockerHub Support

**Image Pull**
``` bash
docker pull swaraj66/chrono-climate-api:latest
```

**Run Container**
``` bash
docker run -p 8080:8080 swaraj66/chrono-climate-api
```

------------------------------------------------------------------------
## Docker Support

**Build Image**

``` bash
docker build -t chrono-climate-api .
```

**Run Container**

``` bash
docker run -p 8080:8080 chrono-climate-api
```

------------------------------------------------------------------------

## Design Highlights

-   Constructor-based dependency injection
-   Clear separation of concerns
-   Reusable utilities
-   CI-ready, build-breaking tests
