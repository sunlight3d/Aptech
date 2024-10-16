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
    <h1>Registration form</h1>
    <?php
        if(isset($_POST['register'])) {
            $username = htmlspecialchars( $_POST['username']);
            $password = htmlspecialchars( $_POST['password']);
            $phone = htmlspecialchars( $_POST['phone']);
            try {

            } catch(PDOException $e) {
                echo "Error in DB: ".$e->getMessage();
            }
        }
        
    ?>
    <form action="./registration.php" method="post">
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
            <tr>
                <td>Phone Number</td>
                <td>
                    <input type="text" name="phone" required>
                </td>
            </tr>
        </table>
        <input type="submit" value="Registration" name="register">
    </form>
</body>
</html>