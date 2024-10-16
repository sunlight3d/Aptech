<?php 
class Task {
    private $name;
    //public $name; NOT recommended
    private $status;
    // Add more fields as needed
    
    // Constructor
    public function __construct($name, $status) {
        //contructor = ham khoi tao
        echo "<h2>Creating $name with status: $status <h2/>";
        $this->name = $name;
        $this->status = $status;
    }

    // Getter methods
    public function getName() { //recommend using Getter
        return $this->name;
    }

    public function getStatus() {
        return $this->status;
    }

    // Setter methods
    public function setName($name) {
        $this->name = $name;
    }

    public function setStatus($status) {
        $this->status = $status;
    }

    // Other methods
    public function markAsCompleted() {
        $this->status = 'completed';
    }
}
?>