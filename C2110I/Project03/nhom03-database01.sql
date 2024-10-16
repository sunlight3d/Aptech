CREATE TABLE Admin (
	user_id INT PRIMARY KEY IDENTITY(1,1),
	email NVARCHAR(50) NOT NULL,
	hashed_password NVARCHAR(200) NOT NULL
);
INSERT INTO Admin (email, hashed_password, salt)
VALUES ('admin1@example.com', CAST(HASHBYTES('SHA2_256', CONCAT('password123', 'mysalt1')) as nvarchar(128)), 'mysalt1');

INSERT INTO Admin (email, hashed_password, salt)
VALUES ('admin2@example.com', CAST(HASHBYTES('SHA2_256', CONCAT('password123', 'mysalt2')) as nvarchar(128)), 'mysalt2');

INSERT INTO Admin (email, hashed_password, salt)
VALUES ('admin3@example.com', CAST(HASHBYTES('SHA2_256', CONCAT('password123', 'mysalt3')) as nvarchar(128)), 'mysalt3');

INSERT INTO Admin (email, hashed_password, salt)
VALUES ('admin4@example.com', CAST(HASHBYTES('SHA2_256', CONCAT('password123', 'mysalt4')) as nvarchar(128)), 'mysalt4');

INSERT INTO Admin (email, hashed_password, salt)
VALUES ('admin5@example.com', CAST(HASHBYTES('SHA2_256', CONCAT('password123', 'mysalt5')) as nvarchar(128)), 'mysalt5');

CREATE TABLE Customer (
	customer_id INT PRIMARY KEY IDENTITY(1,1),
	customer_name NVARCHAR(100) NOT NULL,
	customer_phone NVARCHAR(20) NOT NULL,
	customer_address NVARCHAR(200) NOT NULL
);

INSERT INTO Customer (customer_name, customer_phone, customer_address, customer_email, customer_dob, customer_gender, customer_notes)
VALUES ('Nguyễn Văn A', '0123456789', '123 Đường số 1, Quận 2, TP. HCM', 'nguyenvana@gmail.com', '1990-01-01', 'Nam', 'Khách hàng VIP');

INSERT INTO Customer (customer_name, customer_phone, customer_address, customer_email, customer_dob, customer_gender, customer_notes)
VALUES ('Trần Thị B', '0987654321', '456 Đường số 2, Quận 1, TP. HCM', 'tranthib@gmail.com', '1995-05-05', 'Nữ', 'Khách hàng thân thiết');


CREATE TABLE Invoice (
	invoice_id INT PRIMARY KEY IDENTITY(1,1),
	customer_id INT NOT NULL,
	invoice_date DATE NOT NULL,
	invoice_type NVARCHAR(50) NOT NULL,
	invoice_status NVARCHAR(50) NOT NULL,
	total_amount DECIMAL(18,2) NOT NULL,
	CONSTRAINT FK_Invoice_Customer FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);
INSERT INTO Invoice (customer_id, invoice_date, invoice_type, invoice_status, total_amount)
VALUES (1, '2022-04-10', N'Hóa đơn theo số lượng', N'Đã thanh toán', 500000.00);

INSERT INTO Invoice (customer_id, invoice_date, invoice_type, invoice_status, total_amount)
VALUES (2, '2022-04-11', N'Hóa đơn theo cân nặng', N'Chưa thanh toán', 800000.00);

INSERT INTO Invoice (customer_id, invoice_date, invoice_type, invoice_status, total_amount)
VALUES (3, '2022-04-12', N'Hóa đơn theo gói dịch vụ', N'Đã thanh toán', 1500000.00);

INSERT INTO Invoice (customer_id, invoice_date, invoice_type, invoice_status, total_amount)
VALUES (4, '2022-04-13', N'Hóa đơn theo số lượng', N'Đã thanh toán', 300000.00);

INSERT INTO Invoice (customer_id, invoice_date, invoice_type, invoice_status, total_amount)
VALUES (5, '2022-04-14', N'Hóa đơn theo cân nặng', N'Chưa thanh toán', 1200000.00);


