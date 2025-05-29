drop DATABASE dormitory_management;

CREATE DATABASE IF NOT EXISTS dormitory_management
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

USE dormitory_management;

CREATE TABLE rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY, -- Mã phòng (khóa chính)
    room_number VARCHAR(10) NOT NULL,       -- Số hiệu phòng
    capacity INT NOT NULL,                  -- Sức chứa tối đa của phòng
    current_occupancy INT DEFAULT 0,        -- Số sinh viên hiện tại đang ở
    gender ENUM('male', 'female') NOT NULL, -- Phân loại phòng theo giới tính
    status ENUM('available', 'full') DEFAULT 'available' -- Trạng thái phòng
);

CREATE TABLE room_prices (
    price_id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT NOT NULL,                      -- Phòng áp dụng
    price_per_student DECIMAL(10,2) NOT NULL,  -- Giá mỗi sinh viên phải trả
    effective_from DATE NOT NULL,              -- Áp dụng từ ngày
    effective_to DATE DEFAULT NULL,            -- Kết thúc (nếu có)
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);


CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY, -- Mã sinh viên (khóa chính)
    full_name VARCHAR(100) NOT NULL,           -- Họ tên
    gender ENUM('male', 'female') NOT NULL,    -- Giới tính
    date_of_birth DATE,                        -- Ngày sinh
    phone VARCHAR(20),                         -- Số điện thoại
    email VARCHAR(100),                        -- Email liên hệ
    department VARCHAR(100),                   -- Khoa đang học
    student_code VARCHAR(20) UNIQUE NOT NULL   -- Mã số sinh viên (duy nhất)
);

CREATE TABLE room_applications (
    application_id INT AUTO_INCREMENT PRIMARY KEY,    -- Mã đơn (khóa chính)
    student_id INT,                                   -- Sinh viên nộp đơn
    apply_date DATETIME DEFAULT CURRENT_TIMESTAMP,    -- Ngày nộp đơn
    status ENUM('pending', 'approved', 'rejected') DEFAULT 'pending', -- Trạng thái đơn
    room_id INT,                                      -- Phòng được phân (nếu có)
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);

CREATE TABLE contracts (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,     -- Mã hợp đồng
    student_id INT NOT NULL,                        -- Sinh viên thuê
    room_id INT NOT NULL,                           -- Phòng đang ở
    start_date DATE NOT NULL,                       -- Ngày bắt đầu ở
    end_date DATE,                                  -- Ngày kết thúc (nếu có)
    is_active BOOLEAN DEFAULT TRUE,                 -- Hợp đồng còn hiệu lực không
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);

CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,     -- Mã thanh toán
    contract_id INT NOT NULL,                      -- Thuộc hợp đồng nào
    amount DECIMAL(10, 2) NOT NULL,                -- Số tiền thanh toán
    due_date DATE,                                 -- Hạn thanh toán
    paid_date DATE,                                -- Ngày đã thanh toán
    status ENUM('unpaid', 'paid', 'late') DEFAULT 'unpaid', -- Trạng thái
    FOREIGN KEY (contract_id) REFERENCES contracts(contract_id)
);

CREATE TABLE announcements (
    announcement_id INT AUTO_INCREMENT PRIMARY KEY,   -- Mã thông báo
    title VARCHAR(200) NOT NULL,                      -- Tiêu đề
    content TEXT NOT NULL,                            -- Nội dung
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP     -- Thời gian gửi
);

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,              -- Mã người dùng
    username VARCHAR(50) NOT NULL UNIQUE,                -- Tên đăng nhập (duy nhất)
    password_hash VARCHAR(255) NOT NULL,                 -- Mật khẩu đã mã hóa (băm)
    full_name VARCHAR(100),                              -- Họ tên người dùng
    role ENUM('admin', 'manager', 'staff') DEFAULT 'staff', -- Vai trò
    is_active BOOLEAN DEFAULT TRUE                       -- Trạng thái hoạt động
);

