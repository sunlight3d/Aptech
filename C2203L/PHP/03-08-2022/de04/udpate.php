<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<?php
    require './db_connection.php';    
?>
<body>
<?php    
    if(isset($_POST["submit"])) {
        $name = isset($_POST['name']) ? htmlspecialchars($_POST['name']) : '';
        $gender = isset($_POST['gender']) ? htmlspecialchars($_POST['gender']): 'male';
        $dateOfBirth = $_POST['dateOfBirth'];
        $gender = $gender == 'male';        
        try {
            $statement = $connection->prepare('
                UPDATE tblPerson 
                SET name=:name, gender=:gender, dateOfBirth:dateOfBirth)
                WHERE ID = :ID
            ');    
            $statement->bindParam(':name', $name, PDO::PARAM_STR);
            $statement->bindParam(':gender', $gender, PDO::PARAM_INT);
            $statement->bindParam(':dateOfBirth', $dateOfBirth, PDO::PARAM_STR);            
            $statement->execute();                 
            header('location: /de04/question03.php');
        } catch(PDOException $e) {
            echo "haha3";
            echo "Error in DB: ".$e->getMessage();
        }

    }
    
?>
<form action="/de04/update.php" method="POST">
    <table>    
    <tr>
        <td>
            ID
        </td>
        <td>
           <input type="text" name="name" readonly value="<?php echo?>">
        </td>
        </tr>   
        <tr>
            <td>
                Name
            </td>
            <td>
                <input type="text" name="name" required >
            </td>
        </tr>   
        <tr>
            <td>
                Gender
            </td>
            <td>
                <input type="radio" name="gender" checked value="male" >
                 <label>Male</label>
                <input type="radio" name="gender" value="female">
                <label>Fermale</label>
            </td>
        </tr>
            <td>
                DOB
            </td>
            <td>
                <input type="date" name="dateOfBirth" required>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit" name="submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>