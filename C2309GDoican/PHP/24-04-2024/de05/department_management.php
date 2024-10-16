<?php
require_once 'db_connect.php';

class DepartmentManagement {
    private $pdo;

    public function __construct() {
        $this->pdo = connectToDatabase();
    }

    // Create
    

    // Read
    public function getAlldepartments() {
        $sqlCommand = "SELECT * FROM department";        
        $stmt = $this->pdo->query($sqlCommand);
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}

?>
