<?php
// Import file db_connect.php để kết nối CSDL
require './employee_management.php';

// Kiểm tra nếu dữ liệu được gửi từ form
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Lấy dữ liệu từ form
    $id = $_POST['id'] ?? 0;
    $name = $_POST['name'] ?? '';
    $position = $_POST['position'] ?? '';
    $salary = $_POST['salary'] ?? 0;

    // Kiểm tra dữ liệu
    if (empty($name) || empty($position) || empty($salary)) {
        echo "All fields are required!";
        exit;
    }
    $employeeManagement = new EmployeeManagement();
    $employeeManagement->updateEmployee($id, $name, $position, $salary);
    header('Location: question02.php');//router
    exit; // Dừng kịch bản sau khi chuyển hướng
} else {
    echo "Invalid request!";
}
?>
