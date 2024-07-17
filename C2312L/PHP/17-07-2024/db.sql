CREATE DATABASE c2312l;
USE c2312l;
CREATE TABLE tblItem(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL UNIQUE
);
--PHP Data Object = PDO 
-- use PDO to connect mysql DB from PHP
INSERT INTO tblItem(name) VALUES
('iphone 15'),
('dell latitude'),
('samsung galaxy s23'),
('hp spectre x360'),
('macbook pro'),
('google pixel 7'),
('bose headphones'),
('nintendo switch'),
('xbox series x'),
('playstation 5'),
('ipad pro'),
('sony alpha a7'),
('canon eos r5'),
('nikon z6'),
('microsoft surface pro'),
('tesla model y'),
('fitbit versa'),
('kindle paperwhite'),
('lg oled tv'),
('dyson vacuum'),
('roomba s9'),
('logitech mouse'),
('razer keyboard'),
('huawei p50'),
('asus rog laptop'),
('fujifilm xt-4'),
('beats by dre'),
('oculus quest 2'),
('garmin forerunner'),
('kitchenaid mixer');

