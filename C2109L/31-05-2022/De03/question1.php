<?php
    $name = $_GET['name'] ?? '';
    $message = empty($name) ? "" : "Hello $name";
    //convert string to array
    $sub_names = explode(' ', $name);
    $message2 = '';    
    foreach ($sub_names as $key => $sub_name) {        
        $message2 = $message2.($key == 0 ? "" : " ")
                ."<span style='color: red'>"
                .$sub_name[0]."</span>"
                .substr($sub_name, 1);        
    }    
?>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Please input your name:</h1>    
    <form action="./question1.php" method="get">
        <input type="text" name="name" />
        <input type="submit" value="Submit">
        <h3><?php echo $message; ?></h3>
        <p><?php echo $message2?></p>
    </form>
</body>
</html>