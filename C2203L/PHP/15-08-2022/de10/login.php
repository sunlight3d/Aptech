<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <?php 
        require './db_connection.php';        
    ?>
</head>
<body>
    <h1>Login form</h1>
    <?php
        $error = "";
        if(isset($_POST['login'])) {
            $username = htmlspecialchars( $_POST['username']);
            $password = htmlspecialchars( $_POST['password']);            
            try {
                $statement = $connection->prepare('
                    SELECT COUNT(*) AS count FROM abc12users 
                    WHERE username=:username AND password_hash=:password_hash
                ');    
                $statement->bindParam(':username', $username, PDO::PARAM_STR);                
                $password_hash = sha1($password)."";
                $statement->bindParam(':password_hash',$password_hash, PDO::PARAM_STR);                
                
                $statement->execute();     
                $all_items = $statement->fetchAll();                    
                //print_r($all_items);
                if($all_items[0]["count"] > 0) {
                    $error = "Login successfully";
                } else {
                    $error = "Wrong username and password";
                };
            } catch(PDOException $e) {
                $error =  "Error in DB: ".$e->getMessage();                
            }
        }
        
    ?>
    <form action="./login.php" method="post">
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
        </table>
        <input type="submit" value="Login" name="login">
        <h2><?php echo $error;?></h2>
    </form>
</body>
</html>