-- Create the database
CREATE DATABASE HospitalDB;
GO

-- Use the created database
USE HospitalDB;
GO

-- Create the Ward table
CREATE TABLE Ward (
    WardId INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Capacity INT NOT NULL CHECK (Capacity >= 1)
);
GO

-- Create the Nurse table
CREATE TABLE Nurse (
    NurseId INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Certification NVARCHAR(255) NOT NULL,
    WardId INT NOT NULL,
    FOREIGN KEY (WardId) REFERENCES Ward(WardId)
);
GO

-- Insert sample data into the Ward table
INSERT INTO Ward (Name, Capacity) VALUES
('Cardiology', 20),
('Oncology', 15),
('Pediatrics', 30),
('Neurology', 25),
('Emergency', 50),
('Orthopedics', 18),
('Maternity', 22),
('ICU', 10),
('Surgery', 12),
('Dermatology', 16);
GO

-- Insert sample data into the Nurse table
INSERT INTO Nurse (Name, Certification, WardId) VALUES
('Alice Johnson', 'Certified Registered Nurse', 1),
('Bob Smith', 'Advanced Practice Registered Nurse', 1),
('Carol White', 'Licensed Practical Nurse', 2),
('David Green', 'Certified Nurse Midwife', 2),
('Emma Thompson', 'Certified Registered Nurse Anesthetist', 3),
('Fiona Gallagher', 'Clinical Nurse Specialist', 3),
('George Harris', 'Certified Dialysis Nurse', 4),
('Hannah Adams', 'Certified Pediatric Nurse', 4),
('Ian Clark', 'Oncology Certified Nurse', 5),
('Julia Scott', 'Orthopedic Nurse Certified', 5);
GO
