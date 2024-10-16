CREATE DATABASE StudentManagement;
USE StudentManagement;
DROP DATABASE StudentManagement; --dangerous, DONOT use!
CREATE TABLE tblMark(
 RollNumber INT, 
 FirstName NVARCHAR(50),
 LastName NVARCHAR(50),
 Subject NVARCHAR(70),
 Mark INT
);
--NVARCHAR: unicode variable character
--insert
--record = ban ghi = tuple

INSERT INTO tblMark(RollNumber, FirstName,	LastName,	Subject,	Mark)
			 VALUES(46,		'Johns',	'Bill',		'Math',		84);
SELECT * FROM tblMark;
--1 Department has N Employee
--1 Class has N Student
--1 Doctor has N Patient
--1 Patient has N Doctor
--1 Customer has N Invoice
CREATE TABLE Students(
	RollNumber INT,
	StudentName NVARCHAR(100)
);
INSERT INTO Students(StudentName, RollNumber)
VALUES('nguyen van a', 123);
SELECT * FROM Students;

CREATE TABLE Marks(
	RollNumber INT,--field, attribute
	MarkObtained FLOAT
);
INSERT INTO Marks(RollNumber, MarkObtained)
VALUES(555, 90.5);

--'2022_0T1'
--'2022_0H2'-> sequence 



