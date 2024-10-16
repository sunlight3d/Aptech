/*
Viết cho tôi các câu lệnh tạo bảng sau trong SQL Server:
Tên DB: BankTransfer
Bảng Users: UserID, UserName, UserPass, FullName, Address, Phone, Email, Status
Bảng Accounts: AccountID, AccountType, CreateDate, TotalAmount, UserID
Bảng Transactions: TransactionID, RequestID, ReceiverID, TransferTime, Reason, Amount
*/
IF NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'BankTransfer')
BEGIN
    CREATE DATABASE BankTransfer;
    PRINT 'Database BankTransfer has been created.';
END
ELSE
    PRINT 'Database BankTransfer already exists.';

-- Tạo bảng Users
CREATE TABLE Users (
    UserID INT PRIMARY KEY,
    UserName NVARCHAR(100) NOT NULL,
    UserPass NVARCHAR(100) NOT NULL,
    FullName NVARCHAR(200) NOT NULL,
    Address NVARCHAR(500) NOT NULL,
    Phone NVARCHAR(20) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Status BIT NOT NULL
);

-- Tạo bảng Accounts
CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    AccountType NVARCHAR(50),
    CreateDate DATETIME,
    TotalAmount FLOAT,
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Tạo bảng Transactions
CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY,
    RequestID INT,
    ReceiverID INT,
    TransferTime DATETIME,
    Reason NVARCHAR(500),
    Amount FLOAT,
    FOREIGN KEY (RequestID) REFERENCES Users(UserID),
    FOREIGN KEY (ReceiverID) REFERENCES Users(UserID)
);

USE BankTransfer;

-- Chèn dữ liệu vào bảng Users
INSERT INTO Users (UserID, UserName, UserPass, FullName, Address, Phone, Email, Status)
VALUES
    (1, 'DonaldTrump', 'P@ssw0rd', 'Donald J. Trump', '1600 Pennsylvania Ave NW', '202-456-1111', 'donald.trump@example.com', 1),
    (2, 'BarackObama', 'Pass1234', 'Barack Hussein Obama II', '2446 Belmont Rd NW', '202-456-1414', 'barack.obama@example.com', 0),
    (3, 'ElonMusk', 'SpaceX123', 'Elon Reeve Musk', '3500 Deer Creek Rd', '123-456-7890', 'elon.musk@example.com', 1),
    (4, 'WarrenBuffett', 'Oracle456', 'Warren Edward Buffett', '1440 Kiewit Plaza', '402-346-1400', 'warren.buffett@example.com', 1),
    (5, 'AngelaMerkel', 'Germany789', 'Angela Dorothea Merkel', 'Bundeskanzleramt', '+49 30 18 272-0', 'angela.merkel@example.com', 0),
    (6, 'JeffBezos', 'Amazon321', 'Jeffrey Preston Bezos', '2121 7th Ave', '206-266-1000', 'jeff.bezos@example.com', 1),
    (7, 'VladimirPutin', 'Russia555', 'Vladimir Vladimirovich Putin', '23, Ilyinka Street', '+7 495 987-87-87', 'vladimir.putin@example.com', 1),
    (8, 'QueenElizabeth', 'England123', 'Elizabeth Alexandra Mary Windsor', 'Buckingham Palace', '+44 303 123 7300', 'queen.elizabeth@example.com', 1),
    (9, 'XiJinping', 'China888', 'Xi Jinping', 'Zhongnanhai', '+86 10 6307 0913', 'xi.jinping@example.com', 1),
    (10, 'NarendraModi', 'India777', 'Narendra Damodardas Modi', '7, Lok Kalyan Marg', '+91 11 2301 4000', 'narendra.modi@example.com', 1);

-- Chèn dữ liệu vào bảng Accounts
INSERT INTO Accounts (AccountID, AccountType, CreateDate, TotalAmount, UserID)
VALUES
    (1, 'Savings', GETDATE(), 50000, 1),
    (2, 'Checking', GETDATE(), 10000, 2),
    (3, 'Investment', GETDATE(), 75000, 3),
    (4, 'Savings', GETDATE(), 300000, 4),
    (5, 'Checking', GETDATE(), 5000, 5),
    (6, 'Investment', GETDATE(), 2000000, 6),
    (7, 'Savings', GETDATE(), 100000, 7),
    (8, 'Checking', GETDATE(), 15000, 8),
    (9, 'Investment', GETDATE(), 1000000, 9),
    (10, 'Savings', GETDATE(), 80000, 10);

-- Chèn dữ liệu vào bảng Transactions
INSERT INTO Transactions (TransactionID, RequestID, ReceiverID, TransferTime, Reason, Amount)
VALUES
    (1, 1, 2, GETDATE(), 'Transfer for investment', 5000),
    (2, 2, 1, GETDATE(), 'Repayment of loan', 1500),
    (3, 3, 4, GETDATE(), 'Purchase of stocks', 25000),
    (4, 4, 5, GETDATE(), 'Transfer to checking account', 1000),
    (5, 5, 6, GETDATE(), 'Investment in SpaceX', 500000),
    (6, 6, 7, GETDATE(), 'Transfer for political campaign', 20000),
    (7, 7, 8, GETDATE(), 'Donation to charity', 5000),
    (8, 8, 9, GETDATE(), 'Investment in infrastructure', 750000),
    (9, 9, 10, GETDATE(), 'Transfer for government project', 100000),
    (10, 10, 1, GETDATE(), 'Education fund', 3000);


Scaffold-DbContext -Connection "Data Source=.\SQLEXPRESS;Initial Catalog=BankTransfer;Integrated Security=True;Trusted_Connection=True;" -Provider Microsoft.EntityFrameworkCore.SqlServer
Microsoft.EntityFrameworkCore.SqlServer -OutputDir Models
