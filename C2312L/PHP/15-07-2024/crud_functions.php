<?php
// crud_functions.php

require_once 'db_connection.php';

$pdo = getPDO();

// Create function
function createItem($name) {
    global $pdo;
    //$_GLOBALS["pdo"] = $pdo;
    $sql = "INSERT INTO tblItem (name) VALUES (:name)";
    $stmt = $pdo->prepare($sql);
    $stmt->execute(['name' => $name]);
    return $pdo->lastInsertId();
}

// Read function
function readItems() {
    global $pdo;
    $sql = "SELECT * FROM tblItem";
    $stmt = $pdo->query($sql);
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}

// Update function
function updateItem($id, $newName) {
    global $pdo;
    $sql = "UPDATE tblItem SET name = :name WHERE id = :id";
    $stmt = $pdo->prepare($sql);
    $stmt->execute(['name' => $newName, 'id' => $id]);
    return $stmt->rowCount();
}

// Delete function
function deleteItem($id) {
    global $pdo;
    $sql = "DELETE FROM tblItem WHERE id = :id";
    $stmt = $pdo->prepare($sql);
    $stmt->execute(['id' => $id]);
    return $stmt->rowCount();
}
