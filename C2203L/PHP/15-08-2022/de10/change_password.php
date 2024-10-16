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
    <h1>Change password</h1>
    <?php
        $error = "";
        $message = "";
        if(isset($_POST['change'])) {
            $username           = htmlspecialchars( $_POST['username']);
            $currentPassword    = htmlspecialchars( $_POST['currentPassword']);            
            $newPassword        = htmlspecialchars( $_POST['newPassword']);            
            try {
                $statement = $connection->prepare('
                    SELECT COUNT(*) AS count FROM abc12users 
                    WHERE username=:username AND password_hash=:currentPassword
                ');    
                $statement->bindParam(':username', $username, PDO::PARAM_STR);                                                
                $hashedPassword = sha1($currentPassword)."";
                $statement->bindParam(':currentPassword',$hashedPassword, PDO::PARAM_STR);                
                
                $statement->execute();     
                $all_items = $statement->fetchAll();                    
                $hasThatUser = $all_items[0]["count"] > 0;
                if($hasThatUser) {                    
                    $statement = $connection->prepare('
                        UPDATE abc12users SET password_hash=:password_hash 
                        WHERE username=:username
                    ');    
                    $statement->bindParam(':username', $username, PDO::PARAM_STR);     
                    $hashedPassword = sha1($newPassword)."";                                        
                    $statement->bindParam(':password_hash', $hashedPassword, PDO::PARAM_STR);                            
                    $statement->execute();                               
                    $message = "Change password successfully";
                } else {
                    $error = "Wrong username and password";
                    $message = "";
                };
            } catch(PDOException $e) {
                $error =  "Error in DB: ".$e->getMessage();                
                $message = "";
            }
        }
        
    ?>
    <form action="./change_password.php" method="post">
        <table>
            <tr>
                <td>UserName</td>
                <td>
                    <input type="text" name="username" required>
                </td>
            </tr>
            <tr>
                <td>Current password</td>
                <td>
                    <input type="password" name="currentPassword" required>
                </td>
            </tr>            
            <tr>
                <td>New password</td>
                <td>
                    <input type="password" name="newPassword" required>
                </td>
            </tr>            
        </table>
        <input type="submit" value="Change" name="change">
        <h2><?php echo $error;?></h2>
        <h2><?php echo $message;?></h2>
    </form>
</body>
</html>