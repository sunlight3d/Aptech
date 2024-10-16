DROP DATABASE IF EXISTS PMS;

CREATE DATABASE IF NOT EXISTS PMS;

USE PMS;

CREATE TABLE ORGANIZATION(
	OrganizationID INTEGER NOT NULL AUTO_INCREMENT,
	OrganizationName varchar(255) NULL,
	Code varchar(20) NULL,
	Address varchar(255) NULL,
	Phone varchar(50) NULL,
	Fax char(50) NULL,
	Email varchar(255) NULL,
	Website varchar(255) NULL,
	ParentID INTEGER NULL,
 CONSTRAINT PK_ORGANIZATION PRIMARY KEY CLUSTERED 
(
	OrganizationID
)
);


CREATE TABLE EMPLOYEE(
	EmployeeID INTEGER NOT NULL AUTO_INCREMENT,
	FirstName varchar(50) NULL,
	Code varchar(15) NULL,
	LastName varchar(30) NULL,
	Address varchar(255) NULL,
	Phone varchar(50) NULL,
	Mobile varchar(255) NULL,
	Email varchar(255) NULL,
	Photo varchar (255),
	CurriculumVitaeType varchar(255) NULL,
	CurriculumVitae varchar (255) NULL,
	OrganizationID INTEGER NULL,
	DateofBirth datetime NULL,
	IndentifyNumber varchar(50) NULL,
	IssuedPlace varchar(255) NULL,
	IssuedDate datetime NULL,
	PresentResidence varchar(255) NULL,
	RecruitedDate datetime NULL,
	DateOfEnteringOffice datetime NULL,
	NominatedDate datetime NULL,
	SexID INTEGER NULL,
	PositionID INTEGER NULL,
	Status INTEGER NULL,
 CONSTRAINT PK_EMPLOYEE PRIMARY KEY CLUSTERED 
(
	EmployeeID )
);

CREATE TABLE POSITION (
	PositionID INTEGER NOT NULL AUTO_INCREMENT,
	PositionName varchar(255) NULL,
 CONSTRAINT PK_POSITION PRIMARY KEY CLUSTERED 
(
	PositionID ));

CREATE TABLE SEX(
	SexID INTEGER NOT NULL AUTO_INCREMENT,
	SexName varchar(255) NULL,
 CONSTRAINT PK_SEX PRIMARY KEY CLUSTERED 
(
	SexID ASC
)
); 

CREATE TABLE USERS(
	UsersID INTEGER NOT NULL AUTO_INCREMENT,
	UserName varchar(50) NULL,
	Password varchar(255) NULL,
	Discription varchar(255) NULL,
	EmployeeID INTEGER NULL,
 CONSTRAINT PK_USERS PRIMARY KEY CLUSTERED 
(
	UsersID 
)
);

INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (40, N'Trần Hải', N'100001', N'Triều', N'Hà Nội', NULL, N'0902603358', N'trieuth@tnt-tech.vn', NULL, NULL, NULL, 4, CAST(N'1975-09-25T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (41, N'Trần Hồng', N'100002', N'Hòa', N'Hà Nội', NULL, N'0913226249', N'hoath@tnt-tech.vn', NULL, NULL, NULL, 4, CAST(N'1974-10-28T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 2, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (42, N'Đặng Việt', N'100004', N'Hùng', N'Hà Nội', NULL, N'0915436211', N'hungdv@tnt-tech.vn', NULL, NULL, NULL, 5, CAST(N'1988-04-26T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 4, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (43, N'Lê Thị Thu', N'100005', N'Trang', N'Hà Nội', NULL, N'0942635386', N'tranglt@tnt-tech.vn', NULL, NULL, NULL, 5, CAST(N'1986-12-17T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 5, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (44, N'Đặng Thị', N'100006', N'Đào', N'Hà Nội', NULL, N'0983011289', N'daodt@tnt-tech.vn', NULL, NULL, NULL, 5, CAST(N'1989-12-01T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 5, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (45, N'Nguyễn Đào Anh', N'100007', N'Tuấn', N'Hà Nội', NULL, N'0912653335', N'chatunhi@gmail.com', NULL, NULL, NULL, 5, CAST(N'1967-11-11T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 6, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (46, N'Phạm Thị', N'100008', N'Dung', N'Hà Nội', NULL, N'0971186368', N'dungpt@tnt-tech.vn', NULL, NULL, NULL, 5, CAST(N'1992-02-24T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 7, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (47, N'Nguyễn Kim', N'100009', N'Ngọc', N'Hà Nội', NULL, N'0988428698', N'purchasing@tnt-tech.vn', NULL, NULL, NULL, 6, CAST(N'1985-05-29T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 8, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (48, N'Dương Văn', N'100010', N'Thành', N'Hà Nội', NULL, N'0936657222', N'thanhdv@tnt-tech.vn', NULL, NULL, NULL, 6, CAST(N'1985-04-28T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 9, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (49, N'Lê Thị Thu', N'100038', N'Hiền', N'Hà Nội', NULL, N'0902108824', N'hienltt@tnt-tech.vn', NULL, NULL, NULL, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 10, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (50, N'Nông Thị Thùy', N'100012', N'Linh', N'Hà Nội', NULL, N'0943442123', N'linhnt@tnt-tech.vn', NULL, NULL, NULL, 7, CAST(N'1989-12-06T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 11, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (51, N'Đoàn Viết', N'100014', N'Chung', N'Hà Nội', NULL, N'0932160573', N'chungtnt.tech@gmail.com', NULL, NULL, NULL, 7, CAST(N'1973-05-16T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 12, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (52, N'Lê Trần', N'100015', N'Đăng', N'Hà Nội', NULL, N'0901766699', N'danglt@tnt-tech.vn', NULL, NULL, NULL, 8, CAST(N'1981-09-26T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 13, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (53, N'Đinh Trường', N'100017', N'Xuân', N'Hà Nội', NULL, N'0389971300', N'xuandt@tnt-tech.vn', NULL, NULL, NULL, 8, CAST(N'1990-05-05T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 14, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (54, N'Đỗ Quốc', N'100016', N'Hưng', N'Hà Nội', NULL, N'0913031759', N'hungdq@tnt-tech.vn', NULL, NULL, NULL, 8, CAST(N'1976-11-13T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 15, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (55, N'Kiều Văn', N'100037', N'Khải', N'Hà Nội', NULL, N'0919232885', N'khaikv@tnt-tech.vn', NULL, NULL, NULL, 8, CAST(N'1977-06-18T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 15, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (56, N'Nguyễn Việt', N'100019', N'Hưng', N'Hà Nội', NULL, N'0868604330', N'hungnv@tnt-tech.vn', NULL, NULL, NULL, 9, CAST(N'1987-07-31T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 16, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (57, N'Nguyễn Xuân', N'100020', N'Mạnh', N'Hà Nội', NULL, N'0903257330', N'manhnx@tnt-tech.vn', NULL, NULL, NULL, 9, CAST(N'1990-12-28T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 17, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (58, N'Đỗ Quốc', N'100039', N'Sơn', N'Hà Nội', NULL, N' 0903257044 ', N' sondq@tnt-tech.vn ', NULL, NULL, NULL, 9, CAST(N'1991-09-10T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 17, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (59, N'Hoàng Văn', N'100023', N'Lanh', N'Hà Nội', NULL, N'0986497369', N'lanhhv@tnt-tech.vn', NULL, NULL, NULL, 10, CAST(N'1986-10-05T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 18, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (60, N'Nguyễn Kim', N'100024', N'Kiên', N'Hà Nội', NULL, N'0968090587', N'kiennk@tnt-tech.vn', NULL, NULL, NULL, 10, CAST(N'1987-09-10T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 18, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (61, N'Vũ Thế', N'100025', N'Thức', N'Hà Nội', NULL, N'0949961288', N'thucvt@tnt-tech.vn', NULL, NULL, NULL, 10, CAST(N'1988-12-12T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 18, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (62, N'Phạm Thanh', N'100026', N'Tùng', N'Hà Nội', NULL, N'0912365275', N'tungpt@tnt-tech.vn', NULL, NULL, NULL, 10, CAST(N'1982-07-08T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 19, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (63, N'Lê Hải', N'100029', N'Quân', N'Hà Nội', NULL, N' 0812950035 ', N'quanlh@tnt-tech.vn', NULL, NULL, NULL, 10, CAST(N'1990-10-11T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 19, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (64, N'Phạm Thái', N'100039', N'Dương', N'Hà Nội', NULL, N'0966533568', N'duongpt@tnt-tech.vn', NULL, NULL, NULL, 11, CAST(N'1984-12-25T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 20, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (65, N'Nguyễn Thu', N'100036', N'Phương', N'Hà Nội', NULL, N'0328452456', N'phuong-nguyenthu@tnt-tech.vn', NULL, NULL, NULL, 11, CAST(N'1998-02-06T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 21, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (66, N'Thái Văn', N'100003', N'Minh', N'Hồ Chí Minh', NULL, N'0903664290', N'minhtv@tnt-tech.vn', NULL, NULL, NULL, 12, CAST(N'1974-09-05T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 3, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (67, N'Đỗ Tuyết', N'100013', N'Anh', N'Hồ Chí Minh', NULL, N'0938745785', N'anhdt@tnt-tech.vn', NULL, NULL, NULL, 13, CAST(N'1990-04-26T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 5, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (68, N'Phạm Thanh', N'100044', N'Tuyền', N'Hồ Chí Minh', NULL, N'0983776264', N'tuyenpt@tnt-tech.vn', NULL, NULL, NULL, 14, CAST(N'1992-08-15T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 11, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (69, N'Nguyễn Công', N'100018', N'Nam', N'Hồ Chí Minh', NULL, N'0986485479', N'namnc@tnt-tech.vn', NULL, NULL, NULL, 17, CAST(N'1991-03-02T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 14, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (70, N'Trần Minh', N'100033', N'Quân', N'Hồ Chí Minh', NULL, N' 0376845954 ', N' quantm@tnt-tech.vn ', NULL, NULL, NULL, 17, CAST(N'1997-11-21T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 14, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (71, N'Trần Ngọc', N'100021', N'Phương', N'Hồ Chí Minh', NULL, N'0909994003', N'phuongtn@tnt-tech.vn', NULL, NULL, NULL, 15, CAST(N'1989-10-28T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 17, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (72, N'Nguyễn Thành', N'100022', N'Phương', N'Hồ Chí Minh', NULL, N'0905461801', N'phuongnt@tnt-tech.vn', NULL, NULL, NULL, 15, CAST(N'1992-01-28T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 17, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (73, N'Cao Minh', N'100027', N'Nhựt', N'Hồ Chí Minh', NULL, N'0932434191', N'nhutcm@tnt-tech.vn', NULL, NULL, NULL, 16, CAST(N'1985-11-22T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 18, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (74, N'Lưu Quang', N'100028', N'Vũ', N'Hồ Chí Minh', NULL, N'0944977863', N'vulq@tnt-tech.vn', NULL, NULL, NULL, 16, CAST(N'1997-01-19T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 19, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (75, N'Nguyễn Hữu', N'100031', N'Tài', N'Hồ Chí Minh', NULL, N' 0936649796 ', N' tainh@tnt-tech.vn ', NULL, NULL, NULL, 16, CAST(N'1991-04-20T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 19, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (76, N'Trần Thế', N'100035', N'Vinh', N'Hồ Chí Minh', NULL, N' 0963835034 ', N' vinhtt@tnt-tech.vn ', NULL, NULL, NULL, 16, CAST(N'1997-04-24T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 19, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (77, N'Nguyễn Trung', N'100046', N'Hiếu', N'Hồ Chí Minh', NULL, N' 0967730672 ', N' hieunt@tnt-tech.vn ', NULL, NULL, NULL, 16, CAST(N'1998-01-18T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 19, 1);
INSERT EMPLOYEE (EmployeeID, FirstName, Code, LastName, Address, Phone, Mobile, Email, Photo, CurriculumVitaeType, CurriculumVitae, OrganizationID, DateofBirth, IndentifyNumber, IssuedPlace, IssuedDate, PresentResidence, RecruitedDate, DateOfEnteringOffice, NominatedDate, SexID, PositionID, Status) VALUES (78, N'Dương Điền Đăng', N'100047', N'Khoa', N'Hồ Chí Minh', NULL, N' 0901496981 ', N' khoadd@tnt-tech.vn ', NULL, NULL, NULL, 16, CAST(N'1993-02-23T00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 19, 1);


INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (1, N'TNT Technologies Joint Stock Company', N'TNT', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (2, N'TRỤ SỞ CÔNG TY TẠI HÀ NỘI', N'HANOI', NULL, NULL, NULL, NULL, NULL, 1);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (3, N'VĂN PHÒNG ĐẠI DIỆN TP HỒ CHÍ MINH ', N'HCM', NULL, NULL, NULL, NULL, NULL, 1);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (4, N'BAN GIÁM ĐỐC', NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (5, N'PHÒNG TÀI CHÍNH - KẾ TOÁN', NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (6, N'PHÒNG MUA HÀNG', NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (7, N'PHÒNG HÀNH CHÍNH - NHÂN SỰ', NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (8, N'PHÒNG GIẢI PHÁP & THIẾT KẾ', NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (9, N'PHÒNG DỊCH VỤ KỸ THUẬT', NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (10, N'PHÒNG DỰ ÁN', NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (11, N'PHÒNG KINH DOANH', NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (12, N'TRƯỞNG VĂN PHÒNG ĐẠI DIỆN TP HỒ CHÍ MINH', NULL, NULL, NULL, NULL, NULL, NULL, 3);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (13, N'KẾ TOÁN ', NULL, NULL, NULL, NULL, NULL, NULL, 3);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (14, N'HÀNH CHÍNH NHÂN SỰ ', NULL, NULL, NULL, NULL, NULL, NULL, 3);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (15, N'PHÒNG DỊCH VỤ KỸ THUẬT', NULL, NULL, NULL, NULL, NULL, NULL, 3);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (16, N'PHÒNG DỰ ÁN', NULL, NULL, NULL, NULL, NULL, NULL, 3);
INSERT ORGANIZATION (OrganizationID, OrganizationName, Code, Address, Phone, Fax, Email, Website, ParentID) VALUES (17, N'PHÒNG GIẢI PHÁP & THIẾT KẾ', NULL, NULL, NULL, NULL, NULL, NULL, 3);

INSERT POSITION (PositionID, PositionName) VALUES (1, N'Giám đốc');
INSERT POSITION (PositionID, PositionName) VALUES (2, N'Phó Giám đốc');
INSERT POSITION (PositionID, PositionName) VALUES (3, N'Trưởng đại diện VP Hồ Chí Minh');
INSERT POSITION (PositionID, PositionName) VALUES (4, N'Kế toán trưởng');
INSERT POSITION (PositionID, PositionName) VALUES (5, N'Kế toán');
INSERT POSITION (PositionID, PositionName) VALUES (6, N'Nhân viên kho');
INSERT POSITION (PositionID, PositionName) VALUES (7, N'Kế toán kho');
INSERT POSITION (PositionID, PositionName) VALUES (8, N'Trưởng nhóm mua hàng');
INSERT POSITION (PositionID, PositionName) VALUES (9, N'Chuyên viên mua hàng');
INSERT POSITION (PositionID, PositionName) VALUES (10, N'Trưởng phòng HCNS ');
INSERT POSITION (PositionID, PositionName) VALUES (11, N'Nhân viên HCNS');
INSERT POSITION (PositionID, PositionName) VALUES (12, N'Lái xe ');
INSERT POSITION (PositionID, PositionName) VALUES (13, N'Trưởng phòng DES');
INSERT POSITION (PositionID, PositionName) VALUES (14, N'Kỹ sư DES');
INSERT POSITION (PositionID, PositionName) VALUES (15, N'Chuyên viên IT');
INSERT POSITION (PositionID, PositionName) VALUES (16, N'Trưởng phòng Dịch vụ');
INSERT POSITION (PositionID, PositionName) VALUES (17, N'Kỹ thuật viên');
INSERT POSITION (PositionID, PositionName) VALUES (18, N'Phụ trách dự án');
INSERT POSITION (PositionID, PositionName) VALUES (19, N'Kỹ sư dự án');
INSERT POSITION (PositionID, PositionName) VALUES (20, N'Trưởng phòng Kinh doanh');
INSERT POSITION (PositionID, PositionName) VALUES (21, N'Nhân viên Kinh doanh');

INSERT SEX (SexID, SexName) VALUES (2, N'Nam');
INSERT SEX (SexID, SexName) VALUES (1, N'Nữ');

INSERT USERS (UsersID, UserName, Password, Discription, EmployeeID) VALUES (1, N'Admin', N'123456', NULL, 55);
INSERT USERS (UsersID, UserName, Password, Discription, EmployeeID) VALUES (4, N'trieuth', N'123456', NULL, 40);

UPDATE EMPLOYEE SET SexID = 2 where SexID=0 AND EmployeeID<80;