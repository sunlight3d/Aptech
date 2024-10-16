<?php
include './database.php';
$sql = "SELECT * FROM tblPerson";
$persons = array(); 
try {
    $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $statement = $connection->prepare($sql);
    $statement->execute();
    $statement->setFetchMode(PDO::FETCH_ASSOC);
    $persons = $statement->fetchAll();
    
} catch (PDOException $e) {
    echo "Cannot execute sql: " . $e->getMessage();
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        table {
            border-collapse: collapse;
            border-spacing: 0;
            width: 100%;
            border: 1px solid #ddd;
        }

        th,
        td {
            text-align: left;
            padding: 16px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
    <title>Document</title>
</head>

<body>
    <p>List of Items11</p>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>DOB</th>
            <th></th>
            <th></th>
        </tr>
        <?php
        foreach ($persons as $person) {
            echo "<tr>";
            echo "<td>" . $person["ID"] . "</td>";
            echo "<td>" . $person["Name"] . "</td>";
            echo "<td>" . $person["Gender"] . "</td>";
            echo "<td>" . $person["DateOfBirth"] . "</td>";
            echo "<td><a href=''>Delete</a></td>";
            echo "<td><a href='/updateOrCreate.php?id=".$person["ID"]."'>Update</a></td>";
            echo "</tr>";
        }
        ?>
    </table>
    <a href='/updateOrCreate.php'>Create</a>        
</body>

</html>