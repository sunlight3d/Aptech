<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Form</title>
    <style>
        table {
            width: 100%;
        }

        th,
        td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .pagination {
            display: flex;
            justify-content: center;
            list-style: none;
        }

        .pagination li {
            margin: 5px;
            padding: 5px;
            border: 1px solid #ddd;
        }

        .pagination li.active {
            font-weight: bold;
        }
    </style>
</head>

<body>
    <?php
    require_once 'crud_functions.php';
    $employees = readEmployees();
    ?>
    <table>
        <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Sex</th>
            <th>Department</th>
            <th>Operation</th>
        </thead>
        <?php foreach ($employees as $employee) { ?>
            <tr>
                <td><?= $employee['employee_id'] ?></td>
                <td><?= $employee['name'] ?></td>
                <td><?= $employee['age'] ?></td>
                <td><?= $employee['sex'] ?></td>
                <td><?= $employee['department'] ?></td>
                <td><a href="update_employee.php?id=<?= $employee['employee_id'];?>">
                    Update
                </a>
            </td>
            </tr>
        <?php } ?>
    </table>
    <a href="create_employee.php">Add</a>
    
</body>

</html>