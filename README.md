# DogApp

Welcome to DogApp, a delightful application for dog enthusiasts! Our application is designed to bring joy to your daily life with man's best friend. At its core, DogApp is a multi-module project consisting of four microservices, two of which are currently under development. Our technology stack is robust and utilizes cutting-edge technology. 

## Architecture

DogApp's architecture is structured around four microservices:

1. **User Service**: Manages user data and authentication. <- In progress
2. **Dog Service**: Handles dog-related data. <- In progress
3. **Walking Service**: Responsible for handling dog-walking data and features. (Not started)
4. **Breeding Service**: Manages dog-breeding related information and features. (Not started)


## Technology Stack

- **Back-end**: Our back-end is primarily powered by Spring Boot.
- **Security**: Authentication and access control is managed by Spring Security.
- **Messaging**: We use Apache Kafka for inter-service communication.
- **Containerization**: Docker and Kubernetes are used to containerize the services.
- **Database**: We employ two PostgreSQL databases - one for the User Service, and the other for the Dog Service.
- **Front-end**: The front-end of DogApp is built using React.

## Deployment

Our deployment strategy involves containerizing our services using Docker, orchestrating them using Kubernetes, and deploying them on AWS. The deployment process is currently in progress.
