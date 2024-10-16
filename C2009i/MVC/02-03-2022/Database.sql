CREATE TABLE Category(
	CategoryId INT PRIMARY KEY IDENTITY(1, 1),
	CategoryName NVARCHAR(100) NOT NULL
);
INSERT INTO Category(CategoryName) VALUES
(N'Electronics'),
(N'Beverages'),
(N'Seafood');
SELECT * FROM Category;
DROP TABLE Product;
CREATE TABLE Product(
	ProductId INT PRIMARY KEY IDENTITY(1, 1),
	ProductName NVARCHAR(50),
	Price FLOAT DEFAULT 0.0,
	Quantity INT DEFAULT 0,
	ReleaseDate DateTime,	
	CategoryId INT,
	FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId)
); 
INSERT INTO Product(ProductName, Price, Quantity, ReleaseDate, CategoryId) VALUES
(N'iphone 3', 112, 2, '2013/02/24', 1),
(N'iphone 4', 54, 2, '2013/09/21', 1),
(N'iphone 5', 695, 2, '2013/05/24', 1),
(N'iphone 6', 222, 2, '2013/04/24', 1);
SELECT * FROM Product;



