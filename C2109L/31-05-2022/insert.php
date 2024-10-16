<?php
    include './database.php';    
    if(isset($_POST['submit'])) {
        $id = $_POST['id'];
        $name = $_POST['name'];
        $gender = $_POST['gender'];
        $dateOfBirth = $_POST['dateOfBirth'];        
        if(empty($id) || empty($name) || empty($gender) || empty($dateOfBirth)) {
            echo "Please input all values";
        } else {
            try {
                $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                $sql = "INSERT INTO tblPerson(Name, Gender, DateOfBirth) VALUES(?, ?, ?)";  
                $connection->prepare($sql)->execute([$name, $gender, $dateOfBirth]);
                echo "haha";
                header("Location: /bai03.php");//redirect        
            } catch(PDOException $e) {                
                echo "Cannot execute sql: " . $e->getMessage();
            }
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
<form action="/insert.php" method="post">
    <table>
        <tr>
            <td>Id</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
            <input type="radio" name="gender" value="Male">
                <label>Male</label><br>
            <input type="radio" name="gender" value="Female">
                <label>Female</label><br>
            </td>
        </tr>
        <tr>
            <td>DOB</td>
            <td><input type="date" name="dateOfBirth"></td>
        </tr>
    </table>
    <input type="submit" name='submit' value="Create"/>
</form>
</body>
</html>