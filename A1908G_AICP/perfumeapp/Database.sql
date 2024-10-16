/*
Write a html file of Register new user, with modern colors, responsively bootstrap(latest version)
FirstName, LastName ,Email,Password
This page must have Header, Footer, responsive mobile first
Header must be fixed(not move) when scrolling down
have some sub menu, footer must have Copyright, modern color
*/
CREATE TABLE Users (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    OrderHistory VARCHAR(MAX),
    Preferences VARCHAR(MAX)
);

-- Raw password: password1
INSERT INTO Users (FirstName, LastName, Email, Password, OrderHistory, Preferences)
VALUES ('John', 'Doe', 'johndoe@example.com', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', NULL, NULL);

-- Raw password: password2
INSERT INTO Users (FirstName, LastName, Email, Password, OrderHistory, Preferences)
VALUES ('Jane', 'Doe', 'janedoe@example.com', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', NULL, NULL);

-- Raw password: password3
INSERT INTO Users (FirstName, LastName, Email, Password, OrderHistory, Preferences)
VALUES ('Alice', 'Johnson', 'alicejohnson@example.com', 'd7d569202f22edb62f9c458e8efc0f2e677168efad0a2e4ad8c3d4aa4a0f9c91', NULL, NULL);

-- Raw password: password4
INSERT INTO Users (FirstName, LastName, Email, Password, OrderHistory, Preferences)
VALUES ('Bob', 'Smith', 'bobsmith@example.com', 'd7f128d32b2258a1a2e803658ef7ed71641df1c8e885b077a6b5dd7a5746a8b0', NULL, NULL);

-- Raw password: password5
INSERT INTO Users (FirstName, LastName, Email, Password, OrderHistory, Preferences)
VALUES ('Charlie', 'Brown', 'charliebrown@example.com', '9c5a6d5d6c0ef76f827123bca4e4b4c6a2b2c3d3e4f5g6h7i8j9k0l1m2n3o4p5', NULL, NULL);

-- Raw password: password6
INSERT INTO Users (FirstName, LastName, Email, Password, OrderHistory, Preferences)
VALUES ('Emily', 'Davis', 'emilydavis@example.com', '50d92801850e1a9577f0a0a12b7d77c0b9a7b9c8d9eaebf0a1b2c3d4e5f6g7h8', NULL, NULL);

-- Raw password: password7
INSERT INTO Users (FirstName, LastName, Email, Password, OrderHistory, Preferences)
VALUES ('Michael', 'Lee', 'michaellee@example.com', 'f2d7e9a20b9c1d2e3e4f5g6h7i8j9k0l1m2n3o4p5q6r7s8t9u0v1w2x3y4z5a6b7', NULL, NULL);


/*
Write html code Display a catalog of perfumes with descriptions, images, and prices.
with modern colors, responsively bootstrap(latest version), mobile ok
Image from url from the internet
*/
CREATE TABLE Products (
    ProductID INT PRIMARY KEY IDENTITY(1,1),
    ProductName VARCHAR(100) NOT NULL,
    Description VARCHAR(MAX),
    ImageURL VARCHAR(MAX),
    Price DECIMAL(10,2) NOT NULL
);
/*
Write html code:
Product search and filtering: Allow users to search for perfumes by name, brand, scent, price range, and other criteria.
Image from url from the internet
No need header, footer, navbar
*/



CREATE TABLE ProductReviews (
    ReviewID INT PRIMARY KEY IDENTITY(1,1),
    UserID INT NOT NULL,
    ProductID INT NOT NULL,
    Rating INT NOT NULL,
    ReviewText VARCHAR(MAX),
    CONSTRAINT FK_ProductReviews_UserID FOREIGN KEY (UserID) REFERENCES Users(UserID),
    CONSTRAINT FK_ProductReviews_ProductID FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('iPhone 13 Pro Max', 'Latest iPhone model with 6.7-inch display', 'https://example.com/images/iphone13promax.jpg', 1099.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('iPad Pro 12.9"', 'New iPad Pro with 12.9-inch display and M1 chip', 'https://example.com/images/ipadpro.jpg', 999.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Dell XPS 13', '13-inch laptop with 11th generation Intel Core processor', 'https://example.com/images/dellxps13.jpg', 1299.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Dyson V11 Vacuum', 'High-performance cordless vacuum cleaner', 'https://example.com/images/dysonv11.jpg', 599.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Instant Pot Duo', '7-in-1 electric pressure cooker', 'https://example.com/images/instantpotduo.jpg', 89.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Nespresso VertuoPlus', 'Espresso and coffee maker machine', 'https://example.com/images/nespressovetuoplus.jpg', 179.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('KitchenAid Stand Mixer', '5-quart professional stand mixer', 'https://example.com/images/kitchenaidmixer.jpg', 429.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('SodaStream Fizzi', 'Sparkling water maker with CO2 cylinder', 'https://example.com/images/sodastreamfizzi.jpg', 79.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Blue Apron Meal Kit', 'Meal kit delivery service', 'https://example.com/images/blueapron.jpg', 59.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('HelloFresh Meal Kit', 'Meal kit delivery service', 'https://example.com/images/hellofresh.jpg', 69.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Samsung Galaxy S22', 'Latest Samsung flagship smartphone with 6.2-inch display', 'https://example.com/images/galaxys22.jpg', 999.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Amazon Echo Dot', 'Smart speaker with Alexa voice assistant', 'https://example.com/images/echodot.jpg', 49.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Sony WH-1000XM4', 'Wireless noise-canceling headphones', 'https://example.com/images/sonywh1000xm4.jpg', 349.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Nintendo Switch', 'Portable gaming console', 'https://example.com/images/nintendoswitch.jpg', 299.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Apple Watch Series 7', 'Advanced smartwatch with health and fitness tracking', 'https://example.com/images/applewatchseries7.jpg', 399.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Roomba i7', 'Robot vacuum cleaner with smart mapping', 'https://example.com/images/roombai7.jpg', 599.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Philips Hue Smart Bulb', 'Color-changing smart LED light bulb', 'https://example.com/images/philipshuebulb.jpg', 49.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Fitbit Charge 5', 'Advanced fitness tracker with heart rate monitoring', 'https://example.com/images/fitbitcharge5.jpg', 179.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Google Nest Thermostat', 'Smart thermostat with energy-saving features', 'https://example.com/images/googlenestthermostat.jpg', 129.00);

INSERT INTO Products (ProductName, Description, ImageURL, Price)
VALUES ('Ring Video Doorbell', 'Smart doorbell with video and two-way audio', 'https://example.com/images/ringvideodoorbell.jpg', 99.00);


CREATE TABLE ShoppingCart (
    CartID INT PRIMARY KEY IDENTITY(1,1),
    UserID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL,
    CONSTRAINT FK_ShoppingCart_UserID FOREIGN KEY (UserID) REFERENCES Users(UserID),
    CONSTRAINT FK_ShoppingCart_ProductID FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE Orders (
    OrderId INT PRIMARY KEY IDENTITY(1,1),
    UserId INT NOT NULL,
    OrderDate DATETIME NOT NULL,
    TotalPrice DECIMAL(18,2) NOT NULL,
    OrderStatus VARCHAR(20) NOT NULL,
    CONSTRAINT FK_Orders_Users FOREIGN KEY (UserId) REFERENCES Users(UserId)
);

CREATE TABLE OrderDetails (
    OrderDetailId INT PRIMARY KEY IDENTITY(1,1),
    OrderId INT NOT NULL,
    ProductId INT NOT NULL,
    Quantity INT NOT NULL,
    Price DECIMAL(18,2) NOT NULL,
    CONSTRAINT FK_OrderDetails_Order FOREIGN KEY (OrderId) REFERENCES Orders(OrderId),
    CONSTRAINT FK_OrderDetails_Product FOREIGN KEY (ProductId) REFERENCES Products(ProductId)
);

CREATE TABLE Newsletters (
    NewsletterID INT PRIMARY KEY IDENTITY(1,1),
    UserID INT NOT NULL,
    Email VARCHAR(100) NOT NULL,
    CONSTRAINT FK_Newsletters_UserID FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE Wishlists (
    WishlistID INT PRIMARY KEY IDENTITY(1,1),
    UserID INT NOT NULL,
    ProductID INT NOT NULL,
    CONSTRAINT FK_Wishlists_UserID FOREIGN KEY (UserID) REFERENCES Users(UserID),
    CONSTRAINT FK_Wishlists_ProductID FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE GiftCards (
    GiftCardID INT PRIMARY KEY IDENTITY(1,1),
    UserID INT NOT NULL,
    Amount DECIMAL(10,2) NOT NULL,
    CONSTRAINT FK_GiftCards_UserID FOREIGN KEY (UserID) REFERENCES Users(UserID)
);
CREATE TABLE Admin (
    AdminID INT PRIMARY KEY IDENTITY(1,1),
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Password VARCHAR(100) NOT NULL
);



I have an entity like this(SQL Server):
CREATE TABLE Users (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    OrderHistory VARCHAR(MAX),
    Preferences VARCHAR(MAX)
);

write REgister, Login function in Controller asp .net  core mvc :
-Password must be hashed
-After login, data is saved session(remember password)
-Use Entity Framework core


Generate 10 users, show me sql insert:
CREATE TABLE Users (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    OrderHistory VARCHAR(MAX),
    Preferences VARCHAR(MAX)
);
Password is hashed using SHA256, comment raw password so I can test login


--Generate 10 products, name maybe: iphone, ipad, laptop, house equipments, foods:
CREATE TABLE Products (
    ProductID INT PRIMARY KEY IDENTITY(1,1),
    ProductName VARCHAR(100) NOT NULL,
    Description VARCHAR(MAX),
    ImageURL VARCHAR(MAX),
    Price DECIMAL(10,2) NOT NULL
);