<?php
require './configuration.php';
$connection_string = "mysql:host=".HOST.";dbname=".DB_NAME.";charset=UTF8";
$connection = NULL;
try {
	$options = [PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION];
	$connection = new PDO(
                    $connection_string, 
                    DB_USER, 
                    DB_PASSWORD, 
                    $options);
	if ($connection) {
		echo "<h1>Connected to the ".DB_NAME." database successfully!<h1>";
	}
} catch (PDOException $e) {
	echo $e->getMessage();
} finally {
    //do nothing
}