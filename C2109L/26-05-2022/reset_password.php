<?php
    include './database.php';  
    if(isset($_POST['submit'])) {        
        //print_r($_POST);
        $user_name = htmlspecialchars($_POST['user_name'] ?? ''); //nil coalescing from "Apple's swift"
        $phone_number = htmlspecialchars($_POST['phone_number'] ?? '');
        if(empty($user_name) || empty($phone_number)) {
            $error_message = "You must enter username, phone";            
        } else {
            $sql = "SELECT COUNT(*) AS count FROM abc12users WHERE username='$user_name' AND phone='$phone_number'";            
            try {
                $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                $statement = $connection->prepare($sql); 
                $statement->execute();
                $statement->setFetchMode(PDO::FETCH_ASSOC); 
                //print_r($statement->fetchAll());
                if(intval($statement->fetchAll()[0]['count']) > 0) {
                    $new_password = substr(md5(rand()), 0, 6);
                    $sql = "UPDATE abc12users SET password_hash = ? WHERE username = ? AND phone = ?";                    
                    $connection->prepare($sql)->execute([
                        sha1($new_password),
                        $user_name,
                        $phone_number
                        ]);
                    echo "Your new password is: $new_password";
                } else {
                    echo "Wrong username or phone.Cannot reset password";
                };                

            } catch(PDOException $e) {
                echo "Cannot execute sql: " . $e->getMessage();
            } 
        }
        //echo "$user_name, $password, $phone_number";
        //var_export($_POST);
        
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
    <p>Reset password Form</p>
    <form 
        action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>"
        method="POST">
    <table>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="user_name"></td>
        </tr>                
        <tr>
            <td>Phone number</td>
            <td><input type="text" name="phone_number"></td>
        </tr>                
    </table>    
    <input type="submit" name='submit' value="Reset">
    </form>    
</body>
</html>