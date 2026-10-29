# REST API Test Automation Framework (Java & REST Assured)

A lightweight, scalable API test automation framework built with **Java**, **REST Assured**, and **TestNG** designed for validating RESTful web services, JSON schemas, status codes, and payload integrity.

---

## 🛠 Tech Stack & Tools
- **Language:** Java 17+
- **API Testing:** REST Assured 5.4.0
- **Test Runner:** TestNG 7.8.0
- **Data Serialization:** Jackson Databind & JSON-Path
- **Build Tool:** Gradle

---

## 🏗 Architecture & Project Layout
```text
src/
└── test/
    ├── java/
    │   ├── base/              # BaseApiTest: RequestSpecification & environment setup
    │   └── tests/             # Endpoint test suites (CRUD operations, status code validation)
    └── resources/
        └── TestNG.xml         # Test suite orchestration & execution runners  
