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
<img width="2136" height="1632" alt="Screenshot 2026-07-11 231221" src="https://github.com/user-attachments/assets/8fa7f161-c03e-4403-bc17-45fa2b21ed52" />
<img width="2130" height="1524" alt="Screenshot 2026-07-11 231115" src="https://github.com/user-attachments/assets/69268ed8-6807-49b0-acf9-daf751933db2" />
<img width="2148" height="1524" alt="Screenshot 2026-07-11 230956" src="https://github.com/user-attachments/assets/0f3fcc6d-7b9e-4812-9cab-c2ab3f043f01" />
<img width="2085" height="1287" alt="Screenshot 2026-07-11 230652" src="https://github.com/user-attachments/assets/0c1ac9b8-b721-40e6-be03-ec5880443e9a" />
<img width="2112" height="1716" alt="Screenshot 2026-07-11 230218" src="https://github.com/user-attachments/assets/79105a2a-1188-439e-a786-6e73b9350564" />

