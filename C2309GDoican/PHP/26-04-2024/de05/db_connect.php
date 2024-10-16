<?php
define('DB_HOST', '127.0.0.1');//const
define('DB_PORT', '3307');
//define('DB_PORT', '3306');
define('DB_NAME', 'C2309GDoiCan');
define('DB_USERNAME', 'root');
define('DB_PASSWORD', 'Abc123456789@');
//define('DB_PASSWORD', '');

function connectToDatabase() {
    try {                
        $connection_string = sprintf("mysql:host=%s;port=%s;dbname=%s", DB_HOST, DB_PORT, DB_NAME);
        $pdo = new PDO($connection_string, DB_USERNAME, DB_PASSWORD);                
        // Set PDO to throw exceptions on errors
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        //echo 'connect DB successfully';        
        return $pdo; // Return PDO instance
    } catch (PDOException $e) {
        // Handle database connection error
        die("Connection failed: " . $e->getMessage());
    }
}
?>
