<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

</head>
<body>
<?php
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $a = intval($_POST['a'] ?? 0);
        $b = intval($_POST['b'] ?? 0);
        $sum = $a + $b;
    }   
?>
<form method="post">
    <input type="text" name="a" placeholder="First number" value="<?php echo $a ?? '' ?>"/>
    <input type="submit" value="+"/>    
    <input type="text" name="b" placeholder="Second number" value="<?php echo $b ?? '' ?>"/>
    <span>=</span>
    <input type="text" name="result" value="<?php echo $sum ?? '' ?>"/>
</form>    


</body>
</html>