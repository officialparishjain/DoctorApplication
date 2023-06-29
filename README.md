# Doctor Application
This project involves developing backend APIs for a patient-doctor management system. The system allows doctors to register patients through a web or mobile portal. The core functionalities include adding doctors and patients, recording patient symptoms, and suggesting doctors based on the symptoms provided.

## Models

The application consists of the following models:

### Doctor

The `Doctor` model represents a doctor entity and has the following properties:

- `doctorId` (Long): Unique identifier for the doctor.
- `doctorName` (String): Name of the doctor.
- `doctorEmail` (String): Email address of the doctor (unique).
- `doctorPhone` (String): Phone number of the doctor (unique).
- `doctorCity` (City): City where the doctor is located. It is an enumeration with values: Delhi, Noida, Faridabad.
- `doctorSpeciality` (Speciality): Speciality of the doctor. It is an enumeration with values: Orthopedic, Gynecology, Dermatology, ENT.

### Patient

The `Patient` model represents a patient entity and has the following properties:

- `patientId` (Long): Unique identifier for the patient.
- `patientName` (String): Name of the patient.
- `patientCity` (String): City where the patient is located.
- `patientEmail` (String): Email address of the patient (unique).
- `patientPhone` (String): Phone number of the patient (unique).
- `patientSymptom` (Symptoms): Symptom experienced by the patient. It is an enumeration with values related to different medical conditions.

### Speciality

The `Speciality` enumeration represents the specialities of doctors. The available specialities are:

- Orthopedic
- Gynecology
- Dermatology
- ENT

### Symptoms

The `Symptoms` enumeration represents the symptoms experienced by patients. The available symptoms are:

- Arthritis (Orthopedic speciality)
- Back_Pain (Orthopedic speciality)
- Tissue_Injuries (Orthopedic speciality)
- Dysmenorrhea (Gynecology speciality)
- Skin_Infection (Dermatology speciality)
- Skin_Burn (Dermatology speciality)
- Ear_Pain (ENT speciality)

### City

The `City` enumeration represents the cities where doctors and patients are located. The available cities are:

- Delhi
- Noida
- Faridabad

## Controllers

The application provides the following controllers to handle various HTTP requests:

### DoctorController

The `DoctorController` handles requests related to doctors.

- `POST /doctor/add`: Creates a new doctor. Expects a JSON body with doctor details. Returns a response indicating the status of the operation.

### PatientController

The `PatientController` handles requests related to patients.

- `POST /patient/add`: Creates a new patient. Expects a JSON body with patient details. Returns a response indicating the status of the operation.
- `GET /patient/suggest/{id}`: Suggests doctors for a patient based on their symptoms. Expects the patient ID as a path parameter. Returns a response with the suggested doctors.

## Services

The application provides the following services to handle business logic:

### DoctorService

The `DoctorService` provides methods for doctor-related operations.

- `addDoctor(Doctor doctor)`: Adds a new doctor to the system.
- `getDoctorBySpecialityAndCity(Speciality doctorSpeciality, City doctorCity)`: Retrieves a list of doctors with the specified speciality and city.

### PatientService

The `PatientService` provides methods for patient-related operations.

- `addPatient(Patient patient)`: Adds a new patient to the system.
- `suggestDoctor(Long id)`: Suggests doctors for the patient with the specified ID based on their symptoms.

## Repositories

The application uses the following repositories for data access:

### DoctorRepository

The `DoctorRepository` provides data access methods for the `Doctor` entity.

- `getDoctorByDoctorSpecialityAndDoctorCity(Speciality doctorSpeciality, City doctorCity)`: Retrieves a list of doctors with the specified speciality and city.

### PatientRepository

The `PatientRepository` provides data access methods for the `Patient` entity.

---

Feel free to customize this `README.md` file based on your project's specific requirements and add more details as needed.

