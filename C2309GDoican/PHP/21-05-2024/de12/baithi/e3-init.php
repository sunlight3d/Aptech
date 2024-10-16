<?php
define('DB_HOST', '127.0.0.1');//const
define('DB_PORT', '3307');//thuong la 3306
//define('DB_PORT', '3306');
define('DB_NAME', 'mysql');
define('DB_USERNAME', 'root');
define('DB_PASSWORD', 'Abc123456789@');//thuong la ''
//define('DB_PASSWORD', '');

function connectToDatabase() {
    try {        
        // Create a new PDO instance
        //PHP Data Object
        //$connection_string = "mysql:host=".DB_HOST.";port=".DB_PORT.";dbname=".DB_NAME;
        $connection_string = sprintf("mysql:host=%s;port=%s;dbname=%s", DB_HOST, DB_PORT, DB_NAME);
        $pdo = new PDO($connection_string, DB_USERNAME, DB_PASSWORD);                
        // Set PDO to throw exceptions on errors
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        echo 'connect DB successfully';        
        return $pdo; // Return PDO instance
    } catch (PDOException $e) {
        // Handle database connection error
        die("Connection failed: " . $e->getMessage());
    }
}
$pdo = connectToDatabase();
try {
    $sql_drop_old_db = "DROP DATABASE exam;";
    $sql_create_db = "create database if not exists exam";
    $sql_create_table = "create table if not exists user_info(username  varchar(30) primary key, password varchar(40))";
    $sql_insert_data = "INSERT INTO user_info (username, password) VALUES (?, ?)"; //seeding

    $stmt = $pdo->prepare($sql_drop_old_db);
    $stmt->execute([]);

    $stmt = $pdo->prepare($sql_create_db);
    $stmt->execute([]);
    echo "<p>create db exam successfully</p>";
    $pdo->query("USE exam");
    $stmt = $pdo->prepare($sql_create_table);
    $stmt->execute([]);


    $stmt = $pdo->prepare($sql_insert_data);
    $stmt->execute(['admin', SHA1('123456')]);
    
    echo "<p>insert data to exam successfully</p>";
    echo "<script>alert('Data inserted successfully!');</script>";
} catch (PDOException $e) {
    // Handle error
    echo "cannot execute commands".$e;
}
?>