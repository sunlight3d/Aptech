<?php
require './Employee.php';
require './db_connection.php';        
function findAllEmployees($connection) {
    $result = [];
    try{
        $statement=$connection->prepare('
          SELECT * FROM employee
        ');
        $statement->execute();
        $all_employees=$statement->fetchAll();
        //convert 
        foreach($all_employees as $dictEmployee) {            
            array_push($result, Employee::fromDictionary($dictEmployee));
        }
    }catch(PDOException $e){
        echo $e->getMessage();
    } finally {
        return $result;
    }
}
function findEmployeeById($connection, $employeeNo) {    
    try{
        $statement=$connection->prepare('
          SELECT * FROM employee WHERE empno=:employeeNo
        ');
        $statement->bindParam(':employeeNo', $employeeNo, PDO::PARAM_INT);
        $statement->execute();
        $foundEmployee = $statement->fetch();
        return Employee::fromDictionary($foundEmployee);                
    }catch(PDOException $e){
        echo $e->getMessage();
        return new Employee();
    } 
}
function insertEmployee($connection,$employee) {
    try {
        $statement = $connection->prepare('
            INSERT INTO employee(empno, ename, post, salary) 
            VALUES(:employeeNo, :employeeName, :post, :salary)
        ');    
        $statement->bindParam(':employeeNo', $employee->employeeNo, PDO::PARAM_INT);
        $statement->bindParam(':employeeName', $employee->employeeName, PDO::PARAM_STR);
        $statement->bindParam(':post', $employee->post, PDO::PARAM_STR);
        $statement->bindParam(':salary', $employee->salary, PDO::PARAM_INT);        
        $statement->execute();                         
    } catch(PDOException $e) {        
        echo "Error in DB: ".$e->getMessage();
    }
}
function updateEmployee($connection, $employee) {
    try {
        $statement = $connection->prepare('
            UPDATE employee 
            SET ename= :employeeName, post= :post, salary= :salary 
            WHERE empno=:employeeNo
        ');    
        $statement->bindParam(':employeeNo', $employee->employeeNo, PDO::PARAM_INT);
        $statement->bindParam(':employeeName', $employee->employeeName, PDO::PARAM_STR);
        $statement->bindParam(':post', $employee->post, PDO::PARAM_STR);
        $statement->bindParam(':salary', $employee->salary, PDO::PARAM_INT);        
        $statement->execute();                         
    } catch(PDOException $e) {        
        echo "Error in DB: ".$e->getMessage();
    }
}
function deleteEmployee($connection, $employeeNo) {
    try {
        $statement = $connection->prepare('
            DELETE FROM  employee             
            WHERE empno=:employeeNo
        ');    
        $statement->bindParam(':employeeNo', $employeeNo, PDO::PARAM_INT);        
        $statement->execute();                         
    } catch(PDOException $e) {        
        echo "Error in DB: ".$e->getMessage();
    }
}
?>