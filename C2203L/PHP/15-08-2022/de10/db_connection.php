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
	if ($connection) {		
		//echo "<h1>Connected to the ".DB_NAME." database successfully!<h1>";
		//create table, then insert data to database 
		$sql_create_tables = [			
			'USE '.DB_NAME,			
			"CREATE TABLE IF NOT EXISTS ".TABLE_ABC12USERS."(".    
			"username VARCHAR(100) UNIQUE,".
			"password_hash VARCHAR(100),".
			"phone VARCHAR(10))"  						
		];		
		foreach ($sql_create_tables as $statement) {
			$connection->exec($statement);
		}
		//echo "<p>Create table ".TABLE_ABC12USERS." successfully</p>";				
	}
} catch (PDOException $e) {	
	echo $e->getMessage();
} finally {
    //do nothing
}