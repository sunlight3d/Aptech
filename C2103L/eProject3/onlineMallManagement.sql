/*
Trong thiết kế trên, chúng ta sử dụng các khóa ngoại để quan hệ giữa các thực thể như sau:

Mỗi tầng trong trung tâm mua sắm (Floors) thuộc về một trung tâm mua sắm cụ thể (Malls).
Mỗi cửa hàng (Shops) thuộc về một tầng cụ thể trong trung tâm mua sắm (Floors).
Mỗi rạp chiếu phim (Cinemas) thuộc về một trung tâm mua sắm cụ thể (Malls).
Mỗi ghế trong rạp chiếu phim (Seats) thuộc về một rạp chiếu phim cụ thể (Cinemas).
Mỗi gian hàng tại khu ẩm thực (FoodCounters) thuộc về một tầng cụ thể trong trung tâm mua sắm (Floors).
Mỗi hình ảnh trong bộ sưu tập (Gallery) thuộc về một trung tâm mua sắm cụ thể (Malls).
Mỗi phản hồi từ khách hàng (Feedbacks) thuộc về một trung tâm mua sắm cụ thể (Malls).
Mỗi đặt vé (Bookings) thuộc về một rạp chiếu phim cụ thể (Cinemas) và một ghế cụ thể (Seats).
Mỗi thông tin liên hệ (Contacts) thuộc về một trung tâm mua sắm cụ thể (Malls).
*/
-- Bảng lưu thông tin về trung tâm mua sắm
CREATE TABLE Malls (
   MallID INT PRIMARY KEY,
   Name NVARCHAR(100) NOT NULL,
   Location NVARCHAR(100) NOT NULL,
   Developer NVARCHAR(100) NOT NULL,
   Area INT,
   Frontage INT
);

-- Bảng lưu thông tin về tầng của trung tâm mua sắm
CREATE TABLE Floors (
   FloorID INT PRIMARY KEY,
   MallID INT,
   Area INT,
   CONSTRAINT FK_Floors_Malls FOREIGN KEY (MallID) REFERENCES Malls (MallID)
);

-- Bảng lưu thông tin về các cửa hàng trong trung tâm mua sắm
CREATE TABLE Shops (
   ShopID INT PRIMARY KEY,
   FloorID INT,
   Name NVARCHAR(100) NOT NULL,
   CONSTRAINT FK_Shops_Floors FOREIGN KEY (FloorID) REFERENCES Floors (FloorID)
);

-- Bảng lưu thông tin về các rạp chiếu phim trong trung tâm mua sắm
CREATE TABLE Cinemas (
   CinemaID INT PRIMARY KEY,
   MallID INT,
   Name NVARCHAR(100) NOT NULL,
   CONSTRAINT FK_Cinemas_Malls FOREIGN KEY (MallID) REFERENCES Malls (MallID)
);

-- Bảng lưu thông tin về các ghế trong rạp chiếu phim
CREATE TABLE Seats (
   SeatID INT PRIMARY KEY,
   CinemaID INT,
   Row INT,
   Number INT,
   CONSTRAINT FK_Seats_Cinemas FOREIGN KEY (CinemaID) REFERENCES Cinemas (CinemaID)
);

-- Bảng lưu thông tin về các gian hàng tại khu ẩm thực trong trung tâm mua sắm
CREATE TABLE FoodCounters (
   CounterID INT PRIMARY KEY,
   FloorID INT,
   Name NVARCHAR(100) NOT NULL,
   CONSTRAINT FK_FoodCounters_Floors FOREIGN KEY (FloorID) REFERENCES Floors (FloorID)
);

-- Bảng lưu thông tin về các sản phẩm và thương hiệu
CREATE TABLE Products (
   ProductID INT PRIMARY KEY,
   Name NVARCHAR(100) NOT NULL,
   Brand NVARCHAR(100) NOT NULL
);

-- Bảng lưu thông tin về phản hồi từ khách hàng
CREATE TABLE Feedbacks (
   FeedbackID INT PRIMARY KEY,
   MallID INT,
   Content NVARCHAR(MAX),
   CONSTRAINT FK_Feedbacks_Malls FOREIGN KEY (MallID) REFERENCES Malls (MallID)
);

-- Bảng lưu thông tin về các hình ảnh trong bộ sưu tập
CREATE TABLE Gallery (
   ImageID INT PRIMARY KEY,
   MallID INT,
   ImagePath NVARCHAR(255) NOT NULL,
   CONSTRAINT FK_Gallery_Malls FOREIGN KEY (MallID) REFERENCES Malls (MallID)
);

-- Bảng lưu thông tin về đặt vé của khách hàng, orders
CREATE TABLE Bookings (
   BookingID INT PRIMARY KEY,
   CinemaID INT,
   SeatID INT,
   CustomerName NVARCHAR(100) NOT NULL,
   CardNumber NVARCHAR(16) NOT NULL,
   CONSTRAINT FK_Bookings_Cinemas FOREIGN KEY (CinemaID) REFERENCES Cinemas (CinemaID),
   CONSTRAINT FK_Bookings_Seats FOREIGN KEY (SeatID) REFERENCES Seats (SeatID)
);

-- Bảng lưu thông tin liên hệ của trung tâm mua sắm
CREATE TABLE Contacts (
   ContactID INT PRIMARY KEY,
   MallID INT,
   Address NVARCHAR(100) NOT NULL,
   Phone NVARCHAR(20) NOT NULL,
   Email NVARCHAR(100) NOT NULL,
   CONSTRAINT FK_Contacts_Malls FOREIGN KEY (MallID) REFERENCES Malls (MallID)
);


CREATE TABLE Users (
   UserID INT PRIMARY KEY,
   Username NVARCHAR(100) NOT NULL,
   Password NVARCHAR(100) NOT NULL,
   Email NVARCHAR(100) NOT NULL,
   FullName NVARCHAR(100),
   RoleID INT,
   CreatedAt DATETIME,
   UpdatedAt DATETIME,
   Deleted INT,
   CONSTRAINT FK_Users_Roles FOREIGN KEY (RoleID) REFERENCES Roles (RoleID)
);

CREATE TABLE Roles (
   RoleID INT PRIMARY KEY,
   RoleName NVARCHAR(100) NOT NULL
);

