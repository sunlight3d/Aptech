<?php
require_once 'db_connect.php';

class EmployeeManagement {
    private $pdo;

    public function __construct() {
        $this->pdo = connectToDatabase();
    }

    // Create
    public function createEmployee($name, $position, $salary) {
        try {
            $stmt = $this->pdo->prepare("INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)");
            $stmt->execute([$name, $position, $salary]);
            return true;
        } catch (PDOException $e) {
            // Handle error
            return false;
        }
    }

    // Read
    public function getAllEmployees() {
        $stmt = $this->pdo->query("SELECT * FROM employees");
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function getEmployeeById($id) {
        $stmt = $this->pdo->prepare("SELECT * FROM employees WHERE id = ?");
        $stmt->execute([$id]);
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    // Update
    public function updateEmployee($id, $name, $post, $salary) {
        try {
            $stmt = $this->pdo->prepare("UPDATE employees SET name = ?, post = ?, salary = ? WHERE id = ?");
            $stmt->execute([$name, $post, $salary, $id]);
            return true;
        } catch (PDOException $e) {
            // Handle error
            return false;
        }
    }

    // Delete
    public function deleteEmployee($id) {
        try {
            $stmt = $this->pdo->prepare("DELETE FROM employees WHERE id = ?");
            $stmt->execute([$id]);
            return true;
        } catch (PDOException $e) {
            // Handle error
            return false;
        }
    }
}

// Example usage:
/*
$employee = new Employee();
$employees = $employee->getAllEmployees();
foreach ($employees as $emp) {
    echo $emp['name'] . "<br>";
}
*/
?>
