CREATE DATABASE studentManagements;
CREATE TABLE student(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    age int,
    address varchar(500),
    javaScore decimal(18,2),
    csharpScore decimal(18,2)
);
ALTER TABLE student ADD CONSTRAINT unique_name UNIQUE (name);

