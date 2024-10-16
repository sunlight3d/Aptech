<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

</head>
<body>     

<?php
    
    if(!isset($_GET['b']) && !isset($_GET['a'])) {
        echo "Please add a=NUMBER&b=NUMBER to the query string";
        return;
    }
    if(!isset($_GET['b'])) {
        echo "Please add b=NUMBER to the query string";
        return;
    }
    
    if(!is_numeric($_GET['b'])) {
        echo "Please add b=NUMBER to the query string";
        return;
    }
        
    if ($_SERVER['REQUEST_METHOD'] === 'GET') {
        $a = intval($_GET['a'] ?? 0);
        $b = intval($_GET['b'] ?? 0);
        $sum = $a + $b;
        //http://localhost:8083/baithi/e1-get.php?a=2&b=3
        echo "$a + $b = $sum";        
    }

?>
</body>
</html>