CREATE DATABASE StudentManagementSystem;
USE StudentManagementSystem;
CREATE TABLE Class(
	ClassId INT NOT NULL,
	ClassCode NVARCHAR(50),
);

ALTER TABLE Class
ADD CONSTRAINT PK_Class PRIMARY KEY(ClassId);

INSERT INTO Class(ClassId, ClassCode) VALUES
(1, N'C1106KV'),
(2, N'C1108GV'),
(3, N'C1108IV'),
(4, N'C1108HV'),
(5, N'C1109GV');

CREATE TABLE Student(
	StudentId INT NOT NULL,
	StudentName NVARCHAR(50),
	BirthDate DATETIME,
	ClassId INT
);
ALTER TABLE Student
ADD CONSTRAINT PK_Student PRIMARY KEY(StudentId);

ALTER TABLE Student ADD CONSTRAINT FK_Student_Class
FOREIGN KEY(ClassId) References Class(ClassId);

CREATE NONCLUSTERED INDEX NCI_Student_StudentName ON Student(StudentName ASC);

INSERT INTO Student(StudentId, StudentName, BirthDate, ClassId) VALUES
(1,N'Phạm Tuấn Anh','1993-08-05',1),
(2,N'Phan Văn Huy','1992-06-10',1),
(3,N'Nguyễn Hoàng Minh','1992-09-07',2),
(4,N'Trần Tuấn Tú','1993-10-10',2),
(5,N'Đỗ Anh Tài','1992-06-06',3);

CREATE TABLE Subject(
	SubjectId INT NOT NULL,
	SubjectName NVARCHAR(100),
	SessionCount INT
);
ALTER TABLE Subject ADD CHECK (SessionCount>=0); 

ALTER TABLE Subject
ADD CONSTRAINT PK_Subject PRIMARY KEY(SubjectId);

ALTER TABLE Result ADD CONSTRAINT FK_Result_Subject
FOREIGN KEY(SubjectId) References Subject(SubjectId);

INSERT INTO Subject(SubjectId, SubjectName, SessionCount) VALUES
(1, N'C Programming', 22),
(2, N'Web Design', 18),
(3, N'Database Management', 23);

CREATE TABLE Result(
	StudentId INT NOT NULL,
	SubjectId INT NOT NULL,
	Mark INT
);
ALTER TABLE Result
ADD CONSTRAINT PK_Result PRIMARY KEY(StudentId,SubjectId);

ALTER TABLE Result ADD CONSTRAINT FK_Result_Student
FOREIGN KEY(StudentId) References Student(StudentId);

ALTER TABLE Result ALTER COLUMN Mark FLOAT;

INSERT INTO Result(StudentId, SubjectId, Mark) VALUES
(1, 1, 8), 
(1, 2, 7), 
(2, 3, 5), 
(3, 2, 6), 
(4, 3, 9), 
(5, 2, 8);

SELECT 
    StudentId AS 'MãSinhViên', 
    StudentName AS 'TênSinhViên', 
    BirthDate AS 'NgàySinh'
FROM Student 
WHERE 
    Student.BirthDate 
        BETWEEN '1992-10-10' AND '1993-10-10';

SELECT
    Class.ClassId AS 'MãLớp',
    Class.ClassCode AS 'TênLớp',
    (CASE WHEN Query2.NumberOfStudents IS NULL THEN 0 ELSE Query2.NumberOfStudents END) AS 'SĩSốLớp'
FROM 
    (SELECT
        ClassID,        
        COUNT(*) AS NumberOfStudents
    FROM Student
    GROUP BY ClassID) AS Query2
    RIGHT JOIN Class
ON Query2.ClassId = Class.ClassId;    


SELECT 
    Student.StudentId AS 'MãSinhViên',
    Student.StudentName AS 'TênSinhViên',
    Query2.TotalOfMark AS 'TổngĐiểm'
FROM Student 
INNER JOIN (SELECT
	StudentId,
	SUM(Mark) AS TotalOfMark
FROM Result
GROUP BY StudentID
HAVING SUM(Mark) > 10) AS Query2
ON Student.StudentId = Query2.StudentId;    

CREATE VIEW view_StudentSubjectMark AS 
SELECT 
    Student.StudentId,
    Student.StudentName,
    Subject.SubjectName,
    Result.Mark    
FROM Student
INNER JOIN Result ON Student.StudentId = Result.StudentId
INNER JOIN Subject ON Result.SubjectId = Subject.SubjectId;


SELECT * FROM view_StudentSubjectMark;

