<?php
    include './database.php';
    if(isset($_POST['submit'])) {        
        //print_r($_POST);
        $user_name = htmlspecialchars($_POST['user_name'] ?? ''); //nil coalescing from "Apple's swift"
        $password = htmlspecialchars($_POST['password'] ?? '');        
        if(empty($user_name) || empty($password)) {
            $error_message = "You must enter username, password";            
        } else {

            $sql = "SELECT * FROM abc12users WHERE username='$user_name'";            
            try {
                $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                $statement = $connection->prepare($sql); 
                $statement->execute();
                $statement->setFetchMode(PDO::FETCH_ASSOC); 
                //print_r($statement->fetchAll());
                $result = $statement->fetchAll();                
                if(count($result) > 0) {
                    //find user with user name, compare password
                    $password_hash = $result[0]['password_hash'];
                    if($password_hash == sha1($password)) {
                        echo "Login successful";
                    } else {
                        echo "wrong username or password";
                    }
                    // echo $password_hash."<br>";
                    // echo sha1($password)."<br>";
                } else {
                    echo "wrong username or password";
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
    <p>Login Form</p>
    <form 
        action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>"
        method="POST">
    <table>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="user_name"></td>
        </tr>        
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>                
    </table>    
    <input type="submit" name='submit' value="Login">
    </form>    
</body>
</html>