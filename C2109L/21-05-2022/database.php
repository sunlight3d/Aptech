<?php
    define('SERVER', 'localhost');
    define('DB_NAME', 'abc12');
    define('DB_USER_NAME', 'root');
    define('DB_PASSWORD', '');
    $sql_create_db = "CREATE DATABASE IF NOT EXISTS ".DB_NAME; 
    $sql_create_table = "
        CREATE TABLE IF NOT EXISTS abc12users (
            username VARCHAR(100),
            password_hash CHAR(40),
            phone VARCHAR(10) UNIQUE
        )";
    //pdo = PHP Data Object
    $connection_string = "mysql:host=".SERVER;
    $connection = null;    
    try {
        $connection = new PDO($connection_string, 
                DB_USER_NAME, DB_PASSWORD);   
        $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        echo "Connected successfully<br>";        
        if($connection->query($sql_create_db) == TRUE) {
            echo "Create DB successfully<br>";;
        } else {
            echo "Create DB failed<br>";;
        }
        $connection->query("USE ".DB_NAME);
        $connection->exec($sql_create_table);
        echo "Table created successfully<br>";;
    } catch(PDOException $e) {
        echo "Connection failed: " . $e->getMessage();
    }    
?>