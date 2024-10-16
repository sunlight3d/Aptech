<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    require_once "./employee_management.php";
    $employeeManagement = new EmployeeManagement();    
    $employeesResult = $employeeManagement->getAllemployees();          
?>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Sex</th>
            <th>Department</th>
            <th>Operation</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($employeesResult as $item): ?>
            <tr>
                <td><?php echo $item['id']; ?></td>
                <td><?php echo $item['employee_name']; ?></td>
                <td><?php echo $item['age']; ?></td>
                <td><?php echo $item['sex']; ?></td>
                <td><?php echo $item['department_name']; ?></td>                 
                <td>                    
                    <a href="editEmployee.php?id=<?php echo $item['id']; ?>">Update</a>
                </td>                
            </tr>
        <?php endforeach; ?>
    </tbody>    
</table>
<a href="insertEmployee.php">Add new</a>
</body>
</html>