-- Bảng users (người dùng)
CREATE TABLE users (
	user_id INT PRIMARY KEY IDENTITY,
	username NVARCHAR(50) UNIQUE NOT NULL,
	password_hash NVARCHAR(255) NOT NULL, -- Mã hóa mật khẩu
	email NVARCHAR(100) UNIQUE NOT NULL,
	first_name NVARCHAR(50) NOT NULL,
	last_name NVARCHAR(50) NOT NULL,
	date_of_birth DATE NOT NULL,
	address NVARCHAR(255) NOT NULL,
	phone_number NVARCHAR(15) NOT NULL,
	join_date DATE NOT NULL
);
INSERT INTO users (username, password_hash, email, first_name, last_name, date_of_birth, address, phone_number, join_date) VALUES
('nguyenvana', HASHBYTES('SHA2_256', 'password1'), 'nguyenvana@example.com', N'Nguyễn', N'Văn A', '1990-01-01', N'123 Đường A', '0987654321', GETDATE()),
('lethib', HASHBYTES('SHA2_256', 'password2'), 'lethib@example.com', N'Lê', N'Thi B', '1991-02-02', N'234 Đường B', '0976543210', GETDATE()),
('tranvanc', HASHBYTES('SHA2_256', 'password3'), 'tranvanc@example.com', N'Trần', N'Văn C', '1992-03-03', N'345 Đường C', '0965432109', GETDATE()),
('phamthid', HASHBYTES('SHA2_256', 'password4'), 'phamthid@example.com', N'Phạm', N'Thi D', '1993-04-04', N'456 Đường D', '0954321098', GETDATE()),
('vuthie', HASHBYTES('SHA2_256', 'password5'), 'vuthie@example.com', N'Vũ', N'Thi E', '1994-05-05', N'567 Đường E', '0943210987', GETDATE()),
('nguyenvanf', HASHBYTES('SHA2_256', 'password6'), 'nguyenvanf@example.com', N'Nguyễn', N'Văn F', '1995-06-06', N'678 Đường F', '0932109876', GETDATE()),
('lethig', HASHBYTES('SHA2_256', 'password7'), 'lethig@example.com', N'Lê', N'Thi G', '1996-07-07', N'789 Đường G', '0921098765', GETDATE()),
('tranvanh', HASHBYTES('SHA2_256', 'password8'), 'tranvanh@example.com', N'Trần', N'Văn H', '1997-08-08', N'890 Đường H', '0910987654', GETDATE()),
('phamthii', HASHBYTES('SHA2_256', 'password9'), 'phamthii@example.com', N'Phạm', N'Thi I', '1998-09-09', N'901 Đường I', '0909876543', GETDATE()),
('vuthij', HASHBYTES('SHA2_256', 'password10'), 'vuthij@example.com', N'Vũ', N'Thi J', '1999-10-10', N'012 Đường J', '0898765432', GETDATE());

-- Bảng insurance_types (loại bảo hiểm)
CREATE TABLE insurance_types (
	insurance_type_id INT PRIMARY KEY IDENTITY,
	name NVARCHAR(100) NOT NULL,
	description NVARCHAR(1000) NOT NULL
);

INSERT INTO insurance_types (name, description) VALUES
(N'Bảo hiểm nhân thọ', 'Bảo hiểm nhân thọ là loại hình bảo hiểm giúp người được bảo hiểm và gia đình có bảo vệ tài chính trong trường hợp xảy ra tai nạn hoặc tử vong.'),
(N'Bảo hiểm y tế', 'Bảo hiểm y tế là loại hình bảo hiểm chi trả chi phí y tế cho người được bảo hiểm khi họ cần điều trị bệnh hoặc tai nạn.'),
(N'Bảo hiểm xe cộ', 'Bảo hiểm xe cộ là loại hình bảo hiểm bảo vệ chủ xe và phương tiện của họ trong trường hợp xảy ra tai nạn giao thông.'),
(N'Bảo hiểm nhà', 'Bảo hiểm nhà là loại hình bảo hiểm cung cấp bồi thường cho chủ nhà trong trường hợp xảy ra thiệt hại do các rủi ro như hỏa hoạn, lụt lội, động đất.');

--Thêm dữ liệu vào bảng insurance_types, tên bằng tiếng việt có dấu

