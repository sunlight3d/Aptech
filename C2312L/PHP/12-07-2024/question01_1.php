<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="./question01_1.php" method="GET">
        <h1>Please input your name:</h1>
        <input type="text" name="name" />
        <input type="submit" value="Submit name">        
    </form>
    <?php
        //php server received ?
        if(isset($_GET["name"])) {
            echo "<h1>Hello ".($_GET["name"] ?? "")."</h1>"; //elvis
        } 
        
        //echo isset($_GET['name']) ? $_GET['name'] :'';
        //$x = 100;
        //print_r($x);
    ?>
</body>

</html>