CREATE DATABASE IF NOT EXISTS php_de04;
USE php_de04;
CREATE TABLE tblItem(
    ID INT,
    Name VARCHAR(50)
);
CREATE TABLE tblPerson(
	ID int PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(50),
	Gender BIT,
	DateOfBirth DATE
);
INSERT INTO tblPerson(Name, Gender, DateOfBirth) VALUES
('Nguyen Van A', 1, '1996/12/15'),
('Nguyen Vadsn A', 1, '1998/11/15'),
('Nguyen Vandsd dA', 0, '1994/10/15'),
('Nguyen Vanjeij A', 0, '1997/07/15'),
('Nguyen Vsdsdan A', 1, '1999/09/15');


INSERT INTO tblItem(ID, Name) VALUES
(1122, 'Mr 1122'),
(389283, 'Mr 2233'),
(3393, 'Mr 1114'),
(1123, 'Mr 88732'),
(9787, 'Mr 8932'),
(1838, 'Mr 3928392'),
(2211, 'Mr 09889'),
(389283, 'Mr 2233'),
(3393, 'Mr 1114'),
(1123, 'Mr 88732'),
(9787, 'Mr 8932'),
(1838, 'Mr 3928392'),
(2211, 'Mr 09889'),
(389283, 'Mr 2233'),
(3393, 'Mr 1114'),
(1123, 'Mr 88732'),
(9787, 'Mr 8932'),
(1838, 'Mr 3928392'),
(2211, 'Mr 09889'),
(389283, 'Mr 2233'),
(3393, 'Mr 1114'),
(1123, 'Mr 88732'),
(389283, 'Mr 2233'),
(3393, 'Mr 1114'),
(1123, 'Mr 88732'),
(9787, 'Mr 8932'),
(1838, 'Mr 3928392'),
(2211, 'Mr 09889'),
(389283, 'Mr 2233'),
(3393, 'Mr 1114'),
(1123, 'Mr 88732'),
(9787, 'Mr 8932'),
(1838, 'Mr 3928392'),
(2211, 'Mr 09889'),
(9787, 'Mr 8932'),
(1838, 'Mr 3928392'),
(2211, 'Mr 09889'),
(1887, 'Mr 66532');