-- Bảng insurance_plans (kế hoạch bảo hiểm)
CREATE TABLE insurance_plans (
	plan_id INT PRIMARY KEY IDENTITY,
	insurance_type_id INT NOT NULL,
	name NVARCHAR(100) NOT NULL,
	premium DECIMAL(18,2) NOT NULL,
	coverage DECIMAL(18,2) NOT NULL,
	term INT NOT NULL, -- Thời hạn bảo hiểm (số ngày)
	FOREIGN KEY (insurance_type_id) REFERENCES insurance_types(insurance_type_id)
);
--Thêm 50 records vào bảng insurance_plans, tên bằng tiếng việt có dấu
INSERT INTO insurance_plans (insurance_type_id, name, description, premium, coverage_amount, term) VALUES
(1, N'Bảo hiểm nhân thọ A1', N'Mô tả về gói bảo hiểm nhân thọ A1', 500, 100000, 365),
(1, N'Bảo hiểm nhân thọ A2', N'Mô tả về gói bảo hiểm nhân thọ A2', 550, 110000, 365),
(1, N'Bảo hiểm nhân thọ A3', N'Mô tả về gói bảo hiểm nhân thọ A3', 600, 120000, 365),
(2, N'Bảo hiểm y tế B1', N'Mô tả về gói bảo hiểm y tế B1', 400, 80000, 365),
(2, N'Bảo hiểm y tế B2', N'Mô tả về gói bảo hiểm y tế B2', 450, 90000, 365),
(2, N'Bảo hiểm y tế B3', N'Mô tả về gói bảo hiểm y tế B3', 500, 100000, 365),
(3, N'Bảo hiểm xe cộ C1', N'Mô tả về gói bảo hiểm xe cộ C1', 300, 60000, 365),
(3, N'Bảo hiểm xe cộ C2', N'Mô tả về gói bảo hiểm xe cộ C2', 350, 70000, 365),
(3, N'Bảo hiểm xe cộ C3', N'Mô tả về gói bảo hiểm xe cộ C3', 400, 80000, 365),
(4, N'Bảo hiểm nhà D1', N'Mô tả về gói bảo hiểm nhà D1', 200, 40000, 365);


-- Bảng user_plans (kế hoạch của người dùng)
CREATE TABLE user_plans (
	user_plan_id INT PRIMARY KEY IDENTITY,
	user_id INT NOT NULL,
	plan_id INT NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (plan_id) REFERENCES insurance_plans(plan_id)
);
--Thêm 50 records vào bảng user_plans, tên bằng tiếng việt có dấu

INSERT INTO user_plans (user_id, insurance_plan_id, start_date, end_date, status) VALUES
(1, 1, '2023-01-01', '2024-01-01', 'active'),
(2, 2, '2023-01-15', '2024-01-15', 'active'),
(3, 3, '2023-02-01', '2024-02-01', 'active'),
(4, 4, '2023-02-15', '2024-02-15', 'active'),
(5, 5, '2023-03-01', '2024-03-01', 'active'),
(6, 6, '2023-03-15', '2024-03-15', 'active'),
(7, 7, '2023-04-01', '2024-04-01', 'active'),
(8, 8, '2023-04-15', '2024-04-15', 'active'),
(9, 9, '2023-05-01', '2024-05-01', 'active'),
(10, 10, '2023-05-15', '2024-05-15', 'active');
/*
Giả sử khách hàng mua bảo hiểm xe cộ, công ty bảo hiểm yêu cầu phải có số đăng ký xe.
Khách hàng mua bảo hiểm y tế, công ty bảo hiểm yêu cầu có căn cước công dân của người mua bảo hiểm. 
Cơ sở dữ liệu cần thiết kế như thế nào để thỏa mãn yêu cầu đó
*/
-- Bảng loans (khoản vay)
CREATE TABLE loans (
	loan_id INT PRIMARY KEY IDENTITY,
	user_plan_id INT NOT NULL,
	amount DECIMAL(18,2) NOT NULL,
	interest_rate DECIMAL(5,2) NOT NULL,
	term INT NOT NULL, -- Thời hạn vay (số ngày)
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	FOREIGN KEY (user_plan_id) REFERENCES user_plans(user_plan_id)
);

