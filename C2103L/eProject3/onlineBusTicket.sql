CREATE TABLE Buses (
	id INT PRIMARY KEY IDENTITY,
	bus_number NVARCHAR(10) NOT NULL UNIQUE,
	bus_type NVARCHAR(50) NOT NULL,
	route NVARCHAR(255) NOT NULL,
	total_seats INT NOT NULL
);

INSERT INTO Buses (bus_number, bus_type, route, total_seats)
VALUES
(N'HN001', N'Xe khách', N'Hà Nội - Nha Trang', 45),
(N'DN002', N'Xe khách', N'Đà Nẵng - Sài Gòn', 30),
(N'HCM003', N'Xe giường nằm', N'Hồ Chí Minh - Đà Lạt', 24),
(N'HCM004', N'Xe limousine', N'Hồ Chí Minh - Vũng Tàu', 12),
(N'HCM005', N'Xe khách', N'Hồ Chí Minh - Nha Trang', 45),
(N'NTN006', N'Xe khách', N'Nha Trang - Ninh Thuận', 30),
(N'HCM007', N'Xe giường nằm', N'Hồ Chí Minh - Huế', 24),
(N'HCM008', N'Xe limousine', N'Hồ Chí Minh - Đà Lạt', 12),
(N'DN009', N'Xe khách', N'Đà Nẵng - Huế', 45),
(N'HN010', N'Xe khách', N'Hà Nội - Sapa', 30),
(N'NTN011', N'Xe giường nằm', N'Nha Trang - Hà Nội', 24),
(N'HCM012', N'Xe limousine', N'Hồ Chí Minh - Cần Thơ', 12),
(N'HCM013', N'Xe khách', N'Hồ Chí Minh - Huế', 45),
(N'DN014', N'Xe khách', N'Đà Nẵng - Quy Nhơn', 30),
(N'HN015', N'Xe giường nằm', N'Hà Nội - Huế', 24),
(N'HCM016', N'Xe limousine', N'Hồ Chí Minh - Vũng Tàu', 12),
(N'NTN017', N'Xe khách', N'Nha Trang - Đà Lạt', 45),
(N'HCM018', N'Xe khách', N'Hồ Chí Minh - Cần Thơ', 30),
(N'HN019', N'Xe giường nằm', N'Hà Nội - Hạ Long', 24),
(N'HCM020', N'Xe limousine', N'Hồ Chí Minh - Phan Thiết', 12),
(N'DN021', N'Xe khách', N'Đà Nẵng - Quảng Ngãi', 45),
(N'NTN022', N'Xe khách', N'Nha Trang - Phan Rang', 30),
(N'HCM023', N'Xe giường nằm', N'Hồ Chí Minh - Đà Nẵng', 24),
(N'HCM024', N'Xe limousine', N'Hồ Chí Minh - Vũng Tàu', 12);

-- Tạo bảng Routes để lưu thông tin tuyến đường
-- Create Routes table to store route information
CREATE TABLE Routes (
	id INT PRIMARY KEY IDENTITY,
	route_name NVARCHAR(255) NOT NULL UNIQUE,
	departure NVARCHAR(255) NOT NULL,
	destination NVARCHAR(255) NOT NULL,
	distance FLOAT NOT NULL
);

INSERT INTO Routes (route_name, departure, destination, distance)
VALUES
(N'Tuyến Hà Nội - Nha Trang', N'Hà Nội', N'Nha Trang', 1287.5),
(N'Tuyến Hồ Chí Minh - Đà Nẵng', N'Hồ Chí Minh', N'Đà Nẵng', 961.3),
(N'Tuyến Đà Nẵng - Sài Gòn', N'Đà Nẵng', N'Hồ Chí Minh', 946.6),
(N'Tuyến Nha Trang - Hà Nội', N'Nha Trang', N'Hà Nội', 1314.4),
(N'Tuyến Hồ Chí Minh - Hà Nội', N'Hồ Chí Minh', N'Hà Nội', 1733.3),
(N'Tuyến Đà Nẵng - Nha Trang', N'Đà Nẵng', N'Nha Trang', 524.8),
(N'Tuyến Hồ Chí Minh - Đà Lạt', N'Hồ Chí Minh', N'Đà Lạt', 309.2),
(N'Tuyến Hà Nội - Sapa', N'Hà Nội', N'Sapa', 380.0),
(N'Tuyến Nha Trang - Đà Lạt', N'Nha Trang', N'Đà Lạt', 146.2),
(N'Tuyến Hồ Chí Minh - Vũng Tàu', N'Hồ Chí Minh', N'Vũng Tàu', 96.4),
(N'Tuyến Đà Nẵng - Huế', N'Đà Nẵng', N'Huế', 103.1),
(N'Tuyến Hồ Chí Minh - Cần Thơ', N'Hồ Chí Minh', N'Cần Thơ', 169.9),
(N'Tuyến Hà Nội - Hạ Long', N'Hà Nội', N'Hạ Long', 155.0),
(N'Tuyến Nha Trang - Phan Thiết', N'Nha Trang', N'Phan Thiết', 249.7),
(N'Tuyến Đà Nẵng - Quy Nhơn', N'Đà Nẵng', N'Quy Nhơn', 315.4),
(N'Tuyến Hồ Chí Minh - Phan Thiết', N'Hồ Chí Minh', N'Phan Thiết', 194.1),
(N'Tuyến Nha Trang - Ninh Thuận', N'Nha Trang', N'Ninh Thuận', 105.4),
(N'Tuyến Nha Trang - Phan Rang', N'Nha Trang', N'Phan Rang', 105.4),
(N'Tuyến Nha Trang - Đà Lạt', N'Nha Trang', N'Đà Lạt', 140.2);


