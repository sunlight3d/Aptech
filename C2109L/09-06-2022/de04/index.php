<?php
    include './database.php';
    if(isset($_POST['submit'])) {
        $empno = $_POST['empno'] ?? "";
        $ename = $_POST['ename'] ?? "";
        $post = $_POST['post'] ?? "";
        $salary = $_POST['salary'] ?? 0;
        if($empno == "" || $ename == "" || $post == "" || $salary == 0) {
            echo "Cannot insert data, you must fill all";
        } else {
            try {
                $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                $sql = "INSERT INTO employee (empno, ename, post, salary) VALUES(?, ?, ?, ?)";  
                $connection->prepare($sql)->execute([$empno, $ename, $post, $salary]);                        
            } catch(PDOException $e) {                
                echo "Cannot insert employee: " . $e->getMessage();
            }
        }
    }
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

        </tr>
        <?php
            foreach($employees as $employee) {
                echo "<tr>";
                echo "<td>".$employee["empno"]."</td>";
                echo "<td>".$employee["ename"]."</td>";
                echo "<td>".$employee["post"]."</td>";
                echo "<td>".$employee["salary"]."</td>";
                echo "</tr>";
            }
        ?>           
    </table>
    <form method="post" action="./employee_list.php">
        <p>Employee No</p>    
        <input type="text" name="empno" />
        <p>Employee Name</p>    
        <input type="text" name="ename" />
        <p>Employee Post</p>    
        <input type="text" name="post" />
        <p>Salary</p>    
        <input type="text" name="salary" />
        <div>
            <input type="submit" name="submit" value="Save Infor">
        </div>
    </form>
</center>
    
</body>
</html>