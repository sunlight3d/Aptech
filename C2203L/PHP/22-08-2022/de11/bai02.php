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
  if(isset($_POST['insertEmployee'])) {        
    insertEmployee($connection,Employee::fromDictionary($_POST));
    echo "<meta http-equiv='refresh' content='0'>";
  }
?>    
<style>
table, th, td {
  border:1px solid black;
}
</style>
<center>
<form action="/bai02.php" method="POST">
  <table style="width:50%">
    <tr>
      <th>Emp No</th>
      <th>Emp Name</th>
      <th>Emp Post</th>
      <th>Emp Salary</th>
    </tr>
    <?php foreach($employees as $employee) {?>
    <tr>      
      <td><?php echo $employee->employeeNo; ?></td>
      <td><?php echo $employee->employeeName; ?></td>
      <td><?php echo $employee->post; ?></td>
      <td><?php echo $employee->salary; ?></td>
    </tr>  
    <? } ?>
  </table>
  <p>Emp No</p>
  <input type="text" name="empno"/>
  <p>Emp Name</p>
  <input type="text" name="ename"/>
  <p>Emp Post</p>
  <input type="text" name="post"/>
  <p>Emp Salary</p>
  <input type="text" name="salary"/>
  <input type="submit" value="Save Infor" name="insertEmployee">
</form>
</center>
</body>
</html>
