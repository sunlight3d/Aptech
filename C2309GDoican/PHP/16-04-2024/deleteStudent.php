<?php
// Import file db_connect.php để kết nối CSDL
require './employee_management.php';

// Kiểm tra nếu phương thức yêu cầu là GET và có tồn tại tham số id
if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['id'])) {
    $id = $_GET['id'] ?? 0; // Lấy id từ tham số truyền vào
    $employeeManagement = new EmployeeManagement();
    $employeeManagement->deleteEmployee($id);
    header('Location: question02.php');    
    exit;     
} else {
    echo "Invalid request!";
}
?>
