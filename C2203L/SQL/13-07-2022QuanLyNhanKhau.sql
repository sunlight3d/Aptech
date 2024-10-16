CREATE DATABASE QuanLyNhanKhau;
USE QuanLyNhanKhau;
CREATE TABLE QuanHuyen(
	MaQH INT IDENTITY(1,1) NOT NULL,
	TenQH NVARCHAR(100)
);
CREATE TABLE DuongPho(
	DuongID INT NOT NULL,
	MaQH INT NOT NULL,
	TenDuong NVARCHAR(MAX) NOT NULL,
	NgayDuyetTen DATETIME NOT NULL
);
CREATE TABLE NhaTrenPho(
	NhaID INT NOT NULL,
	DuongID INT NOT NULL,--N NhaTrenPho - 1 DuongPho
	ChuHo NVARCHAR(50) NULL,
	DienTich MONEY NULL
);
CREATE CLUSTERED INDEX CI_NhaTrenPho_NhaID   
ON NhaTrenPho(NhaID);

CREATE UNIQUE NONCLUSTERED INDEX UI_QuanHuyen_TenQH  
ON QuanHuyen(TenQH );

ALTER TABLE NhaTrenPho
ADD SoNhanKhau INT;

ALTER TABLE QuanHuyen 
ADD CONSTRAINT PK_QuanHuyen 
PRIMARY KEY(MaQH); 

ALTER TABLE DuongPho 
ADD CONSTRAINT PK_DuongPho 
PRIMARY KEY(DuongID); 

ALTER TABLE NhaTrenPho 
ADD CONSTRAINT PK_NhaTrenPho 
PRIMARY KEY(NhaID); 

ALTER TABLE DuongPho
DROP CONSTRAINT CK_DuongPho_NgayDuyetTen;


ALTER TABLE NhaTrenPho
ADD CONSTRAINT FK_NhaTrenPho_DuongPho
FOREIGN KEY (DuongID) REFERENCES DuongPho(DuongID); 

ALTER TABLE DuongPho
ADD CONSTRAINT FK_DuongPho_QuanHuyen
FOREIGN KEY (MaQH) REFERENCES QuanHuyen(MaQH); 


ALTER TABLE DuongPho
ADD CONSTRAINT CK_DuongPho_NgayDuyetTen 
CHECK (NgayDuyetTen >= '1945-09-02' OR NgayDuyetTen <= getdate()); 

INSERT INTO QuanHuyen(TenQH) VALUES
(N'Ba Đình'),
(N'Hoàng Mai');

INSERT INTO DuongPho(DuongId,MaQH,TenDuong,NgayDuyetTen) VALUES
(1,1,N'ĐộiCấn','1946-10-19'),
(2,1,N'VạnPhúc','1998-12-30'),
(3,2,N'GiảiTỏa','1975-09-21');
SELECT * FROM DuongPho;

INSERT INTO NhaTrenPho(NhaID,DuongID,ChuHo,DienTich,SoNhanKhau) VALUES
(1,1,N'Hà Khánh Toàn',100,4),
(2,1,N'Lê Hồng Hải',20,12),
(3,2,N'Trần Khánh',40,1);
SELECT * FROM NhaTrenPho;

UPDATE DuongPho 
SET TenDuong=N'Giải Phóng'
WHERE TenDuong = N'GiảiTỏa';

SELECT * FROM DuongPho 
WHERE TenDuong = N'GiảiTỏa';

SELECT name FROM sys.views WHERE type='V';

DROP VIEW view_all_NhaTrenPho;

CREATE VIEW view_all_NhaTrenPho
AS
	(SELECT 
		QuanHuyen.TenQH, 
		DuongPho.TenDuong, 
		DuongPho.NgayDuyetTen, 
		NhaTrenPho.ChuHo, 
		NhaTrenPho.DienTich, 
		NhaTrenPho.SoNhanKhau	
	FROM QuanHuyen 
	INNER JOIN DuongPho 
	ON QuanHuyen.MaQH=QuanHuyen.MaQH 
	INNER JOIN NhaTrenPho
ON DuongPho.DuongID=NhaTrenPho.DuongID);

SELECT * FROM view_all_NhaTrenPho;


DROP VIEW view_AVG_NhaTrenPho;
CREATE VIEW view_AVG_NhaTrenPho
AS
	(SELECT 
		DuongPho.TenDuong AS 'Tên đường' , 
		Q1.DienTichTrungBinh AS 'Diện tích trung bình' , 
		Q1.NhanKhauTrungBinh AS 'Số nhân khẩu trung bình' 
	FROM DuongPho 
	JOIN 
		(SELECT 
			AVG(NhaTrenPho.DienTich) AS DienTichTrungBinh, 
			AVG(NhaTrenPho.SoNhanKhau) AS NhanKhauTrungBinh, 
			DuongID
		FROM NhaTrenPho
		GROUP BY DuongID) AS Q1 ON Q1.DuongID=DuongPho.DuongID);  
--test view 
SELECT * FROM view_AVG_NhaTrenPho;

/*
SELECT definition
FROM
    sys.sql_modules
WHERE
    object_id = object_id('view_AVG_NhaTrenPho');
*/

DROP PROCEDURE sp_NgayQuyetTen_DuongPho;
CREATE PROCEDURE sp_NgayQuyetTen_DuongPho 
	@NgayDuyet DATETIME	
AS
BEGIN
	SELECT 
		view_all_NhaTrenPho.NgayDuyetTen AS 'Ngày duyệt tên', 
		view_all_NhaTrenPho.TenDuong AS 'Tên Đường', 
		view_all_NhaTrenPho.TenQH	 AS 'Tên quận huyện' 
	FROM view_all_NhaTrenPho
	WHERE view_all_NhaTrenPho.NgayDuyetTen = @NgayDuyet;
END
EXEC sp_NgayQuyetTen_DuongPho '1998-12-30';
--sp = stored procedure

DROP TRIGGER TG_NhaTrenPho_Update;
CREATE TRIGGER TG_NhaTrenPho_Update  
ON NhaTrenPho --on table's name
AFTER UPDATE, INSERT AS --event(when)
BEGIN
	DECLARE @SoNhanKhau AS INT --declare local variable
	SET @SoNhanKhau = (SELECT TOP 1 SoNhanKhau FROM inserted) 
	IF (@SoNhanKhau <= 0 ) 
	BEGIN 
		RAISERROR ('SoNhanKhau must be greater than or equal zero !',16,10);		
		ROLLBACK 
	END	
END

SELECT * FROM NhaTrenPho;
UPDATE NhaTrenPho SET SoNhanKhau=0 
WHERE NhaID=1;


DROP TRIGGER TG_DuongPho_Instead_Of_Delete;
CREATE TRIGGER TG_DuongPho_Instead_Of_Delete  
ON DuongPho --on table's name
INSTEAD OF DELETE AS 
BEGIN
	RAISERROR ('Please do something else instead of deleting data in table DuongPho',16,10);	
	ROLLBACK;
END

--test trigger
SELECT * FROM DuongPho;
DELETE FROM DuongPho WHERE DuongID = 2;
<<<<<<< HEAD


--dnsuhds hduhsdush 
=======
>>>>>>> a2bab596d8ff3818f9e0963c17bb6f9307ddd13f
