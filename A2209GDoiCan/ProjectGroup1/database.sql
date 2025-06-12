-- =============================================================
-- CSDL QUẢN LÝ GIAO & NỘP BÀI TẬP CHO SINH VIÊN (MySQL 8.x)
-- =============================================================
-- Toàn bộ trường đều có COMMENT tiếng Việt để dễ hiểu.
-- =============================================================

-- ====================== TẠO CƠ SỞ DỮ LIỆU ======================
CREATE DATABASE IF NOT EXISTS assignment_app
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci
  COMMENT='CSDL quản lý giao và nộp bài tập cho sinh viên';
USE assignment_app;

-- ====================== BẢNG NGƯỜI DÙNG ======================
CREATE TABLE users (
    user_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT 'Khóa chính người dùng',
    full_name VARCHAR(100) NOT NULL COMMENT 'Họ và tên đầy đủ',
    email VARCHAR(255) NOT NULL UNIQUE COMMENT 'Địa chỉ email (duy nhất)',
    password_hash VARCHAR(255) NOT NULL COMMENT 'Mật khẩu đã mã hóa (BCrypt/PBKDF2)',
    role ENUM('ADMIN','LECTURER','STUDENT') NOT NULL DEFAULT 'STUDENT' COMMENT 'Vai trò hệ thống',
    refresh_token VARCHAR(512) NULL COMMENT 'Refresh JWT hiện hành (mã hóa/UUID)',
    token_expires_at DATETIME NULL COMMENT 'Thời gian hết hạn refresh token',
    last_login DATETIME NULL COMMENT 'Lần đăng nhập gần nhất',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm tạo tài khoản',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Thời điểm cập nhật tài khoản'
) ENGINE=InnoDB COMMENT='Tài khoản người dùng';

