<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php 
  require './employee_repository.php'; 
  $employees = findAllEmployees($connection);     
  if(isset($_GET['deletedEmployeeNo'])) {
    $deletedEmployeeNo = htmlspecialchars($_GET['deletedEmployeeNo']);      
    deleteEmployee($connection, $deletedEmployeeNo);  
    header('Location: /employee_list.php');
  }        
?>        
<center>
<form action="/bai02.php" method="POST">
  <table style="width:50%">
    <tr>
      <th>Emp No</th>
      <th>Emp Name</th>      
      <th>Emp Salary</th>
    </tr>
    <?php foreach($employees as $employee) { ?>
    <tr>      
      <td><?php echo $employee->employeeNo; ?></td>
      <td><?php echo $employee->employeeName; ?></td>      
      <td>
        <a href="/edit_employee.php?employeeNo=<?php echo $employee->employeeNo; ?>">
            Edit</a>
        <a href="/employee_list.php?deletedEmployeeNo=<?php echo $employee->employeeNo; ?>">
        Delete</a>
    </td>
    </tr>  
    <?php } ?>
  </table>

</form>
</center>
</body>
</html>