INSERT INTO rooms (room_id, room_number, capacity, current_occupancy, gender, status) VALUES
(1, 'A101', 4, 2, 'male', 'available'),
(2, 'A102', 4, 4, 'male', 'full'),
(3, 'A103', 2, 1, 'male', 'available'),
(4, 'B101', 4, 0, 'female', 'available'),
(5, 'B102', 4, 4, 'female', 'full'),
(6, 'B103', 3, 1, 'female', 'available'),
(7, 'C201', 2, 2, 'male', 'full'),
(8, 'C202', 3, 3, 'female', 'full'),
(9, 'D301', 4, 3, 'male', 'available'),
(10, 'D302', 2, 0, 'female', 'available');


INSERT INTO room_prices (price_id, room_id, price_per_student, effective_from, effective_to) VALUES
(1, 1, 500000, '2025-01-01', '2025-06-30'),
(2, 1, 520000, '2025-07-01', NULL),

(3, 2, 500000, '2025-01-01', '2025-06-30'),
(4, 2, 530000, '2025-07-01', NULL),

(5, 3, 550000, '2025-06-01', NULL),

(6, 4, 600000, '2025-01-01', '2025-06-30'),
(7, 4, 620000, '2025-07-01', NULL),

(8, 5, 600000, '2025-06-01', NULL),

(9, 6, 580000, '2025-06-01', NULL),

(10, 7, 520000, '2025-01-01', '2025-06-30'),
(11, 7, 540000, '2025-07-01', NULL),

(12, 8, 610000, '2025-01-01', '2025-06-30'),
(13, 8, 630000, '2025-07-01', NULL),

(14, 9, 530000, '2025-06-01', NULL),

(15, 10, 590000, '2025-01-01', '2025-06-30'),
(16, 10, 600000, '2025-07-01', NULL),

(17, 3, 560000, '2025-10-01', NULL); -- phòng 3 được cập nhật lại giá lần 2

INSERT INTO students (student_id, full_name, gender, date_of_birth, phone, email, department, student_code) VALUES
(1, 'Nguyễn Nhật Ngọc', 'female', '2002-09-10', '0945099305', 'nguyennhatngoc@aptechlearning.edu.vn', 'AICP', 'SV001'),
(2, 'Đỗ Hữu Nam', 'male', '2005-08-11', '0946127133', 'dohuynam@aptechlearning.edu.vn', 'AICP', 'SV002'),
(3, 'Đỗ Anh Nhung', 'female', '2006-09-08', '0929319417', 'doanhnhung@aptechlearning.edu.vn', 'ADSE', 'SV003'),
(4, 'Nguyễn Anh Long', 'male', '2004-07-19', '0922552531', 'nguyenthanhlong@aptechlearning.edu.vn', 'AABB', 'SV004'),
(5, 'Đặng Hữu Lan', 'female', '2003-11-14', '0929620875', 'danghuulan@aptechlearning.edu.vn', 'AICP', 'SV005'),
(6, 'Trần Thanh Tùng', 'male', '2002-06-13', '0948246146', 'tranthanhtung@aptechlearning.edu.vn', 'ADSE', 'SV006'),
(7, 'Phạm Hữu Linh', 'female', '2002-09-19', '0944370691', 'phamhuulinh@aptechlearning.edu.vn', 'ADSE', 'SV007'),
(8, 'Vũ Anh Tùng', 'male', '2002-02-20', '0940542235', 'vuanhtung@aptechlearning.edu.vn', 'ADSE', 'SV008'),
(9, 'Đặng Anh Thảo', 'female', '2006-05-06', '0927895857', 'danganhthao@aptechlearning.edu.vn', 'AICP', 'SV009'),
(10, 'Đặng Thùy Phong', 'male', '2003-02-22', '0920490642', 'dangthuyphong@aptechlearning.edu.vn', 'AICP', 'SV010'),
(11, 'Trần Minh Nhung', 'female', '2002-07-16', '0946980640', 'tranminhnhung@aptechlearning.edu.vn', 'AABB', 'SV011'),
(12, 'Lê Thùy Hiếu', 'male', '2005-08-17', '0949581075', 'lethuyhieu@aptechlearning.edu.vn', 'AICP', 'SV012'),
(13, 'Trần Anh Hằng', 'female', '2005-10-21', '0940572134', 'tranhang@aptechlearning.edu.vn', 'ADSE', 'SV013'),
(14, 'Vũ Gia Phong', 'male', '2006-05-06', '0920235165', 'vugiaphong@aptechlearning.edu.vn', 'AICP', 'SV014'),
(15, 'Hoàng Anh Nhung', 'female', '2005-03-13', '0928126324', 'hoanganhnhung@aptechlearning.edu.vn', 'AICP', 'SV015'),
(16, 'Phạm Quốc Dũng', 'male', '2004-06-23', '0946572113', 'phamquocdung@aptechlearning.edu.vn', 'ADSE', 'SV016'),
(17, 'Nguyễn Văn Mai', 'female', '2005-06-08', '0910645181', 'nguyenvanmai@aptechlearning.edu.vn', 'ADSE', 'SV017'),
(18, 'Phạm Thanh Hiếu', 'male', '2003-02-03', '0943247945', 'phamthanhhieu@aptechlearning.edu.vn', 'AICP', 'SV018'),
(19, 'Lê Anh Lan', 'female', '2004-08-03', '0912154004', 'leanhlan@aptechlearning.edu.vn', 'ADSE', 'SV019'),
(20, 'Đỗ Minh Tùng', 'male', '2005-05-04', '0910841589', 'dominhtung@aptechlearning.edu.vn', 'AABB', 'SV020');


