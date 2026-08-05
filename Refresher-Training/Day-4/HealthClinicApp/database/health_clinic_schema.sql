CREATE DATABASE IF NOT EXISTS health_clinic_db;
USE health_clinic_db;

DROP TABLE IF EXISTS visit_history;
DROP TABLE IF EXISTS billing;
DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS doctor_specializations;
DROP TABLE IF EXISTS patient_phones;
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS specializations;
DROP TABLE IF EXISTS patients;

CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    email VARCHAR(100) UNIQUE,
    registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE patient_phones (
    phone_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE,
    INDEX idx_patient_id (patient_id)
);

CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100) UNIQUE
);

CREATE TABLE specializations (
    specialization_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255)
);

CREATE TABLE doctor_specializations (
    doctor_id INT NOT NULL,
    specialization_id INT NOT NULL,
    PRIMARY KEY (doctor_id, specialization_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) ON DELETE CASCADE,
    FOREIGN KEY (specialization_id) REFERENCES specializations(specialization_id) ON DELETE CASCADE
);

CREATE TABLE appointments (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    status ENUM('Scheduled', 'Completed', 'Cancelled') DEFAULT 'Scheduled',
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
    INDEX idx_patient_id (patient_id),
    INDEX idx_doctor_date (doctor_id, appointment_date),
    INDEX idx_status (status)
);

CREATE TABLE billing (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT NOT NULL UNIQUE,
    amount DECIMAL(10,2) NOT NULL,
    payment_status ENUM('Pending', 'Paid', 'Refunded') DEFAULT 'Pending',
    billing_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);

CREATE TABLE visit_history (
    visit_id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT NOT NULL UNIQUE,
    diagnosis VARCHAR(255),
    prescription VARCHAR(255),
    visit_notes TEXT,
    FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);

INSERT INTO patients (first_name, last_name, date_of_birth, gender, email)
VALUES
('Ramesh', 'Kumar', '1979-05-14', 'Male', 'ramesh@email.com'),
('Sita', 'Sharma', '1992-03-21', 'Female', 'sita@email.com');

INSERT INTO patient_phones (patient_id, phone_number)
VALUES (1, '9876543210'), (1, '9998887777'), (2, '8887776666');

INSERT INTO doctors (first_name, last_name, phone_number, email)
VALUES
('Anjali', 'Rao', '9123456780', 'dr.rao@clinic.com'),
('Vikram', 'Mehta', '9012345678', 'dr.mehta@clinic.com');

INSERT INTO specializations (name, description)
VALUES
('Cardiology', 'Heart-related treatment'),
('Pediatrics', 'Child healthcare'),
('Dermatology', 'Skin and hair treatment');

INSERT INTO doctor_specializations (doctor_id, specialization_id)
VALUES (1, 1), (2, 2);

INSERT INTO appointments (patient_id, doctor_id, appointment_date, status)
VALUES
(1, 1, '2026-08-05 10:00:00', 'Scheduled'),
(2, 2, '2026-08-06 11:30:00', 'Scheduled');
