CREATE DATABASE StudentManagementSystem;
USE StudentManagementSystem;
CREATE TABLE Class(
	ClassId INT NOT NULL,
	ClassCode NVARCHAR(50),
);
CREATE TABLE Student(
	StudentId INT NOT NULL,
	StudentName NVARCHAR(50),
	BirthDate DATETIME,
	ClassId INT,
);
CREATE TABLE Subject(
	SubjectId INT NOT NULL,
	SubjectName NVARCHAR(100),	
	SessionCount INT
);
CREATE TABLE Result (
	StudentId INT NOT NULL,
	SubjectId INT NOT NULL,	
	Mark INT
);
CREATE NONCLUSTERED INDEX CI_tblUser_UserID ON tblUser(StudentName);
DROP INDEX IF EXISTS NCI_Student_StudentName ON Student;
--alter table change column type sql server
ALTER TABLE Result ALTER COLUMN Mark FLOAT; 
--Constraints - rang buoc
-- alter table add constraint foreign key
ALTER TABLE Class ADD CONSTRAINT PK_Class PRIMARY KEY(classId); 
--ALTER TABLE Class DROP CONSTRAINT PK_Class; 
ALTER TABLE Student ADD CONSTRAINT PK_Student PRIMARY KEY(StudentId); 
--ALTER TABLE Class DROP CONSTRAINT PK_Student; 

ALTER TABLE Subject ADD CONSTRAINT PK_Subject PRIMARY KEY(SubjectId); 
--ALTER TABLE Subject DROP CONSTRAINT PK_Subject; 

ALTER TABLE Result ADD CONSTRAINT PK_Result PRIMARY KEY(StudentId, SubjectId); 
--ALTER TABLE Result DROP CONSTRAINT PK_Result; 

--alter table add foreign key sql server
ALTER TABLE Student
ADD CONSTRAINT FK_Student_Class
FOREIGN KEY (ClassId) REFERENCES Class(ClassId); 
--ALTER TABLE Student DROP CONSTRAINT FK_Student_Class; 
ALTER TABLE Result
ADD CONSTRAINT FK_Result_Student
FOREIGN KEY (StudentId) REFERENCES Student(StudentId); 
--ALTER TABLE Student DROP CONSTRAINT FK_Result_Student; 
ALTER TABLE Result
ADD CONSTRAINT FK_Result_Subject
FOREIGN KEY (StudentId) REFERENCES Student(StudentId); 
--ALTER TABLE Student DROP CONSTRAINT FK_Result_Subject; 
--alter table add constraint check sql server
ALTER TABLE Subject
ADD CONSTRAINT CK_Subject_SessionCount CHECK (SessionCount > 0); 
--ALTER TABLE Subject DROP CONSTRAINT CK_Subject_SessionCount; 
--sequence
INSERT INTO Class(ClassId, ClassCode) VALUES
(1, 'C1106KV'),
(2, 'C1108GV'),
(3, 'C1108IV'),
(4, 'C1108HV'),
(5, 'C1109GV');
SELECT * FROM Class;
INSERT INTO Student(StudentId, StudentName, BirthDate, ClassId) VALUES
(1, N'PhạmTuấnAnh', '1993-08-03',1),
(2, N'PhanVănHuy', '1992-07-03',1),
(3, N'NguyễnHoàng Minh', '1997-12-20',2),
(4, N'TrầnTuấnTú', '1993-01-25',2),
(5, N'ĐỗAnhTài', '1999-09-29',3);

DELETE FROM Student WHERE 1=1;
SELECT * FROM Student;

--INSERT INTO Class(ClassId, ClassCode) VALUES
--(1000, 'C22303L');
DELETE FROM Class WHERE ClassId=1000;

INSERT INTO Student(StudentId, StudentName, BirthDate, ClassId) 
VALUES(6, N'Nguyen vAn XX', '1999-09-29',1000);
SELECT * FROM Student;
DELETE FROM Student WHERE ClassId=1000;

INSERT INTO Subject(SubjectId, SubjectName, SessionCount) VALUES
(1, 'C Programming', 22),
(2, 'Web Design', 18),
(3, 'Database Managemen', 23);
INSERT INTO Result(StudentId, SubjectId, Mark) VALUES
(1,1,8),
(1,2,7),
(2,3,5),
(3,2,6),
(4,3,9);