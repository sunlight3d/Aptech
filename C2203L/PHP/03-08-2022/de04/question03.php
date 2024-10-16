<!DOCTYPE html>
<html>
<?php
    require './db_connection.php';    
?>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<body>

<h2></h2>
<?php
    $statement = $connection->prepare('SELECT * FROM tblPerson');        
    $statement->execute();     
    $all_items = $statement->fetchAll();      
?>
<center>
<table style="width:50%">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Gender</th>
    <th>DOB</th>
    <th></th>
  </tr>  
    <?php forEach($all_items as $person ) {?>
        <tr>
        <td><?php echo $person["ID"];?></td>
        <td><?php echo $person["Name"];?></td>
        <td><?php echo $person["Gender"];?></td>
        <td><?php echo $person["DateOfBirth"];?></td>        
        <td>
            <a href="#">Update</a>
            <a href="#">Delete</a>        
        </td>    
        </tr>  
    <?php }?>
    
  
</table>
<a href="/de04/addnew.php">Create</a>
</center>


</body>
</html>