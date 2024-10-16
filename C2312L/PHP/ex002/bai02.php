<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        $oceans = ["Pacific", "Atlantic", "Indian", "Arctic", "Southern"];
        echo "<ol>";
        foreach ($oceans as $ocean) {
            echo "<li>".$ocean."</li>";
        }
        echo "</ol>";
        $items = ['pen' => 3.45, 'notebook' => 5.25, 'eraser' => 0.99];
        $promoted_items = [];
        
        foreach ($items as $key=>$value) {
            $promoted_items[$key] = (1 + 0.15) * $value;
            echo "<h2>".$key." : ".$value."</h2>";
        }
        echo "After promotion: <br>";
        //iterate result
        foreach ($promoted_items as $key=>$value) {
            echo "<h2>".$key." : ".$value."</h2>";
        }
    ?>
</body>
</html>