CREATE TABLE user_plan_details (
    id INT PRIMARY KEY IDENTITY(1,1),
    user_plan_id INT NOT NULL,
    insurance_type_id INT NOT NULL,
    vehicle_registration_number NVARCHAR(50) NULL,
    personal_id_number NVARCHAR(20) NULL,
    FOREIGN KEY (user_plan_id) REFERENCES user_plans(id),
    FOREIGN KEY (insurance_type_id) REFERENCES insurance_types(id)
);
INSERT INTO user_plan_details (user_plan_id, insurance_type_id, vehicle_registration_number, personal_id_number) VALUES
(1, 3, N'51A-123.45', NULL),
(2, 3, N'51B-678.90', NULL),
(3, 3, N'51C-111.22', NULL),
(4, 3, N'51D-333.44', NULL),
(5, 3, N'51E-555.66', NULL),
(6, 2, NULL, N'012345678901'),
(7, 2, NULL, N'012345678902'),
(8, 2, NULL, N'012345678903'),
(9, 2, NULL, N'012345678904'),
(10, 2, NULL, N'012345678905');

--Thêm 50 records vào bảng user_plan_details, tên bằng tiếng việt có dấu
-- Bảng payments (thanh toán)
CREATE TABLE payments (
	payment_id INT PRIMARY KEY IDENTITY,
	user_plan_id INT NOT NULL,
	amount DECIMAL(18,2) NOT NULL,
	payment_date DATE NOT NULL,
	FOREIGN KEY (user_plan_id) REFERENCES user_plans(user_plan_id)
);

Viết các view, procedures cần có cho ứng dụng này

CREATE VIEW user_insurance_details AS
SELECT u.id AS user_id, u.full_name, u.email, up.id AS user_plan_id, up.start_date, up.end_date, up.status, it.name AS insurance_type, ip.name AS insurance_plan, ip.premium, ip.coverage_amount
FROM users u
JOIN user_plans up ON u.id = up.user_id
JOIN insurance_plans ip ON up.insurance_plan_id = ip.id
JOIN insurance_types it ON ip.insurance_type_id = it.id;

CREATE TABLE advisors (
    id INT PRIMARY KEY IDENTITY(1,1),
    full_name NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) UNIQUE NOT NULL,
    phone_number NVARCHAR(20)
);

ALTER TABLE users
ADD advisor_id INT FOREIGN KEY REFERENCES advisors(id);

CREATE PROCEDURE create_advisor
    @FullName NVARCHAR(255),
    @Email NVARCHAR(255),
    @PhoneNumber NVARCHAR(20),
    @Result NVARCHAR(MAX) OUTPUT
AS
BEGIN
    IF EXISTS(SELECT 1 FROM advisors WHERE email = @Email)
    BEGIN
        SET @Result = N'Địa chỉ email đã được sử dụng!'
    END
    ELSE
    BEGIN
        INSERT INTO advisors (full_name, email, phone_number) VALUES (@FullName, @Email, @PhoneNumber)
        SET @Result = N'Thêm mới nhân viên tư vấn bảo hiểm thành công!'
    END
END

CREATE PROCEDURE assign_customer_to_advisor
    @UserId INT,
    @AdvisorId INT,
    @Result NVARCHAR(MAX) OUTPUT
AS
BEGIN
    IF EXISTS(SELECT 1 FROM users WHERE id = @UserId) AND EXISTS(SELECT 1 FROM advisors WHERE id = @AdvisorId)
    BEGIN
        UPDATE users
        SET advisor_id = @AdvisorId
        WHERE id = @UserId
        SET @Result = N'Gán khách hàng cho nhân viên tư vấn bảo hiểm thành công!'
    END
    ELSE
    BEGIN
        SET @Result = N'Khách hàng hoặc nhân viên tư vấn bảo hiểm không tồn tại!'
    END
END


CREATE PROCEDURE login
    @Email NVARCHAR(255),
    @Password NVARCHAR(255),
    @Result NVARCHAR(MAX) OUTPUT
AS
BEGIN
    DECLARE @hashed_password NVARCHAR(255)

    SELECT @hashed_password = password_hash FROM users WHERE email = @Email

    IF EXISTS(SELECT 1 FROM users WHERE email = @Email AND password_hash = HASHBYTES('SHA2_256', @Password))
    BEGIN
        SET @Result = N'Đăng nhập thành công!'
    END
    ELSE
    BEGIN
        SET @Result = N'Sai tên đăng nhập hoặc mật khẩu!'
    END
END

CREATE PROCEDURE register_user
    @FullName NVARCHAR(255),
    @Email NVARCHAR(255),
    @Password NVARCHAR(255),
    @Result NVARCHAR(MAX) OUTPUT
