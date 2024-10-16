<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h2>Enter X and Y values:</h2>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" 
        method="get">
        <label for="x">X:</label>
        <input type="text" id="x" name="x"><br><br>
        <label for="y">Y:</label>
        <input type="text" id="y" name="y"><br><br>
        <input type="submit" value="Submit">
    </form>
    <?php
        // Retrieve X and Y values from the POST request
        $x = $_GET['x'] ?? 0;
        $y = $_GET['y'] ?? 0;                
        // Convert the values to integers
        $x = intval($x);
        $y = intval($y);
        if($x > 10) {
            echo "x is greater than 10";
        } else {
            echo "x is smaller than 10";
        }
        // Calculate the sum
        $sum = $x + $y;
        if($x != 0 && $y != 0) {
            echo "<h1>The sum of $x and $y is: $sum<h1>";
        } else {
            echo "<h1 style='color:red;'>Please input x, y<h1>";
        }
        // Return the sum
        
        ?>
</body>
</html>