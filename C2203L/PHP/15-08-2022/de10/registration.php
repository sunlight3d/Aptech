<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <?php 
        require './db_connection.php';
        function checkUserExists($username, $connection) {
            try {
                $statement = $connection->prepare('
                    SELECT COUNT(*) AS count FROM abc12users 
                    WHERE username=:username
                ');    
                $statement->bindParam(':username', $username, PDO::PARAM_STR);                
                $statement->execute();     
                $all_items = $statement->fetchAll();    
                //print_r($all_items);
                return $all_items[0]["count"] > 0;
            } catch(PDOException $e) {
                echo "Error in DB: ".$e->getMessage();
                return false;
            }
        }
    ?>
</head>
<body>
    <h1>Registration form</h1>
    <?php
        if(isset($_POST['register'])) {
            $username = htmlspecialchars( $_POST['username']);
            $password = htmlspecialchars( $_POST['password']);
            $phone = htmlspecialchars( $_POST['phone']);
            try {
                //check user exists
                if(checkUserExists($username, $connection) == TRUE) {
                    echo "<h3>User already exists</h3>";
                } else {
                    $statement = $connection->prepare('
                        INSERT INTO abc12users(username, password_hash, phone)
                        VALUES(:username, :password_hash, :phone)
                    ');    
                    $statement->bindParam(':username', $username, PDO::PARAM_STR);                         
                    $password_hash = sha1($password)."";
                    $statement->bindParam(':password_hash', $password_hash, PDO::PARAM_STR);        
                    $statement->bindParam(':phone', $phone, PDO::PARAM_STR);        
                    $statement->execute();   
                    echo "<h3>Register successfully with username: "
                            .$username.", phone: ".$phone."</h3>";
                }                
            } catch(PDOException $e) {
                echo "Error in DB: ".$e->getMessage();
            }
        }
        
    ?>
    <form action="./registration.php" method="post">
        <table>
            <tr>
                <td>UserName</td>
                <td>
                    <input type="text" name="username" required>
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <input type="password" name="password" required>
                </td>
            </tr>
            <tr>
                <td>Phone Number</td>
                <td>
                    <input type="text" name="phone" required>
                </td>
            </tr>
        </table>
        <input type="submit" value="Registration" name="register">
    </form>
</body>
</html>