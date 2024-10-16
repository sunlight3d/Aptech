<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php 
    //$a = isset($_GET['a']) ? $_GET['a'] : 0;
    $a = $_GET['a'] ?? 0;
    $b = isset($_GET['b']) ? $_GET['b'] : 0;
    $result = 0;
    $operation = isset($_GET['operation']) ? $_GET['operation'] : "";
    if($operation === '+'){
        $result = $a + $b;
    }else if($operation === '-'){
        $result = $a - $b;
    }else if($operation === '*'){
        $result = $a * $b;
    }else{
        $result =  $b !=0  ? $a/$b : 'error';
    }

?>
<form action="">
    <input type="text" name="a" id="" value="<?=$a?>"><br>
    <input type="text" name="b" id="" value="<?=$b?>"><br>
    <select name="operation" id="">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="submit" value="Tinh">
    <input type="text" name="" id="" value="<?=$result?>">
</form>
</body>
</html>