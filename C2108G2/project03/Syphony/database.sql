-- Bảng Courses
CREATE TABLE Courses (
    CourseID INT PRIMARY KEY,
    CourseName NVARCHAR(255), -- Tên khóa học
    CourseDescription NVARCHAR(MAX) -- Mô tả khóa học
);

-- Bảng Students
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    StudentName NVARCHAR(255), -- Tên học viên
    StudentRollNumber NVARCHAR(50), -- Số roll của học viên
    CourseID INT, -- Khóa ngoại liên kết với bảng Courses
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

-- Bảng EntranceExams
CREATE TABLE EntranceExams (
    ExamID INT PRIMARY KEY,
    ExamDate DATE, -- Ngày tổ chức kỳ thi
    ExamFee DECIMAL(10, 2), -- Phí thi
    CourseID INT, -- Khóa ngoại liên kết với bảng Courses
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

-- Bảng Results
CREATE TABLE Results (
    ResultID INT PRIMARY KEY,
    ExamID INT, -- Khóa ngoại liên kết với bảng EntranceExams
    StudentID INT, -- Khóa ngoại liên kết với bảng Students
    Marks DECIMAL(10, 2) -- Điểm số đạt được
    FOREIGN KEY (ExamID) REFERENCES EntranceExams(ExamID),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID)
);

-- Bảng Centres
CREATE TABLE Centres (
    CentreID INT PRIMARY KEY,
    CentreName NVARCHAR(255), -- Tên trung tâm
    CentreAddress NVARCHAR(MAX), -- Địa chỉ trung tâm
    ContactNumber NVARCHAR(20) -- Số điện thoại liên hệ
);

-- Bảng FAQs
CREATE TABLE FAQs (
    FAQID INT PRIMARY KEY,
    Question NVARCHAR(MAX), -- Câu hỏi
    Answer NVARCHAR(MAX) -- Câu trả lời
);

-- Bảng Admin
CREATE TABLE Admin (
    AdminID INT PRIMARY KEY,
    Username NVARCHAR(50), -- Tên đăng nhập của quản trị viên
    Password NVARCHAR(50) -- Mật khẩu của quản trị viên
);

-- Bảng CourseFees
CREATE TABLE CourseFees (
    CourseID INT PRIMARY KEY, -- Khóa ngoại liên kết với bảng Courses
    BasicFees DECIMAL(10, 2), -- Phí học cơ bản
    DurationMonths INT, -- Thời gian học (tháng)
    ExtraLabFees DECIMAL(10, 2) -- Phí lab thêm (tuỳ chọn)
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);
