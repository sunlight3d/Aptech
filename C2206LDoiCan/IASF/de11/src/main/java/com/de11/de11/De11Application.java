package com.de11.de11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class De11Application {

	public static void main(String[] args) {
		SpringApplication.run(De11Application.class, args);
	}

}
/*
viết cho tôi câu lệnh mysql tạo ra 1 bảng tên là products có các trường:
id, name, brand, madein, price
Hãy đặt kiểu giá trị cho các trường 1 cách hợp lý, kèm các ràng buộc cụ thể.
Các quy ước đặt tên phải chuẩn theo mysql

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(100) NOT NULL,
    madein VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

INSERT INTO products (name, brand, madein, price) VALUES
('Ultra Phone', 'BrandA', 'USA', 399.99),
('Mega Tablet', 'BrandB', 'Canada', 299.99),
('Super Laptop', 'BrandC', 'China', 499.99),
('Smart Watch', 'BrandA', 'USA', 199.99),
('E-Reader Glow', 'BrandB', 'Canada', 129.99),
('Compact Camera', 'BrandC', 'China', 250.00),
('Gaming Console', 'BrandA', 'USA', 350.00),
('Video Projector', 'BrandB', 'Canada', 455.00),
('Portable Speaker', 'BrandC', 'China', 59.99),
('Fitness Tracker', 'BrandA', 'USA', 75.99),
('Wireless Earbuds', 'BrandB', 'Canada', 89.99),
('Action Camera', 'BrandC', 'China', 129.00),
('HD Television', 'BrandA', 'USA', 920.00),
('Bluetooth Headset', 'BrandB', 'Canada', 250.00),
('Smart Home Hub', 'BrandC', 'China', 99.99),
('Noise Cancelling Headphone', 'BrandA', 'USA', 299.99),
('Advanced Router', 'BrandB', 'Canada', 199.50),
('Smart Light Bulb', 'BrandC', 'China', 45.99),
('Robotic Vacuum', 'BrandA', 'USA', 460.00),
('Drone with Camera', 'BrandB', 'Canada', 359.99),
('Digital Thermometer', 'BrandC', 'China', 25.99),
('Smart Scale', 'BrandA', 'USA', 130.00),
('Electric Scooter', 'BrandB', 'Canada', 599.00),
('Wireless Charger', 'BrandC', 'China', 23.99),
('Outdoor Security Camera', 'BrandA', 'USA', 199.99),
('Smart Water Bottle', 'BrandB', 'Canada', 60.00),
('Solar Panel Charger', 'BrandC', 'China', 85.00),
('LED Desk Lamp', 'BrandA', 'USA', 42.99),
('Mini Bluetooth Speaker', 'BrandB', 'Canada', 49.99),
('Smart Garden System', 'BrandC', 'China', 189.99);

Viết cho tôi model trong Java Springboot tương ứng với bảng trên, tên model là Product
Có các annotation tương ứng

Từ Model trên viết cho tôi Repository, có hỗ trợ paging, hiện danh sách sản phẩm

Trong phần Thymeleaf, thêm cột Actions, cột này có thẻ a là Delete. Khi bấm vào sẽ hỏi confirm
Nếu đồng ý sẽ gọi phương thức xoá sản phẩm trong controller,
Xoá xong reload lại list
* */