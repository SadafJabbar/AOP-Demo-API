# AOP Demo API

A Spring Boot CRUD REST API built to practice Aspect-Oriented Programming (AOP). The project demonstrates how cross-cutting concerns such as logging, exception tracking, method execution time, and returned results can be handled separately from the main business logic.

## Features

- Create User
- Get User by ID
- Get all Users
- Update User
- Delete User
- Request DTO with validation
- H2 Database with JPA/Hibernate
- Custom exception handling
- Aspect-Oriented Programming
- Custom AOP annotation

## AOP Concepts

- `@Before` — runs before the target method
- `@After` — runs after the target method
- `@AfterReturning` — runs when the method successfully returns
- `@AfterThrowing` — runs when the method throws an exception
- `@Around` — runs before and after the target method
- `JoinPoint` — provides information about the intercepted method
- `ProceedingJoinPoint` — allows the intercepted method to continue using `proceed()`
- `Pointcut` — defines which methods should be intercepted
- `Aspect` — contains cross-cutting logic
- `Weaving` — connects the aspect with the target methods
- Custom `@TrackExecution` annotation — allows execution-time tracking on selected methods

## Aspects

### LoggingAspect

Uses `@Before` and `@After` advice to log when service methods start and finish.

### ResultAspect

Uses `@AfterReturning` to log the result returned by a service method.

### ExceptionAspect

Uses `@AfterThrowing` to detect and log exceptions thrown by service methods.

### ExecutionTimeAspect

Uses `@Around` and `ProceedingJoinPoint` to calculate and log the execution time of selected service methods.

## Custom Annotation

The project contains a custom `@TrackExecution` annotation.

Methods marked with `@TrackExecution` are intercepted by the `ExecutionTimeAspect` so their execution time can be measured.

## Project Structure

src/main/java/aop_demo_api/aop_demo_api

├── aspect
│   ├── LoggingAspect.java
│   ├── ResultAspect.java
│   ├── ExceptionAspect.java
│   └── ExecutionTimeAspect.java
│
├── annotation
│   └── TrackExecution.java
│
├── controller
│   └── UserController.java
│
├── dto
│   └── UserRequest.java
│
├── entity
│   └── UserEntity.java
│
├── exception
│   └── UserNotFound.java
│
├── repository
│   └── UserRepository.java
│
└── service
└── UserService.java

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/users/{id}` | Get user by ID |
| GET | `/api/v1/users` | Get all users |
| POST | `/api/v1/users` | Create a user |
| PUT | `/api/v1/users/{id}` | Update a user |
| DELETE | `/api/v1/users/{id}` | Delete a user |

## Technologies

- Java 21
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- Spring AOP / AspectJ
- H2 Database
- Lombok
- Bean Validation
- Maven

## Purpose

This project was created to practice Aspect-Oriented Programming with Spring Boot 
and understand how cross-cutting concerns can be separated from the application's main 
business logic. It combines a simple CRUD API with multiple AOP concepts and a custom 
annotation to provide practical experience with Spring AOP.