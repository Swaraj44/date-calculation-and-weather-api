# Backend APIs – Spring Boot Project

## Overview

This repository contains a **Spring Boot–based backend API application** developed as a structured backend engineering task.  
The application exposes multiple RESTful endpoints that perform:

1. Date difference calculation without using date libraries  
2. Number-to-English-words conversion  
3. Weather-based temperature statistics for Dhaka  

The project emphasizes **clean architecture**, **input validation**, **global exception handling**, **unit testing**, and **Docker-based deployment**.

---

## Technology Stack

- **Language:** Java 11  
- **Framework:** Spring Boot 2.7.x  
- **Build Tool:** Maven  
- **Testing:** JUnit 5, Spring MockMvc  
- **External API:** Open-Meteo (Weather data)  
- **Containerization:** Docker  

---

##  Project Structure


<img width="490" height="669" alt="image" src="https://github.com/user-attachments/assets/07871ffc-eb6e-45a7-a387-7b89d08054c1" />


API Endpoints
1. Number of Days Between Two Dates

Endpoint

POST /number-of-days


Input (JSON)

{
  "startDate": "2024-01-01",
  "endDate": "2024-01-10"
}


Output (JSON)

{
  "days": 9
}


Notes

Date format: YYYY-MM-DD

Date calculation is implemented without using any date libraries

Input validated using regex

2. Number to Words

Endpoint

POST /number-to-words


Input (JSON)

{
  "number": "36.40"
}


Output (JSON)

{
  "words": "thirty six point four zero"
}


Constraints

0 <= number < 1000

Maximum 2 decimal places

Output in lowercase

No hyphens or “and”

3. Temperature Statistics for Dhaka

Endpoint

POST /temperature-stats-for-dhaka


Input (JSON)

{
  "startDate": "2024-01-01",
  "endDate": "2024-01-05"
}


Output (JSON)

{
  "min": -5.4,
  "max": 1.3,
  "average": -1.44,
  "minText": "minus five point four",
  "maxText": "positive one point three",
  "averageText": "minus one point four four"
}


Notes

Weather data fetched from Open-Meteo

Dhaka coordinates: 23.8103, 90.4125

Text conversion reuses Number-to-Words logic

Proper floating-point rounding applied

Input Validation

Regex-based validation for:

Dates

Numbers

Invalid inputs result in HTTP 400 Bad Request

Validation logic centralized in a utility class

Global Exception Handling

Implemented using @RestControllerAdvice

Consistent JSON error responses

Handles:

Validation errors

Illegal arguments

Runtime exceptions

Testing
Test Coverage

Controller Tests (MockMvc)

Service Tests

Utility / Validator Tests

Test Location
src/test/java

Run Tests
mvn clean test


Tests are executed automatically as part of the build process.

Running the Application Locally
Prerequisites

Java 11

Maven

Run
mvn spring-boot:run


Application starts at:

http://localhost:8080

Docker Support
Build Docker Image
docker build -t backend_apis .

Run Container
docker run -p 8080:8080 backend_apis

Design Highlights

Constructor-based dependency injection

Separation of concerns (Controller / Service / Utility)

Reusable logic across tasks

Build-breaking tests (CI-ready)

Clean, maintainable codebase

Possible Enhancements

Swagger / OpenAPI documentation

Integration tests with Testcontainers

Caching weather API responses

CI/CD pipeline configuration
