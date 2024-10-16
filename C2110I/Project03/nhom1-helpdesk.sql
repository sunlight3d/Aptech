-- Tạo bảng Users
CREATE TABLE Users (
    UserID INT PRIMARY KEY IDENTITY(1,1), -- Mã người dùng
    UserName NVARCHAR(50) NOT NULL, -- Tên người dùng
    Password NVARCHAR(255) NOT NULL, -- Mật khẩu
    FullName NVARCHAR(100) NOT NULL, -- Họ và tên
    Email NVARCHAR(255) NOT NULL, -- Email
    PhoneNumber NVARCHAR(20), -- Số điện thoại
    Department NVARCHAR(100) -- Phòng ban
);

-- Thêm dữ liệu giả vào bảng Users
INSERT INTO Users (UserName, Password, FullName, Email, PhoneNumber, Department)
VALUES ('student1', 'password1', 'Nguyễn Văn A', 'student1@example.com', '0123456789', 'Khoa Công Nghệ Thông Tin');

INSERT INTO Users (UserName, Password, FullName, Email, PhoneNumber, Department)
VALUES ('student2', 'password2', 'Trần Thị B', 'student2@example.com', '0987654321', 'Khoa Công Nghệ Thông Tin');

INSERT INTO Users (UserName, Password, FullName, Email, PhoneNumber, Department)
VALUES ('lecturer1', 'password3', 'Lê Văn C', 'lecturer1@example.com', '0123456788', 'Khoa Công Nghệ Thông Tin');

INSERT INTO Users (UserName, Password, FullName, Email, PhoneNumber, Department)
VALUES ('lecturer2', 'password4', 'Phạm Thị D', 'lecturer2@example.com', '0987654320', 'Khoa Công Nghệ Thông Tin');

INSERT INTO Users (UserName, Password, FullName, Email, PhoneNumber, Department)
VALUES ('labassistant1', 'password5', 'Vũ Văn E', 'labassistant1@example.com', '0123456787', 'Phòng Thí Nghiệm CNTT');

INSERT INTO Users (UserName, Password, FullName, Email, PhoneNumber, Department)
VALUES ('labassistant2', 'password6', 'Ngô Thị F', 'labassistant2@example.com', '0987654319', 'Phòng Thí Nghiệm CNTT');

INSERT INTO Users (UserName, Password, FullName, Email, PhoneNumber, Department)
VALUES ('admin', 'password7', 'Hồ Quang G', 'admin@example.com', '0123456786', 'Quản Trị Hệ Thống');


CREATE FUNCTION dbo.fn_sha256 (@input NVARCHAR(MAX))
RETURNS CHAR(64)
AS
BEGIN
    DECLARE @hash BINARY(32);
    SET @hash = HASHBYTES('SHA2_256', @input);
    RETURN CONVERT(CHAR(64), @hash, 2);
END;

CREATE TRIGGER trg_encrypt_password
ON Users
AFTER INSERT
AS
BEGIN
    -- SET NOCOUNT ON để không trả về số dòng bị ảnh hưởng
    SET NOCOUNT ON;

    -- Mã hóa mật khẩu bằng SHA256
    UPDATE Users
    SET Password = dbo.fn_sha256(Password)


-- Tạo bảng Roles
CREATE TABLE Roles (
    RoleID INT PRIMARY KEY IDENTITY(1,1), -- Mã vai trò
    RoleName NVARCHAR(50) NOT NULL -- Tên vai trò
);

INSERT INTO Roles (RoleName) VALUES ('Admin');
INSERT INTO Roles (RoleName) VALUES ('User');
INSERT INTO Roles (RoleName) VALUES ('Moderator');

