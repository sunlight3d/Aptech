<?php
function calculate($firstNumber, $secondNumber, $operator) {
    /*
    $result = 0;
    
    if($operator == "+") {
        $result = $firstNumber + $secondNumber;
    } else if($operator == "-") {
        $result = $firstNumber - $secondNumber;
    } else if($operator == "*") {
        $result = $firstNumber * $secondNumber;
    } else if($operator == "/") {
        $result = ($secondNumber == 0) ? "error" : ($firstNumber / $secondNumber);            
    }
    */    
    //best
    return match ($operator) {
        '+' => $firstNumber + $secondNumber,
        '-' => $firstNumber - $secondNumber,
        '*' => $firstNumber * $secondNumber,
        '/' => ($secondNumber == 0) ? "error" : ($firstNumber / $secondNumber),
    };
    return $result;
}
?>