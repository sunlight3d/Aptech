<?php
    include './database.php';         
    if(isset($_GET['id'])) {
        $id = $_GET['id'];
        $sql = "SELECT * FROM tblperson WHERE id='$id'";
        try {
            $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $statement = $connection->prepare($sql);
            $statement->execute();
            $statement->setFetchMode(PDO::FETCH_ASSOC);
            //print_r($statement->fetchAll());

            $result = $statement->fetchAll();

            if (count($result) > 0) {
                $name = $result[0]['Name'] ?? '';
                $gender = $result[0]['Gender'] ?? '';
                $dateOfBirth = $result[0]['DateOfBirth'] ?? '';
            }
        } catch (PDOException $e) {
            echo "Cannot execute sql: " . $e->getMessage();
        }
    }             
    if(isset($_POST['submit'])) {        
        $name = $_POST['name'];
        $gender = $_POST['gender'];
        $dateOfBirth = $_POST['dateOfBirth'];           
        try {
            $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $sql = "UPDATE tblPerson SET Name = ?, Gender = ?, DateOfBirth = ? WHERE id = ?";              
            $connection->prepare($sql)->execute([$name, $gender, $dateOfBirth, $_POST['id']]);            
            header("Location: /bai03.php");//redirect        
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
<form action="/update.php" method="post">
    <table>        
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="<?php echo $name?>"></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
            <input type="hidden" name="id" value="<?php echo $id;?>" >
            <input type="radio" 
                name="gender"   
                <?php if (isset($gender) && $gender=="1") echo "checked";?>              
                value="1">
                <label>Male</label><br>
            <input 
                type="radio" 
                name="gender" 
                <?php if (isset($gender) && $gender=="0") echo "checked";?>
                value="0"
                >
                <label>Female</label><br>
            </td>
        </tr>
        <tr>
            <td>DOB</td>
            <td><input type="date" name="dateOfBirth" value="<?php echo $dateOfBirth?>"></td>
        </tr>
    </table>
    <input type="submit" name='submit' value="Update"/>
</form>
</body>
</html>