--Bảng Sản phẩm trong hoá đơn (Invoice_Item)
CREATE TABLE Invoice_Item (
	invoice_item_id INT PRIMARY KEY IDENTITY(1,1),
	invoice_id INT NOT NULL,
	item_name NVARCHAR(100) NOT NULL,
	item_quantity INT NOT NULL,
	item_price DECIMAL(18,2) NOT NULL,
	CONSTRAINT FK_Invoice_Item_Invoice FOREIGN KEY (invoice_id) REFERENCES Invoice(invoice_id)
);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (1, N'Áo phông', 3, 150000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (1, N'Quần jean', 2, 250000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (2, N'Áo sơ mi', 4, 200000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (2, N'Quần âu', 1, 500000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (3, N'Gói dịch vụ A', 1, 1500000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (4, N'Áo thun', 5, 60000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (4, N'Quần bò', 2, 350000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (5, N'Áo khoác', 1, 800000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (5, N'Quần tây', 3, 300000.00);

-- Thêm 41 bản ghi dữ liệu tiếng Việt khác
INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (6, N'Áo phông', 2, 120000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (6, N'Quần đùi', 3, 80000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (7, N'Áo khoác', 1, 900000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (7, N'Quần tây', 2, 350000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (8, N'Áo thun', 3, 90000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (8, N'Quần bò', 1, 550000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (9, N'Gói dịch vụ B', 1, 2500000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (10, N'Áo len', 2, 300000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (10, N'Quần short', 3, 120000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (11, N'Áo khoác', 1, 700000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (11, N'Quần jean', 2, 350000.00);

INSERT INTO Invoice_Item (invoice_id, item_name, item_quantity, item_price)
VALUES (12, N'Áo thun', 4, 120000.00);


--Bảng Giao hàng (Delivery)
CREATE TABLE Delivery (
	delivery_id INT PRIMARY KEY IDENTITY(1,1),
	invoice_id INT NOT NULL,
	delivery_status NVARCHAR(50) NOT NULL,
	delivery_date DATE NOT NULL,
	CONSTRAINT FK_Delivery_Invoice FOREIGN KEY (invoice_id) REFERENCES Invoice(invoice_id)
);
INSERT INTO Delivery (invoice_id, delivery_status, delivery_date)
VALUES (1, N'Đã giao hàng', '2022-01-15');

INSERT INTO Delivery (invoice_id, delivery_status, delivery_date)
VALUES (2, N'Đã giao hàng', '2022-02-01');

INSERT INTO Delivery (invoice_id, delivery_status, delivery_date)
VALUES (3, N'Đang chuẩn bị giao', '2022-03-05');

INSERT INTO Delivery (invoice_id, delivery_status, delivery_date)
VALUES (4, N'Chờ giao hàng', '2022-04-10');

INSERT INTO Delivery (invoice_id, delivery_status, delivery_date)
VALUES (5, N'Đã giao hàng', '2022-05-20');

-- Thêm 45 bản ghi dữ liệu tiếng Việt khác
INSERT INTO Delivery (invoice_id, delivery_status, delivery_date)
VALUES (6, N'Đã giao hàng', '2022-06-08');

INSERT INTO Delivery (invoice_id, delivery_status, delivery_date)
VALUES (7, N'Chờ giao hàng', '2022-07-14');

INSERT INTO Delivery (invoice_id, delivery_status, delivery_date)
VALUES (8, N'Đang chuẩn bị giao', '2022-08-03');

INSERT INTO Delivery (invoice_id, delivery_status, delivery_date)
VALUES (9, N'Chờ giao hàng', '2022-09-22');

INSERT INTO Delivery (invoice_id, delivery_status, delivery_date)
VALUES (10, N'Đang chuẩn bị giao', '2022-10-11');

-- Các câu lệnh INSERT tiếp theo được lặp lại với các giá trị khác để tạo 50 bản ghi dữ liệu.

CREATE TABLE Employee (
	employee_id INT PRIMARY KEY IDENTITY(1,1),
	employee_name NVARCHAR(100) NOT NULL,
	employee_salary DECIMAL(18,2) NOT NULL
);

INSERT INTO Employee (employee_name, employee_salary)
VALUES (N'Trần Văn A', 12000000.00);

INSERT INTO Employee (employee_name, employee_salary)
VALUES (N'Nguyễn Thị B', 15000000.00);

INSERT INTO Employee (employee_name, employee_salary)
VALUES (N'Vũ Quang C', 9000000.00);

INSERT INTO Employee (employee_name, employee_salary)
VALUES (N'Lê Anh D', 8000000.00);

INSERT INTO Employee (employee_name, employee_salary)
VALUES (N'Phạm Minh E', 11000000.00);

-- Thêm 45 bản ghi dữ liệu tiếng Việt khác
INSERT INTO Employee (employee_name, employee_salary)
VALUES (N'Trần Thanh Hương', 13000000.00);

INSERT INTO Employee (employee_name, employee_salary)
VALUES (N'Nguyễn Văn Đức', 10000000.00);

INSERT INTO Employee (employee_name, employee_salary)
VALUES (N'Vũ Thị Hạnh', 11000000.00);

INSERT INTO Employee (employee_name, employee_salary)
VALUES (N'Lê Văn Khánh', 9000000.00);

INSERT INTO Employee (employee_name, employee_salary)
VALUES (N'Phạm Thanh Tuấn', 8000000.00);

-- Các câu lệnh INSERT tiếp theo được lặp lại với các giá trị khác để tạo 50 bản ghi dữ liệu.


CREATE TABLE Report (
	report_id INT PRIMARY KEY IDENTITY(1,1),
	report_type NVARCHAR(100) NOT NULL,
	report_date DATE NOT NULL,
	report_content NVARCHAR(MAX) NOT NULL
);

INSERT INTO Report (report_type, report_date, report_content)
VALUES (N'Báo cáo tổng hợp', '2022-01-15', N'Tổng hợp doanh thu trong tháng 1');

INSERT INTO Report (report_type, report_date, report_content)
VALUES (N'Báo cáo chi tiết', '2022-02-01', N'Báo cáo chi tiết khách hàng trong tháng 2');

INSERT INTO Report (report_type, report_date, report_content)
VALUES (N'Báo cáo tổng hợp', '2022-03-05', N'Tổng hợp doanh thu trong quý 1');

INSERT INTO Report (report_type, report_date, report_content)
VALUES (N'Báo cáo chi tiết', '2022-04-10', N'Báo cáo chi tiết khách hàng trong tháng 4');

INSERT INTO Report (report_type, report_date, report_content)
VALUES (N'Báo cáo tổng hợp', '2022-05-20', N'Tổng hợp doanh thu trong năm 2022');

-- Thêm 45 bản ghi dữ liệu tiếng Việt khác
INSERT INTO Report (report_type, report_date, report_content)
VALUES (N'Báo cáo chi tiết', '2022-06-08', N'Báo cáo chi tiết khách hàng trong tháng 6');

INSERT INTO Report (report_type, report_date, report_content)
VALUES (N'Báo cáo tổng hợp', '2022-07-14', N'Tổng hợp doanh thu trong năm 2022');

INSERT INTO Report (report_type, report_date, report_content)
VALUES (N'Báo cáo chi tiết', '2022-08-03', N'Báo cáo chi tiết khách hàng trong tháng 8');

INSERT INTO Report (report_type, report_date, report_content)
VALUES (N'Báo cáo tổng hợp', '2022-09-22', N'Tổng hợp doanh thu trong quý 3');

INSERT INTO Report (report_type, report_date, report_content)
VALUES (N'Báo cáo chi tiết', '2022-10-11', N'Báo cáo chi tiết khách hàng trong tháng 10');


Stored procedure: SP_GetCustomerInvoice

Mô tả: Truy vấn thông tin hóa đơn của khách hàng dựa trên id khách hàng.
Tham số đầu vào: @customer_id INT
Tham số đầu ra: Danh sách các hóa đơn của khách hàng.
Câu lệnh SQL:
CREATE PROCEDURE SP_GetCustomerInvoice
@customer_id INT
AS
SELECT * FROM Invoice
WHERE customer_id = @customer_id


Function: FN_CalculateInvoiceAmount

Mô tả: Tính toán tổng giá trị của một hóa đơn dựa trên thông tin chi tiết của các mặt hàng trong hóa đơn.
Tham số đầu vào: @invoice_id INT
Tham số đầu ra: Tổng giá trị của hóa đơn.
Câu lệnh SQL:
CREATE FUNCTION FN_CalculateInvoiceAmount
(
    @invoice_id INT
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    DECLARE @total_amount DECIMAL(18,2)
    SELECT @total_amount = SUM(item_quantity * item_price) 
    FROM Invoice_Item
    WHERE invoice_id = @invoice_id
    RETURN @total_amount
END

View: V_CustomerInvoice

Mô tả: Liệt kê thông tin hóa đơn của khách hàng bao gồm thông tin khách hàng, chi tiết hóa đơn và tổng giá trị của hóa đơn.
Câu lệnh SQL:

CREATE VIEW V_CustomerInvoice AS
SELECT c.customer_id, c.customer_name, c.customer_phone, i.invoice_id, i.invoice_date, i.invoice_type, 
       ii.item_name, ii.item_quantity, ii.item_price, dbo.FN_CalculateInvoiceAmount(i.invoice_id) AS total_amount
FROM Customer c
INNER JOIN Invoice i ON c.customer_id = i.customer_id
INNER JOIN Invoice_Item ii ON i.invoice_id = ii.invoice_id

Stored procedure: SP_UpdateDeliveryStatus

Mô tả: Cập nhật trạng thái giao hàng của hóa đơn và trả về tổng số hóa đơn đã được cập nhật.
Tham số đầu vào: @invoice_id INT, @delivery_status NVARCHAR(50)
Tham số đầu ra: Số lượng hóa đơn đã được cập nhật trạng thái.
Câu lệnh SQL:
CREATE PROCEDURE SP_UpdateDeliveryStatus
@invoice_id INT,
@delivery_status NVARCHAR(50)
AS
BEGIN
    UPDATE Delivery
    SET delivery_status = @delivery_status
    WHERE invoice_id = @invoice_id
    SELECT COUNT(*) FROM Delivery WHERE delivery_status = @delivery_status
END

Function: FN_GetTotalCollection

Mô tả: Tính tổng doanh thu từ hóa đơn đã được thanh toán trong một ngày
View: V_InvoiceSummary
Mô tả: Liệt kê tổng hợp các hóa đơn đã được tạo ra trong một khoảng thời gian nhất định.
Tham số đầu vào: @start_date DATE, @end_date DATE
Câu lệnh SQL:
CREATE VIEW V_InvoiceSummary AS
SELECT invoice_type, COUNT(*) AS total_invoices, SUM(total_amount) AS total_amount
FROM Invoice
WHERE invoice_date >= @start_date AND invoice_date <= @end_date
GROUP BY invoice_type

Stored procedure: SP_GetUnpaidInvoices

Mô tả: Truy vấn các hóa đơn chưa thanh toán của một khách hàng cụ thể.
Tham số đầu vào: @customer_id INT
Tham số đầu ra: Danh sách các hóa đơn chưa thanh toán.
Câu lệnh SQL:
CREATE PROCEDURE SP_GetUnpaidInvoices
@customer_id INT
AS
SELECT *
FROM Invoice
WHERE customer_id = @customer_id AND invoice_status = 'Unpaid'


Function: FN_GetTotalCollectionByDateRange

Mô tả: Tính tổng doanh thu từ hóa đơn đã được thanh toán trong một khoảng thời gian nhất định.
Tham số đầu vào: @start_date DATE, @end_date DATE
Tham số đầu ra: Tổng doanh thu trong khoảng thời gian đó.
Câu lệnh SQL:
CREATE FUNCTION FN_GetTotalCollectionByDateRange
(
    @start_date DATE,
    @end_date DATE
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    DECLARE @total_collection DECIMAL(18,2)
    SELECT @total_collection = SUM(total_amount)
    FROM Invoice
    WHERE invoice_date >= @start_date AND invoice_date <= @end_date AND invoice_status = 'Paid'
    RETURN @total_collection
END


View: V_GarmentCollection

Mô tả: Liệt kê tổng doanh thu của các loại quần áo trong một khoảng thời gian nhất định.
Tham số đầu vào: @start_date DATE, @end_date DATE
Câu lệnh SQL:

CREATE VIEW V_GarmentCollection AS
SELECT ii.item_name, SUM(ii.item_price * ii.item_quantity) AS total_amount
FROM Invoice i
INNER JOIN Invoice_Item ii ON i.invoice_id = ii.invoice_id
WHERE i.invoice_date >= @start_date AND i.invoice_date <= @end_date AND i.invoice_status = 'Paid'
GROUP BY ii.item_name

Function: FN_GetInvoiceTotal
Mô tả: Tính tổng số tiền của một hóa đơn.
Tham số đầu vào: @invoice_id INT
Tham số đầu ra: Tổng số tiền của hóa đơn.
Câu lệnh SQL:


CREATE FUNCTION FN_GetInvoiceTotal
(
    @invoice_id INT
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    DECLARE @total DECIMAL(18,2)
    SELECT @total = SUM(item_price * item_quantity)
    FROM Invoice_Item
    WHERE invoice_id = @invoice_id
    RETURN @total
END

View: V_CustomerDuePayment
Mô tả: Liệt kê các khách hàng chưa thanh toán hết số tiền nợ.
Tham số đầu vào: Không có.
Câu lệnh SQL:
CREATE VIEW V_CustomerDuePayment AS
SELECT c.customer_id, c.customer_name, SUM(i.total_amount) AS due_payment
FROM Customer c
INNER JOIN Invoice i ON c.customer_id = i.customer_id
WHERE i.invoice_status = 'Unpaid'
GROUP BY c.customer_id, c.customer_name

Stored procedure: SP_GetDeliveryStatus
Mô tả: Truy vấn trạng thái của lô hàng đã giao cho một khách hàng cụ thể.
Tham số đầu vào: @customer_id INT
Tham số đầu ra: Danh sách các lô hàng đã giao và trạng thái của chúng.
Câu lệnh SQL:
CREATE PROCEDURE SP_GetDeliveryStatus
(
    @customer_id INT
)
AS
BEGIN
    SELECT d.delivery_id, d.delivery_status, d.delivery_date
    FROM Delivery d
    INNER JOIN Invoice i ON d.invoice_id = i.invoice_id
    WHERE i.customer_id = @customer_id
END






