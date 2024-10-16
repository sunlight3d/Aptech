-- Bảng Categories (Danh mục)
CREATE TABLE Categories (
    CategoryID INT PRIMARY KEY, -- Khóa chính của danh mục
    CategoryName NVARCHAR(100), -- Tên danh mục
    CategoryType NVARCHAR(50), -- Loại danh mục (commercial hoặc residential)
    Description NVARCHAR(MAX) -- Mô tả danh mục
);

-- Bảng Listings (Các bài đăng)
CREATE TABLE Listings (
    ListingID INT PRIMARY KEY, -- Khóa chính của bài đăng
    CategoryID INT, -- Khóa ngoại tham chiếu đến danh mục tương ứng
    PackageID INT, -- Khóa ngoại tham chiếu đến gói đăng tin tương ứng
    Title NVARCHAR(100), -- Tiêu đề bài đăng
    Description NVARCHAR(MAX), -- Mô tả bài đăng
    ListingType NVARCHAR(50), -- Loại bài đăng (buy, sell, rent)
    Price DECIMAL(18, 2), -- Giá bài đăng
    Location NVARCHAR(100), -- Vị trí bài đăng
    IsActive BIT, -- Trạng thái hoạt động của bài đăng
    CreatedAt DATETIME, -- Thời điểm tạo bài đăng
    UpdatedAt DATETIME, -- Thời điểm cập nhật bài đăng
    FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID),
    FOREIGN KEY (PackageID) REFERENCES Packages (PackageID)
);

-- Bảng Packages (Gói đăng tin)
CREATE TABLE Packages (
    PackageID INT PRIMARY KEY, -- Khóa chính của gói đăng tin
    PackageName NVARCHAR(100), -- Tên gói đăng tin
    Price DECIMAL(18, 2), -- Giá gói đăng tin
    Duration INT, -- Thời gian hiệu lực của gói đăng tin (số ngày)
    IsActive BIT -- Trạng thái hoạt động của gói đăng tin
);

-- Bảng Users (Người dùng)
CREATE TABLE Users (
    UserID INT PRIMARY KEY, -- Khóa chính của người dùng
    Username NVARCHAR(50), -- Tên người dùng
    Password NVARCHAR(50), -- Mật khẩu người dùng
    Email NVARCHAR(100), -- Địa chỉ email người dùng
    Role NVARCHAR(50), -- Vai trò người dùng (admin, private seller, agent)
    IsActive BIT -- Trạng thái hoạt động của người dùng
);



-- Bảng Images (Hình ảnh)
CREATE TABLE Images (
    ImageID INT PRIMARY KEY, -- Khóa chính của hình ảnh
    ListingID INT, -- Khóa ngoại tham chiếu đến bài đăng tương ứng
    ImagePath NVARCHAR(MAX) -- Đường dẫn đến hình ảnh
);

-- Bảng Transactions (Giao dịch)
CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY, -- Khóa chính của giao dịch
    UserID INT, -- Khóa ngoại tham chiếu đến người dùng thực hiện giao dịch
    PackageID INT, -- Khóa ngoại tham chiếu đến gói đăng tin tương ứng
    Amount DECIMAL(18, 2), -- Số tiền giao dịch
    PaymentDate DATETIME -- Ngày thanh toán
);

-- Bảng Statistics (Thống kê) => có thể tạo view
CREATE TABLE Statistics (
    StatisticID INT PRIMARY KEY, -- Khóa chính của thống kê
    PaymentsToday INT, -- Số lượng giao dịch được thực hiện trong ngày
    UnapprovedListings INT, -- Số lượng bài đăng chưa được phê duyệt
    UnverifiedListings INT, -- Số lượng bài đăng chưa được xác minh
    ApprovedListings INT, -- Số lượng bài đăng đã được phê duyệt
    NumberOfCategories INT, -- Số lượng danh mục
    NumberOfPrivateSellers INT, -- Số lượng người bán riêng tư
    NumberOfAgents INT -- Số lượng đại lý
);
