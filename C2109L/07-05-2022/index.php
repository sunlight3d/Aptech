<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>This is html and php</h1>
    <?php
    $x = 100;    
    //echo "chao ban";    
    $number_of_persons = 10;
    var_export($number_of_persons);
    $a = '123.4';//this is a string
    $b = floatval($a);
    echo "Value of b is : ".$b."<br>";
    $greater_than_10 = $b > 10;
    echo "Boolean's value is : ".$greater_than_10."<br>";
    $is_good = true;
    var_export($is_good);
    //array example
    $some_numbers = [1, 3, 4, 5, 6, 8];
    var_dump($some_numbers);
    foreach($some_numbers as $some_number) {
        echo $some_number."<br>";
    }
    //associative array, like object
    $mr_hoang = array("name" => "Hoang", "age" => 18);
    $mr_hoang["dob"] = "11-11-1990";
    echo "ahaha";
    $point = array();
    $point[1.2] = 2.5;
    $point[3.7] = 7.9;
    //etc...
    //var_dump($mr_hoang);
    var_dump($point);    
    //$z = array();
    //echo $z["name"];
    $greetings = "Welcome to my class";
    echo "string's length = ".strlen($greetings)."<br>";
    echo "number of words : ".str_word_count($greetings);
    //NaN = not a number
    echo is_nan("123aa.33");
    define("HOST", "126.2.31.11");
    define("PORT", 3306);
    ?>
    
</body>
</html>