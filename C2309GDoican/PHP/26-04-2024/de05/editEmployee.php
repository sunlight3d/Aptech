<?php
require_once "./employee_management.php";
require_once "./department_management.php";
// Lấy employee's id từ URL
$employeeId = $_GET['id'] ?? 0;
$employeeManagement = new EmployeeManagement();
$departmentManagement = new DepartmentManagement();
$employee = $employeeManagement->getEmployeeById($employeeId);

$departments = $departmentManagement->getAlldepartments();
//var_dump($departments);
if (!$employee) {
    echo "employee not found";
    exit;
}
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Lấy dữ liệu từ form
    $id = $_POST['id'] ?? 0;
    $name = $_POST['name'] ?? '';
    $age = $_POST['age'] ?? '';
    $sex = $_POST['sex'] ?? '';

    $selectedDepartmentId = $_POST['selectedDepartmentId'] ?? 0;    
    // Kiểm tra dữ liệu
    if (empty($name) || empty($age) || empty($selectedDepartmentId)) {
        echo "All fields are required!";
        exit;
    }    
    $employeeManagement->updateEmployee($id, $name, $selectedDepartmentId, $age, $sex);
    header('Location: question03.php');//router
    exit; // Dừng kịch bản sau khi chuyển hướng
}

?>

<!-- Form để chỉnh sửa thông tin sinh viên -->
<form method="post">
    <input type="hidden" name="id" 
        value="<?php echo $employee['id']; ?>">
    <table>
        <tr>
            <td>
                Name
            </td>
            <td>
            <input type="text" id="name" name="name" 
                value="<?php echo $employee['name']; ?>" required>
            </td>
        </tr>
        <tr>
            <td>
                Age
            </td>
            <td>
            <input type="text" id="age" name="age" 
                value="<?php echo $employee['age']; ?>" required>
            </td>
        </tr>
        <tr>
            <td>
                Sex
            </td>
            <td>
                <input type="radio" name="sex" value="Male">
                  <label>Male</label>
                  <input type="radio" name="sex" value="Female">
                  <label>Female</label>
            </td>
        </tr>
        <tr>
            <td>
                Department
            </td>
            <td>
                <select name="selectedDepartmentId">
                    <?php foreach ($departments as $department): ?>
                        <option value="<?php echo htmlspecialchars($department['id']); ?>">
                            <?php echo htmlspecialchars($department['name']); ?>
                        </option>
                    <?php endforeach; ?>
                </select>
            </td>

        </tr>

    </table>    

    <input type="submit" value="Update">
</form>
