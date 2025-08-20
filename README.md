# Tour Service API

A Spring Boot REST API for managing tours. Supports CRUD operations, image uploads to AWS S3, Swagger documentation, and optional deployment on AWS.

---

 🚀 Tech Stack

- Java 17  
- Spring Boot 3.x** (Web, Data JPA, Validation, Security)  
- postgreSQL (Database)  
- Swagger / SpringDoc** (API documentation)  
- AWS S3 (Image storage)  
- Docker (optional)  
- JUnit / Mockito (Unit testing)  

---

## ⚙️ Setup Instructions

1. Clone the Repository
bash
git clone https://github.com/<your-username>/tourservice.git
cd tourservice

2. Configure Database
spring.datasource.url=jdbc:mysql://localhost:3306/tourdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

3. AWS S3 Configuration
aws.accessKey=<your-access-key>
aws.secretKey=<your-secret-key>
aws.s3.bucket=tourservice-bucket

4. Build & Run
mvn clean install
mvn spring-boot:run


Application runs at:
http://localhost:8080


5. API Endpoints

| Method | Endpoint          | Description     | Auth    |
| ------ | ----------------- | --------------- | ------- |
| POST   | `/api/tours`      | Create new tour | API Key |
| GET    | `/api/tours`      | Get all tours   | API Key |
| GET    | `/api/tours/{id}` | Get tour by ID  | API Key |
| PUT    | `/api/tours/{id}` | Update tour     | API Key |
| DELETE | `/api/tours/{id}` | Delete tour     | API Key |


6. API Security
X-API-KEY: your-secret-key


7. Postman Collection
curl -H "X-API-KEY: your-secret-key" http://localhost:8080/api/tours