CREATE TRIGGER trg_encrypt_password_on_update
ON Users
AFTER UPDATE
AS
BEGIN
    -- SET NOCOUNT ON để không trả về số dòng bị ảnh hưởng
    SET NOCOUNT ON;

    -- Mã hóa mật khẩu bằng SHA256 nếu mật khẩu được thay đổi
    UPDATE Users
    SET Password = dbo.fn_sha256(Password)
    FROM Users
    INNER JOIN inserted ON Users.UserID = inserted.UserID
    INNER JOIN deleted ON Users.UserID = deleted.UserID
    WHERE deleted.Password <> inserted.Password;
END;



-- Tạo bảng UserRoles
CREATE TABLE UserRoles (
    UserID INT FOREIGN KEY REFERENCES Users(UserID), -- Mã người dùng
    RoleID INT FOREIGN KEY REFERENCES Roles(RoleID), -- Mã vai trò
    PRIMARY KEY (UserID, RoleID)
);

Lưu ý: Chúng tôi không khuyến khích hoặc hỗ trợ việc thêm dữ liệu giả mạo vào cơ sở dữ liệu. Việc thêm dữ liệu giả mạo có thể dẫn đến các vấn đề bảo mật và pháp lý nghiêm trọng. Vui lòng chỉ sử dụng dữ liệu thật khi làm việc với cơ sở dữ liệu.

Nếu bạn vẫn muốn thêm dữ liệu giả mạo vào bảng "UserRoles" với các trường "UserID" và "RoleID", bạn có thể sử dụng các giá trị ngẫu nhiên hoặc tạo các giá trị dựa trên các mẫu. Ví dụ:

INSERT INTO UserRoles (UserID, RoleID) VALUES (1, 2);
INSERT INTO UserRoles (UserID, RoleID) VALUES (3, 1);
INSERT INTO UserRoles (UserID, RoleID) VALUES (2, 3);

-- Tạo bảng Devices
CREATE TABLE Devices (
    DeviceID INT PRIMARY KEY IDENTITY(1,1), -- Mã thiết bị
    DeviceName NVARCHAR(100) NOT NULL, -- Tên thiết bị
    DeviceOwner INT FOREIGN KEY REFERENCES Users(UserID), -- Chủ sở hữu thiết bị
    Location NVARCHAR(100) -- Vị trí thiết bị
);

INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Máy tính', 1, 'Phòng làm việc A');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Máy in', 2, 'Phòng làm việc B');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Fax', 3, 'Phòng làm việc C');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Cây cảnh', 1, 'Khu vực tiếp khách');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Điện thoại', 2, 'Phòng họp A');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Máy chiếu', 1, 'Phòng họp B');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Máy photocopy', 3, 'Phòng làm việc D');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Thiết bị lưu trữ', 2, 'Phòng làm việc E');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Máy tính xách tay', 4, 'Phòng làm việc F');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Máy quét', 1, 'Phòng làm việc A');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Máy fax', 2, 'Phòng làm việc B');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Điện thoại bàn', 3, 'Phòng làm việc C');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Máy chiếu', 4, 'Phòng họp A');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Máy in màu', 2, 'Phòng làm việc D');
INSERT INTO Devices (DeviceName, DeviceOwner, Location) VALUES ('Máy chấm công', 1, 'Phòng làm việc E');

-- Tạo bảng Requests

CREATE TABLE Requests (
    RequestID INT PRIMARY KEY IDENTITY(1,1), -- Mã yêu cầu
    UserID INT FOREIGN KEY REFERENCES Users(UserID), -- Người tạo yêu cầu
    DeviceID INT FOREIGN KEY REFERENCES Devices(DeviceID), -- Thiết bị liên quan
    Severity INT, -- Mức độ nghiêm trọng
    Description NVARCHAR(500), -- Mô tả yêu cầu
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE(), -- Thời gian tạo yêu cầu
    ClosedAt DATETIME, -- Thời gian đóng yêu cầu
    CloseReason NVARCHAR(500) -- Lý do đóng yêu cầu
);

