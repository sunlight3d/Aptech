USE c2206l; -- Chuyển đổi sang cơ sở dữ liệu c2206l

CREATE TABLE students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(100) NOT NULL,
  age INT NOT NULL,
  address VARCHAR(500),
  javaScore DECIMAL(18, 1),
  csharpScore DECIMAL(18, 1)
);


-- Thêm 20 bản ghi giả mạo vào bảng "students"
INSERT INTO students (Name, Age, Address, JavaScore, CSharpScore) VALUES
  ('John Doe', 20, '123 Main St', 85.5, 90.0),
  ('Alice Smith', 22, '456 Elm St', 92.0, 88.5),
  ('Bob Johnson', 21, '789 Oak St', 78.75, 82.0),
  ('Sarah Brown', 23, '101 Pine St', 88.25, 95.5),
  ('Michael Davis', 22, '202 Maple St', 76.0, 81.0),
  ('Emily Wilson', 20, '303 Cedar St', 94.75, 91.5),
  ('David Lee', 21, '404 Birch St', 85.0, 87.0),
  ('Jennifer Hall', 23, '505 Redwood St', 90.25, 89.5),
  ('Daniel Miller', 22, '606 Spruce St', 77.5, 80.0),
  ('Lisa White', 21, '707 Sequoia St', 82.75, 84.5),
  ('Matthew Moore', 20, '808 Red St', 89.0, 86.0),
  ('Olivia Martin', 23, '909 Blue St', 76.25, 83.0),
  ('James Clark', 22, '1010 Green St', 92.5, 87.5),
  ('Sophia Anderson', 21, '1111 Yellow St', 87.75, 89.0),
  ('William Rodriguez', 20, '1212 Orange St', 79.0, 82.5),
  ('Ava Taylor', 23, '1313 Violet St', 93.25, 92.0),
  ('Joseph Hernandez', 22, '1414 Indigo St', 81.5, 83.5),
  ('Charlotte Wilson', 21, '1515 Lavender St', 86.75, 88.0),
  ('Benjamin Gonzalez', 20, '1616 Maroon St', 74.25, 80.5),
  ('Mia Perez', 23, '1717 Teal St', 91.0, 89.0);
