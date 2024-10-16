<?php
    include './database.php';
    //print_r($_SERVER);
    //check whether server received request ?
    //print_r($_POST);
    //var_export($_POST); //show detail object, except types
    //var_dump($_POST); //show detail object, include types    
    //print "toi ten la";
    $error_message = '';

    if(isset($_POST['submit'])) {        
        //print_r($_POST);
        $user_name = htmlspecialchars($_POST['user_name'] ?? ''); //nil coalescing from "Apple's swift"
        $password = htmlspecialchars($_POST['password'] ?? '');        
        $phone_number = htmlspecialchars($_POST['phone_number'] ?? '');
        if(empty($user_name) || empty($password) || empty($phone_number)) {
            $error_message = "You must enter username, password, phone !";            
        } else {

            $sql = "SELECT COUNT(*) AS count FROM abc12users WHERE username='$user_name'";            
            try {
                $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                $statement = $connection->prepare($sql); 
                $statement->execute();
                $statement->setFetchMode(PDO::FETCH_ASSOC); 
                //print_r($statement->fetchAll());
                if(intval($statement->fetchAll()[0]['count']) > 0) {
                    echo "User exists";
                } else {
                    //ok to insert
                    //echo "ok to insert";
                    $sql = "INSERT INTO abc12users(username, password_hash, phone) VALUES(?, ?, ?)";                    
                    $generated_password = sha1($password);
                    $connection->prepare($sql)->execute([$user_name, $generated_password, $phone_number]);
                    echo "<p>Register user successfully<p>";
                    echo "<p>Username = $user_name, phone = $phone_number</p>";
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
    <p>Registration Form</p>
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
        <tr>
            <td>Phone number</td>
            <td><input type="text" name="phone_number"></td>
        </tr>                
    </table>
    <p style="color: red;"><?php echo $error_message; ?></p>
    <input type="submit" name='submit' value="Registration">
    </form>    
</body>
</html>