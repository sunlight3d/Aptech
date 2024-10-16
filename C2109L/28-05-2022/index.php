<?php
    include './database.php';  
    $items = [];
    $total_pages = 0;
    $page = htmlspecialchars($_GET['page'] ?? 0); //nil coalescing from "Apple's swift"
        $limit = htmlspecialchars($_GET['limit'] ?? 10);
        $offset = intval($page) * intval($limit);
        $sql = "SELECT * FROM tblItem LIMIT "."$limit"." OFFSET "."$offset";                            
        try {
            $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $statement = $connection->prepare($sql);
            $statement->execute();
            $statement->setFetchMode(PDO::FETCH_ASSOC);
            $items = $statement->fetchAll();      
            
            $sql = "SELECT count(*) as count FROM tblItem";
            $statement = $connection->prepare($sql);
            $statement->execute();
            $count = intval($statement->fetchAll()[0]['count']);            
            $total_pages = intval($count / $limit) + ($count % $limit > 0 ? 1 : 0);
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

        th, td {
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
    <p>List of Items</p>
    
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>                
            </tr>
            <?php
                foreach($items as $item) {
                    echo "<tr>";
                    echo "<td>".$item["ID"]."</td>";
                    echo "<td>".$item["Name"]."</td>";
                    echo "</tr>";
                }
            ?>           
        </table>
    <?php
        for($i = 0; $i < $total_pages; $i++){
            $page_name = "";
            if($i == 0) {
                $page_name = "First";
            } else if ($i >= $total_pages - 1) {
                $page_name = "Last";
            } else {
                $page_name = $i + 1;
            }
            $query_string = "/index.php?page=$i&limit=$limit";
            echo ("<a href='$query_string'> $page_name </a>");            
        }
    ?>        
    
</body>
</html>