-- Tạo bảng Schedule để lưu thông tin lịch trình của xe buýt
-- Create Schedule table to store bus schedule information
CREATE TABLE Schedule (
	id INT PRIMARY KEY IDENTITY,
	bus_id INT FOREIGN KEY REFERENCES Buses(id),
	route_id INT FOREIGN KEY REFERENCES Routes(id),
	departure_time DATETIME NOT NULL,
	arrival_time DATETIME NOT NULL
);
INSERT INTO Schedule (bus_id, route_id, departure_time, arrival_time)
VALUES
(1, 2, '2023-04-23 08:00:00', '2023-04-24 20:00:00'),
(2, 3, '2023-04-24 09:00:00', '2023-04-25 17:30:00'),
(3, 4, '2023-04-24 11:30:00', '2023-04-24 19:30:00'),
(4, 5, '2023-04-23 22:00:00', '2023-04-24 05:00:00'),
(5, 6, '2023-04-24 09:30:00', '2023-04-26 11:30:00'),
(6, 7, '2023-04-23 15:30:00', '2023-04-24 19:30:00'),
(7, 8, '2023-04-24 06:30:00', '2023-04-24 15:30:00'),
(8, 9, '2023-04-23 07:30:00', '2023-04-23 14:30:00'),
(9, 10, '2023-04-24 10:30:00', '2023-04-24 14:30:00'),
(10, 11, '2023-04-24 15:00:00', '2023-04-24 17:00:00'),
(11, 12, '2023-04-24 11:30:00', '2023-04-24 15:30:00'),
(12, 13, '2023-04-23 13:30:00', '2023-04-23 17:30:00'),
(13, 14, '2023-04-24 08:30:00', '2023-04-24 11:30:00'),
(14, 15, '2023-04-24 06:30:00', '2023-04-24 10:30:00'),
(15, 16, '2023-04-23 14:30:00', '2023-04-23 18:30:00'),
(16, 17, '2023-04-24 12:00:00', '2023-04-24 16:00:00'),
(17, 18, '2023-04-23 16:30:00', '2023-04-23 19:00:00'),
(18, 19, '2023-04-24 07:30:00', '2023-04-24 11:30:00');

-- Tạo bảng Customers để lưu thông tin khách hàng
-- Create Customers table to store customer information
CREATE TABLE Customers (
	id INT PRIMARY KEY IDENTITY,
	name NVARCHAR(255) NOT NULL,
	age INT NOT NULL,
	contact NVARCHAR(255) NOT NULL
);

INSERT INTO Customers (name, age, contact)
VALUES
('Nguyễn Thị Kim Tuyến', 25, '0123456789'),
('Trần Thị Hương Giang', 30, '0987654321'),
('Lê Văn Quang Huy', 45, '0909090909'),
('Phạm Thị Trang', 22, '0169696969'),
('Ngô Đình Hoài An', 50, '0912345678'),
('Trịnh Thị Ngọc Ánh', 35, '0123456789'),
('Lý Thị Ngọc Hân', 28, '0987654321'),
('Đặng Văn Trường', 42, '0909090909'),
('Võ Thị Minh Châu', 33, '0169696969'),
('Phan Văn Quốc Việt', 48, '0912345678'),
('Trần Thị Thanh Hằng', 29, '0123456789'),
('Nguyễn Văn Tùng', 27, '0987654321'),
('Lê Thị Hoàng Anh', 40, '0909090909'),
('Hồ Văn Đức', 26, '0169696969'),
('Đào Thị Mai Anh', 39, '0912345678'),
('Bùi Văn Khánh', 31, '0123456789'),
('Lưu Thị Thuỳ Trang', 36, '0987654321'),
('Mai Văn Nam', 43, '0909090909'),
('Đinh Thị Minh Ngọc', 24, '0169696969'),
('Trần Văn Minh', 38, '0912345678');


