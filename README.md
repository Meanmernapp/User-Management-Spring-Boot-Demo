# Construction Project Management System

This project is a Construction Project Management System built using Java Spring Boot, Apache Kafka, and Swagger for API documentation. It provides a dashboard to manage construction projects, real-time messaging using Kafka, and a RESTful API to interact with the system.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Architecture](#architecture)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Construction Project Management System is designed to help construction companies manage their projects efficiently. It offers features such as project tracking, real-time updates via Kafka, and a user-friendly dashboard for managing all aspects of a construction project.

## Features

- Project Management Dashboard
- Real-time Messaging with Apache Kafka
- RESTful APIs for Project Management
- Swagger API Documentation
- User Authentication and Authorization

## Architecture

The system follows a microservices architecture with the following components:

- **Java Spring Boot**: Backend service for handling business logic and APIs.
- **Apache Kafka**: Messaging system for real-time updates and communication.
- **Swagger**: API documentation and testing tool.
- **Database**: Relational database for storing project data (e.g., PostgreSQL).

![Architecture Diagram](docs/architecture-diagram.png)

## Installation

### Prerequisites

- Java 11 or higher
- Maven
- Docker (for running Kafka and PostgreSQL)
- Node.js and npm (for the frontend)

### Backend Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/construction-project-management.git
    cd construction-project-management
    ```

2. **Build the backend**:
    ```bash
    cd backend
    mvn clean install
    ```

3. **Run Kafka and PostgreSQL using Docker**:
    ```bash
    docker-compose up -d
    ```

4. **Run the Spring Boot application**:
    ```bash
    mvn spring-boot:run
    ```

### Frontend Setup

1. **Navigate to the frontend directory**:
    ```bash
    cd ../frontend
    ```

2. **Install dependencies**:
    ```bash
    npm install
    ```

3. **Run the frontend application**:
    ```bash
    npm start
    ```

## Usage

- Access the project management dashboard at `http://localhost:3000`.
- Use the API endpoints documented with Swagger at `http://localhost:8080/swagger-ui.html`.

## API Documentation

The API is documented using Swagger. You can view and test the APIs by navigating to `http://localhost:8080/swagger-ui.html` once the backend service is running.

### Example API Endpoints

- **Create a new project**: `POST /api/projects`
- **Get all projects**: `GET /api/projects`
- **Update a project**: `PUT /api/projects/{projectId}`
- **Delete a project**: `DELETE /api/projects/{projectId}`

## Contributing

We welcome contributions from the community. To contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
