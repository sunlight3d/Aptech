CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY, -- ID tự tăng
    title VARCHAR(255) NOT NULL, -- Tiêu đề của task
    description TEXT, -- Mô tả chi tiết task
    status ENUM('Pending', 'In Progress', 'Completed') NOT NULL DEFAULT 'Pending' -- Trạng thái của task
);


##Thêm mới một task
curl -X POST http://localhost:3000/api/tasks \
-H "Content-Type: application/json" \
-d '{
  "title": "Lập báo cáo tuần",
  "description": "Viết báo cáo tổng kết công việc tuần này",
  "status": "Pending"
}'

##Lấy danh sách tất cả các task
curl -X GET http://localhost:3000/api/tasks


##Cập nhật thông tin một task:
 curl -X PUT http://localhost:3000/api/tasks/1 \
-H "Content-Type: application/json" \
-d '{
  "title": "Lập báo cáo chi tiết 11",
  "description": "Bổ sung thông tin chi tiết vào báo cáo 22",
  "status": "In Progress"
}'

curl -X DELETE http://localhost:3000/api/tasks/123

