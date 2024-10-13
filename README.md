# Spring-Based POS System

## Introduction

This project is a **Point of Sale (POS) system** built using the **Spring framework**. It is designed to manage the operations of a fruit shop, including inventory management, sales tracking, and customer handling. The system is built on a **layered architecture** and utilizes **loggers** for debugging and monitoring. It leverages **JPA** and **Hibernate** for database interactions, ensuring efficient and seamless ORM (Object Relational Mapping).

The system is designed to provide a scalable and maintainable solution, following best practices in architecture with well-defined layers, including **Controller**, **Service**, **DAO**, **Entity**, and **DTO** classes. Custom exception handling ensures smooth error management, and configuration is handled by two main config classes.

## Key Features:
- **Inventory Management**: CRUD operations for managing products.
- **Sales**: Create Customer Orders.
- **Customer Management**: Add and manage customer profiles.
- **Logging**: Integrated logging for tracking events and debugging.
- **Layered Architecture**: Clear separation between presentation, business logic, and data layers.
- **REST API with JSON responses.**
- **Exception handling and validation using Spring Validator**.

## Technologies Used:
- **Backend**: Spring java framework, Spring Data JPA, Hibernate
- **Frontend**: HTML, CSS, JavaScript (with jQuery and Bootstrap)
- **Database**: MySQL
- **Communication**: AJAX
- **Logging**: Built-in Spring loggers for monitoring application flow
- **ORM**: JPA with Hibernate for database interactions
- **Spring Data JPA**- Data repository layer
- **Lombok**- To reduce boilerplate code

## System Architecture:
This project maintains a well-defined **layered architecture**, consisting of the following:
- **Controller Layer**: Manages HTTP requests and responses.
- **Service Layer**: Contains the business logic and service implementations.
- **DAO Layer**: Handles data persistence and database interaction.
- **Entity Class**: Maps to database tables using Hibernate.
- **DTO Class**: Used for transferring data between layers.
- **Customize Exception Class**: For handling specific exceptions and errors.
- **Config Classes**: 
  - **WebAppRootConfig**: Configuration related to application context.
  - **WebAppConfig**: Handles configurations related to the web layer (e.g., view resolver, resource handler).
## API Endpoints

### Customer Endpoints

- **GET /customer**: Retrieve all customers or Get a customer by ID.
- **POST /customer**: Create a new customer.
- **PUT /customer**: Update an existing customer.
- **DELETE /customer/{id}**: Delete a customer by ID.

### Item Endpoints

- **GET /item**: Retrieve all items Get a item by Code.
- **POST /item**: Create a new item.
- **PUT /item**: Update an existing item.
- **DELETE /item/{id}**: Delete an item by Code.

### Order Endpoints

- **POST /order**: Create a new order.
- **GET /order**: Retrieve all orders .

## API Documentation

You can view the detailed API documentation with example requests and responses [here](https://documenter.getpostman.com/view/35385949/2sAXxS7Azd).

## Frontend Repository
Find the frotend implementation here: [Fruit Shop Frontend](https://github.com/madhushiillesinghe/Fruit-Shop-Spring-Frontend-.git).

## 🛡️ License:
This project is licensed under the MIT License - see the LICENSE file for details.




