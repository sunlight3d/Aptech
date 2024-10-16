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

SELECT * FROM Categories;
UPDATE Categories 
SET counts = Quantity
FROM (
	SELECT  
		Categories.catID AS 'catID',
		Categories.catname AS 'Category',
		Q1.Quantity AS 'Quantity'
	FROM
	(Select catID,COUNT (catID) AS Quantity from Travels Group by catID) AS Q1
	INNER JOIN Categories 
	ON Categories.catID = Q1.catID) AS Q2
WHERE Categories.catID= Q2.CatID;

--update price
SELECT catID FROM Categories WHERE catname='Food and drink';
SELECT * FROM Travels;

UPDATE Travels SET days = 6
WHERE catID='300';

--SELECT * FROM Travels WHERE (trID = 10 OR trID = 12);
SELECT * FROM Travels WHERE trID IN (10, 12, 15, 178, 21);

SELECT * FROM Travels WHERE 
Travels.days > 5 AND Travels.catID IN (
	SELECT catID FROM Categories WHERE catname='Food and drink'
);

UPDATE Travels 
SET Travels.price = 1.1*Travels.price
WHERE Travels.days > 5 AND Travels.catID IN (
	SELECT catID FROM Categories WHERE catname='Food and drink'
);

DROP TRIGGER TG_Travels_Update;
CREATE TRIGGER TG_Travels_Update  
ON Travels --on table's name
AFTER UPDATE AS --event(when)
BEGIN
	DECLARE @Price AS FLOAT --declare local variable
	SET @Price = (SELECT TOP 1 Price FROM INSERTED) 
	IF (@Price < 0) 
	BEGIN 
		RAISERROR ('Travel tour’s price must be
					greater than zero',16,10);		
		ROLLBACK 
	END
END
--test trigger
UPDATE Travels
SET Travels.price = 381 
WHERE trID='14';
SELECT * FROM Travels;

DROP TRIGGER TG_Travels_Delete;
CREATE TRIGGER TG_Travels_Delete  
ON Travels --on table's name
AFTER DELETE AS --event(when)
BEGIN
	UPDATE Categories 
	SET Categories.counts = Categories.counts - 1 
	--DELETED = "deleted travel"
	WHERE Categories.catID IN (SELECT catID FROM DELETED)		
END

SELECT * FROM Travels WHERE trID = 14;
DELETE FROM Travels WHERE trID = 14;
SELECT * FROM Categories WHERE catID=100;
--test trigger
SELECT * FROM Travels WHERE trID = 14;
DELETE FROM Travels WHERE trID = 14;
SELECT * FROM Categories WHERE catID=100;


DROP TRIGGER TG_Travels_Insert;
CREATE TRIGGER TG_Travels_Insert  
ON Travels --on table's name
AFTER INSERT AS --event(when)
BEGIN
	DECLARE @StartDate AS DateTime --declare local variable
	SET @StartDate = (SELECT TOP 1 startDate FROM INSERTED) 
	IF (@StartDate < GETDATE()) 
	BEGIN 
		RAISERROR ('Travel tour’s startdate must be
				after the current date.',16,10);		
		ROLLBACK 
	END	
END
--test trigger
SELECT * FROM Travels;

INSERT INTO Travels(trID, name, price, days, catID, startDate) 
VALUES(99, 'di dhoieo wew', 900, 10, 300, '2022-07-09');

DELETE FROM Travels WHERE trID=99;

INSERT INTO Travels(trID, name, price, days, catID, startDate) 
VALUES(99, 'di dhoieo wew', 900, 10, 300, '2022-07-07');

SELECT * FROM sys.triggers WHERE type='TR';