<?php
    include './database.php';         
    if(isset($_GET['id'])) {
        $id = $_GET['id'];        
        try {
            $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $sql = "DELETE FROM tblPerson WHERE id = ?";              
            $connection->prepare($sql)->execute([$id]);            
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