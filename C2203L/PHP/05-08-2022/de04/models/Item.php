<?php
//echo "This is point class";
class Item {    
    public function __construct(
        public int $id = 1,
        public string $name = ""
    ) {
        
    }      
}
?>