<?php
// crud_functions.php

require_once 'db_connect.php';

$pdo = getPDO();
if (!$pdo) {
    echo '<p style="color: red;">Connection to db failed</p>';
}

function createUser($data){
    global $pdo;
    if(findUserByUsername($data['username'])){
        echo 'Username exists';
        return -1;
    }
    $sql = "INSERT INTO users (username,password_hash,phone) ".
            "VALUES (:username,:password_hash,:phone)";
    $stmt = $pdo->prepare($sql);
    $stmt ->execute([
        'username'=> $data['username'], 
        'password_hash'=> password_hash($data['password'], PASSWORD_DEFAULT), 
        'phone'=> $data['phone']
    ]);
    //password_verify('rasmuslerdorf', $hash)
    return intval($pdo->lastInsertId());
}

function findUserByUsername($username){
    global $pdo;
    $sql = "SELECT * FROM users WHERE username = :username";
    $stmt = $pdo->prepare($sql);
    $stmt->bindParam(':username', $username, PDO::PARAM_STR);
    $stmt->execute();
    $user = $stmt->fetch(PDO::FETCH_ASSOC);
    var_dump($user);
    return $user;
}
function login($username, $password) {
    global $pdo;
    $user = findUserByUsername($username);
    if (!$user) {
        return null;
    }
    
    // Assuming $user['password'] contains the hashed password stored in the database.
    if (password_verify($password, $user['password_hash'])) {
        return $user;
    }
    return null;
}

