const mysql = require('mysql2/promise');

const connectionPromise = mysql
  .createConnection({
    host: 'localhost',
    port: 3309, // Thay đổi cổng nếu cần
    user: 'root', // Thay đổi user nếu cần
    password: '', // Thay đổi mật khẩu
    database: 'hospital',
  })
  .then((conn) => {
    console.log('Successfully connected to MySQL');
    return conn; // Trả về đối tượng connection
  })
  .catch((err) => {
    console.error('Connection error:', err);
    throw err; // Ném lỗi để xử lý ở nơi sử dụng
  });

module.exports = connectionPromise;


/*
CREATE TABLE wards (
    id INT AUTO_INCREMENT PRIMARY KEY, -- ID tự tăng
    name VARCHAR(255) NOT NULL UNIQUE, -- Tên không trùng lặp
    capacity INT NOT NULL CHECK (capacity > 0), -- Sức chứa lớn hơn 0
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Tự động thêm created_at
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Tự động thêm updated_at
);
CREATE TABLE nurses (
    id INT AUTO_INCREMENT PRIMARY KEY, -- ID tự tăng
    name VARCHAR(50) NOT NULL, -- Tên bắt buộc
    certification ENUM('Bác sĩ', 'Y tá', 'Hộ lý', 'Kỹ thuật viên') NOT NULL, -- Chứng chỉ hợp lệ
    ward_id INT NOT NULL, -- Tham chiếu đến bảng wards
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Tự động thêm created_at
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Tự động thêm updated_at
    UNIQUE (name, ward_id), -- Đảm bảo tên trong cùng ward không trùng lặp
    CONSTRAINT fk_ward FOREIGN KEY (ward_id) REFERENCES wards (id) ON DELETE CASCADE -- Ràng buộc khóa ngoại
);

INSERT INTO wards (name, capacity) VALUES 
('Khoa Nội', 30),
('Khoa Ngoại', 40),
('Khoa Nhi', 25),
('Khoa Sản', 35),
('Khoa Hồi Sức', 20),
('Khoa Xét Nghiệm', 15),
('Khoa Phẫu Thuật', 50),
('Khoa Tim Mạch', 45),
('Khoa Tiêu Hóa', 30),
('Khoa Thần Kinh', 40);

INSERT INTO nurses (name, certification, ward_id) VALUES 
('Nguyễn Văn A', 'Bác sĩ', 1),
('Trần Thị B', 'Y tá', 2),
('Phạm Văn C', 'Kỹ thuật viên', 3),
('Lê Thị D', 'Hộ lý', 4),
('Ngô Văn E', 'Bác sĩ', 5),
('Vũ Thị F', 'Y tá', 6),
('Đặng Văn G', 'Kỹ thuật viên', 7),
('Hoàng Thị H', 'Hộ lý', 8),
('Bùi Văn I', 'Bác sĩ', 9),
('Dương Thị K', 'Y tá', 10),
('Phan Văn L', 'Kỹ thuật viên', 1),
('Lý Thị M', 'Hộ lý', 2),
('Võ Văn N', 'Bác sĩ', 3),
('Đỗ Thị O', 'Y tá', 4),
('Đinh Văn P', 'Kỹ thuật viên', 5),
('Trương Thị Q', 'Hộ lý', 6),
('Nguyễn Văn R', 'Bác sĩ', 7),
('Trần Thị S', 'Y tá', 8),
('Phạm Văn T', 'Kỹ thuật viên', 9),
('Lê Thị U', 'Hộ lý', 10);

 */