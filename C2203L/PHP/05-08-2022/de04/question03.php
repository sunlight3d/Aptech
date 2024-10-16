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
  <?php
    if(isset($_GET['deletedPersonID'])) {
      try {
        $statement = $connection->prepare('
            DELETE FROM tblPerson WHERE ID = :ID
        ');    
        $statement->bindParam(':ID', $_GET['deletedPersonID'], PDO::PARAM_INT);        
        $statement->execute();                 
        header('location: /de04/question03.php');
      } catch(PDOException $e) {          
          echo "Error in DB: ".$e->getMessage();
      }
    }
  ?>
    <?php forEach($all_items as $person ) {?>
        <tr>
        <td><?php echo $person["ID"];?></td>
        <td><?php echo $person["Name"];?></td>
        <td><?php echo $person["Gender"];?></td>
        <td><?php echo $person["DateOfBirth"];?></td>        
        <td>
            <a href="/de04/update.php?personID=<?php echo $person["ID"];?>">Update</a>
            <a href="/de04/question03.php?deletedPersonID=<?php echo $person["ID"];?>">Delete</a>        
        </td>    
        </tr>  
    <?php }?>
    
  
</table>
<a href="/de04/addnew.php">Create</a>
</center>


</body>
</html>