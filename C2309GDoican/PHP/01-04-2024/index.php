<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>chao ban</h1>
    <?php
    echo "<h2 style='color:red;'>Hello, PHP!</h2>";
    
    // Define the array
    $names = ["NGuyEn vAn A", "TRan vaN B"];

    // Loop through each item in the array
    foreach ($names as $name) {
        // Convert each item to lowercase
        $name = strtolower($name);
        
        // Convert each item using ucwords()
        $name = ucwords($name);
        
        // Output the converted name
        echo "<p>$name</p>";
    }
    
?>
</body>
</html>