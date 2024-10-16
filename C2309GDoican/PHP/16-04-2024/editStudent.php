<?php
require_once "./employee_management.php";
// Lấy student's id từ URL
$studentId = $_GET['id'] ?? 0;
$employeeManagement = new EmployeeManagement();
// Gọi hàm lấy thông tin student từ id
$student = $employeeManagement->getEmployeeById($studentId);

// Kiểm tra nếu không có sinh viên
if (!$student) {
    echo "Student not found";
    exit;
}
?>

<!-- Form để chỉnh sửa thông tin sinh viên -->
<form method="post" action="updateStudent.php">
    <input type="hidden" name="id" 
        value="<?php echo $student['id']; ?>">
    
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" 
        value="<?php echo $student['name']; ?>" required><br><br>

    <label for="position">Position:</label>
    <input type="text" id="position" name="position" 
        value="<?php echo $student['position']; ?>" required>
    <br><br>

    <label for="salary">Salary:</label>
    <input type="number" id="salary" 
        name="salary" value="<?php echo $student['salary']; ?>" required>
    <br><br>

    <input type="submit" value="Update">
</form>
