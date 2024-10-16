
<?php
/*
how to connect from PHP to mysql db(use: root, pass: "", db's name: c2312l, server: localhost, 3306)
using pdo
write a function to do this inside php file
 */
//define("SERVER_NAME", "localhost");
const SERVER_NAME = "localhost";
const USERNAME = "root";
const PASSWORD = "Abc123456789";//docker container
//const PASSWORD = "";
const DATABASE_NAME = "c2312l";
//const PORT = 3306;
const PORT = 3307;//docker container


function getPDO() {
    try {
        $connection_string = "mysql:host=" . SERVER_NAME 
                                . ";port=" . PORT 
                                . ";dbname=" . DATABASE_NAME 
                                . ";charset=utf8";
        $pdo = new PDO($connection_string, USERNAME, PASSWORD);
        // Set the PDO error mode to exception
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $pdo;
    } catch (PDOException $e) {
        die("Connection failed: " . $e->getMessage());
    }
}

/*
function connectToDatabase() {
    $serverName = SERVER_NAME;
    $username = USERNAME;
    $password = PASSWORD;
    $databaseName = DATABASE_NAME;
    $port = PORT;
    
    // Create connection
    $mysqli = new mysqli($serverName, $username, $password, $databaseName, $port);

    // Check connection
    if ($mysqli->connect_error) {
        die("Connection failed: " . $mysqli->connect_error);
    }

    // Set charset to utf8
    if (!$mysqli->set_charset("utf8")) {
        die("Error loading character set utf8: " . $mysqli->error);
    }

    return $mysqli;
}
*/


?>
