<?php
    include './database.php';  
    if(isset($_POST['submit'])) {        
        //print_r($_POST);
        $user_name = htmlspecialchars($_POST['user_name'] ?? ''); //nil coalescing from "Apple's swift"
        $password = htmlspecialchars($_POST['password'] ?? '');
        $new_password = htmlspecialchars($_POST['new_password'] ?? '');
        if(empty($user_name) || empty($password) || empty($new_password)) {
            $error_message = "You must enter username, password, new password";            
        } else {
            $sql = "SELECT COUNT(*) AS count FROM abc12users WHERE ".
                    "username='$user_name' ".
                    "AND password_hash='".sha1($password)."'";            
            try {
                $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                $statement = $connection->prepare($sql); 
                $statement->execute();
                $statement->setFetchMode(PDO::FETCH_ASSOC); 
                //print_r($statement->fetchAll());
                if(intval($statement->fetchAll()[0]['count']) > 0) {                    
                    $sql = "UPDATE abc12users SET password_hash = ? ".
                    "WHERE username = ?";                    
                    $connection->prepare($sql)->execute([
                        sha1($new_password),
                        $user_name                    
                        ]);
                    echo "Change password successfully";
                } else {
                    echo "Cannot change password";
                };                
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
    <p>Change password Form</p>
    <form 
        action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>"
        method="POST">
    <table>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="user_name"></td>
        </tr>                
        <tr>
            <td>Current password</td>
            <td><input type="password" name="password"></td>
        </tr>                
        <tr>
            <td>New password</td>
            <td><input type="password" name="new_password"></td>
        </tr>                
    </table>        
    <input type="submit" name='submit' value="Change" />
    </form>    
</body>
</html>