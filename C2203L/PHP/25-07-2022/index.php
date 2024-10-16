<?php
    //echo "<h1>Chao ban</h1>";
    // print ("<h1>hjaha<h1>");
    $x = 100;
    $y = 300;
    //echo "x = ${x}", "y = ${y}"; 
    //print "x = ${x}", "y = ${y}"; 
    //string concatenation
    $message = "x = ${x}, y = ${y}";
    $message2 = "x = ".$x.", y = ".$y;
    $sum = $x + $y;
    echo "<p>".$message."</p>";
    echo $sum;
    //PHP receives value from client
    /*
    if(isset($_GET['a'])) {
        $a = $_GET['a'];
    } else {
        $a = 0;
    }
    $a = isset($_GET['a']) ? isset($_GET['a']) : 0;
    */
    $a = isset($_GET['a']) ? intval($_GET['a']) : 0; //intval == integer value
    $b = isset($_GET['b']) ? intval($_GET['b']) : 0;    
    //$b = isset($_GET['b']) ?? 0; //?? = default value = elvis operator
    echo "haha<br>";    
    print_r($a);//print result
    print_r($b);//print result
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
    <h1><?php echo $x;?></h1>
    <h1>This is a form</h1>
    <form action="./index.php" method="get">
        <input type="text" name="a" placeholder="Enter value of a:"><br>
        <input type="text" name="b" placeholder="Enter value of b:"><br>
        <input type="submit" value="Calculate Sum">
    </form>
    <p>sum = <?php echo $a + $b; ?></p>
</body>
</html>