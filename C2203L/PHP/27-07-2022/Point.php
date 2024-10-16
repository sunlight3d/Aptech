<?php
//echo "This is point class";
class Point {
    
    public function __construct(
        public float $x = 0.0,
        public float $y = 0.0,
        public float $z = 0.0,
    ) {
        echo "this is constructor of Point object<br>";
    }   
    public function doSomething() {
        echo "doSomething...<br>";
    }
}
?>