<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Day of the week</h1>
    <p>Please enter a day of the week:</p>
    <form action="" method='get'>
        <input type="text" name="day">
        <input type="submit" value="Go">
    </form>
    <?php
        if(isset($_GET['day'])) {
            $day = $_GET['day'];
            echo "You typed: ".$day;
        }
    ?>
</body>
</html>