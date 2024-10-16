CREATE DATABASE Travel_Management;
USE Travel_Management;

CREATE TABLE Travels(
	trID INT NOT NULL,
	name VARCHAR(100) NOT NULL,
	price FLOAT,
	days INT,
	catID INT NOT NULL,
	startDate DATETIME
);
CREATE TABLE Categories(
	catID INT NOT NULL,
	catname VARCHAR(100) NOT NULL,
	counts INT
);
ALTER TABLE Travels DROP CONSTRAINT PK_Travels;
ALTER TABLE Travels ADD CONSTRAINT PK_Travels PRIMARY KEY(trID); 
ALTER TABLE Categories ADD CONSTRAINT PK_Categories PRIMARY KEY(catID); 

ALTER TABLE Travels
ADD CONSTRAINT FK_TravelsCategories
FOREIGN KEY (catID) REFERENCES Categories(catID); 

ALTER TABLE Travels
ADD CONSTRAINT CK_Travels_Days 
CHECK (Travels.days > 0 AND Travels.days < 15); 

ALTER TABLE Travels
ADD CONSTRAINT UN_Travels_Name
UNIQUE(name);

DELETE FROM Travels WHERE trID=11;


SELECT * FROM Travels;

ALTER TABLE Travels DROP CONSTRAINT DF_Travels_StartDate;

ALTER TABLE Travels
ADD CONSTRAINT DF_Travels_StartDate                                        
DEFAULT GetDate() FOR startDate;


--DELETE FROM Travels WHERE 1<2;
--DELETE FROM Categories WHERE 1<2;
INSERT INTO Categories(catID, catname) VALUES
(100, 'Beaches'),
(200, 'Family Travels'),
(300, 'Food and drink'),
(400, 'Skiing');

INSERT INTO Travels(trID,name,price,days,catID) VALUES
(10,'manolyu kyhddw', 200, 2, 100),
(11,'dgftgergfverg fert', 250, 2, 200),
(12,'ffertr tertettr', 300, 2, 100),
(13,'rertev gffygfgy', 180, 2, 300),
(14,'drytr7 trtrtryt', 380, 2, 100);

SELECT 
Categories.catID,
Categories.catname,
Q1.quantity
FROM 
(SELECT 
	catID,
	COUNT(catID) AS quantity
FROM Travels
GROUP BY catID) AS Q1
INNER JOIN Categories
ON Categories.catID = Q1.catID;

