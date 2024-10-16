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
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <p>Theme:</p>
            <label><input type="radio" name="theme" value="Light" checked> Light</label>
            <label><input type="radio" name="theme" value="Dark"> Dark</label>
        </div>
        <div>
            <p>Remember me for:</p>
            <label><input type="radio" name="remember" value="5s" checked> 5 Seconds</label>
            <label><input type="radio" name="remember" value="Forever"> Forever</label>
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
    </form>
</body>
</html>
<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = isset($_POST['username']) ? $_POST['username'] : '';
    $password = isset($_POST['password']) ? $_POST['password'] : '';
    $theme = isset($_POST['theme']) ? $_POST['theme'] : 'Light'; // Default to Light theme if not specified
    $remember = isset($_POST['remember']) ? $_POST['remember'] : '5s'; // Default to 5 seconds if not specified


    // Here you would typically set cookies or session variables based on the 'Remember me' choice
    // For example, setting a cookie for 5 seconds:
    if ($remember === '5s') {
        setcookie('username', $username, time() + 5, "/");
    } else {
        // If 'Forever', set a long duration
        setcookie('username', $username, time() + (10 * 365 * 24 * 60 * 60), "/"); // Lasts 10 years
    }
    $pdo = connectToDatabase();
    $pdo->query("select count(*) as numberOfUsers from user_info where username='admin' AND password = sha1('123456')");
    if(numberOfUsers > ) {echo login successfully} else {
        login failed
    }
}
?>
