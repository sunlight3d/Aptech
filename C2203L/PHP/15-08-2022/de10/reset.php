<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <?php 
        require './db_connection.php';        
        function generateString($length = 10) {
            $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
            $charactersLength = strlen($characters);
            $randomString = '';
            for ($i = 0; $i < $length; $i++) {
                $randomString .= $characters[rand(0, $charactersLength - 1)];
            }
            return $randomString;
        }
    ?>
</head>
<body>
    <h1>Reset password</h1>
    <?php
        $error = "";
        $message = "";
        if(isset($_POST['reset'])) {
            $username = htmlspecialchars( $_POST['username']);
            $phone = htmlspecialchars( $_POST['phone']);            
            try {
                $statement = $connection->prepare('
                    SELECT COUNT(*) AS count FROM abc12users 
                    WHERE username=:username AND phone=:phone
                ');    
                $statement->bindParam(':username', $username, PDO::PARAM_STR);                                
                $statement->bindParam(':phone',$phone, PDO::PARAM_STR);                
                
                $statement->execute();     
                $all_items = $statement->fetchAll();                    
                //print_r($all_items);
                if($all_items[0]["count"] > 0) {
                    $new_password = generateString(6);
                    $statement = $connection->prepare('
                        UPDATE abc12users SET password_hash=:password_hash 
                        WHERE username=:username AND phone=:phone
                    ');    
                    $statement->bindParam(':username', $username, PDO::PARAM_STR);                         
                    $password_hash = sha1($new_password)."";
                    $statement->bindParam(':password_hash', $password_hash, PDO::PARAM_STR);        
                    $statement->bindParam(':phone', $phone, PDO::PARAM_STR);        
                    $statement->execute();                               
                    $message = "Your new password is :".$new_password;
                } else {
                    $error = "Wrong username and phone";
                    $message = "";
                };
            } catch(PDOException $e) {
                $error =  "Error in DB: ".$e->getMessage();                
                $message = "";
            }
        }
        
    ?>
    <form action="./reset.php" method="post">
        <table>
            <tr>
                <td>UserName</td>
                <td>
                    <input type="text" name="username" required>
                </td>
            </tr>
            <tr>
                <td>Phone</td>
                <td>
                    <input type="text" name="phone" required>
                </td>
            </tr>            
        </table>
        <input type="submit" value="reset" name="reset">
        <h2><?php echo $error;?></h2>
        <h2><?php echo $message;?></h2>
    </form>
</body>
</html>