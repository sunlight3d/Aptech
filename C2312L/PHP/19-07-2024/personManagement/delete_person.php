<?php
require_once 'crud_functions.php';
$id = isset($_GET['id']) ? $_GET['id'] : '';

$result = deletePerson($id);

if ($result) {
    header("Location: question03.php");
} else {
    echo 'Xóa bản ghi thất bại';
}
