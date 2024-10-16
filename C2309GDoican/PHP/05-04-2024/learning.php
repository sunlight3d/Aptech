<?php
    //super global: $_SERVER, $_POST, $_
    $x = 10;
    $GLOBALS['name'] = 'Hoang';
    function doSomething() {
        $x = 11;
        echo $x;
    }
    //doSomething();
    //var_dump($GLOBALS);
    $mark = 9;
    if($mark > 10 || $mark < 0) { 
        echo 'invalid';
    } elseif($mark > 8 && $mark <= 10) {
        echo 'very good';
    } else if($mark > 6 && $mark <= 8) {
        echo 'normal';
    } else if($mark <= 6) {
        echo 'not good';
    } 
    $choice = 1;
    do {
        echo "<h1>haha<h1>";
    }while($choice < 0);
    for($i = 0; $i < 10; $i++) {
        //echo $i.", ";
        echo "$i, ";
    }
    //foreach
    $persons = array(//array
        array(
            //associative array = key-value object
            "name" => "Nguyen Van A",
            "age" => 18,
            "address" => "address a"
        ),
        array(
            //associative array = key-value object
            "name" => "alan ",
            "age" => 20,
            "address" => "dmsdj address a"
        ),
        array(
            //associative array = key-value object
            "name" => "John",
            "age" => 332,
            "address" => "address afmdk fdfn "
        ),
    );
    //ok, not so good
    for ($i = 0; $i < count($persons); $i++) {
        $person = $persons[$i];        
        //var_dump($person);    
    }
    $number_of_students = 100;
    $z                  = 20;
    $choice12           = 3;
    //better
    foreach($persons as $person) {
        echo $person["name"] . " "
            . $person["age"] . "."            
            . $person["address"] . ".";
    }
?>