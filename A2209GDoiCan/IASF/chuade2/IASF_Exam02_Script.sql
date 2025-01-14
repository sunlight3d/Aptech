CREATE TABLE doctor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL
);

CREATE TABLE patient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    dob DATE NOT NULL
);

CREATE TABLE appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_date DATE NOT NULL,
    status ENUM('Scheduled', 'Completed', 'Canceled') NOT NULL DEFAULT 'Scheduled',
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE,
    FOREIGN KEY (doctor_id) REFERENCES doctor(id) ON DELETE CASCADE
);

INSERT INTO doctor (name, specialization, email, phone) VALUES
('Dr. John Smith', 'Cardiology', 'john.smith@hospital.com', '123-456-7890'),
('Dr. Emily Davis', 'Dermatology', 'emily.davis@hospital.com', '123-456-7891'),
('Dr. Michael Brown', 'Neurology', 'michael.brown@hospital.com', '123-456-7892'),
('Dr. Sarah Johnson', 'Pediatrics', 'sarah.johnson@hospital.com', '123-456-7893'),
('Dr. James Wilson', 'Orthopedics', 'james.wilson@hospital.com', '123-456-7894'),
('Dr. Laura Taylor', 'Gynecology', 'laura.taylor@hospital.com', '123-456-7895'),
('Dr. Robert Anderson', 'Psychiatry', 'robert.anderson@hospital.com', '123-456-7896'),
('Dr. Mary Thomas', 'Radiology', 'mary.thomas@hospital.com', '123-456-7897'),
('Dr. Richard Garcia', 'Ophthalmology', 'richard.garcia@hospital.com', '123-456-7898'),
('Dr. Lisa Martinez', 'Endocrinology', 'lisa.martinez@hospital.com', '123-456-7899');

INSERT INTO patient (first_name, last_name, email, phone, dob) VALUES
('Alice', 'Williams', 'alice.williams@example.com', '987-654-3210', '1980-05-12'),
('Bob', 'Johnson', 'bob.johnson@example.com', '987-654-3211', '1975-03-25'),
('Charlie', 'Brown', 'charlie.brown@example.com', '987-654-3212', '1990-07-30'),
('Daisy', 'Miller', 'daisy.miller@example.com', '987-654-3213', '1985-11-18'),
('Edward', 'Taylor', 'edward.taylor@example.com', '987-654-3214', '2000-01-02'),
('Fiona', 'Wilson', 'fiona.wilson@example.com', '987-654-3215', '1995-08-19'),
('George', 'Anderson', 'george.anderson@example.com', '987-654-3216', '1970-12-15'),
('Hannah', 'Moore', 'hannah.moore@example.com', '987-654-3217', '1988-09-05'),
('Ian', 'Clark', 'ian.clark@example.com', '987-654-3218', '1992-04-10'),
('Julia', 'Hall', 'julia.hall@example.com', '987-654-3219', '1997-06-22');

INSERT INTO appointment (appointment_date, status, patient_id, doctor_id) VALUES
('2024-12-20', 'Scheduled', 1, 1),
('2024-12-21', 'Completed', 2, 1),
('2024-12-22', 'Canceled', 3, 2),
('2024-12-23', 'Scheduled', 4, 3),
('2024-12-24', 'Completed', 5, 3),
('2024-12-25', 'Scheduled', 6, 4),
('2024-12-26', 'Scheduled', 7, 5),
('2024-12-27', 'Scheduled', 8, 6),
('2024-12-28', 'Scheduled', 9, 7),
('2024-12-29', 'Completed', 10, 8),
('2024-12-30', 'Scheduled', 1, 9),
('2024-12-31', 'Scheduled', 2, 9),
('2025-01-01', 'Completed', 3, 10),
('2025-01-02', 'Canceled', 4, 10),
('2025-01-03', 'Scheduled', 5, 1);