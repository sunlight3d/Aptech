##Thêm mới một task
curl -X POST http://localhost:3000/tasks \
-H "Content-Type: application/json" \
-d '{
  "title": "Lập báo cáo tuần",
  "description": "Viết báo cáo tổng kết công việc tuần này",
  "status": "Pending"
}'

##Lấy danh sách tất cả các task
curl -X GET http://localhost:3000/tasks


##Cập nhật thông tin một task:
 curl -X PUT http://localhost:3000/tasks/123 \
-H "Content-Type: application/json" \
-d '{
  "title": "Lập báo cáo chi tiết",
  "description": "Bổ sung thông tin chi tiết vào báo cáo",
  "status": "In Progress"
}'

curl -X DELETE http://localhost:3000/tasks/123

