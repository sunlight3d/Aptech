<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Enter your first name or lastname</h1>
    <?php
        $firstName = $_POST['firstName'] ?? '';
        $lastName = $_POST['lastName'] ?? '';
        $fullName = "${firstName} ${lastName}";
        $i = 0;
        while($i < 5) {
            echo "${i}<br>";
            $i++;
        }
    ?>
    <form action="./post_form.php" method="POST">
        <input type="text" name="firstName"><br>
        
        <input type="text" name="lastName"><br>
        <input type="submit" value="Get Full name">
    </form>
    <h1><?php echo $fullName;?></h1>
</body>
</html>git