INSERT INTO room_applications (application_id, student_id, apply_date, status, room_id) VALUES
(1, 1, '2025-05-05', 'approved', 7),
(2, 2, '2025-04-09', 'pending', NULL),
(3, 3, '2025-02-19', 'rejected', NULL),
(4, 4, '2025-03-17', 'pending', NULL),
(5, 5, '2025-06-28', 'pending', NULL),
(6, 6, '2025-02-24', 'approved', 4),
(7, 7, '2025-04-10', 'approved', 3),
(8, 8, '2025-04-26', 'rejected', NULL),
(9, 9, '2025-06-26', 'rejected', NULL),
(10, 10, '2025-06-08', 'approved', 1),
(11, 11, '2025-03-07', 'approved', 5),
(12, 12, '2025-06-25', 'approved', 2),
(13, 13, '2025-04-26', 'approved', 8),
(14, 14, '2025-06-14', 'rejected', NULL),
(15, 15, '2025-03-11', 'rejected', NULL),
(16, 16, '2025-01-19', 'pending', NULL),
(17, 17, '2025-02-21', 'approved', 1),
(18, 18, '2025-02-16', 'pending', NULL),
(19, 19, '2025-06-02', 'rejected', NULL),
(20, 20, '2025-06-06', 'pending', NULL);


INSERT INTO contracts (contract_id, student_id, room_id, start_date, end_date, is_active) VALUES
(1, 1, 7, '2025-07-06', NULL, TRUE),
(2, 6, 4, '2025-07-20', NULL, TRUE),
(3, 7, 3, '2025-07-23', NULL, TRUE),
(4, 10, 1, '2025-07-12', NULL, TRUE),
(5, 11, 5, '2025-07-28', NULL, TRUE),
(6, 12, 2, '2025-07-03', NULL, TRUE),
(7, 13, 8, '2025-07-24', NULL, TRUE),
(8, 17, 1, '2025-07-21', NULL, TRUE),
(9, 19, 9, '2025-07-17', '2025-12-27', FALSE),
(10, 9, 6, '2025-07-19', NULL, TRUE),
(11, 5, 2, '2025-07-29', NULL, TRUE),
(12, 20, 5, '2025-07-26', '2025-10-28', FALSE),
(13, 8, 5, '2025-07-21', NULL, TRUE),
(14, 16, 5, '2025-07-15', NULL, TRUE),
(15, 2, 2, '2025-07-07', '2025-10-26', FALSE),
(16, 14, 8, '2025-07-10', NULL, TRUE),
(17, 4, 8, '2025-07-30', NULL, TRUE),
(18, 15, 3, '2025-07-16', '2025-12-24', FALSE),
(19, 3, 9, '2025-07-05', NULL, TRUE),
(20, 18, 2, '2025-07-13', NULL, TRUE);

