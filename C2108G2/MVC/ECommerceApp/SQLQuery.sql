CREATE DATABASE c2108g2;
USE c2108g2;
-- Create the Users table
CREATE TABLE Users (
    UserId INT PRIMARY KEY IDENTITY(1,1),
    Username VARCHAR(50) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    Address VARCHAR(100) NOT NULL,
    Phone VARCHAR(20) NOT NULL
);

-- Create the Categories table
CREATE TABLE Categories (
    CategoryId INT PRIMARY KEY IDENTITY(1,1),
    CategoryName VARCHAR(50) NOT NULL
);

-- Create the Products table
CREATE TABLE Products (
    ProductId INT PRIMARY KEY IDENTITY(1,1),
    ProductName VARCHAR(50) NOT NULL,
    Description VARCHAR(200) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    Image VARCHAR(100) NOT NULL,
    CategoryId INT FOREIGN KEY REFERENCES Categories(CategoryId)
);

-- Create the Cart table
CREATE TABLE Cart (
    CartId INT PRIMARY KEY IDENTITY(1,1),
    UserId INT FOREIGN KEY REFERENCES Users(UserId),
    ProductId INT FOREIGN KEY REFERENCES Products(ProductId),
    Quantity INT NOT NULL
);

-- Create the Orders table
CREATE TABLE Orders (
    OrderId INT PRIMARY KEY IDENTITY(1,1),
    UserId INT FOREIGN KEY REFERENCES Users(UserId),
    TotalPrice DECIMAL(10,2) NOT NULL,
    OrderDate DATETIME NOT NULL
);
-- Create the OrderDetails table
CREATE TABLE OrderDetails (
    OrderDetailId INT PRIMARY KEY IDENTITY(1,1),
    OrderId INT FOREIGN KEY REFERENCES Orders(OrderId),
    ProductId INT FOREIGN KEY REFERENCES Products(ProductId),
    Quantity INT NOT NULL,
    Price DECIMAL(10,2) NOT NULL
);

-- Create a unique index on the Email column of the Users table
CREATE UNIQUE INDEX Email_Unique_Index ON Users (Email)

-- Create a unique index on the ProductName column of the Products table
CREATE UNIQUE INDEX ProductName_Unique_Index ON Products (ProductName)

-- Create a stored procedure to add a user to the Users table with an encrypted password
DROP TRIGGER EncryptPasswordTrigger;
CREATE TRIGGER EncryptPasswordTrigger
ON Users
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    UPDATE Users
    SET password = dbo.HashPassword(Users.password)
    FROM inserted
    WHERE Users.UserId = inserted.UserId;
END

-- Create a stored procedure to check if a user exists in the Users table with a given email and password
CREATE PROCEDURE CheckUser
    @Email VARCHAR(50),
    @Password VARCHAR(100)
AS
BEGIN
    SELECT UserId, Username, Email, Address, Phone
    FROM Users
    WHERE Email = @Email AND Password = HASHBYTES('SHA2_256', @Password)
END

SELECT * FROM Users;
DELETE FROM Users WHERE Email='aaa@gmail.com';

INSERT INTO Users(Username, Email, Address, Phone)
VALUES('hoangnd', 'aaa@gmail.com', 'aa111', '0912212');