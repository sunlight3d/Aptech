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
    $foundUser = [];
    if(isset($_GET["personID"])){
        $personID = htmlspecialchars($_GET["personID"]);
        //Get person object from personID    
        try {
            $statement = $connection->prepare('
                SELECT * FROM tblPerson WHERE ID=:id
            ');    
            $statement->bindParam(':id', $personID, PDO::PARAM_STR);        
            $statement->execute();     
            $foundUser = $statement->fetch();              
            //var_dump($foundUser["DateOfBirth"]);  
            //var_dump(date_format(new DateTime($foundUser["DateOfBirth"]),"Y/m/d")); 

        }catch(PDOException $e) {
            echo "Cannot connect DB: $e->getMessage()";
        }
    }        
?>
<body>
<?php    
    if(isset($_POST["Create"])) {        
        $name = isset($_POST['name']) ? htmlspecialchars($_POST['name']) : '';
        $gender = isset($_POST['gender']) ? htmlspecialchars($_POST['gender']): 'male';
        $dateOfBirth = $_POST['dateOfBirth'];
        $gender = $gender == 'male';        
        
        $foundUser["ID"] = $_POST['ID'];
        $foundUser["Name"] = $name;
        $foundUser["Gender"] = $gender;
        $foundUser["DateOfBirth"] = $dateOfBirth;        
        try {
            $statement = $connection->prepare('
                UPDATE tblPerson SET name=:name, gender=:gender, dateOfBirth=:dateOfBirth WHERE ID = :ID
            ');    
            $statement->bindParam(':ID', $foundUser["ID"], PDO::PARAM_INT);
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
           <input type="text" name="ID" readonly value="<?php echo $foundUser['ID']?>">
        </td>
        </tr>   
        <tr>
            <td>
                Name
            </td>
            <td>
            <input type="text" name="name" 
                value="<?php echo $foundUser['Name']?>" required>                
            </td>
        </tr>   
        <tr>
            <td>
                Gender
            </td>
            <td>
                <input type="radio" name="gender"                      
                    <?php echo ($foundUser["Gender"] == 1) ?  "checked" : "" ;  ?>
                    value="male" >
                 <label>Male</label>
                <input type="radio" name="gender" 
                    <?php echo ($foundUser["Gender"] == 0) ?  "checked" : "" ;  ?>
                    value="female">
                <label>Female</label>
            </td>
        </tr>
            <td>
                DOB
            </td>
            <td>
                <input type="date" name="dateOfBirth" 
                value="<?php echo date_format(new DateTime($foundUser["DateOfBirth"]),"Y-m-d"); ?>" 
                required>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create" name="Create">
            </td>
        </tr>
    </table>
</form>
</body>
</html>