<?php
/*
how to connect from PHP to mysql db(use: root, pass: "", db's name: c2312l, server: localhost, 3306)
using pdo
write a function to do this inside php file
 */
//define("SERVER_NAME", "localhost");
const SERVER_NAME = "localhost";
const USERNAME = "root";
const PASSWORD = "";
const DATABASE_NAME = "exam";
const PORT = 3306;


function getPDO()
{
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

// Example of using the function
