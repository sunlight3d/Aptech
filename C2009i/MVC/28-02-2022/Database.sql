CREATE TABLE Category(
	CategoryId INT PRIMARY KEY IDENTITY(1, 1),
	CategoryName NVARCHAR(100) NOT NULL
);
INSERT INTO Category(CategoryName) VALUES
(N'Electronics'),
(N'Beverages'),
(N'Seafood');

CREATE TABLE Product(	
	ProductName NVARCHAR(50),
	Price FLOAT DEFAULT 0.0,
	Quantity INT DEFAULT 0,
	ReleaseDate DateTime,
	

