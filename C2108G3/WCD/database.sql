DROP DATABASE c2108g3;
CREATE DATABASE c2108g3
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
USE c2108g3;
DROP TABLE IF EXISTS tblMobile;

CREATE TABLE tblMobile (
    mobile_id INT PRIMARY KEY AUTO_INCREMENT,
    mobile_name VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    warranty VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    in_out_stock TINYINT,
    price FLOAT,
    accessories VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    image_src VARCHAR(100)
);


INSERT INTO tblMobile (mobile_name, warranty, in_out_stock, price, accessories, image_src) VALUES
('Apple iPhone 4s - 32Gb', '03 tháng', 1, 14000000, 'Sạc, cáp, tai nghe, hộp sách', 'image/w182h182_apple-iphone-4s-16gb-1331181668.jpg'),
('HTC One V - T320e', '06 tháng', 1, 5100000, 'Pin, sạc, cáp, tai nghe, hộp sách', 'image/w182h182_htc-evo-3d-1331180995.jpg'),
('HTC One V - T320e', '12 tháng', 1, 7000000, 'Sạc, cáp, tai nghe, hộp sách', 'image/w182h182_htc-one-v-1334399457.jpg'),
('HTC Rhyme-S510b', '12 tháng', 1, 6400000, 'Pin, sạc, cáp, tai nghe, hộp sách, thẻ 8GB đi kèm, Còn BH chính hãng', 'image/w182h182_htc-rhyme-s510b-1331113653.jpg'),
('Motorola RAZR XT910', '12 tháng', 1, 6900000, 'Pin, sạc, cáp, tai nghe, sách hướng dẫn, hộp đựng', 'image/w182h182_motorola-razr-xt910-1331194891.jpg'),
('Nokia C5-00.2', '12 tháng', 1, 8000000, 'Sạc, cáp, tai nghe, hộp sách', 'image/w182h182_nokia-c5-00-2-1334289932.jpg'),
('Nokia C5-06', '12 tháng', 0, 3000000, 'Sạc, cáp, tai nghe, hộp sách', 'image/w182h182_nokia-c5-06-1334289945.jpg'),
('Samsung Galaxy Note N7000', '10 tháng', 1, 8900000, 'Pin, sạc, cáp, tai nghe, hộp sách', 'image/w182h182_samsung-galaxy-note-cty-n7000-1331191686.jpg'),
('Sony Xperia S-LT26i', '6 tháng', 1, 9400000, 'Sạc, cáp, tai nghe, hộp sách', 'image/w182h182_sony-xperia-s-lt26i-1334226065.jpg'),
('Sony Xperia Sola - MT27i', '6 tháng', 0, 5300000, 'Sạc, cáp, tai nghe, hộp sách hướng dẫn', 'image/w182h182_sony-xperia-sola-1336725289.jpg');

SELECT * FROM tblMobile;
