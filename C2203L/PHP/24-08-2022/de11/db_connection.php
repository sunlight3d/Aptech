<?php
require './config.php';
$connection_string = "mysql:host=".HOST.";dbname=".DB_NAME.";charset=UTF8";
$connection = NULL;
try {
	$options = [PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION];
	$connection = new PDO(
                    $connection_string, 
                    DB_USER, 
                    DB_PASSWORD, 
                    $options);	
		//echo "<p>Create table ".TABLE_ABC12USERS." successfully</p>";				
	
} catch (PDOException $e) {	
    $connection = NULL;
	echo $e->getMessage();
} finally {
    //do nothing
}