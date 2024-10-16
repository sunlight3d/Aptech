use c1908GDoiCan;
CREATE TABLE tblEmployee(
    EmployeeNo VARCHAR(10) PRIMARY KEY,
    EmployeeName VARCHAR(300),
    PlaceOfWork VARCHAR(300),
    PhoneNo VARCHAR(300)
);
DESCRIBE tblEmployee;
INSERT INTO tblEmployee(EmployeeNo,EmployeeName,PlaceOfWork, PhoneNo)
VALUES("E0105", "Nguyen Van A", "Hai Duong", "0121212524"),
("E0101", "Nguyen Van A", "Hai Duong", "0121212524"),
("E0102", "Nguyen Van B", "Ha Nam", "873827382"),
("E0103", "Nguyen Van C", "Hanoi", "9838322232"),
("E0104", "Nguyen Van D", "Hai Duong", "9839283287");






