<?php
    require './db_connection.php';    
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
table {  
  border-collapse: collapse;
  width: 50%;
}

td, th {
  border: 1px solid black;
  text-align: left;  
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<?php
    $limit = 10;    
    $page = isset($_GET['page']) ? $_GET['page'] : 0;    
    $offset = $page * $limit; 
      
    $statement = $connection->prepare('
        SELECT * FROM tblitem LIMIT :limit OFFSET :offset
    ');    
    $statement->bindParam(':limit', $limit, PDO::PARAM_INT);
    $statement->bindParam(':offset', $offset, PDO::PARAM_INT);
    $statement->execute();     
    $all_items = $statement->fetchAll();        
?>
<center>
    <table>
    <tr>
        <th>ID</th>
        <th>Name</th>    
    </tr>
    <?php foreach ($all_items as $row) {?>
        <tr>
            <td><?php echo $row['ID'];?></td>
            <td><?php echo $row['name'];?></td>
        </tr>
            
    <?php } ?>                
    </table>
    <a href="#">First</a>
    <a href="#">Last</a>
</center>
<body>
    
</body>
</html>