<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
</head>
<body>
<form method="POST">
    <div>
        <label class="label" for="username">Username:</label>
        <input type="text" id="username" name="username">
    </div>
    <div>
        <label class="label" for="password">Password:</label>
        <input type="password" id="password" name="password">
    </div>
    <div>
        <p class="label">Theme:</p>
        <label class="label"><input type="radio" name="theme" value="Light" checked> Light</label>
        <label class="label"><input type="radio" name="theme" value="Dark"> Dark</label>
    </div>
    <div>
        <p class="label">Remember me for:</p>
        <label class="label"><input type="radio" name="remember" value="5s" checked> 5 Seconds</label>
        <label class="label"><input type="radio" name="remember" value="Forever"> Forever</label>
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>

</body>
<script>
    document.addEventListener('DOMContentLoaded', function () {
    const themeRadios = document.querySelectorAll('input[name="theme"]');
    const labels = document.querySelectorAll('.label');

    function changeBackground() {
        const themeColor = this.value === 'Light' ? 'white' : 'black';
        const textColor = this.value === 'Light' ? 'black' : 'white';
        document.body.style.backgroundColor = themeColor;
        
        labels.forEach(label => {
            label.style.color = textColor;
        });
    }

    themeRadios.forEach(radio => {
        radio.addEventListener('change', changeBackground);
    });
});

</script>
</html>
<?php
require_once './e3-init.php';
$mang = array(
    [4,6,5,3],
    [5,3,2,9,34,68,78]
);
//$mang[0] => [4,6,5,3]
//$mang[1] => [5,3,2,9,34,68,78]
/*
foreach($mang[1] as $item) {
    echo $item;
}
*/
forEach($mang as $items){    
    
    forEach($items as $eachNumber){
        echo "$eachNumber ,";
    }
    echo "<br/>";
    
 };
die();
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = isset($_POST['username']) ? $_POST['username'] : '';
    $password = isset($_POST['password']) ? $_POST['password'] : '';
    $theme = isset($_POST['theme']) ? $_POST['theme'] : 'Light'; // Default to Light theme if not specified
    $remember = isset($_POST['remember']) ? $_POST['remember'] : '5s'; // Default to 5 seconds if not specified
    $pdo = connectToDatabase();

    //$pdo->query("USE exam");        

    //echo "username: $username, password: $password, theme: $theme, remember: $remember";    

    if(empty($username)) {
        echo "<p style='color: red;'>Username cannot be empty</p>";
        return;
    }
    if(empty($password)) {
        echo "<p style='color: red;'>Password cannot be empty</p>";
        return;
    }
    //die();
    
    $stmt = $pdo->prepare("SELECT * FROM exam.user_info WHERE username = ?");
    $stmt->execute([$username]);   
    $user = $stmt->fetch(PDO::FETCH_ASSOC);
    if($user == null) {
        echo "<p style='color: red;'>Your username does not exist</p>";
        return;
    }

    // Here you would typically set cookies or session variables based on the 'Remember me' choice
    // For example, setting a cookie for 5 seconds:
    if ($remember === '5s') {
        setcookie('username', $username, time() + 5, "/");
    } else {
        // If 'Forever', set a long duration
        setcookie('username', $username, time() + (10 * 365 * 24 * 60 * 60), "/"); // Lasts 10 years
    }
    
    $stmt = $pdo->prepare("SELECT * FROM exam.user_info WHERE username = ? AND password = ?");
    $stmt->execute([$username, SHA1($password)]);        
    $user = $stmt->fetch(PDO::FETCH_ASSOC);
    if(isset($user)) {
        header('Location: e5-manage.php');
    }    
}
?>
