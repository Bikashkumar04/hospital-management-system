# Hospital Management System

A Spring Boot-based Hospital Management System for managing patients, doctors, appointments, and insurance data. The application uses Spring Data JPA, PostgreSQL, validation, Lombok, and ModelMapper to expose a small REST API for hospital workflows.

## Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring Web MVC**
- **Spring Data JPA**
- **Spring Validation**
- **Spring Security**
- **PostgreSQL**
- **Lombok**
- **ModelMapper**
- **Maven Wrapper**

## Features

- Create and list patient records
- View doctors and appointments
- Create appointments for patients and doctors
- Assign or remove insurance from a patient
- Seed demo data on startup using `data.sql`

## Project Structure

```text
src/main/java/com/bikash/hospital_management_system
├── config/        # Application configuration (ModelMapper bean)
├── controller/    # REST controllers
├── dto/           # Request/response models
├── entity/        # JPA entities and enums
├── repository/    # Spring Data repositories
└── service/       # Business logic
```

## Prerequisites

Before running the project, make sure you have:

- Java 21 installed
- PostgreSQL running locally
- A database named `hospital_db`
- Maven Wrapper available in the project root

## Database Configuration

The application reads database settings from `src/main/resources/application.properties`.

Default settings used by the project:

- **URL:** `jdbc:postgresql://localhost:5432/hospital_db`
- **Username:** `postgres`
- **Password:** set in `application.properties`
- **JPA mode:** `create`
- **Seed data:** loaded from `classpath:data.sql`

> Tip: For real usage, move credentials to environment variables or an external config file instead of keeping them in source control.

## Run the Application

From the project root, run:

```bash
./mvnw spring-boot:run
```

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

The app starts on port **8081**.

## Main Endpoints

### Admin

- `GET /admin/patients?page=0&size=10`
  - Returns a paginated list of patients.

### Public / Hospital

- `GET /public/doctors`
  - Returns all doctors.

### Doctor

- `GET /doctors/appointments`
  - Returns appointments for a doctor.
  - Current implementation uses a hardcoded doctor ID in the controller.

### Patient

- `POST /patients/appointments`
  - Creates a new appointment.
  - Request body example:

```json
{
  "doctorId": 1,
  "patientId": 1,
  "appointmentTime": "2026-05-18T10:30:00",
  "reason": "General checkup"
}
```

- `GET /patients/profile`
  - Returns a patient profile.
  - Current implementation uses a hardcoded patient ID in the controller.

## Seed Data

The project includes `src/main/resources/data.sql` with sample records for:

- Patients
- Doctors
- Appointments

This makes it easier to try the API immediately after startup.

## Testing

Test classes are located under `src/test/java/com/bikash/hospital_management_system`.

To run tests:

```bash
./mvnw test
```

On Windows PowerShell:

```powershell
.\mvnw.cmd test
```

### Notes about tests

- The tests currently rely on application startup and the configured database.
- Some test methods print values rather than asserting behavior.
- If you change the schema or sample data, update the tests accordingly.

## Important Notes

- The project currently uses Spring Security on the classpath, but no custom security configuration was found.
- Some controllers use hardcoded IDs for demo purposes.
- The application is designed to work with a live PostgreSQL database.

## License

No license file is currently included.