INSERT INTO payments (payment_id, contract_id, amount, due_date, paid_date, status) VALUES
(NULL, 1, 600000, '2024-08-31', '2024-09-01', 'late'),
(NULL, 2, 700000, '2024-08-31', '2024-09-02', 'late'),
(NULL, 3, 700000, '2024-08-31', '2024-09-04', 'late'),
(NULL, 3, 600000, '2024-09-30', '2024-09-25', 'paid'),
(NULL, 4, 700000, '2024-08-31', '2024-08-31', 'paid'),
(NULL, 4, 500000, '2024-09-30', '2024-09-30', 'paid'),
(NULL, 5, 500000, '2024-08-31', '2024-09-04', 'late'),
(NULL, 5, 700000, '2024-09-30', '2024-10-01', 'late'),
(NULL, 6, 600000, '2024-08-31', '2024-08-31', 'paid'),
(NULL, 6, 500000, '2024-09-30', NULL, 'unpaid'),
(NULL, 7, 500000, '2024-08-31', '2024-08-29', 'paid'),
(NULL, 7, 500000, '2024-09-30', '2024-09-29', 'paid'),
(NULL, 8, 500000, '2024-08-31', '2024-08-30', 'paid'),
(NULL, 9, 600000, '2024-08-31', '2024-09-05', 'late'),
(NULL, 9, 600000, '2024-09-30', '2024-10-02', 'late'),
(NULL, 10, 600000, '2024-08-31', NULL, 'unpaid'),
(NULL, 11, 600000, '2024-08-31', '2024-09-02', 'late'),
(NULL, 12, 600000, '2024-08-31', '2024-08-30', 'paid'),
(NULL, 12, 500000, '2024-09-30', '2024-10-06', 'late'),
(NULL, 13, 600000, '2024-08-31', NULL, 'unpaid'),
(NULL, 13, 700000, '2024-09-30', '2024-10-02', 'late'),
(NULL, 14, 700000, '2024-08-31', '2024-08-27', 'paid'),
(NULL, 15, 500000, '2024-08-31', NULL, 'unpaid'),
(NULL, 16, 500000, '2024-08-31', '2024-09-07', 'late'),
(NULL, 17, 700000, '2024-08-31', '2024-08-26', 'paid'),
(NULL, 17, 600000, '2024-09-30', '2024-10-05', 'late'),
(NULL, 18, 500000, '2024-08-31', '2024-09-05', 'late'),
(NULL, 18, 500000, '2024-09-30', '2024-10-07', 'late'),
(NULL, 19, 500000, '2024-08-31', '2024-08-28', 'paid'),
(NULL, 19, 500000, '2024-09-30', '2024-10-03', 'late'),
(NULL, 20, 700000, '2024-08-31', '2024-09-02', 'late'),
(NULL, 20, 600000, '2024-09-30', '2024-09-30', 'paid');

