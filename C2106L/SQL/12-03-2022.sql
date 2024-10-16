CREATE DATABASE StudentManagementSystem;
USE StudentManagementSystem;
CREATE TABLE Class(
	ClassId INT NOT NULL,
	ClassCode NVARCHAR(50),
);

ALTER TABLE NhaTrenPho
ADD CONSTRAINT PK_NhaTrenPho PRIMARY KEY(NhaID);

ALTER TABLE NhaTrenPho
ADD CONSTRAINT FK_NhaTrenPho_DuongPho
FOREIGN KEY(DuongID) 
References DuongPho(DuongID);

CREATE TABLE Student(
	StudentId INT NOT NULL,
	StudentName NVARCHAR(50),
	BirthDate DATETIME,
	ClassId INT
);
CREATE NONCLUSTERED INDEX NCI_Student_StudentName ON Student(StudentName ASC);

CREATE TABLE Subject(
	SubjectId INT NOT NULL,
	SubjectName NVARCHAR(100),
	SessionCount INT
);

CREATE TABLE Result(
	StudentId INT NOT NULL,
	SubjectId INT NOT NULL,
	Mark INT
);
ALTER TABLE Result 
ALTER COLUMN Mark FLOAT;

--docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=123456" -p 1435:1433 --name sql-server-2019-container -d mcr.microsoft.com/mssql/server:2019-latest