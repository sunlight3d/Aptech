CREATE DATABASE StudentManagement;
CREATE SEQUENCE sequence_student_id
    AS INT
    START WITH 1
    INCREMENT BY 1;
CREATE TABLE Student (
    id varchar(10) PRIMARY KEY 
		DEFAULT 'SV' + RIGHT('000' + CAST(NEXT VALUE FOR sequence_student_id AS VARCHAR(10)), 3),
    FullName varchar(255) NOT NULL,
    Gender varchar(10) NOT NULL,
    PhoneNumber varchar(15) NOT NULL,
    Height int NOT NULL,
    DOB date NOT NULL
);
INSERT INTO Student (FullName, Gender, PhoneNumber, Height, DOB)
VALUES
    ('John Doe', 'Male', '1234567890', 170, '1980-01-01'),
    ('Jane Doe', 'Female', '2345678901', 160, '1981-02-01'),
    ('Bob Smith', 'Male', '3456789012', 175, '1982-03-01'),
    ('Alice Johnson', 'Female', '4567890123', 165, '1983-04-01'),
    ('Charlie Brown', 'Male', '5678901234', 180, '1984-05-01'),
    ('Emily Davis', 'Female', '6789012345', 155, '1985-06-01'),
    ('Michael Wilson', 'Male', '7890123456', 185, '1986-07-01'),
    ('Sarah Green', 'Female', '8901234567', 150, '1987-08-01'),
    ('William Baker', 'Male', '9012345678', 170, '1988-09-01'),
    ('Elizabeth Jones', 'Female', '0123456789', 160, '1989-10-01'),
    ('David Lewis', 'Male', '1234567890', 175, '1990-11-01'),
    ('Karen King', 'Female', '2345678901', 165, '1991-12-01'),
    ('James Clark', 'Male', '3456789012', 180, '1992-01-01'),
    ('Maria Martinez', 'Female', '4567890123', 155, '1993-02-01'),
    ('William Lee', 'Male', '5678901234', 185, '1994-03-01'),
    ('Jennifer Davis', 'Female', '6789012345', 150, '1995-04-01'),
    ('Daniel Wilson', 'Male', '7890123456', 170, '1996-05-01'),
    ('Linda Young', 'Female', '8901234567', 160, '1997-06-01'),
    ('Richard Anderson', 'Male', '9012345678', 175, '1998-07-01');
