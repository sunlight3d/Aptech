use C1908iLTN;
CREATE TABLE tblClass(
ClassId INT IDENTITY(1, 1) PRIMARY KEY NOT NULL,
ClassName NVARCHAR(30) NOT NULL,
NumberOfStudents INT DEFAULT 0,
);
INSERT INTO tblClass(ClassName, NumberOfStudents) VALUES
(N'C19099M', 12),
(N'C1101LV', 12),
(N'C1011L', 12);

CREATE TABLE tblStudent(
	StudentId INT IDENTITY PRIMARY KEY NOT NULL,
	StudentName NVARCHAR(30) NOT NULL,
	Gender BIT,
	DateOfBirth DATETIME NOT NULL,
	Address NVARCHAR(300)  NOT NULL,
	ClassId INT  NOT NULL,
);
SELECT * FROM tblClass;
INSERT INTO tblStudent(StudentName, Gender, DateOfBirth, Address, ClassId) VALUES
(N'Nguyễn Văn Hưng', 1, '1997/11/25', N'Đội Cấn', 2),
(N'Hoàng Mai Hương', 0, '2000/12/26', N'Xuân Đỉnh', 1);
SELECT * FROM tblStudent;
ALTER TABLE tblStudent 
ADD CONSTRAINT FK_ClassStudent 
FOREIGN KEY (ClassId) REFERENCES tblClass(ClassId);

ALTER TABLE tblStudent
ADD UserName NVARCHAR(100) DEFAULT '';

ALTER TABLE tblStudent
ADD Password NVARCHAR(100) DEFAULT '';
SELECT * FROM tblStudent;

UPDATE tblStudent SET UserName='hungnv', Password='123456'
WHERE StudentId=1;

--check login
SELECT COUNT(*) as count 
FROM tblStudent WHERE UserName='hungnv' AND Password='123456';