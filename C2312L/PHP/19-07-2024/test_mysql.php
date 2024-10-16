<?php
require_once 'db_connection.php';
$pdo = getPDO();
global $pdo;
$i = 0;

function randomString($length = 50) {
    $characters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $charactersLength = strlen($characters);
    $randomString = '';
    for ($j = 0; $j < $length; $j++) {
        $randomString .= $characters[rand(0, $charactersLength - 1)];
    }
    return $randomString;
}

try {
    while (true) {
        $tableName = randomString(); // Generate a random table name
        $sql = "CREATE TABLE $tableName (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))";
        $pdo->exec($sql); // Execute the SQL command to create the table    
        echo $i.", ";
        $i++;
    }
} catch (Exception $e) {
    echo "Exception at $i, cause: " . $e->getMessage();
}
?>
