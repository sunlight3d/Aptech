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

ALTER TABLE DuongPho DROP CONSTRAINT CK_DuongPho_NgayDuyetTen;

ALTER TABLE DuongPho
ADD CONSTRAINT CK_DuongPho_NgayDuyetTen 
CHECK (NgayDuyetTen >= '1945/09/02' OR NgayDuyetTen <= GETDATE()); --validation


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

CREATE CLUSTERED INDEX CI_NhaTrenPho_NhaID ON NhaTrenPho(NhaID ASC);
CREATE NONCLUSTERED INDEX UI_QuanHuyen_TenQH ON QuanHuyen(TenQH ASC);

INSERT INTO NhaTrenPho(NhaID, DuongID, ChuHo, DienTich, SoNhanKhau) VALUES
(1,1, N'Hà Khánh Toàn', 100, 4),
(2,1, N'Lê Hồng Hải', 20, 12),
(3,2, N'Trần Khánh', 40, 1);

SELECT * FROM NhaTrenPho;

UPDATE DuongPho SET TenDuong = N'Giải Phóng'
WHERE TenDuong = N'Giải Tỏa';
SELECT * FROM DuongPho;

DROP VIEW view_all_NhaTrenPho;
CREATE VIEW view_all_NhaTrenPho AS 
SELECT 
	QuanHuyen.TenQH AS TenQH,
	DuongPho.TenDuong AS TenDuong,
	DuongPho.NgayDuyetTen AS NgayDuyetTen,
	NhaTrenPho.ChuHo AS ChuHo,
	NhaTrenPho.DienTich AS DienTich,
	NhaTrenPho.SoNhanKhau AS SoNhanKhau
FROM QuanHuyen 
INNER JOIN DuongPho ON QuanHuyen.MaQH=DuongPho.MaQH
INNER JOIN NhaTrenPho ON DuongPho.DuongID=NhaTrenPho.DuongID;

SELECT * FROM view_all_NhaTrenPho;
--8-Views
CREATE VIEW view_AVG_NhaTrenPho AS 
SELECT 
       TenDuong AS 'Ten duong',
	   SUM(DienTich) / COUNT(DienTich) AS 'Dien tich trung binh',
	   SUM(SoNhanKhau) / COUNT(SoNhanKhau) AS 'So nhan khau trung binh'
FROM DuongPho
INNER JOIN NhaTrenPho ON DuongPho.DuongID = NhaTrenPho.DuongID
GROUP BY TenDuong;

SELECT * FROM view_AVG_NhaTrenPho ORDER BY 'So nhan khau trung binh' ASC;
SELECT * FROM view_AVG_NhaTrenPho ORDER BY 'Dien tich trung binh' ASC;

--9. Procedure
DROP PROCEDURE sp_NgayQuyetTen_DuongPho;
CREATE PROCEDURE sp_NgayQuyetTen_DuongPho 
@NgayDuyet DATETIME AS
BEGIN
	SELECT 
		NgayDuyetTen AS 'Ngày Duyệt Tên', 
		TenDuong AS 'Tên Đường', 
		TenQH AS 'Tên Quận Huyện'
	FROM view_all_NhaTrenPho
	WHERE NgayDuyetTen=@NgayDuyet;	
END

EXECUTE sp_NgayQuyetTen_DuongPho '1946/10/19'; 

--10. Trigger
DROP TRIGGER TG_NhaTrenPho_Update;

CREATE TRIGGER TG_NhaTrenPho_Update  
ON NhaTrenPho
AFTER UPDATE AS   
DECLARE @Count INT
SET @Count = (SELECT COUNT(inserted.SoNhanKhau) FROM inserted
	WHERE inserted.SoNhanKhau <= 0)
IF(@Count > 0)
BEGIN  
	RAISERROR ('SoNhanKhau must be greater than zero !', 16, 10)  
	ROLLBACK
END;  
--test trigger
SELECT * FROM NhaTrenPho;
UPDATE NhaTrenPho SET SoNhanKhau = -1 WHERE NhaID = 1;

DROP TRIGGER TG_DuongPho_Instead_Of_Delete;
CREATE TRIGGER TG_DuongPho_Instead_Of_Delete  
ON DuongPho
INSTEAD OF DELETE AS   
BEGIN  	
	PRINT 'Please do something else instead of deleting data in table DuongPho!'
	--ROLLBACK
END;  

SELECT * FROM DuongPho;
DELETE FROM DuongPho WHERE DuongID = 1;


