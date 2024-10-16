<?php
define('DB_HOST', '127.0.0.1');//const
define('DB_PORT', '3307');
define('DB_NAME', 'C2309GDoiCan');
define('DB_USERNAME', 'root');
define('DB_PASSWORD', 'Abc123456789@');

function connectToDatabase() {
    try {        
        // Create a new PDO instance
        $pdo = new PDO("mysql:host=".DB_HOST.";port=".DB_PORT.";dbname=".DB_NAME, DB_USERNAME, DB_PASSWORD);                
        // Set PDO to throw exceptions on errors
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        echo 'connect DB successfully';        
        return $pdo; // Return PDO instance
    } catch (PDOException $e) {
        // Handle database connection error
        die("Connection failed: " . $e->getMessage());
    }
}
?>
