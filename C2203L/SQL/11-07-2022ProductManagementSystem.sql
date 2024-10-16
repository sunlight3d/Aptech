CREATE DATABASE ProductManagementSystem;
USE ProductManagementSystem;
CREATE TABLE tblUser(
	UserID INT NOT NULL,
	UserName NVARCHAR(50),
);
CREATE TABLE tblOrder(
	OrderID INT NOT NULL,
	UserID INT NOT NULL,
	OrderDate DATETIME
);
CREATE TABLE tblProduct(
	ProductID INT NOT NULL,
	ProductName NVARCHAR(50),
	Quantity INT,
	Price MONEY,
	Description NTEXT
);
CREATE TABLE tblOrderDetail(
	OrderID INT NOT NULL,
	ProductID INT NOT NULL,
	Quantity INT,
	Price MONEY	
);
DROP INDEX CI_tblUser_UserID ON tblUser;
CREATE CLUSTERED INDEX CI_tblUser_UserID ON tblUser(UserID);

ALTER TABLE tblUser
ADD BirthDate DATETIME; 

ALTER TABLE tblOrder 
ADD CONSTRAINT DF_tblOrder_OrderDate
DEFAULT GETDATE() FOR OrderDate;

ALTER TABLE tblUser ADD CONSTRAINT PK_tblUser PRIMARY KEY(UserId); 
ALTER TABLE tblOrder ADD CONSTRAINT PK_tblOrder PRIMARY KEY(OrderID); 
ALTER TABLE tblProduct ADD CONSTRAINT PK_tblProduct PRIMARY KEY(ProductID); 
ALTER TABLE tblOrderDetail ADD CONSTRAINT PK_tblOrderDetail PRIMARY KEY(OrderID, ProductID);

ALTER TABLE tblOrder
ADD CONSTRAINT FK_tblOrder_tblUser
FOREIGN KEY (UserId) REFERENCES tblUser(UserId); 

ALTER TABLE tblOrderDetail
ADD CONSTRAINT FK_tblOrderDetail_tblOrder
FOREIGN KEY (OrderID) REFERENCES tblOrder(OrderID); 

ALTER TABLE tblOrderDetail
ADD CONSTRAINT FK_tblOrderDetail_tblProduct
FOREIGN KEY (ProductID) REFERENCES tblProduct(ProductID); 

ALTER TABLE tblOrder
ADD CONSTRAINT CK_tblOrder_OrderDate 
CHECK (OrderDate >= '2000-01-01' OR OrderDate <= GETDATE()); 

ALTER TABLE tblUser
ADD CONSTRAINT UN_tblUser_UserName 
UNIQUE(UserName); 

DELETE FROM tblUser WHERE 1=1;
INSERT INTO tblUser(UserID, UserName, BirthDate) VALUES
(1, N'stevejobs', '1996-08-28'),
(2, N'billgates', '1998-06-18'),
(3, N'larry', '1997-05-25'),
(4, N'mark', '1984-03-27'),
(5, N'dell', '1955-08-15'),
(6, N'eric', '1955-07-28');

INSERT INTO tblOrder(OrderID, UserID, OrderDate) VALUES
(1,2,'2002-12-01'),
(2,3,'2000-03-02'),
(3,2,'2004-08-03'),
(4,1,'2001-05-12'),
(5,4,'2002-10-04'),
(6,6,'2002-03-08'),
(7,5,'2002-05-02');

INSERT INTO tblProduct(ProductID, ProductName, Quantity, Price, Description) VALUES
(1,'Asus Zen', 2, 10,N'See what others can''t see'),
(2,'BPhone', 10, 20,N'The first flat-design smartphone in the world'),
(3,'iPhone', 13, 300,N'The only thing that''s changed is everything.'),
(4,'XPEria', 7, 80,N'The world''s first 4K smartphone.'),
(5,'Galaxy Note', 12, 120,N'Created to reflect your desire');

INSERT INTO tblOrderDetail(OrderID,ProductID,Quantity,Price) VALUES
(1,1,10,10),
(1,2,4,20),
(2,3,5,50),
(3,3,6,80),
(4,2,21, 120),
(5,2,122,300);

SELECT * FROM tblOrderDetail;

SELECT * FROM tblProduct WHERE ProductID = 3;
UPDATE tblProduct SET tblProduct.Price = 0.9*tblProduct.Price
WHERE ProductID = 3;

SELECT 
	tblUser.UserID,
	tblUser.UserName,
	tblOrder.OrderID,
	tblOrder.OrderDate,
	tblOrderDetail.Quantity,
	tblOrderDetail.Price,
	tblProduct.ProductName
FROM tblUser
INNER JOIN tblOrder
ON tblUser.UserID = tblOrder.UserID
INNER JOIN tblOrderDetail
ON tblOrderDetail.OrderID = tblOrder.OrderID
INNER JOIN tblProduct
ON tblProduct.ProductID = tblOrderDetail.ProductID;

SELECT * FROM tblOrderDetail;

DROP VIEW view_Top2Product;
CREATE VIEW view_Top2Product AS
SELECT 
	--TOP 2
	Q1.ProductID,
	tblProduct.ProductName,
	tblProduct.Price,
	Q1.TotalQuantity
FROM tblProduct
INNER JOIN (SELECT 
	ProductID,
	SUM(Quantity) AS TotalQuantity
FROM tblOrderDetail
GROUP BY ProductID) AS Q1
ON Q1.ProductID = tblProduct.ProductID;

SELECT TOP 2 * FROM view_Top2Product
ORDER BY TotalQuantity DESC;

DROP PROCEDURE sp_TimSanPham;
CREATE PROCEDURE sp_TimSanPham 
	@GiaMua MONEY,
	@Count INT OUTPUT
AS
BEGIN
	SELECT @Count = count(*)
	FROM tblProduct WHERE tblProduct.Price < @GiaMua;
END
--sp = stored procedure
 
DECLARE @Count1 money;
EXECUTE sp_TimSanPham 200, @Count = @Count1 OUTPUT;    

PRINT 'count is ' + CONVERT(varchar(10),@Count1);  
GO

DROP TRIGGER TG_tblProduct_Update;
CREATE TRIGGER TG_tblProduct_Update  
ON tblProduct --on table's name
AFTER UPDATE AS --event(when)
BEGIN
	DECLARE @Price AS MONEY --declare local variable
	SET @Price = (SELECT TOP 1 Price FROM tblProduct) 
	IF (@Price < 10) 
	BEGIN 
		RAISERROR ('You don''t update price less than 10!',16,10);		
		ROLLBACK 
	END	
END
--test trigger
SELECT * FROM tblProduct;
UPDATE tblProduct SET Price = 11 WHERE ProductID = 1;

DROP TRIGGER TG_tblUser_Update;
CREATE TRIGGER TG_tblUser_Update  
ON tblUser --on table's name
AFTER UPDATE AS --event(when)
	--check Whether Username is "modified" ?
BEGIN 
	IF ((COLUMNS_UPDATED() & 2) = 2) OR ((COLUMNS_UPDATED() & 4) = 4)    
	--PRINT COLUMNS_UPDATED();
	BEGIN
		RAISERROR ('You cannot update Username',16,10);		
		ROLLBACK 
	END	
END
SELECT * FROM tblUser;

UPDATE tblUser SET UserName='stevejobs1' WHERE UserID=1;
UPDATE tblUser SET BirthDate='1996-08-27', UserName = 'stevejobs2' WHERE UserID=1;
