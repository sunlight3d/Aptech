<?php
require './configuration.php';
require './models/Item.php';
function generate_fake_items($connection) {
	//insert fake data			
	$faked_items = [
		new Item(11, "Hello how are you"),
		new Item(55, "dsrwev fg wfdtfdt"),
		new Item(65, "this i a adn sds"),
		new Item(12, "dsds. ds trtr yrtytr5y"),
		new Item(43, "mfsi tglroekfsdg,djgdjg"),
		new Item(14, "smrodj js fjdtfjd gd"),
		new Item(89, "smfp sjegj9djjwet ert"),
		new Item(95, "s vjwoirt wtjewp"),
		new Item(13, "n hfhsarthw"),
		new Item(18, "jrhjasrhse gtshther"),
		new Item(19, "z jdfosr fjstejtert trt"),
		new Item(22, "rm,e tjr tdhtedhtjhtri"),
	];
	$sql_insert = '
		INSERT INTO tblItem(ID, name) VALUES(:id, :name)
	';
	$statement = $connection->prepare($sql_insert);
	foreach ($faked_items as $faked_item) {
		$statement->execute([
			':id' => $faked_item->id,
			':name' => $faked_item->name
		]);
	}
	echo "<p>INSERT fake data successfully</p>";
}
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
			'USE de04',
			'
			CREATE TABLE IF NOT EXISTS tblItem(
				ID INT,
				name VARCHAR(50) 
			)
			'
		];		
		foreach ($sql_create_tables as $statement) {
			$connection->exec($statement);
		}
		//echo "<p>Create table tblItem successfully</p>";		
		//generate_fake_items(connection: $connection);		
	}
} catch (PDOException $e) {
	echo $e->getMessage();
} finally {
    //do nothing
}