-- Tạo bảng Employees để lưu thông tin nhân viên
-- Create Employees table to store employee information
CREATE TABLE Employees (
	id INT PRIMARY KEY IDENTITY,
	username NVARCHAR(50) NOT NULL UNIQUE,
	password NVARCHAR(255) NOT NULL,
	name NVARCHAR(255) NOT NULL,
	age INT NOT NULL,
	contact NVARCHAR(255) NOT NULL,
	location NVARCHAR(255) NOT NULL,
	qualification NVARCHAR(255) NOT NULL
);

INSERT INTO Employees (username, password, name, age, contact, location, qualification)
VALUES
('employee1', 'password1', 'Nguyễn Thị Hương', 25, '0123456789', 'Hà Nội', 'Đại học'),
('employee2', 'password2', 'Trần Văn Hùng', 30, '0987654321', 'Hải Phòng', 'Cao đẳng'),
('employee3', 'password3', 'Lê Thị Quỳnh', 45, '0909090909', 'Đà Nẵng', 'Trung cấp'),
('employee4', 'password4', 'Phạm Văn Tuấn', 22, '0169696969', 'Hồ Chí Minh', 'Đại học'),
('employee5', 'password5', 'Ngô Đình Thiện', 50, '0912345678', 'Cần Thơ', 'Cao đẳng'),
('employee6', 'password6', 'Trịnh Thị Kim Ngân', 35, '0123456789', 'Hải Dương', 'Trung cấp'),
('employee7', 'password7', 'Lý Thanh Huy', 28, '0987654321', 'Nghệ An', 'Đại học'),
('employee8', 'password8', 'Đặng Văn Lâm', 42, '0909090909', 'Hà Tĩnh', 'Cao đẳng'),
('employee9', 'password9', 'Võ Thị Thu Hương', 33, '0169696969', 'Bình Dương', 'Trung cấp'),
('employee10', 'password10', 'Phan Văn Bảy', 48, '0912345678', 'Quảng Ninh', 'Đại học');

-- Tạo bảng Tickets để lưu thông tin vé
-- Create Tickets table to store ticket information
CREATE TABLE Tickets (
	id INT PRIMARY KEY IDENTITY,
	customer_id INT FOREIGN KEY REFERENCES Customers(id),
	schedule_id INT FOREIGN KEY REFERENCES Schedule(id),
	seat_number INT NOT NULL,
	price FLOAT NOT NULL,
	booking_date DATETIME NOT NULL,
	status NVARCHAR(50) NOT NULL
);

INSERT INTO Tickets (customer_id, schedule_id, seat_number, price, booking_date, status)
VALUES
(1, 1, 1, 1500000, '2023-05-01 09:00:00', 'booked'),
(2, 3, 5, 800000, '2023-05-03 14:30:00', 'booked'),
(3, 2, 2, 1200000, '2023-05-02 11:45:00', 'booked'),
(4, 4, 8, 900000, '2023-05-04 16:20:00', 'booked'),
(5, 6, 3, 600000, '2023-05-06 13:00:00', 'booked'),
(6, 7, 12, 1500000, '2023-05-07 08:15:00', 'booked'),
(7, 5, 7, 1000000, '2023-05-05 10:00:00', 'booked'),
(8, 8, 10, 1300000, '2023-05-08 15:45:00', 'booked'),
(9, 9, 4, 700000, '2023-05-09 12:30:00', 'booked'),
(10, 10, 6, 800000, '2023-05-10 11:00:00', 'booked'),
(1, 1, 1, 1500000, '2023-05-01 09:00:00', 'booked'),
(2, 3, 5, 800000, '2023-05-03 14:30:00', 'canceled'),
(3, 2, 2, 1200000, '2023-05-02 11:45:00', 'booked'),
(4, 4, 8, 900000, '2023-05-04 16:20:00', 'canceled'),
(5, 6, 3, 600000, '2023-05-06 13:00:00', 'booked'),
(6, 7, 12, 1500000, '2023-05-07 08:15:00', 'checked in'),
(7, 5, 7, 1000000, '2023-05-05 10:00:00', 'booked'),
(8, 8, 10, 1300000, '2023-05-08 15:45:00', 'checked in'),
(9, 9, 4, 700000, '2023-05-09 12:30:00', 'canceled'),
(10, 10, 6, 800000, '2023-05-10 11:00:00', 'checked in');