INSERT INTO payments (contract_id, amount, due_date, paid_date, status) VALUES
(1, 600000, '2025-08-31', NULL, 'unpaid'),
(2, 600000, '2025-08-31', '2025-09-03', 'late'),
(2, 600000, '2025-09-30', '2025-09-30', 'paid'),
(3, 600000, '2025-08-31', NULL, 'unpaid'),
(3, 500000, '2025-09-30', NULL, 'unpaid'),
(4, 700000, '2025-08-31', '2025-09-04', 'late'),
(5, 600000, '2025-08-31', '2025-08-31', 'paid'),
(6, 500000, '2025-08-31', '2025-08-31', 'paid'),
(6, 500000, '2025-09-30', '2025-09-30', 'paid'),
(7, 700000, '2025-08-31', '2025-08-31', 'paid'),
(7, 600000, '2025-09-30', '2025-10-02', 'late'),
(8, 500000, '2025-08-31', '2025-09-05', 'late'),
(8, 700000, '2025-09-30', '2025-09-30', 'paid'),
(9, 500000, '2025-08-31', '2025-09-01', 'late'),
(9, 500000, '2025-09-30', '2025-09-30', 'paid'),
(10, 600000, '2025-08-31', '2025-09-02', 'late'),
(10, 700000, '2025-09-30', '2025-10-04', 'late'),
(11, 500000, '2025-08-31', '2025-09-02', 'late'),
(11, 500000, '2025-09-30', '2025-09-30', 'paid'),
(12, 700000, '2025-08-31', '2025-09-02', 'late'),
(13, 700000, '2025-08-31', '2025-08-31', 'paid'),
(13, 600000, '2025-09-30', NULL, 'unpaid'),
(14, 600000, '2025-08-31', NULL, 'unpaid'),
(15, 500000, '2025-08-31', NULL, 'unpaid'),
(16, 700000, '2025-08-31', NULL, 'unpaid'),
(17, 700000, '2025-08-31', '2025-09-05', 'late'),
(18, 600000, '2025-08-31', '2025-08-31', 'paid'),
(18, 500000, '2025-09-30', '2025-10-01', 'late'),
(19, 500000, '2025-08-31', '2025-09-02', 'late'),
(20, 500000, '2025-08-31', '2025-09-05', 'late'),
(20, 600000, '2025-09-30', NULL, 'unpaid');

INSERT INTO announcements (title, content, created_at) VALUES
('Thông báo đăng ký ở ký túc xá học kỳ I', 'Sinh viên bắt đầu nộp đơn đăng ký ở KTX từ ngày 01/07/2025 đến 20/07/2025. Hạn cuối không gia hạn.', '2025-06-25 08:30:00'),
('Lịch đóng tiền phòng tháng 8', 'Đề nghị sinh viên đóng tiền phòng trước ngày 05/08/2025. Sau thời hạn sẽ tính phí phạt trễ hạn.', '2025-07-25 09:00:00'),
('Lịch cúp điện định kỳ', 'KTX sẽ cúp điện từ 13h đến 17h ngày 10/08/2025 để bảo trì hệ thống. Mong sinh viên thông cảm và chuẩn bị trước.', '2025-08-05 14:45:00'),
('Thông báo sửa chữa nhà vệ sinh tầng 3', 'Nhà vệ sinh tầng 3 khu A sẽ được sửa chữa từ 12/08 đến 18/08. Đề nghị sinh viên sử dụng các tầng khác.', '2025-08-10 10:00:00'),
('Khảo sát hài lòng sinh viên về KTX', 'Sinh viên vui lòng hoàn thành khảo sát online trước ngày 25/08/2025 để nhà trường cải thiện dịch vụ.', '2025-08-15 12:15:00'),
('Thông báo vệ sinh phòng định kỳ', 'Ban quản lý sẽ kiểm tra vệ sinh phòng vào ngày 20/08/2025. Đề nghị sinh viên dọn dẹp sạch sẽ.', '2025-08-17 08:30:00'),
('Cảnh báo bảo mật thông tin cá nhân', 'Không chia sẻ mật khẩu tài khoản với người khác. Mọi vi phạm sẽ bị xử lý theo quy định.', '2025-08-18 09:00:00'),
('Hướng dẫn đăng nhập hệ thống KTX', 'Sinh viên đăng nhập tại https://ktx.aptech.edu.vn bằng MSSV và mật khẩu mặc định là ngày sinh.', '2025-07-15 11:20:00'),
('Thông báo kết thúc hợp đồng sớm', 'Sinh viên muốn kết thúc hợp đồng ở KTX sớm vui lòng liên hệ văn phòng trước 15 ngày.', '2025-09-01 10:10:00'),
('Chúc mừng năm học mới 2025-2026', 'Ban quản lý KTX chúc toàn thể sinh viên một năm học thành công và nhiều sức khỏe.', '2025-09-05 08:00:00');

