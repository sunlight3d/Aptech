<?php
    define('SERVER', 'localhost');
    define('DB_NAME', 'php_de04');
    define('DB_USER_NAME', 'root');
    define('DB_PASSWORD', '');
    $sql_create_db = "CREATE DATABASE IF NOT EXISTS ".DB_NAME; 
    $sql_create_table = "
        CREATE TABLE IF NOT EXISTS tblItem(
            ID INT,
            Name VARCHAR(50)
        )
    ";
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

