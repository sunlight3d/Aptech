<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php 
        function reverseString($inputString) {
            $outputString = "";
            for( $i = strlen($inputString) - 1; $i >= 0; $i--) {
                $outputString = $outputString.$inputString[$i];
            }
            return $outputString;
        }
        echo "<h1>Current year is : ".date("Y")."</h1>";
        echo "<h2>reverse of Olympic is: ".reverseString("Olympic")."</br></h2>";
    ?>
</body>
</html>