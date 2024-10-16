CREATE DATABASE de04;
USE de04;
CREATE TABLE IF NOT EXISTS tblItem(
    ID INT,
    name VARCHAR(50) 
);
ALTER TABLE tblItem
ADD CONSTRAINT UN_tblItem UNIQUE(name);

INSERT INTO tblItem(ID, name) VALUES
(11, 'Mr678545AA jiudjsi'),
(22, 'Mr545666AA jiudjsi'),
(2, 'MrAA jiudjsi'),
(33, 'MrAfd5554345A jiudjsi'),
(4, 'MrA434AA jiudjsi'),
(66, 'M5f45rAA jiudjsi'),
(88, 'MrAA434 jire444rudjsi'),
(161, 'ffMrAA jiudjsi'),
(99, 'MrtrtrAAcvd jiudjsi'),
(90, 'vgvrtr jiude4wredrjsi'),
(233, 'Mr454534AA jiudjsi'),
(98, 'MrsdtvgAA jiudjsi'),
(23, 'MrAeweA jiudjsi');
SELECT * FROM tblItem;

CREATE TABLE tblPerson(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(50),
    Gender BIT,
    DateOfBirth DATETIME 
);
INSERT INTO tblPerson(Name, Gender, DateOfBirth) VALUES
('Alex ss', 1, '1979-12-29'),
('Adnsiflex ss', 0, '1993-11-30'),
('Amndsds', 0, '1979-06-22'),
('alnfnjsdkAlex ss', 1, '2000-05-15');