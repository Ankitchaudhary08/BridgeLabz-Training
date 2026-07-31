
-- Hospital Database Practice


CREATE DATABASE fortis_hospital;
USE fortis_hospital;

-- Create Patient Table
CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    dob DATE,
    gender ENUM('Male','Female','Other'),
    mobile VARCHAR(15) UNIQUE,
    email VARCHAR(80),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ALTER Commands
ALTER TABLE patients MODIFY COLUMN email VARCHAR(120);

ALTER TABLE patients ADD COLUMN city VARCHAR(50);

ALTER TABLE patients CHANGE COLUMN city patient_city VARCHAR(50);

ALTER TABLE patients DROP COLUMN patient_city;

-- Rename Table
RENAME TABLE patients TO hospital_patients;

RENAME TABLE hospital_patients TO patients;

-- Insert Patient Records
INSERT INTO patients(full_name,dob,gender,mobile,email)
VALUES
('Rahul Sharma','1998-06-15','Male','9876543210','rahul@gmail.com');

INSERT INTO patients(full_name,dob,gender,mobile,email)
VALUES
('Priya Verma','1999-11-22','Female','9876543211','priya@gmail.com'),
('Rohan Singh','2001-03-08','Male','9876543212','rohan@gmail.com');

-- Update
UPDATE patients
SET mobile='9998887777'
WHERE patient_id=1;

-- Delete
DELETE FROM patients
WHERE patient_id=3;

-- Create Doctor Table
CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    specialization VARCHAR(100),
    mobile VARCHAR(15),
    email VARCHAR(100)
);

-- Insert Doctor Records
INSERT INTO doctors(first_name,last_name,specialization,mobile,email)
VALUES
('Ankit','Mehra','Cardiologist','9123456701','ankit@fortis.com'),
('Sneha','Kapoor','Neurologist','9123456702','sneha@fortis.com');

-- Display Data
SELECT * FROM patients;

SELECT * FROM doctors;


-- College Database Practice


CREATE DATABASE university_db;

USE university_db;

-- Student Table
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100)
);

-- Course Enrollment Table
CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    FOREIGN KEY(student_id)
    REFERENCES students(student_id)
);

-- Course Table with Composite Key
CREATE TABLE courses (
    course_id INT,
    semester INT,
    PRIMARY KEY(course_id,semester)
);

-- Insert Students
INSERT INTO students
VALUES
(101,'Aarav Sharma'),
(102,'Diya Gupta'),
(103,'Karan Verma');

-- Insert Enrollments
INSERT INTO enrollments
VALUES
(1,101),
(2,102);

-- INNER JOIN
SELECT *
FROM students
INNER JOIN enrollments
ON students.student_id=enrollments.student_id;

-- LEFT JOIN
SELECT *
FROM students
LEFT JOIN enrollments
ON students.student_id=enrollments.student_id;

-- FULL OUTER JOIN Simulation
SELECT *
FROM students
LEFT JOIN enrollments
ON students.student_id=enrollments.student_id

UNION

SELECT *
FROM students
RIGHT JOIN enrollments
ON students.student_id=enrollments.student_id;