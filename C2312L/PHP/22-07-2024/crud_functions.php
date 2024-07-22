<?php
// crud_functions.php

require_once 'db_connect.php';

$pdo = getPDO();
if (!$pdo) {
    //echo "Connected successfully to the database.";
    // You can perform database operations here
    echo '<p style="color: red;">Connection to db failed</p>';
}

function readEmployees(){
    global $pdo;
    $sql = "SELECT employee.id AS employee_id, employee.name, employee.dept_id, employee.age, employee.sex, department.name AS department
            FROM employee 
            INNER JOIN department ON employee.dept_id = department.id";
    $stmt = $pdo->query($sql);
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}

function readDepartment(){
    global $pdo;
    $sql = "SELECT * FROM Department";
    $stmt = $pdo->query($sql);
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}

function getEmployeeById($id){
    global $pdo;
    $sql = "SELECT * FROM Employee WHERE id = :id";
    $stmt = $pdo->prepare($sql);
    $stmt->bindParam(':id', $id, PDO::PARAM_INT);
    $stmt->execute();
    $employee = $stmt->fetch(PDO::FETCH_ASSOC);
    return $employee;
}
function createEmployee($name,$age,$sex,$dept_id){
    global $pdo;
    $sql = "INSERT INTO employee (name,age,sex,dept_id) VALUES (:name,:age,:sex,:dept_id) ";
    $stmt = $pdo->prepare($sql);
    $stmt ->execute(['name'=> $name, 'age' => $age, 'sex' => $sex,'dept_id' => $dept_id]);
    return $pdo->lastInsertId();

}
function updateEmployee($id, $name, $age, $sex, $dept_id)
{
    global $pdo; // Giả sử bạn đã kết nối với database và lưu kết nối vào biến $pdo

    $sql = "UPDATE employee
            SET name = :name,
                age = :age,
                sex = :sex,
                dept_id = :dept_id
            WHERE id = :id";

    $stmt = $pdo->prepare($sql);
    $stmt->execute([
        'name' => $name,
        'age' => $age,
        'sex' => $sex,
        'dept_id' => $dept_id,
        'id' => $id
    ]);

    return $stmt->rowCount();
}