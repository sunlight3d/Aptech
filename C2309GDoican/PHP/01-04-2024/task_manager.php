<?php
    include_once './Task.php';
    // Create a new Task object
    $task1 = new Task("Do PHP homework", "pending");
    //echo $task1->name;//cannot access name if $name is "private"
    echo $task1->getName();
    $task2 = new Task("Do C++ homework", "completed");
?>

