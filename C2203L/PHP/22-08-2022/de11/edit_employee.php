<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<?php
    require './employee_repository.php';     
    if(isset($_POST['updateEmployee'])) {
        //echo "haha1";
        updateEmployee($connection, Employee::fromDictionary($_POST));
        //echo "haha2";
        header('Location: ./employee_list.php');        
    } else {
        $employeeNo = htmlspecialchars($_GET['employeeNo']);    
        $foundUser = findEmployeeById($connection, $employeeNo);    
    }
?>

<body>
    <h1>Update Employee's Information</h1>
    <form action="/edit_employee.php" method="POST">
        <table>
            <tr>
                <td>Emp No</td>
                <td><input type="int" readonly name="empno" 
                value="<?php echo $foundUser->employeeNo;?>"/></td>
            </tr>
            <tr>
                <td>Emp Name</td>
                <td><input type="text" name="ename" 
                value="<?php echo $foundUser->employeeName;?>"/></td>
            </tr>
            <tr>
                <td>Post</td>
                <td><input type="text" name="post" 
                value="<?php echo $foundUser->post;?>"/></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td><input type="int" name="salary" 
                    value="<?php echo $foundUser->salary;?>"/></td>
            </tr>
        </table>
        <input type="submit" name="updateEmployee" value="Update"/>
    </form>
</body>
</html>