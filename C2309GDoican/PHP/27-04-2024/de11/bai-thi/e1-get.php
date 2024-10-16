<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php 
    $a = $_GET['a'] ?? 0;
    $b = $_GET['b'] ?? 0;
    $sum = $a + $b;
    echo "<h1>".$a."+".$b." = ".$sum."</h1>";        
?>
</body>
</html>