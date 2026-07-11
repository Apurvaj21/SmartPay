# SmartPay - Microservices-Based Payment System

## Overview

SmartPay is a microservices-based backend system designed to handle user authentication, order management, and payment processing. The system demonstrates real-world backend architecture with secure APIs, inter-service communication, and transaction workflows.

---

## Architecture

The application is built using a microservices architecture with three independent services:

* **User Service** → Handles authentication and JWT token generation
* **Order Service** → Manages order creation and retrieval
* **Payment Service** → Processes payments and updates order status

---

## System Flow

1. User logs in → receives JWT token
2. User creates an order via Order Service
3. Payment Service processes payment
4. Payment Service calls Order Service
5. Order status updated to **SUCCESS / FAILED**

---

## Tech Stack

* Java, Spring Boot
* Spring Security (JWT Authentication)
* REST APIs
* MySQL
* Microservices Architecture
* RestTemplate (Inter-service communication)
* Postman (API Testing)

---

## Project Structure

```
SmartPay/
 ├── user-service/
 ├── order-service/
 ├── payment-service/
```

---

## Key Features

* JWT-based authentication and authorization
* Role-based access control (ADMIN / USER)
* Microservices communication using REST APIs
* Payment workflow with order status synchronization
* Global exception handling for clean API responses

---

## How to Run

1. Start MySQL
2. Run all three services:

   * user-service
   * order-service
   * payment-service
3. Use Postman to test APIs

---

## Testing Flow

* Login → Get JWT
* Create Order
* Process Payment
* Verify Order Status

---


