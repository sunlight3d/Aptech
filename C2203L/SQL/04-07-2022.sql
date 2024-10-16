CREATE DATABASE StudentManagementSystem;
USE StudentManagementSystem;--switch to a specific DB
CREATE TABLE Class(
	--classId, ClassCode,.. are called "fields, properties"
	ClassId INT NOT NULL, --"not null" is called "constraints"
	ClassCode NVARCHAR(50), -- Unicode variable character 
);
CREATE TABLE Student( --syntax => UPPERCASE
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
CREATE NONCLUSTERED INDEX NCI_Student_StudentName   
ON Student(StudentName);
DROP INDEX IF EXISTS NCI_Student_StudentName ON Student;
--alter table change column type sql server
--alter table IS NOT "update"(change data)
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
--insert data to DB
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
SELECT * FROM Result;
--6.Query operations - cac thao tac truy van
SELECT 
	--AS = alias = bí danh
	Student.StudentId AS N'Mã sinh viên', 
	Student.StudentName as N'Tên Sinh viên', 
	FORMAT(Student.BirthDate, 'yyyy-MM-dd') AS N'Ngày sinh' 
FROM Student 
WHERE BirthDate BETWEEN '1992-10-10' 
		AND '1993-10-10';

SELECT * FROM Class;
SELECT * FROM Student;

SELECT Class.ClassId, Class.ClassCode, Student.StudentId
FROM Class
INNER JOIN Student ON Class.ClassId=Student.ClassId;

--idea = join Q1 + Class
SELECT 
	Class.ClassId AS 'Mã Lớp', 
	Class.ClassCode AS 'Tên lớp', 
	IIF(Q1.numberOfStudents IS NULL, 0, Q1.numberOfStudents) AS 'Sĩ số lớp'
FROM 
	(SELECT COUNT(ClassId) AS numberOfStudents, 
	ClassId
	FROM Student
	GROUP BY ClassId) AS Q1
RIGHT JOIN Class ON Q1.ClassId = Class.ClassId;
--Sum up mark of all subjects for each student
SELECT * FROM Result;

SELECT 
	Student.StudentId AS 'Mã Sinh Viên', 
	Student.StudentName AS 'Tên Sinh Viên',
	Q1.TotalMark AS 'Tổng điểm'
	--IIF(Q1.TotalMark IS NULL, N'Chưa thi', CONVERT(varchar(10),Q1.TotalMark)) AS 'Tổng điểm'
FROM 
	(SELECT StudentId, SUM(Mark) AS TotalMark
		FROM Result GROUP BY StudentId) AS Q1
INNER JOIN Student
ON Student.StudentId = Q1.StudentId;

--7. Views
DROP VIEW view_StudentSubjectMark;
CREATE VIEW view_StudentSubjectMark AS 
SELECT
	Student.StudentId,
	Student.StudentName,
	Subject.SubjectName, 
	Result.Mark
FROM Student
JOIN Result
  ON Student.StudentId = Result.StudentId
JOIN Subject
  ON Result.SubjectId = Subject.SubjectId;

SELECT TOP 3 * FROM view_StudentSubjectMark ORDER BY Mark DESC; -- descending

SELECT * FROM Result WHERE SubjectId = 2;



CREATE PROCEDURE up_IncreaseMark 
@SubjectId INT AS
BEGIN
	UPDATE Result SET Result.Mark = Result.Mark - 1
	WHERE Result.SubjectId = 2;
END
