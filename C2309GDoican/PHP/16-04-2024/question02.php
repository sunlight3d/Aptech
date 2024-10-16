<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        /* CSS để tạo các dòng xen kẽ */
        tr:nth-child(even) {
            background-color: red; 
        }
    </style>
</head>
<body>
<?php
    // Include the database connection function
    //require_once 'db_connect.php';

    // Call the function to establish a database connection
    //$pdo = connectToDatabase();

    // Now you can use the $pdo object to perform database operations
    // For example, you can execute a SQL query:
    /*
    $statement = $pdo->query("SELECT * FROM employees");
    $result = $statement->fetchAll(PDO::FETCH_ASSOC);
    print_r($result);
    */
    require_once "./employee_management.php";
    $employeeManagement = new EmployeeManagement();
    //$employeeManagement->createEmployee("Nguyen vAn xx 12", "sales", 12345);
    $students = $employeeManagement->getAllEmployees();    
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        // Xử lý dữ liệu được gửi bằng phương thức POST ở đây
        $name = $_POST['name'] ?? '';
        $position = $_POST['position'] ?? '';
        $salary = $_POST['salary'] ?? '';
        $employeeManagement->createEmployee( $name, $position, $salary);
        header('location: ./question02.php');
    }
?>

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Position</th>
            <th>Salary</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($students as $student): ?>
            <tr>
                <td><?php echo $student['name']; ?></td>
                <td><?php echo $student['position']; ?></td>
                <td><?php echo $student['salary']; ?></td>
                <td>                    
                    <a href="editStudent.php?id=<?php echo $student['id']; ?>">Edit</a>
                </td>
                <td>
                    <a href="#" class="delete-link" data-id="<?php echo $student['id']; ?>" style="color: red;">Delete</a>
                </td>
            </tr>
        <?php endforeach; ?>
    </tbody>    
</table>

<form method="post" action="question02.php">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="position">Position:</label>
        <input type="text" id="position" name="position" required><br><br>

        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" required><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
<script>
    // Bắt sự kiện click vào link Delete
    document.addEventListener('DOMContentLoaded', function() {
        const deleteLinks = document.querySelectorAll('.delete-link');

        deleteLinks.forEach(link => {
            link.addEventListener('click', function(event) {
                event.preventDefault();
                const studentId = this.getAttribute('data-id');
                
                // Hiển thị thông báo xác nhận
                const isDelete = confirm('Bạn có chắc chắn muốn xóa nhân viên này không?');
                
                if (isDelete) {
                    // Nếu đồng ý xóa, chuyển hướng đến trang deleteStudent.php
                    window.location.href = `deleteStudent.php?id=${studentId}`;
                }
            });
        });
    });
</script>
</html>