-- ====================== BẢNG LỚP HỌC ======================
CREATE TABLE classes (
    class_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT 'Khóa chính lớp học',
    class_code VARCHAR(50) NOT NULL UNIQUE COMMENT 'Mã lớp (ví dụ: CS101)',
    class_name VARCHAR(100) NOT NULL COMMENT 'Tên lớp/môn học',
    description TEXT NULL COMMENT 'Mô tả chi tiết lớp học',
    semester VARCHAR(20) NOT NULL COMMENT 'Học kỳ (ví dụ: 2025A)',
    lecturer_id BIGINT UNSIGNED NOT NULL COMMENT 'Giảng viên phụ trách',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm tạo lớp',
    FOREIGN KEY (lecturer_id) REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB COMMENT='Thông tin lớp học';

-- ====================== BẢNG THAM GIA LỚP HỌC ======================
CREATE TABLE class_students (
    class_id BIGINT UNSIGNED NOT NULL COMMENT 'Khóa ngoại tới lớp học',
    student_id BIGINT UNSIGNED NOT NULL COMMENT 'Khóa ngoại tới sinh viên',
    joined_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm sinh viên vào lớp',
    PRIMARY KEY (class_id, student_id),
    FOREIGN KEY (class_id) REFERENCES classes(class_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (student_id) REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Liên kết nhiều-nhiều giữa sinh viên và lớp học';

-- ====================== BẢNG BÀI TẬP ======================
CREATE TABLE assignments (
    assignment_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT 'Khóa chính bài tập',
    class_id BIGINT UNSIGNED NOT NULL COMMENT 'Lớp học giao bài',
    title VARCHAR(255) NOT NULL COMMENT 'Tiêu đề bài tập',
    description TEXT COMMENT 'Mô tả yêu cầu bài tập',
    due_at DATETIME NOT NULL COMMENT 'Hạn nộp bài',
    max_score DECIMAL(5,2) NOT NULL COMMENT 'Điểm tối đa',
    assignment_type ENUM('INDIVIDUAL','GROUP') NOT NULL DEFAULT 'INDIVIDUAL'
        COMMENT 'Loại bài: cá nhân hay nhóm',
    time_bound TINYINT(1) NOT NULL DEFAULT 0
        COMMENT '0: không ràng buộc thời gian, 1: có ràng buộc thời gian',
    allow_resubmit TINYINT(1) NOT NULL DEFAULT 0
        COMMENT '0: không cho nộp lại, 1: cho phép nộp lại',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm tạo',
    FOREIGN KEY (class_id) REFERENCES classes(class_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    INDEX idx_assignment_due (due_at)
) ENGINE=InnoDB COMMENT='Danh sách bài tập được giao';

-- ====================== BẢNG FILE ĐÍNH KÈM BÀI TẬP ======================
CREATE TABLE assignment_attachments (
    attachment_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT 'Khóa chính file đính kèm',
    assignment_id BIGINT UNSIGNED NOT NULL COMMENT 'Khóa ngoại tới bài tập',
    file_url VARCHAR(512) NOT NULL COMMENT 'Đường dẫn file (S3 / local)',
    uploaded_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm tải file',
    FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tệp đính kèm của bài tập';

-- ====================== BẢNG BÀI NỘP ======================
CREATE TABLE submissions (
    submission_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT 'Khóa chính bài nộp',
    assignment_id BIGINT UNSIGNED NOT NULL COMMENT 'Bài tập tương ứng',
    student_id BIGINT UNSIGNED NOT NULL COMMENT 'Sinh viên nộp bài',
    attempt SMALLINT UNSIGNED NOT NULL DEFAULT 1 COMMENT 'Số lần nộp (1,2,...)',
    submitted_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm nộp',
    note TEXT COMMENT 'Ghi chú của sinh viên',
    file_url VARCHAR(512) NOT NULL COMMENT 'Đường dẫn file bài làm',
    score DECIMAL(5,2) NULL COMMENT 'Điểm giảng viên chấm',
    feedback_text TEXT NULL COMMENT 'Nhận xét của giảng viên',
    feedback_file_url VARCHAR(512) NULL COMMENT 'File phản hồi (nếu có)',
    graded_by BIGINT UNSIGNED NULL COMMENT 'Giảng viên chấm',
    graded_at DATETIME NULL COMMENT 'Thời điểm chấm',
    FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (student_id) REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (graded_by) REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    UNIQUE (assignment_id, student_id, attempt)
) ENGINE=InnoDB COMMENT='Bài làm sinh viên gửi lên';

-- ====================== BẢNG BÌNH LUẬN TRÊN BÀI NỘP ======================
CREATE TABLE submission_comments (
    comment_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT 'Khóa chính bình luận',
    submission_id BIGINT UNSIGNED NOT NULL COMMENT 'Bài nộp liên quan',
    user_id BIGINT UNSIGNED NOT NULL COMMENT 'Người bình luận (GV/SV)',
    content TEXT NOT NULL COMMENT 'Nội dung bình luận',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm bình luận',
    FOREIGN KEY (submission_id) REFERENCES submissions(submission_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Trao đổi giữa giảng viên và sinh viên';

-- ====================== BẢNG LOG GỬI THÔNG BÁO ======================
CREATE TABLE notification_log (
    notification_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT 'Khóa chính thông báo',
    user_id BIGINT UNSIGNED NOT NULL COMMENT 'Người nhận',
    assignment_id BIGINT UNSIGNED NOT NULL COMMENT 'Bài tập liên quan',
    notification_type ENUM('REMIND_BEFORE','REMIND_DEADLINE') NOT NULL COMMENT 'Loại thông báo',
    sent_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm gửi',
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    INDEX idx_notification_user (user_id)
) ENGINE=InnoDB COMMENT='Lưu vết thông báo email đã gửi';

-- ====================== VIEW THỐNG KÊ BÀI NỘP ======================
CREATE OR REPLACE VIEW vw_assignment_stats AS
SELECT
    a.assignment_id,
    a.title,
    COUNT(s.submission_id)                       AS total_submissions,
    SUM(CASE WHEN s.submitted_at <= a.due_at THEN 1 ELSE 0 END) AS on_time_submissions,
    SUM(CASE WHEN s.submitted_at > a.due_at THEN 1 ELSE 0 END) AS late_submissions,

/*========================================================
   SEED DỮ LIỆU GIẢ – 12-06-2025
   ─ 1 ADMIN, 1 Giảng viên, 3 Sinh viên
   ─ 2 Lớp học, 3 Bài tập, 1 File đính kèm
   ─ 3 Bài nộp + 2 bình luận
========================================================*/
START TRANSACTION;

/*----------- USERS (ADMIN, LECTURER, STUDENTS) ---------*/
INSERT INTO users 
    (user_id, full_name,           email,                  password_hash,                       role,      refresh_token, token_expires_at,      last_login)
VALUES
    (1,       'Super Admin',       'admin@example.com',    '$2y$10$abcdefghijklmnopqrstuv',     'ADMIN',   UUID(),       DATE_ADD(NOW(), INTERVAL 30 DAY), NOW()),
    (2,       'Dr. Nguyễn Văn A',  'lecturer@example.com', '$2y$10$abcdefghijklmnopqrstuv',     'LECTURER',UUID(),       DATE_ADD(NOW(), INTERVAL 30 DAY), NOW()),
    (3,       'Trần Thị Bình',     'sv1@example.com',      '$2y$10$abcdefghijklmnopqrstuv',     'STUDENT', NULL,        NULL,                          NULL),
    (4,       'Lê Văn Cường',     'sv2@example.com',      '$2y$10$abcdefghijklmnopqrstuv',     'STUDENT', NULL,        NULL,                          NULL),
    (5,       'Phạm Minh Duy',     'sv3@example.com',      '$2y$10$abcdefghijklmnopqrstuv',     'STUDENT', NULL,        NULL,                          NULL);

/*----------- CLASSES -----------------------------------*/
INSERT INTO classes
    (class_id, class_code, class_name,                description,                    semester, lecturer_id)
VALUES
    (1,        'CS101',     'Nhập môn Lập trình',      'Học Python cơ bản',            '2025A',   2),
    (2,        'DB202',     'Cơ sở dữ liệu',           'Thiết kế & truy vấn MySQL',    '2025A',   2);

/*----------- CLASS ↔ STUDENTS --------------------------*/
INSERT INTO class_students (class_id, student_id, joined_at) VALUES
    (1,3,NOW()), (1,4,NOW()), (1,5,NOW()),
    (2,3,NOW()), (2,4,NOW());

/*----------- ASSIGNMENTS -------------------------------*/
INSERT INTO assignments
    (assignment_id, class_id, title,                        description,                           due_at,                              max_score, assignment_type, time_bound, allow_resubmit)
VALUES
    (1,             1,        'BT1: Hello World',            'Viết chương trình Python in \"Hello World\"', DATE_ADD(NOW(), INTERVAL 7 DAY),  10,       'INDIVIDUAL', 0,          1),
    (2,             1,        'BT2: Hàm & Vòng lặp',         'Hoàn thành các function trong file đính kèm', DATE_ADD(NOW(), INTERVAL 14 DAY), 20,       'INDIVIDUAL', 0,          1),
    (3,             2,        'BT1: Thiết kế ERD',           'Vẽ sơ đồ ER cho shop online',                  DATE_ADD(NOW(), INTERVAL 10 DAY), 15,       'GROUP',      0,          0);

/*----------- FILE ĐÍNH KÈM CHO BÀI TẬP -----------------*/
INSERT INTO assignment_attachments
    (attachment_id, assignment_id, file_url, uploaded_at)
VALUES
    (1,            2,            '/files/CS101/BT2_template.zip', NOW());

/*----------- SUBMISSIONS (bài nộp) ---------------------*/
INSERT INTO submissions
    (submission_id, assignment_id, student_id, attempt, submitted_at, note,                  file_url,                                   score, feedback_text, graded_by, graded_at)
VALUES
    (1,             1,            3,          1,       NOW(),         'Bài làm lần 1',       '/submissions/1/sv3_hello.py',              9.5,   'Tốt lắm!',     2,        NOW()),
    (2,             1,            4,          1,       NOW(),         '',                    '/submissions/1/sv4_hello.py',              8.0,   'Thiếu comment', 2,        NOW()),
    (3,             3,            3,          1,       NOW(),         'Nhóm em gửi ERD',     '/submissions/3/erd_group.pdf',             NULL,  NULL,           NULL,     NULL);

/*----------- COMMENTS TRÊN BÀI NỘP ---------------------*/
INSERT INTO submission_comments
    (comment_id, submission_id, user_id, content,      created_at)
VALUES
    (1,          1,             3,       'Cảm ơn thầy!', NOW()),
    (2,          1,             2,       'Thầy đã sửa điểm và thêm phản hồi.', NOW());

COMMIT;

/*----------- RESET AUTO_INCREMENT (tùy chọn) -----------*/
-- ALTER TABLE users              AUTO_INCREMENT = 100;
-- ALTER TABLE classes            AUTO_INCREMENT = 100;
-- ALTER TABLE assignments        AUTO_INCREMENT = 100;
-- ALTER TABLE submissions        AUTO_INCREMENT = 100;
-- ALTER TABLE submission_comments AUTO_INCREMENT = 100;

