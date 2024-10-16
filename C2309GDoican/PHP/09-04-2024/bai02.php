<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Bai 02</h1>
    <form method="post">
    <input type="text" name="inputText"/>
    <input type="submit" value="Input some text">
</form>        

<?php
// Kiểm tra nếu là phương thức POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Lấy giá trị từ trường inputText trong form và chuyển thành mảng bằng cách tách chuỗi dựa trên khoảng trắng
    $inputArray = explode(" ", $_POST['inputText']);

    // Dùng vòng lặp để xử lý từng từ trong mảng
    foreach ($inputArray as &$word) {
        // Đổi màu cho chữ cái đầu tiên của mỗi từ sang màu đỏ
        $word = "<span style='color: red;'>" . substr($word, 0, 1) . "</span>" . substr($word, 1);
    }

    // Chuyển mảng đã được xử lý thành chuỗi và hiển thị ra màn hình
    echo implode(" ", $inputArray);
}    
    ?>
</body>
</html>