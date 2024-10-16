CREATE DATABASE StudentManagementSystem;

CREATE TABLE tblClass(
	ClassId INT NOT NULL, 
	ClassCode VARCHAR(50) NOT NULL
);
ALTER TABLE tblClass ADD PRIMARY KEY (ClassId);
--Them du lieu vao bang(insert)
-- INSERT INTO tblClass(ClassId, ClassCode) VALUES(1, 'C2009L');
-- INSERT INTO tblClass(ClassId, ClassCode) VALUES(2, 'C2009G');
-- INSERT INTO tblClass(ClassId, ClassCode) VALUES(3, 'C1908i');
DELETE FROM tblClass WHERE 1 = 1;
--insert bundle
INSERT INTO tblClass(ClassId, ClassCode) 
VALUES
(1, 'C2009L'),
(2, 'C2009G'),
(3, 'C1908i');
--thu insert them 1 ban ghi trung lap(dublicate)
INSERT INTO tblClass(ClassId, ClassCode) VALUES(1, 'C2009L'); 
--=> lop trung => phai co constraint(rang buoc unique)
--bo xung rang buoc(vi ko the xoa du lieu duoc)
ALTER TABLE tblClass


ADD CONSTRAINT UC_Class UNIQUE (ClassId,ClassCode);
DROP CONSTRAINT UC_Class;

ALTER TABLE tblClass DROP INDEX UC_Class;

DROP TABLE tblStudent;
CREATE TABLE tblStudent(
	StudentId INT PRIMARY KEY AUTO_INCREMENT,
	StudentName VARCHAR(300),
	BirthDate Date,
	ClassId INT
);
--insert data
INSERT INTO tblStudent(StudentName, BirthDate, ClassId)
VALUES('Nguyen Van A', '2000-12-23', 2);

--rang buoc(constraint) foreign key
ALTER TABLE tblStudent
ADD FOREIGN KEY (ClassId) REFERENCES tblClass(ClassId);

INSERT INTO tblStudent(StudentName, BirthDate, ClassId)
VALUES('Nguyen Van X', '2000-12-23', 20);
DROP TABLE tblSubject;

CREATE TABLE tblSubject(
	SubjectId INT PRIMARY KEY AUTO_INCREMENT,
	SubjectName VARCHAR(300) DEFAULT '',
	SessionCount INT DEFAULT 0
);
ALTER TABLE tblSubject
ADD CONSTRAINT CHECK_SessionCount CHECK (SessionCount > 0);
--View => can join data tu nhieu bang vao thanh 1 collection
--lam report
INSERT INTO tblSubject(SubjectName, SessionCount) VALUES
('C++', 5),
('ADF1', 10),
('html and web programming', 15);


--bang tblResult quan he N - 1 voi tblStudent
--FK = Foreign Key
CREATE TABLE tblResult(
	StudentId INT,
	SubjectId INT,
	Mark INT,
	CONSTRAINT FK_StudentResult FOREIGN KEY (StudentId) REFERENCES tblStudent(StudentId),
	CONSTRAINT FK_SubjectResult FOREIGN KEY (SubjectId) REFERENCES tblSubject(SubjectId)	
);
--doi kieu gia tri, tu int => float, int => double, ...
ALTER TABLE tblResult
MODIFY COLUMN Mark FLOAT;

INSERT INTO tblResult(StudentId, SubjectId, Mark) VALUES
(1, 2, 6),
(4, 3, 5);
--join theo thu tu tblClass -> tblStudent -> tblResult -> tblSubject
SELECT 
	tblStudent.StudentName,
	tblStudent.BirthDate,
	tblClass.ClassCode,	
	tblSubject.SubjectName,
	tblResult.Mark 
FROM tblClass 
    INNER JOIN tblStudent ON tblClass.ClassId = tblStudent.ClassId
    INNER JOIN tblResult ON tblStudent.StudentId = tblResult.StudentId
    INNER JOIN tblSubject ON tblResult.SubjectId = tblSubject.SubjectId
ORDER BY tblStudent.StudentId;




















