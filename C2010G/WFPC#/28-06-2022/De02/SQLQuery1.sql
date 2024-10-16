DROP TABLE tblClass;
DROP TABLE tblStudent;
CREATE TABLE tblClass(
    classCode INT PRIMARY KEY IDENTITY(1,1),
    className NVARCHAR(30) NOT NULL,
    numberOfStudents INT DEFAULT 1
);
CREATE TABLE tblStudent(
	studentId INT PRIMARY KEY IDENTITY(1,1),
    studentName NVARCHAR(30) NOT NULL,
    gender BIT,
    dateOfBirth DateTime,
    address NVARCHAR(255),
    classCode INT,
    userName NVARCHAR(20),
    password NVARCHAR(20) NOT NULL,
);
ALTER TABLE tblStudent ADD CONSTRAINT PK_Student_CLASS 
FOREIGN KEY (classCode) REFERENCES tblClass(classCode);
--ALTER TABLE tblStudent DROP CONSTRAINT PK_Student_CLASS;
INSERT INTO tblClass(className,numberOfStudents) VALUES
('C1011GV', 2),
('C1009M', 3),
('C1010KV', 56),
('C1011L', 23);
INSERT INTO tblStudent(studentName, gender, dateOfBirth,
    address, classCode,userName, password) VALUES
(N'Nguyễn Văn Hưng', 1, '1990-09-08', N'Đội Cấn', 1, 'hungnv', 123456),
(N'Trần Văn Hiếu', 1, '1988-12-08', N'Hai Bà Trưng', 1, 'kdiwsu', 123456),
(N'Nguyễn Văn tiến', 1, '1993-09-08', N'Hoàn Kiếm', 1, 'hiodh', 123456),
(N'mai huong', 1, '1995-09-08', N'Bạch Mai', 1, 'jdisujyo', 123456);

SELECT className, studentName, userName, address
FROM tblStudent
INNER JOIN tblClass ON tblStudent.classCode=tblClass.classCode;