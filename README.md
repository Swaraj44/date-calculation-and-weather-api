# Chrono Climate Full Stack Application

This repository contains a **full-stack application** that includes:

1. **Chrono Climate API** – a Spring Boot backend exposing REST APIs.  
2. **API Client Dashboard** – a React frontend built with Vite consuming the backend APIs.  

The project focuses on **clean architecture**, **input validation**, **global exception handling**, **unit testing**, and **Docker-based deployment**.

---

## Repository Structure

```
chrono-climate-app/
├── backend/             # Spring Boot backend (Chrono Climate API)
│   └── README.md        # Detailed backend instructions
│
├── frontend/            # React + Vite frontend (API Client Dashboard)
│   └── README.md        # Detailed frontend instructions
│
├── README.md            # General overview (this file)
```

> Each folder contains its own detailed README with instructions on installation, running, testing, and Docker deployment.

---

## Features

### Backend (Chrono Climate API)

- Calculate **number of days between two dates** without using date libraries
- Convert **numbers into words** (`0–999`, up to 2 decimal places)
- Fetch **temperature statistics for Dhaka** from Open-Meteo
- Global exception handling and input validation
- Unit testing with JUnit and MockMvc
- Docker support

### Frontend (API Client Dashboard)

- Consume the backend APIs:
  - `/api/number-of-days`
  - `/api/number-to-words`
  - `/api/temperature-stats-for-dhaka`
- Clean and responsive UI
- Simple Fetch-based API integration
- Docker support

---

## Getting Started

### Prerequisites

- Java 11 and Maven 3.9+ (backend)
- Node.js v18+ (frontend)
- Docker (optional, for containerized deployment)

---

### Running Locally

1. **Backend**
    ```bash
    cd backend
    mvn spring-boot:run
    ```
    Runs on `http://localhost:8080`.

2. **Frontend**
    ```bash
    cd frontend
    npm install
    npm run dev
    ```
    Runs on `http://localhost:5173`.

---

### Docker Deployment

1. **Backend**
    ```bash
    cd backend
    docker build -t chrono-climate-api .
    docker run -p 8080:8080 chrono-climate-api
    ```

2. **Frontend**
    ```bash
    cd frontend
    docker build -t api-client .
    docker run -p 5173:80 api-client
    ```

> You can also pull pre-built images from DockerHub:
>
> ```bash
> docker pull swaraj66/chrono-climate-api:latest
> docker pull swaraj66/api-client:latest
> ```
Run Container
> ```bash
> docker run -p 8080:8080 swaraj66/chrono-climate-api:latest
> docker run -p 5173:80 swaraj66/api-client:latest
> ```

---

## Notes

- Backend handles all input validation.
- Frontend focuses on usability and clean API integration.
- Each module (backend/frontend) has independent README files for detailed instructions.

