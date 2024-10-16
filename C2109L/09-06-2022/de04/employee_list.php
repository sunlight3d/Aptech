<?php
    include './database.php';    
    $employees = [];    
    $sql = "SELECT * FROM employee";                            
        try {
            $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $statement = $connection->prepare($sql);
            $statement->execute();
            $statement->setFetchMode(PDO::FETCH_ASSOC);
            $employees = $statement->fetchAll();      
            //echo "fetch employees successfully";
        } catch (PDOException $e) {
            echo "Cannot execute sql: " . $e->getMessage();
        }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>    
<center>
<table>
        <tr>
            <th>Emp No</th>
            <th>Emp Name</th>                
            <th>Emp Post</th>                
            <th>Emp Salary</th>                
            <th></th>
        </tr>
        <?php
            foreach($employees as $employee) {
                echo "<tr>";
                echo "<td>".$employee["empno"]."</td>";
                echo "<td>".$employee["ename"]."</td>";
                echo "<td>".$employee["post"]."</td>";
                echo "<td>".$employee["salary"]."</td>";
                echo "<td><a href='./update.php?empno=".$employee["empno"]."'>Edit Info</a></td>";
                echo "</tr>";
            }
        ?>           
    </table>    
</center>
    
</body>
</html>