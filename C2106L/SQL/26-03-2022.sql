DROP DATABASE Travel_Management;
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

DELETE FROM Travels WHERE 1=1;
INSERT INTO Travels(trID, name, price, days, catID, startdate) VALUES
(10,  'Manele Bay, Hawaii',        200,      2,      100,     '2011-04-30'),
(11,  'Hilton Waikoloa Village',   250,      4,      200,     '2011-04-16'),
(12,  'Clearwater Beach, Florida', 300,      7,      100,     '2011-02-11'),
(13,  'Sandwich Paradise',         180,      2,      300,     '2011-01-10'),
(14,  'Cape may, New Jersey',      380,      4,      100,     '2011-01-10');

UPDATE Travels SET days = 8 
WHERE trID = 13;

SELECT * FROM Travels;
--GROUP BY
--Q5:
SELECT 
	Categories.catID, 
	Categories.catname as 'Category', 
	COUNT(Categories.catID) as Quantity
FROM Categories
INNER JOIN Travels ON Travels.catID = Categories.catID
GROUP BY Categories.catID, Categories.catname;
--Q6-1
SELECT * FROM Categories;
UPDATE Categories SET
Categories.counts = Temp.Quantity
FROM
	(SELECT 
		Categories.catID, 
		Categories.catname as 'Category', 
		COUNT(Categories.catID) as Quantity
	FROM Categories
	INNER JOIN Travels ON Travels.catID = Categories.catID
	GROUP BY Categories.catID, Categories.catname) AS Temp
WHERE Categories.catID = Temp.catID;

UPDATE Categories SET counts = 0
WHERE counts IS NULL;
--Q6-2
UPDATE Travels SET Travels.price = 1.1 * Travels.price
WHERE Travels.trID IN
	(SELECT Travels.trID FROM Travels 
	WHERE
		Travels.days > 5
		AND Travels.catID 
			IN (SELECT catID FROM Categories WHERE catname LIKE '%Food and Drink%'));

--Q7:
DROP TRIGGER TG_Travels_Update;
CREATE TRIGGER TG_Travels_Update
ON Travels AFTER UPDATE AS
	DECLARE @NumberOfNegativePrice AS INT 
	--kiem tra xem co ban ghi nao co Price < 0 hay ko, neu co thi lay ra 1 cai
	SET @NumberOfNegativePrice = (SELECT COUNT(*) FROM Travels WHERE Price < 0) 	
	IF @NumberOfNegativePrice > 0 
		BEGIN RAISERROR  ('Travel tour’s price must be greater than zero',16,10); 
			ROLLBACK --undo
		END
--Test trigger
SELECT * FROM Travels;
UPDATE Travels SET Travels.price = -1
WHERE Travels.trID = 10;

DROP TRIGGER TG_Travels_Delete;
CREATE TRIGGER TG_Travels_Delete
ON Travels AFTER DELETE AS 
DECLARE @catID AS INT
SELECT @catID = deleted.catId FROM deleted
UPDATE Categories SET Categories.counts = Categories.counts - 1
WHERE Categories.catID = @catID AND Categories.counts > 0;

--test trigger
SELECT * FROM Categories;
SELECT * FROM Travels;

DELETE FROM Travels WHERE trID = 10;

DROP TRIGGER TG_Travels_Insert;
CREATE TRIGGER TG_Travels_Insert
ON Travels AFTER INSERT AS 
DECLARE @startdate AS DATETIME
SELECT @startdate = inserted.startDate FROM inserted
IF @startdate < GETDATE() 
	BEGIN 
		RAISERROR  ('Travel tour’s startdate must be after the current date',16,10); 
		ROLLBACK --undo
	END
--test trigger
INSERT INTO Travels(trID, name, price, days, catID, startDate) 
VALUES(15, 'Di choi 1 minh', 11.2, 3, 100, '2022-03-25');

