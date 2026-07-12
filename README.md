
# SmartPay – Microservices-Based Payment System

## What is this project?

SmartPay is a backend microservices project built using Spring Boot.
It simulates a real-world system where:

* Users register and log in
* Users create orders
* Payments are processed
* Order status updates automatically after payment

---

## Project Structure

This project has **3 independent services**:

```
SmartPay/
 ├── user-service
 ├── order-service
 ├── payment-service
```

### Services:

* **user-service**

  * Register & login
  * JWT token generation
  * Authentication

* **order-service**

  * Create orders
  * View orders
  * Role-based access (USER / ADMIN)

* **payment-service**

  * Process payments
  * Updates order status by calling order-service

---

## Requirements

Install these before running:

* Java 17+
* Maven
* MySQL
* Postman
* Git

---

## Step 1: Database Setup

Open MySQL and run:

```sql
CREATE DATABASE smartpay_user;
CREATE DATABASE smartpay_order;
CREATE DATABASE smartpay_payment;
```

---

## Step 2: Configure Database

Go to each service → `src/main/resources/application.properties`

Update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/smartpay_user
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

-> Change DB name for:

* order-service → `smartpay_order`
* payment-service → `smartpay_payment`

---

## Step 3: Run the Project

Open terminal and run each service separately:

### Start user-service

```bash
cd user-service
mvn spring-boot:run
```

### Start order-service

```bash
cd order-service
mvn spring-boot:run
```

### Start payment-service

```bash
cd payment-service
mvn spring-boot:run
```

-> Make sure all 3 services are running

---

## Step 4: API Testing (Postman)

---

### 1️. Register User

**POST** `/users/register`

```json
{
  "name": "Test User",
  "email": "user@test.com",
  "password": "Test@123",
  "role": "USER"
}
```

---

### 2️. Login

**POST** `/users/login`

```json
{
  "email": "user@test.com",
  "password": "Test@123"
}
```

-> Copy the token from response

---

### 3️. Create Order

**POST** `/orders`

Header:

```
Authorization: Bearer <token>
```

```json
{
  "amount": 5000
}
```

---

### 4️. Process Payment

**POST** `/payments`

Header:

```
Authorization: Bearer <token>
```

```json
{
  "orderId": 1,
  "amount": 5000
}
```

---

### 5️. Get Orders

**GET** `/orders`

Header:

```
Authorization: Bearer <token>
```

---

## How the System Works

```
Register → Login → Create Order → Payment → Order Status Updated
```

* Payment success/failure is simulated
* Order status becomes:

  * SUCCESS 
  * FAILED 

---

## Roles

### USER:

* Register & login
* Create orders
* View own orders
* Make payments

### ADMIN:

* View all orders

---

## Important Notes

* Run all 3 services before testing
* Always pass JWT token in secured APIs
* Validation errors return proper messages
* Payment status is random (simulation)

---

## Tech Stack

* Java
* Spring Boot
* Spring Security (JWT)
* REST APIs
* MySQL
* Microservices Architecture
* RestTemplate

---

If you are testing:

* First register
* Then login
* Use token in all APIs
* Test both USER and ADMIN roles

<img width="2151" height="1734" alt="Screenshot 2026-07-12 182205" src="https://github.com/user-attachments/assets/f79a45e6-5855-4223-b3a0-de048a172bbb" />
<img width="2160" height="1611" alt="Screenshot 2026-07-12 182112" src="https://github.com/user-attachments/assets/0e7cff83-3a5d-4308-ab9a-2b0dc7fc91d9" />
<img width="2127" height="1506" alt="Screenshot 2026-07-12 181954" src="https://github.com/user-attachments/assets/0fe8df92-7a97-42d3-8f88-af709132dae9" />
<img width="2109" height="1395" alt="Screenshot 2026-07-12 181815" src="https://github.com/user-attachments/assets/f992ef09-6426-4b8e-bf66-96aba5fea8d9" />
<img width="2163" height="1554" alt="Screenshot 2026-07-12 181735" src="https://github.com/user-attachments/assets/ce937d63-337b-49d0-a5ec-9e43d6307e9f" />