AS
BEGIN
    IF EXISTS(SELECT 1 FROM users WHERE email = @Email)
    BEGIN
        SET @Result = N'Địa chỉ email đã được sử dụng!'
    END
    ELSE
    BEGIN
        INSERT INTO users (full_name, email, password_hash) VALUES (@FullName, @Email, HASHBYTES('SHA2_256', @Password))
        SET @Result = N'Đăng ký thành công!'
    END
END

CREATE PROCEDURE purchase_insurance_plan
    @UserId INT,
    @InsurancePlanId INT,
    @StartDate DATE,
    @EndDate DATE,
    @Status NVARCHAR(50),
    @Result NVARCHAR(MAX) OUTPUT
AS
BEGIN
    IF EXISTS(SELECT 1 FROM insurance_plans WHERE id = @InsurancePlanId)
    BEGIN
        INSERT INTO user_plans (user_id, insurance_plan_id, start_date, end_date, status) VALUES (@UserId, @InsurancePlanId, @StartDate, @EndDate, @Status)
        SET @Result = N'Mua/gia hạn gói bảo hiểm thành công!'
    END
    ELSE
    BEGIN
        SET @Result = N'Gói bảo hiểm không tồn tại!'
    END
END

CREATE PROCEDURE get_insurance_plan_details
    @InsurancePlanId INT,
    @InsurancePlanDetails NVARCHAR(MAX) OUTPUT
AS
BEGIN
    SELECT @InsurancePlanDetails = (
        SELECT id, name, description, premium, coverage_amount, insurance_type_id
        FROM insurance_plans
        WHERE id = @InsurancePlanId
        FOR JSON PATH, WITHOUT_ARRAY_WRAPPER
    )
END


CREATE PROCEDURE get_insurance_plans_by_type
    @InsuranceTypeId INT,
    @InsurancePlans NVARCHAR(MAX) OUTPUT
AS
BEGIN
    SELECT @InsurancePlans = (
        SELECT id, name, description, premium, coverage_amount, insurance_type_id
        FROM insurance_plans
        WHERE insurance_type_id = @InsuranceTypeId
        FOR JSON PATH
    )
END

CREATE PROCEDURE get_insurance_plan_details
    @InsurancePlanId INT,
    @InsurancePlanDetails NVARCHAR(MAX) OUTPUT
AS
BEGIN
    SELECT @InsurancePlanDetails = (
        SELECT id, name, description, premium, coverage_amount, insurance_type_id
        FROM insurance_plans
        WHERE id = @InsurancePlanId
        FOR JSON PATH, WITHOUT_ARRAY_WRAPPER
    )
END

CREATE PROCEDURE get_user_insurance_plans
    @UserId INT,
    @UserInsurancePlans NVARCHAR(MAX) OUTPUT
AS
BEGIN
    SELECT @UserInsurancePlans = (
        SELECT up.id, up.start_date, up.end_date, up.status, ip.name, ip.description, ip.premium, ip.coverage_amount, it.name AS insurance_type
        FROM user_plans up
        JOIN insurance_plans ip ON up.insurance_plan_id = ip.id
        JOIN insurance_types it ON ip.insurance_type_id = it.id
        WHERE up.user_id = @UserId
        FOR JSON PATH
    )
END

CREATE PROCEDURE update_user_info
    @UserId INT,
    @FullName NVARCHAR(255),
    @Email NVARCHAR(255),
    @Result NVARCHAR(MAX) OUTPUT
AS
BEGIN
    IF EXISTS(SELECT 1 FROM users WHERE id = @UserId)
    BEGIN
        UPDATE users
        SET full_name = @FullName, email = @Email
        WHERE id = @UserId
        SET @Result = N'Cập nhật thông tin cá nhân thành công!'
    END
    ELSE
    BEGIN
        SET @Result = N'Người dùng không tồn tại!'
    END
END



CREATE PROCEDURE get_insurance_plans_by_type
    @InsuranceTypeId INT,
    @InsurancePlans NVARCHAR(MAX) OUTPUT
AS
BEGIN
    SELECT @InsurancePlans = (
        SELECT id, name, description, premium, coverage_amount, insurance_type_id
        FROM insurance_plans
        WHERE insurance_type_id = @InsuranceTypeId
        FOR JSON PATH
    )
END


advisors có quyền đăng nhập vào hệ thống và quan sát khách hàng của mình