-- Tạo bảng TicketPrices để lưu thông tin giá vé theo loại xe và khoảng cách
-- Create TicketPrices table to store ticket prices based on bus type and distance
CREATE TABLE TicketPrices (
	id INT PRIMARY KEY IDENTITY,
	bus_type NVARCHAR(50) NOT NULL,
	distance_from FLOAT NOT NULL,
	distance_to FLOAT NOT NULL,
	price FLOAT NOT NULL
);
INSERT INTO TicketPrices (bus_type, distance_from, distance_to, price)
VALUES
('Sleeper bus', 0, 100, 1000000),
('Sleeper bus', 101, 300, 1500000),
('Sleeper bus', 301, 500, 2000000),
('Luxury bus', 0, 100, 1500000),
('Luxury bus', 101, 300, 2000000),
('Luxury bus', 301, 500, 2500000),
('Regular bus', 0, 100, 800000),
('Regular bus', 101, 300, 1200000),
('Regular bus', 301, 500, 1600000),
('Mini bus', 0, 100, 500000),
('Mini bus', 101, 300, 800000),
('Mini bus', 301, 500, 1200000);


-- Tạo stored procedure để tính giá vé theo loại xe, khoảng cách và độ tuổi của khách hàng
-- Create stored procedure to calculate ticket price based on bus type, distance, and customer age
CREATE PROCEDURE CalculateTicketPrice
	@bus_type NVARCHAR(50),
	@distance FLOAT,
	@age INT,
	@price FLOAT OUTPUT
AS
BEGIN
	DECLARE @base_price FLOAT;
SELECT @base_price = price FROM TicketPrices
WHERE bus_type = @bus_type AND @distance BETWEEN distance_from AND distance_to;
IF @age <= 5
    SET @price = 0;
ELSE IF @age BETWEEN 5 AND 12
    SET @price = @base_price * 0.5;
ELSE IF 
	@age BETWEEN  60 AND 120
SET @price = @base_price * 0.8;
ELSE
	SET @price = @base_price;
END;

-- Tạo view để xem thông tin đặt vé
-- Create view to display booking information
CREATE VIEW BookingInformation AS
SELECT
	t.id AS ticket_id,
	c.name AS customer_name,
	c.age AS customer_age,
	r.departure AS departure,
	r.destination AS destination,
	s.departure_time AS departure_time,
	s.arrival_time AS arrival_time,
	t.price AS ticket_price
FROM Tickets t
JOIN Customers c ON t.customer_id = c.id
JOIN Schedule s ON t.schedule_id = s.id
JOIN Routes r ON s.route_id = r.id;

-- Tạo stored procedure để đặt vé
-- Create stored procedure to book a ticket
CREATE PROCEDURE BookTicket
	@customer_name NVARCHAR(255),
	@customer_age INT,
	@contact NVARCHAR(255),
	@schedule_id INT,
	@seat_number INT
AS
BEGIN
DECLARE @customer_id INT, @bus_type NVARCHAR(50), @distance FLOAT, @price FLOAT;
-- Thêm thông tin khách hàng và lấy id của khách hàng mới
-- Insert customer information and get the id of the new customer
INSERT INTO Customers (name, age, contact) VALUES (@customer_name, @customer_age, @contact);
SET @customer_id = SCOPE_IDENTITY();

-- Lấy thông tin loại xe và khoảng cách từ lịch trình
-- Get bus type and distance information from the schedule
SELECT @bus_type = b.bus_type, @distance = r.distance
FROM Schedule s
JOIN Buses b ON s.bus_id = b.id
JOIN Routes r ON s.route_id = r.id
WHERE s.id = @schedule_id;

-- Tính giá vé
-- Calculate ticket price
EXEC CalculateTicketPrice @bus_type, @distance, @customer_age, @price OUTPUT;

-- Thêm thông tin vé
-- Insert ticket information
INSERT INTO Tickets (customer_id, schedule_id, seat_number, price, booking_date, status)
VALUES (@customer_id, @schedule_id, @seat_number, @price, GETDATE(), 'booked');
END;

-- Tạo stored procedure để hủy vé và hoàn tiền
-- Create stored procedure to cancel ticket and refund
CREATE PROCEDURE CancelTicket
@ticket_id INT
AS
BEGIN
DECLARE @booking_date DATETIME, @cancel_date DATETIME, @price FLOAT, @refund FLOAT;

-- Lấy thông tin ngày đặt vé và giá vé
-- Get booking date and ticket price information
SELECT @booking_date = booking_date, @price = price FROM Tickets WHERE id = @ticket_id;

SET @cancel_date = GETDATE();

-- Tính hoàn tiền
-- Calculate refund
IF DATEDIFF(DAY, @booking_date, @cancel_date) >= 2
    SET @refund = @price;
ELSE IF DATEDIFF(DAY, @booking_date, @cancel_date) = 1
    SET @refund = @price * 0.85;
ELSE
    SET @refund = @price * 0.7;

-- Cập nhật trạng thái vé và hoàn tiền
-- Update ticket status and refund
UPDATE Tickets
SET status = 'cancelled', price = @refund
WHERE id = @ticket_id;
END;
