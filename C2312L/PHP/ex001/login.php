<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>Registration</h1>
    <?php
    require_once('crud_functions.php');
    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $username = $_POST['username'];
        $password = $_POST['password'];
        $user = login($username, $password);
        if($user == null) {
            echo "Wrong username and password";
            return;
        }
        echo "Login successfully";
    }
    
    ?>
    <form method="post" action="login.php">
        <div>
            <input type="text" name="username" placeholder="Enter username" />
        </div>
        <div>
            <input type="password" name="password" placeholder="Enter password" />
        </div>
        
        <input type="submit" value="Login">
    </form>
</body>

</html>