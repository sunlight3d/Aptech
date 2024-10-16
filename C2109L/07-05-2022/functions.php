<?php
$x = 333;//global variable
function sum_2_numbers($a, $b) {
    $x = 120; //local variable
    return $a + $b;   
}
echo sum_2_numbers(3, 4);
echo "haha<br>";
echo $x;
?>