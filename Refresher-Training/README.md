# 📘 Day 1 - DBMS Fundamentals & RDBMS Basics

##  Overview

On Day 1, I learned the fundamentals of Database Management Systems (DBMS) and Relational Database Management Systems (RDBMS). I explored how databases are used to store and manage data efficiently and practiced basic SQL commands using MySQL Workbench.

---

##  Topics Covered

- What is Data, Database, and DBMS
- File System vs DBMS
- Advantages of DBMS
- Types of DBMS
- Introduction to RDBMS
- Features of RDBMS
- SQL vs NoSQL
- Introduction to MySQL
- MySQL Architecture
- Creating Databases and Tables
- DDL (CREATE, ALTER, DROP, TRUNCATE, RENAME)
- DML (INSERT, UPDATE, DELETE)
- TCL (COMMIT, ROLLBACK)
- DCL (GRANT, REVOKE)

---

##  Practical Work

### 🏥 Hospital Database
- Created a Hospital database.
- Created `patients` and `doctors` tables.
- Inserted, updated, deleted, and retrieved records.
- Modified table structure using `ALTER TABLE`.
- Practiced `RENAME`, `DROP`, and `TRUNCATE` commands.

###  College Database
- Created `students`, `enrollments`, and `courses` tables.
- Implemented Primary Key, Foreign Key, and Composite Key.
- Practiced SQL Joins:
  - INNER JOIN
  - LEFT JOIN
  - RIGHT JOIN
  - FULL OUTER JOIN (using UNION)

---

##  Technologies Used

- MySQL
- MySQL Workbench
- SQL
- Visual Studio Code
- Git & GitHub

---

##  Files

```
Day-1/
├── Day1_SQL_Query.sql
└── README.md
```

---

##  Key Learnings

- Understood the basics of DBMS and RDBMS.
- Learned the difference between SQL and NoSQL.
- Created databases and tables using SQL.
- Performed CRUD operations.
- Practiced DDL, DML, TCL, and DCL commands.
- Worked with Primary Keys, Foreign Keys, and Joins.
- Gained hands-on experience with MySQL Workbench.

---

## 🚀 Outcome

Successfully completed the Day 1 DBMS practice by building sample databases and executing essential SQL commands. This provided a strong foundation for learning advanced database concepts in the upcoming sessions.


---

# 📘 Day 2 - Database Design & Optimization

## Overview

On Day 2, I learned how to design efficient and well-structured databases using Entity Relationship (ER) Diagrams, Database Indexing, and Database Normalization. I understood how proper database design improves data consistency, minimizes redundancy, and enhances query performance.

## Topics Covered

### 1. Entity Relationship (ER) Diagram

* Introduction to ER Diagrams
* Entities
* Attributes
* Relationships
* Cardinality
* Primary Key
* Foreign Key
* Weak Entity
* ER Diagram Design Principles

### 2. Database Indexing

* What is an Index?
* Purpose of Indexing
* Clustered Index
* Non-Clustered Index
* Advantages of Indexing
* Disadvantages of Over-Indexing
* Impact of Indexing on Query Performance

### 3. Database Normalization

* First Normal Form (1NF)
* Second Normal Form (2NF)
* Third Normal Form (3NF)
* Boyce-Codd Normal Form (BCNF)
* Eliminating Data Redundancy
* Improving Database Consistency

## Practical Work

### 🏥 Health Clinic Database

* Designed the database structure using an ER Diagram.
* Identified entities, attributes, and relationships.
* Applied Primary Key and Foreign Key constraints.
* Implemented normalization up to BCNF.
* Created SQL scripts for the Health Clinic database.
* Analyzed where indexes should be used to optimize query performance.

## Technologies Used

* MySQL
* MySQL Workbench
* SQL
* Visual Studio Code
* Git & GitHub

## Files

```text
Day-2/
├── Health_Clinic.sql
└── README.md
```

## Key Learnings

* Understood the importance of database design before implementation.
* Learned to create ER diagrams for real-world applications.
* Explored different relationship types and cardinality.
* Understood the role of indexing in improving query performance.
* Learned when indexes should and should not be used.
* Applied database normalization (1NF, 2NF, 3NF, and BCNF).
* Designed efficient and optimized relational databases.

## 🚀 Outcome

Successfully completed Day 2 by learning database design principles, implementing normalization techniques, and understanding indexing concepts. This strengthened my foundation in designing scalable, efficient, and optimized relational databases for real-world applications.


# 📘 Day 3 - SQL Joins, Stored Procedures & Triggers

## Overview

On Day 3, I learned advanced SQL concepts including SQL Joins, Stored Procedures, and Triggers using MySQL. I practiced retrieving data from multiple related tables, creating reusable database procedures with different parameter types, handling errors, and automating database operations using triggers in the Health Clinic database.

