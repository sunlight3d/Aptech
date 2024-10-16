<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method="post">
        <input type="text" name="username"/>
        <input type="submit" value="Submit name">
    </form>        
    <?php
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        echo $_POST['username'];
    }
    ?>    
</body>
</html>