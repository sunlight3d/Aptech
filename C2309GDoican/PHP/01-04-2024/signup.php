<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
        <div>
            <input type="text" name="username" placeholder="Enter username" required/>
        </div>
        <div>
            <input type="email" name="email" placeholder="Enter email" required/>
        </div>
        <div>
            <input type="password" name="password" placeholder="enter password" required/>
        </div>
        <div>
            <input type="password" name="confirmPassword" placeholder="Re enter password" required/>
        </div>
        <div>
            <input type="Submit" value="Register user" />
        </div>        
    </form>
    <?php
        //$username = isset($_POST["username"]) ? $_POST["username"] : "";
        $username = $_POST["username"] ?? ""; 
        $email = $_POST["email"] ?? ""; 
        $password = $_POST["password"] ?? ""; 
        $confirmPassword = $_POST["confirmPassword"] ?? ""; 
        
        if(empty($username) && empty($email) && empty($password) ) {
            return;
        }
        if(strlen($username) < 5) {
            echo "username must be at least 5 characters";
            return;
        }
        if(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            //inValid email
            echo "inValid email";
            return;
       }
       if(strlen($password) < 3) {
        echo "password must be at least 3 characters";
        return;
       }
       if(strcmp($password, $confirmPassword) != 0) {
        echo "Password and confirm password are not the same";
        return;
       }
       echo "All information is ok";        

    ?>
</body>
</html>