---

## Topics Covered

### 1. SQL Joins

- INNER JOIN
- LEFT JOIN
- RIGHT JOIN
- FULL OUTER JOIN (using UNION)
- SELF JOIN
- CROSS JOIN
- Multiple Table Join

### 2. Stored Procedures

- Why Stored Procedures
- Creating Stored Procedures
- Calling Stored Procedures
- IN Parameters
- OUT Parameters
- INOUT Parameters
- Error Handling

### 3. Triggers

- BEFORE INSERT
- AFTER INSERT
- BEFORE UPDATE
- AFTER UPDATE
- BEFORE DELETE
- AFTER DELETE

---

## Practical Work

### 🏥 Health Clinic Database

- Performed different types of SQL Joins on multiple related tables.
- Retrieved patient, doctor, appointment, billing, and specialization details using multi-table joins.
- Created Stored Procedures to automate common database operations.
- Implemented procedures using IN, OUT, and INOUT parameters.
- Added error handling using transactions and exception handlers.
- Created Triggers to automatically validate data, maintain audit logs, and enforce business rules.
- Practiced BEFORE and AFTER triggers for INSERT, UPDATE, and DELETE operations.

---

## Technologies Used

- MySQL
- MySQL Workbench
- SQL
- Visual Studio Code
- Git & GitHub

---

## Files

```text
Day-3/
├── Health_Clinic_join.sql
└── README.md
```

---

## Key Learnings

- Understood how different SQL Joins combine data from multiple related tables.
- Learned when to use INNER, LEFT, RIGHT, FULL OUTER, SELF, and CROSS JOIN.
- Created reusable Stored Procedures for database operations.
- Worked with IN, OUT, and INOUT parameters.
- Implemented error handling using transactions and SQL exception handlers.
- Automated database operations using Triggers.
- Learned to maintain data integrity and audit logs using BEFORE and AFTER triggers.
- Gained hands-on experience building advanced SQL solutions using the Health Clinic database.

---

## 🚀 Outcome

Successfully completed Day 3 by implementing advanced SQL concepts including SQL Joins, Stored Procedures, and Triggers. Built reusable database logic, automated data validation and auditing, and strengthened practical SQL skills required for developing real-world database applications.

# 📘 Day 4 - Implement CRUD Operations in Health Clinic App

## Overview

On Day 4, I worked on the **Health Clinic Application** by testing different modules and understanding how they interact with each other. I performed CRUD operations, booked appointments, generated bills, and explored important backend concepts like layered architecture, DAO, transactions, and connection pooling.

---

## Topics Covered

- Patient CRUD Operations
- Doctor & Specialization Management
- Appointment Booking
- Billing Module
- Visit History
- Layered Architecture
- DAO Pattern
- Connection Pooling
- Transactions
- Foreign Keys

---

## Practical Work

### 🏥 Health Clinic Application

- Tested Patient CRUD operations (Add, List, View, Update).
- Added doctors and linked them with specializations.
- Created specializations such as Cardiology and Dermatology.
- Booked appointments using valid Patient ID and Doctor ID.
- Completed appointments, which automatically generated Billing and Visit History records.
- Viewed bills, checked bills for specific appointments, and marked bills as **Paid**.

---

## Technologies Used

- Java
- JDBC
- MySQL
- HikariCP
- Maven
- Git & GitHub

---

## Files

```text
Day-4/
├── HealthClinicApp/
└── README.md
```

---

## Key Learnings

- Understood the layered architecture (**UI → Service → DAO → Database**).
- Learned why DAO uses an interface and implementation.
- Explored how connection pooling improves database performance.
- Learned how transactions maintain data consistency during multiple database operations.
- Understood the importance of foreign keys in maintaining valid relationships between tables.

---

## 🚀 Outcome

Successfully completed Day 4 by testing the core modules of the Health Clinic Application and gaining practical experience with CRUD operations, appointment management, billing workflow, layered architecture, transactions, and database relationships.

---

# Day 5 - Java Servlet Fundamentals

## 📚 Overview

This module covers the fundamentals of **Java Servlets**, **Apache Tomcat**, **Maven Web Applications**, **HTTP request handling**, and **HTML form integration**. A **Greeting Application** was built to understand the complete request-response lifecycle.

---

## 📌 Topics Covered

### Java Servlet Basics

- Introduction to Java Servlets
- Role of Servlets in Java Web Applications
- Servlet Architecture
- Servlet Life Cycle

### Apache Tomcat

- Installing and Configuring Apache Tomcat 10
- Setting up `JAVA_HOME`
- Deploying WAR Files
- Understanding the `webapps` Directory
- Running Applications on Tomcat

### Maven Web Application

- Creating a Maven Web Project
- Understanding Project Structure
- Configuring `pom.xml`
- WAR Packaging
- Maven Build Process

