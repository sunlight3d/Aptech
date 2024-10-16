<?php
    include './database.php';         
    if(isset($_GET['empno'])) {
        $empno = $_GET['empno'];
        $sql = "SELECT * FROM employee WHERE empno='$empno'";
        try {
            $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $statement = $connection->prepare($sql);
            $statement->execute();
            $statement->setFetchMode(PDO::FETCH_ASSOC);
            //print_r($statement->fetchAll());

            $result = $statement->fetchAll();

            if (count($result) > 0) {
                $empno = $result[0]['empno'] ?? '';
                $ename = $result[0]['ename'] ?? '';
                $post = $result[0]['post'] ?? '';
                $salary = $result[0]['salary'] ?? '';
            }
        } catch (PDOException $e) {
            echo "Cannot execute sql: " . $e->getMessage();
        }
    }             
    if(isset($_POST['submit'])) {        
        $empno = $_POST['empno'];
        $ename = $_POST['ename'];
        $post = $_POST['post'];
        $salary = $_POST['salary'];
        try {
            $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $sql = "UPDATE employee SET empno = ?, ename = ?, post = ?, salary = ? WHERE empno = ?";              
            $connection->prepare($sql)->execute([$empno, $ename, $post, $salary, $_POST['empno']]);              
            header("Location: ./employee_list.php");//redirect   
        } catch(PDOException $e) {                
            echo "Cannot execute sql: " . $e->getMessage();
        }
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
        <h1>Update Employee's information</h1>
        <form method="post" action="./update.php">
            <table>
                <tr>
                    <td>Emp No</td>
                    <td><input type="text" name="empno"
                        value=<?php echo $empno?>
                    ></td>
                </tr>
                <tr>
                    <td>Emp Name</td>
                    <td><input type="text" name="ename"
                        value=<?php echo $ename?>
                    ></td>
                </tr>
                <tr>
                    <td>Post</td>
                    <td><input type="text" name="post"
                    value=<?php echo $post?>
                    ></td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td><input type="text" name="salary"
                    value=<?php echo $salary?>
                    ></td>
                </tr>
            </table>        
            <input type="submit" value="Update" name="submit">
        </form>
        
    </center>
</body>
</html>