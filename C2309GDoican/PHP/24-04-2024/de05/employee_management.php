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
            $stmt = $this->pdo->prepare("INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)");
            $stmt->execute([$name, $position, $salary]);
            return true;
        } catch (PDOException $e) {
            // Handle error
            return false;
        }
    }

    // Read
    public function getAllemployees() {
        $sqlCommand = "
            SELECT 
                employee.id,
                employee.name as employee_name, 
                employee.age, 
                employee.sex,                 
                department.id as department_name
            FROM employee
            INNER JOIN department
            ON employee.dept_id = department.id
            ";        
        $stmt = $this->pdo->query($sqlCommand);
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function getEmployeeById($id) {
        $stmt = $this->pdo->prepare("SELECT * FROM employee WHERE id = ?");
        $stmt->execute([$id]);
        
        $employee = $stmt->fetch(PDO::FETCH_ASSOC);
        return $employee;
        //return $employee ? $employee : null;
    }

    // Update
    public function updateEmployee($id, $name, $age, $sex) {
        try {
            $stmt = $this->pdo->prepare("
                UPDATE employee 
                SET 
                    name = ?, 
                    age = ?, 
                    sex = ? 
                WHERE 
                    id = ?
            ");            
            $stmt->execute([$name, $age, $sex, $id]);
            return true;
        } catch (PDOException $e) {
            // Handle error
            return false;
        }
    }
    
    // Delete
    public function deleteEmployee($id) {
        try {
            $stmt = $this->pdo->prepare("DELETE FROM employee WHERE id = ?");
            $stmt->execute([$id]);
            return true;
        } catch (PDOException $e) {
            // Handle error
            return false;
        }
    }
}

?>