### Servlet Development

- Creating a Servlet using `HttpServlet`
- Using `@WebServlet`
- Working with `HttpServletRequest`
- Working with `HttpServletResponse`
- Using `PrintWriter`

### HTTP Methods

- `doGet()`
- `doPost()`
- GET vs POST
- Using `request.getParameter()`

### HTML Form Integration

- Creating HTML Forms
- GET & POST Form Submission
- Connecting HTML Forms with Servlets
- Processing User Input

---

## 🚀 Project

### Greeting Application

Built a simple Greeting Application to understand servlet-based web application development.

**Features:**

- HTML Form
- Servlet Mapping
- GET Request Handling
- POST Request Handling
- Dynamic Response Generation

---

## 🛠️ Troubleshooting & Debugging

- Fixed `JAVA_HOME` Configuration Issues
- Resolved Tomcat Deployment Problems
- Fixed HTTP 404 Errors
- Fixed HTTP 405 Errors
- Understood WAR Deployment
- Rebuilt & Redeployed Maven Projects

---

## 💻 Technologies Used

| Technology | Version / Purpose |
|------------|-------------------|
| Java | 21 |
| Jakarta Servlet API | 6 |
| Apache Tomcat | 10 |
| Maven | Build & Dependency Management |
| HTML | Form & UI |
| IntelliJ IDEA | Development Environment |

---

## 🎯 Key Concepts Learned

- Java Servlet Fundamentals
- Request-Response Cycle
- Servlet Mapping
- GET vs POST
- Form Handling
- Tomcat Configuration
- Maven WAR Packaging
- Web Application Deployment
- Basic Web Application Debugging

## 🎯 Next Steps

- Push the project to GitHub.
- Test Delete operations.
- Verify Visit History module.
- Perform complete end-to-end testing.

  # Day 6 - CRUD Operation with Spring Boot

## 📚 Overview

On Day 6, I implemented **CRUD (Create, Read, Update, Delete) operations** in the Greeting Application using **Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

The application follows a layered architecture with **Controller, Service, Repository, Entity, and DTO** layers to understand how data flows between the client and database.

---

## 📌 Topics Covered

### Spring Boot CRUD

- Understanding CRUD operations
- Creating REST APIs
- Handling HTTP requests
- Working with Spring Boot layers
- Dependency Injection
- Constructor-based Dependency Injection

### Spring Data JPA

- Creating Repository interfaces
- Extending `JpaRepository`
- Using predefined CRUD methods
- `save()`
- `findAll()`
- `findById()`
- `delete()`

### Hibernate & MySQL

- Connecting Spring Boot with MySQL
- Database configuration
- Automatic table creation using Hibernate
- Using `spring.jpa.hibernate.ddl-auto=update`
- Understanding JPA Entity mapping

### Layered Architecture

- Controller Layer
- Service Layer
- Repository Layer
- Entity Layer
- DTO Layer
- Interface and Implementation

---

## 🚀 Project

### Greeting Application - CRUD

Enhanced the Greeting Application by implementing complete CRUD functionality for greeting messages.

### CRUD Operations

| Operation | HTTP Method | Purpose |
|-----------|-------------|---------|
| Create | `POST` | Create a new greeting |
| Read All | `GET` | Get all greetings |
| Read By ID | `GET` | Get a greeting by ID |
| Update | `PUT` | Update an existing greeting |
| Delete | `DELETE` | Delete a greeting |

---




# Day 7 - Spring REST API & Request Handling

## Start Developing ContactApp

### Topics Covered

- Spring REST API
- RESTful API Endpoints
- HTTP Methods
- Request Handling in Spring Boot
- `@RestController`
- `@RequestMapping`
- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`
- `@RequestBody`
- `@PathVariable`
- `@RequestParam`
- Response Handling
- H2 In-Memory Database Basics
- Distributed Architecture Overview

---

## 1. Spring REST API

A REST API allows different applications to communicate with each other over HTTP.

Spring Boot provides annotations that make it easy to create RESTful APIs.

### Basic Flow

```text
Client
   ↓
REST API
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Database


# Day 8 - Contact App Enhancement

### Topics Covered
- Completed Contact App
- Added `@Valid` request validation
- Added `@NotBlank`, `@Size`, and `@Pattern`
- Implemented centralized exception handling
- Created `ContactNotFoundException`
- Added `@RestControllerAdvice` and `@ExceptionHandler`
- Integrated H2 Database and H2 Console
- Added DTO Layer (Request DTO & Response DTO)
- Tested APIs using Postman

### Practice
- Tested Create, Get, and Update Contact APIs
- Tested validation and error handling
- Practiced DTO → Entity and Entity → DTO conversion

### Status
✅ Day 8 Completed
