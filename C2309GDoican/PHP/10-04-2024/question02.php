<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
?>

</body>
</html>