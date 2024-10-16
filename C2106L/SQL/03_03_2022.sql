CREATE DATABASE QuanLyNhanKhau;
USE QuanLyNhanKhau;
-- SQL Server,Oracle, Postgres, mysql,mongodb, graphql
CREATE TABLE QuanHuyen(
	MaQH	INT IDENTITY(1, 1) NOT NULL,
	TenQH	NVARCHAR(100),
);
ALTER TABLE QuanHuyen
ADD CONSTRAINT PK_QuanHuyen PRIMARY KEY(MaQH);
INSERT INTO QuanHuyen(TenQH) VALUES
(N'Ba Đình'),
(N'Hoàng Mai');
SELECT * FROM QuanHuyen;

--1 quận huyện có nhiều đường phố
CREATE TABLE DuongPho(
	DuongID			INT NOT NULL,
	MaQH			INT NOT NULL,
	TenDuong		NVARCHAR(MAX) NOT NULL,
	NgayDuyetTen	DATETIME NOT NULL
);
ALTER TABLE DuongPho
ADD CONSTRAINT PK_DuongPho PRIMARY KEY(DuongID);

ALTER TABLE DuongPho
ADD CONSTRAINT CK_DuongPho_NgayDuyetTen 
CHECK (NgayDuyetTen >= '1945/09/02' OR NgayDuyetTen <= GETDATE());

ALTER TABLE DuongPho DROP CONSTRAINT CK_DuongPho_NgayDuyetTen;

ALTER TABLE DuongPho
ADD CONSTRAINT FK_DuongPho_QuanHuyen
FOREIGN KEY(MaQH) 
References QuanHuyen(MaQH);

INSERT INTO DuongPho(DuongID, MaQH, TenDuong, NgayDuyetTen) VALUES
(1, 1, N'Đội Cấn', '1946-10-19'),
(2, 1, N'Vạn Phúc', '1998-12-30'),
(3, 2, N'Giải Tỏa', '1979-09-21');
--1 DuongPho co chua nhieu NhaTrenPho
CREATE TABLE NhaTrenPho(
	NhaID		INT NOT NULL,
	DuongID		INT NOT NULL,
	ChuHo		NVARCHAR(50), 
	DienTich	MONEY
);
ALTER TABLE NhaTrenPho
ADD CONSTRAINT PK_NhaTrenPho PRIMARY KEY(NhaID);

ALTER TABLE NhaTrenPho
ADD CONSTRAINT FK_NhaTrenPho_DuongPho
FOREIGN KEY(DuongID) 
References DuongPho(DuongID);

ALTER TABLE NhaTrenPho 
ADD SoNhanKhau INT;

SELECT * FROM NhaTrenPho;

CREATE CLUSTERED INDEX CI_NhaTrenPho_NhaID ON NhaTrenPho(NhaID ASC);
CREATE NONCLUSTERED INDEX UI_QuanHuyen_TenQH ON QuanHuyen(TenQH ASC);


