# HealthClinicApp

Java JDBC console application for a clinic receptionist.

## Features

- Register, list, view, update, and delete patients
- Register, list, view, update, and delete doctors
- Manage specializations and assign them to doctors
- Book, list, update, and cancel appointments
- Complete an appointment in one transaction:
  - appointment status becomes `Completed`
  - bill is created
  - visit history is created
- View and update billing records
- View visit history

## Database

Run `database/health_clinic_schema.sql` in MySQL first.

Default connection values:

- URL: `jdbc:mysql://localhost:3306/health_clinic_db?useSSL=false&serverTimezone=UTC`
- User: `root`
- Password: `root`

You can override them without editing code:

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/health_clinic_db?useSSL=false&serverTimezone=UTC"
$env:DB_USER="root"
$env:DB_PASSWORD="your_password"
```

## Run

```powershell
mvn clean compile
mvn exec:java
```
