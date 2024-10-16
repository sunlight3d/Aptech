CREATE DATABASE testdb;
use testdb;
CREATE TABLE tblClass(
    MaLop INT PRIMARY KEY IDENTITY(1,1),
    TenLop NVARCHAR(30) NOT NULL, 
    SiSo INT NOT NULL,
);
CREATE TABLE tblStudent(
    MaSv INT PRIMARY KEY IDENTITY(1,1),
    TenSv NVARCHAR(30) NOT NULL, 
    GioiTinh bit,
    NSinh DATETIME,
    DiaChi NVARCHAR(30) NOT NULL, 
    MaLop int,
    UserNm NVARCHAR(30),
    Password NVARCHAR(20) NOT NULL,
);
ALTER TABLE tblStudent
ADD CONSTRAINT FK_ClassStudent
FOREIGN KEY (MaLop) REFERENCES tblClass(MaLop);

INSERT into tblClass(TenLop, SiSo)
VALUES(N'C1908iLTN', 15),
(N'C2006L', 11),
(N'C1234L', 18);

SELECT * FROM tblClass;
SELECT * FROM tblStudent;
insert into tblStudent(MaLop, TenSv, GioiTinh, NSinh, DiaChi,UserNm, [Password])
VALUES(1, 'Nguyen Van A', 1, '1993/03/03', 'nha A, ngo B, pho C','nguyenvana', '123456');
SELECT * FROM tblStudent WHERE tblStudent.UserNm = 'nguyenvana' AND tblStudent.Password = '123456';

SELECT tblClass.TenLop, tblStudent.TenSv,tblStudent.UserNm, tblStudent.DiaChi 
FROM tblStudent
INNER JOIN tblClass ON tblStudent.MaLop=tblClass.MaLop;

SELECT tblClass.TenLop, tblStudent.TenSv,tblStudent.UserNm, tblStudent.DiaChi 
FROM tblStudent
INNER JOIN tblClass ON tblStudent.MaLop=tblClass.MaLop;


CREATE VIEW viewClassStudent as 
SELECT tblClass.*, tblStudent.TenSv,tblStudent.UserNm, tblStudent.DiaChi 
FROM tblStudent
INNER JOIN tblClass ON tblStudent.MaLop=tblClass.MaLop;

DROP VIEW viewClassStudent;
SELECT * FROM viewClassStudent;

CREATE TABLE tblDepartment(
    DepartmentId INT IDENTITY(1, 1) PRIMARY KEY,
    DepartmentName NVARCHAR(300) NOT NULL    
);
INSERT INTO tblDepartment(DepartmentName)
VALUES('Accounting'),
('Administration'),
('DTY'),
('Engineering'),
('F&A'),
('Marketing');

SELECT * FROM tblDepartment;
drop table tblEmployee;
CREATE TABLE tblEmployee(
    EmployeeId INT IDENTITY(1, 1) PRIMARY KEY,
    EmployeeName NVARCHAR(300) NOT NULL,
    Gender BIT,     
    BirthDate DATETIME NOT NULL,
    Telephone VARCHAR(100) NOT NULL,
    Address NVARCHAR(300) DEFAULT '',
    DepartmentId INT 
);
INSERT INTO tblEmployee(EmployeeName, Gender, BirthDate, Telephone, Address, DepartmentId)
VALUES('Nguyen Van A', 1, '1993/03/02', '123457878', 'address 11', 1),
('Nguyen Van B', 1, '1993/03/02', '123457878', 'address 122', 2),
('Nguyen Van C', 1, '1994/03/02', '223457878', 'address 33', 2),
('Nguyen Van D', 1, '1995/03/02', '323457878', 'address 44', 2),


ALTER TABLE tblEmployee
ADD CONSTRAINT FK_DepartmentEmployee
FOREIGN KEY (DepartmentId) REFERENCES tblDepartment(DepartmentId);

ALTER TABLE tblEmployee
DROP CONSTRAINT FK_DepartmentEmployee; 


