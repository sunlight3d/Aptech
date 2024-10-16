

 <?php
require_once 'db_connection.php';
/**
a $pdo is created in db_connection.php, how to import this file from question02.php
 */
$pdo = getPDO();
if ($pdo) {
    echo "Connected successfully to the database.";
    // You can perform database operations here
}   

?>
