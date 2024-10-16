DROP DATABASE de05;
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'de05')
BEGIN
    CREATE DATABASE de05;
END
USE de05;

CREATE TABLE Users (
    [Id]                   NVARCHAR (450)    NOT NULL,
    [UserName]             NVARCHAR (256)    NULL,    
    [Email]                NVARCHAR (256)    NULL,    
    [EmailConfirmed]       BIT               DEFAULT 1,
    [PasswordHash]         NVARCHAR (MAX)    NULL,
    [PhoneNumber]          NVARCHAR (MAX)    NULL,
    [PhoneNumberConfirmed] BIT               NOT NULL,
    [TwoFactorEnabled]     BIT               NOT NULL,
    [LockoutEnd]           DATETIMEOFFSET    NULL,
    [LockoutEnabled]       BIT               NOT NULL,
    [AccessFailedCount]    INT               NOT NULL,
    CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED ([Id] ASC)
);

CREATE TABLE Roles (
    [Id]           NVARCHAR(450) NOT NULL,
    [Name]         NVARCHAR(256) NULL,    
    [ConcurrencyStamp] NVARCHAR(MAX) NULL,
    CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED ([Id] ASC)
);

CREATE TABLE UserRoles (
    [UserId]       NVARCHAR(450) NOT NULL,
    [RoleId]       NVARCHAR(450) NOT NULL,
    CONSTRAINT [PK_UserRoles] PRIMARY KEY CLUSTERED ([UserId] ASC, [RoleId] ASC),
    CONSTRAINT [FK_UserRoles_Users_UserId] FOREIGN KEY ([UserId]) REFERENCES Users ([Id]) ON DELETE CASCADE,
    CONSTRAINT [FK_UserRoles_Roles_RoleId] FOREIGN KEY ([RoleId]) REFERENCES Roles ([Id]) ON DELETE CASCADE
);

CREATE TABLE Products (
     Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Name VARCHAR(255),
    Price DECIMAL(10, 2),
    Description VARCHAR(MAX),
    Quantity INT
);
CREATE TABLE Orders (
    Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    OrderDate DATETIME,
    CustomerPhone VARCHAR(15),
    ProductId INT,
    Quantity INT
);


-- Đặt NOT NULL cho cột Name
ALTER TABLE Products
ALTER COLUMN Name NVARCHAR(255) NOT NULL;

-- Đặt NOT NULL cho cột Price
ALTER TABLE Products
ALTER COLUMN Price DECIMAL(10, 2) NOT NULL;

-- Đặt NOT NULL cho cột Quantity
ALTER TABLE Products
ALTER COLUMN Quantity INT NOT NULL;


-- Add check constraints for length and minimum values
ALTER TABLE Products
ADD CONSTRAINT CHK_Products_Name_Length CHECK (LEN(Name) >= 5 AND LEN(Name) <= 255);

ALTER TABLE Products
ADD CONSTRAINT CHK_Products_Price_Min CHECK (Price >= 0);

ALTER TABLE Products
ADD CONSTRAINT CHK_Products_Quantity_Min CHECK (Quantity >= 0);

-- Đặt NOT NULL cho cột CustomerPhone
ALTER TABLE Orders
ALTER COLUMN CustomerPhone NVARCHAR(15) NOT NULL;

-- Đặt NOT NULL cho cột Quantity
ALTER TABLE Orders
ALTER COLUMN Quantity INT NOT NULL;


-- Add check constraints for length and minimum values
ALTER TABLE Orders
ADD CONSTRAINT CHK_Orders_CustomerPhone_Length CHECK (LEN(CustomerPhone) >= 6 AND LEN(CustomerPhone) <= 15);

ALTER TABLE Orders
ADD CONSTRAINT CHK_Orders_Quantity_Min CHECK (Quantity >= 1);

-- Add foreign key constraint
ALTER TABLE Orders
ADD CONSTRAINT FK_Orders_Products_ProductId FOREIGN KEY (ProductId) REFERENCES Products(Id);


INSERT INTO Products (Name, Price, Description, Quantity) VALUES
('iPhone 13', 799.00, 'iPhone 13 with 128GB storage - latest model', 50),
('MacBook Pro 14"', 1999.00, 'MacBook Pro with M1 chip - 512GB SSD, 16GB RAM', 30),
('Samsung Galaxy S21', 699.00, 'Samsung Galaxy S21 - 128GB storage, 8GB RAM', 75),
('Dell XPS 13', 999.00, 'Dell XPS 13 with Intel Core i7 - 256GB SSD, 8GB RAM', 40),
('Apple Watch Series 7', 399.00, 'Apple Watch Series 7 - 45mm, GPS model', 65),
('Sony WH-1000XM4 Headphones', 349.99, 'Sony noise-cancelling wireless headphones', 90),
('iPad Pro 11"', 799.00, 'iPad Pro with 128GB storage, WiFi model', 50),
('Lenovo ThinkPad X1 Carbon', 1200.00, 'Lenovo ThinkPad X1 Carbon Gen 9 - Intel i5, 512GB SSD, 8GB RAM', 35),
('Google Pixel 6', 599.00, 'Google Pixel 6 - 128GB storage, 8GB RAM', 80),
('HP Spectre x360', 1150.00, 'HP Spectre x360 Convertible laptop - Intel i7, 256GB SSD, 16GB RAM', 45),
('Microsoft Surface Pro 7', 899.00, 'Microsoft Surface Pro 7 - 128GB SSD, 8GB RAM', 60),
('Bose QuietComfort Earbuds', 279.00, 'Bose noise-cancelling wireless earbuds', 110),
('Nikon Z6', 1599.99, 'Nikon Z6 Full Frame Mirrorless Camera', 30),
('Canon EOS R5', 3899.00, 'Canon EOS R5 Mirrorless Camera - 45MP, 8K Video', 25),
('Apple AirPods Pro', 249.00, 'Apple AirPods Pro with noise-cancellation', 150),
('Asus ROG Phone 5', 699.00, 'Asus ROG Gaming Phone - 12GB RAM, 256GB Storage', 65),
('Samsung Galaxy Tab S7', 649.99, 'Samsung Galaxy Tab S7 - 11" screen, 128GB', 70),
('Sony PlayStation 5', 499.99, 'Sony PlayStation 5 console', 30),
('Xbox Series X', 499.99, 'Microsoft Xbox Series X console', 40),
('JBL Flip 5', 119.99, 'JBL Flip 5 Portable Bluetooth Speaker', 120);

INSERT INTO Orders (OrderDate, CustomerPhone, ProductId, Quantity) VALUES
('2023-06-01', '1234567890', 1, 1),
('2023-06-02', '2345678901', 2, 2),
('2023-06-03', '3456789012', 3, 3),
('2023-06-04', '4567890123', 4, 1),
('2023-06-05', '5678901234', 5, 2),
('2023-06-06', '6789012345', 6, 1),
('2023-06-07', '7890123456', 7, 4),
('2023-06-08', '8901234567', 8, 1),
('2023-06-09', '9012345678', 9, 2),
('2023-06-10', '0123456789', 10, 3),
('2023-06-11', '1234509876', 11, 1),
('2023-06-12', '2345610987', 12, 2),
('2023-06-13', '3456721098', 13, 3),
('2023-06-14', '4567832109', 14, 1),
('2023-06-15', '5678943210', 15, 2),
('2023-06-16', '6789054321', 16, 3),
('2023-06-17', '7890165432', 17, 1),
('2023-06-18', '8901276543', 18, 2),
('2023-06-19', '9012387654', 19, 1),
('2023-06-20', '0123498765', 20, 2);
