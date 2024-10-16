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
        $retypedPassword = $_POST['retypedPassword'];
        $phone = $_POST['phone'];
        //validate
        if($password != $retypedPassword) {
            echo 'Password and retyped password must be the same';
            return;
        }
        $userId = createUser([
            'username'=> $username,
            'password'=> $password,
            'phone'=> $phone,
        ]);
        echo 'ahahahaa';
        var_dump($userId);
        if($userId > 0) { 
            //header("Location: question04.php");
            echo 'Register successfully with username = '.$username.', phone: '.$phone;
        }
    }
    
    ?>
    <form method="post" action="register.php">
        <div>
            <input type="text" name="username" placeholder="Enter username" />
        </div>
        <div>
            <input type="password" name="password" placeholder="Enter password" />
        </div>
        <div>
            <input type="password" name="retypedPassword" placeholder="Retype password" />
        </div>
        <div>
            <input type="text" name="phone" placeholder="Enter phone" />
        </div>
        <input type="submit" value="Register">
    </form>
</body>

</html>