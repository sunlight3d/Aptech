<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Paginated Items</title>
    <style>
        table {
            width: 100%;
        }

        th,
        td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .pagination {
            display: flex;
            justify-content: center;
            list-style: none;
        }

        .pagination li {
            margin: 5px;
            padding: 5px;
            border: 1px solid #ddd;
        }

        .pagination li.active {
            font-weight: bold;
        }
    </style>
</head>

<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <?php
        require_once 'crud_functions.php';
        //$currentPage = isset($_GET['page']) ? (int)$_GET['page'] : 0;
        $currentPage = $_GET['page'] ?? 0;
        $itemsPerPage = 5;
        $current_page = floatval(!empty($_GET['page'])) ? $_GET['page'] : 1;
        $offset = ($current_page - 1) * $itemsPerPage;
        $totalRecords = getTotalItemCount();;
        $totalPages = ceil($totalRecords / $itemsPerPage); //lam tron len
        $items = readItems($currentPage, $itemsPerPage);
        foreach ($items as $item) {
            echo '<tr>';
            echo '<td>' . htmlspecialchars($item['id']) . '</td>';
            echo '<td>' . htmlspecialchars($item['name']) . '</td>';
            echo '</tr>';
        }
        ?>
    </table>
    <ul class="pagination">
        <?php
        for ($i = 1; $i <= $totalPages; $i++) {
            $class = ($currentPage == $i) ? "active" : "";
            echo "<li class='$class'><a href='?page=$i'>$i</a></li>";
        }
        ?>
    </ul>
</body>

</html>