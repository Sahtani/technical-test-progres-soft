# **Technical Test ProgresSoft**

## **Overview**
This project is a **Spring Boot** application designed to manage deals efficiently.

---

## 📑 Table of Contents
- [Overview](#overview)
- [Key Features](#key-features)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)
- [License](#license)

---

## 🔍 Overview
FX Data Warehouse is designed to process and store Foreign Exchange deals with robust validation, deduplication, and persistence capabilities. The system ensures data integrity while maintaining a no-rollback policy for imported deals.

---

## 🚀 Key Features
✅ **Comprehensive deal validation**  
- Unique Deal ID verification  
- Currency ISO code validation  
- Timestamp format validation  
- Amount validation  

✅ **Duplicate detection and prevention**  
✅ **Partial save capability (no rollback policy)**  
✅ **Detailed logging and audit trail**  
✅ **Robust error handling**  

---

## **Technologies Used**
- 🖥️ **Java 17**
- 🏗️ **Spring Boot**
- 📦 **Maven**
- 🗄️ **PostgreSQL**
- 🐳 **Docker & Docker Compose**
  
## 📦 Getting Started
### Prerequisites
- JDK 17
- Docker & Docker Compose
- Maven 3.8+
  ### Installation
1️⃣ **Clone the repository**
```sh
git clone https://github.com/Sahtani/technical-test-progres-soft
```
2️⃣ Start the Application
```sh
make up
```
📌 API Documentation
Deal Import Endpoint
POST /api/deals
Content-Type: application/json

Request Body:

{
  "id": "DR123456",
  "fromCurrency": "USD",
  "toCurrency": "EUR",
  "timestamp": "2024-01-01T10:00:00Z",
  "amount": 1000000.00
}
Response:

{
  "id": "DR123456",
  "fromCurrency": "USD",
  "toCurrency": "EUR",
  "timestamp": "2024-01-01T10:00:00Z",
  "amount": 1000000.00
}
📂 Project Structure
technicalTest/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/progressoft/technicaltest/
│   │   │       ├── config/
|   |   |       |── controller/
|   |   |       |── dto/
|   |   |       |── entity/
|   |   |       |── exception/
|   |   |       |── mapper/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   └── resources/
│   └── test/
├── Dockerfile
└── docker-compose.yml 
└── Makefile

