CREATE DATABASE Travel_Management;
USE Travel_Management;
CREATE TABLE Travels(
	trID INT NOT NULL,
	name VARCHAR(100) NOT NULL, 
	price FLOAT,
	days INT,
	catID INT NOT NULL,
	startdate DATETIME
);
ALTER TABLE Travels DROP CONSTRAINT PK_Travels;

ALTER TABLE Travels ADD CONSTRAINT FK_Travels_Categories
FOREIGN KEY(catID) References Categories(catID);

ALTER TABLE Travels ADD CHECK (days > 0 AND days <= 15); 

ALTER TABLE Travels
ADD CONSTRAINT UN_TravelName 
UNIQUE (name);

ALTER TABLE Travels 
ADD CONSTRAINT DF_startdate
DEFAULT GETDATE() FOR startdate;

ALTER TABLE Travels 
ADD CONSTRAINT PK_Travels PRIMARY KEY(trID);

CREATE TABLE Categories(
	catID INT NOT NULL,
	catname VARCHAR(100) NOT NULL, 
	counts INT
);

ALTER TABLE Categories 
ADD CONSTRAINT PK_Categories PRIMARY KEY(catID);

--insert data
INSERT INTO Categories(catID, catname) VALUES
(100, 'Beaches'),
(200, 'Family Travels'),
(300, 'Food and Drink'),
(400, 'Skiiing');

INSERT INTO Travels(trID, name, price, days, catID, startdate) VALUES
(10, 'Male bay, Hawai', 200);