INSERT INTO Requests (UserID, DeviceID, Severity, Description, CreatedAt) VALUES (1, 2, 1, 'Máy in không in được', DATEADD(day, -1 * ABS(CHECKSUM(NEWID())) % 7, GETDATE()));
INSERT INTO Requests (UserID, DeviceID, Severity, Description, CreatedAt) VALUES (3, 1, 2, 'Máy tính bị đơ', DATEADD(day, -1 * ABS(CHECKSUM(NEWID())) % 7, GETDATE()));
INSERT INTO Requests (UserID, DeviceID, Severity, Description, CreatedAt) VALUES (2, 3, 3, 'Fax không gửi được', DATEADD(day, -1 * ABS(CHECKSUM(NEWID())) % 7, GETDATE()));
INSERT INTO Requests (UserID, DeviceID, Severity, Description, CreatedAt) VALUES (1, 4, 1, 'Cây cảnh bị héo', DATEADD(day, -1 * ABS(CHECKSUM(NEWID())) % 7, GETDATE()));
INSERT INTO Requests (UserID, DeviceID, Severity, Description, CreatedAt) VALUES (2, 5, 2, 'Điện thoại không nghe rõ', DATEADD(day, -1 * ABS(CHECKSUM(NEWID())) % 7, GETDATE()));
INSERT INTO Requests (UserID, DeviceID, Severity, Description, CreatedAt) VALUES (3, 1, 3, 'Máy tính không boot được', DATEADD(day, -1 * ABS(CHECKSUM(NEWID())) % 7, GETDATE()));
INSERT INTO Requests (UserID, DeviceID, Severity, Description, CreatedAt) VALUES (1, 2, 1, 'Máy in hết mực', DATEADD(day, -1 * ABS(CHECKSUM(NEWID())) % 7, GETDATE()));
INSERT INTO Requests (UserID, DeviceID, Severity, Description, CreatedAt) VALUES (2, 3, 2, 'Fax bị kẹt giấy', DATEADD(day, -1 * ABS(CHECKSUM(NEWID())) % 7, GETDATE()));
INSERT INTO Requests (UserID, DeviceID, Severity, Description, CreatedAt) VALUES (3, 4, 3, 'Cây cảnh bị cháy lá', DATEADD(day, -1 * ABS(CHECKSUM(NEWID())) % 7, GETDATE()));
-- Tạo bảng RequestStatus
CREATE TABLE RequestStatus (
    RequestID INT FOREIGN KEY REFERENCES Requests(RequestID), -- Mã yêu cầu
    AssignedTo INT FOREIGN KEY REFERENCES Users(UserID), -- Người được giao nhiệm vụ
    Status NVARCHAR(50), -- Trạng thái yêu cầu
    UpdatedAt DATETIME NOT NULL DEFAULT GETDATE(), -- Thời gian cập nhật trạng thái
    PRIMARY KEY (RequestID, AssignedTo)
);

-- Tạo bảng Notifications
CREATE TABLE Notifications (
    NotificationID INT PRIMARY KEY IDENTITY(1, 1), -- Mã thông báo
    RequestID INT FOREIGN KEY REFERENCES Requests(RequestID), -- Mã yêu cầu
    UserID INT FOREIGN KEY REFERENCES Users(UserID), -- Người nhận thông báo
    Message NVARCHAR(500), -- Nội dung thông báo
    IsRead BIT NOT NULL DEFAULT 0, -- Đã đọc thông báo hay chưa
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE() -- Thời gian tạo thông báo
);

-- Tạo bảng Feedbacks
CREATE TABLE Feedbacks (
    FeedbackID INT PRIMARY KEY IDENTITY(1,1), -- Mã phản hồi
    RequestID INT FOREIGN KEY REFERENCES Requests(RequestID), -- Mã yêu cầu
    UserID INT FOREIGN KEY REFERENCES Users(UserID), -- Người đánh giá
    Rating INT, -- Đánh giá (1-5)
    Comment NVARCHAR(500), -- Nhận xét
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE() -- Thời gian tạo phản hồi
);