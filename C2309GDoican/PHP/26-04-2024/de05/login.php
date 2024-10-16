<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method="post" action="login.php">    
    <table>
        <tr>
            <td>
                Username
            </td>
            <td>
                <input type="text" name="username" required/>
            </td>
        </tr>
        <tr>
            <td>
                Password
            </td>
            <td>
                <input type="password" name="password" required/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Login"/>
            </td>
            <td>
                
            </td>
        </tr>
    </table>
    </form>
    <?php
    // Kiểm tra nếu là phương thức POST
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $username = $_POST['username'] ?? '';
        $password = $_POST['password'] ?? '';
        $expired_time = 3600 * 24 *30; //30 days        
        setcookie("username", $username, time() + $expired_time); 
        setcookie("password", $password, time() + $expired_time);         
        header('location: ./details.php');
    }    
    ?>    
</body>
</html>