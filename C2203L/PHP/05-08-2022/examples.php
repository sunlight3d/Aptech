<?php
//associative array = dictionary = json object
include './Point.php';
include './Server.php';
$studentA = array(
    "name" => "Hoang",
    "age" => 18,
    "email" => "hoang@gmail.com",
    //multiple values
    "phones" => "01215745;08151245;154545545"
);
print_r($studentA);
//multi-dimensional array
$arrayA = [    
    [4, 5, 6, 7, 9, 7],
    [3, 1, 2, 9, 1, 4]
];
echo "<br>";
forEach($arrayA as $item) {
    forEach($item as $eachNumber) {
        echo "$eachNumber, ";
    }
    echo "<br>";
}
$phones = $studentA['phones'];
forEach(explode(";", $phones) as $eachPhoneNumber) {
    echo "$eachPhoneNumber<br>";
}
$GLOBALS['aa'] = 99;
function xx() {
    $GLOBALS[
        'aa'] = 100;
}
xx();
echo "<br>aa = ".$GLOBALS['aa'];
echo "<br>color = ".Point::$color;
echo "<br> server's name = ".Server::$NAME;
echo "<br> server's port = ".Server::$PORT;
//var_dump($GLOBALS);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>    
    <script>    
        debugger
        for(let i = 0; i < 3; i++) {
            let aa = 999
        }
        alert(`aa = ${aa}`);
</script>
</head>
<body>
    
</body>
</html>