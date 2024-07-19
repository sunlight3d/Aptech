<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    require_once('crud_functions.php');
    $name = isset($_GET['name']) ? $_GET['name'] : '';
    $gender = isset($_GET['gender']) ? $_GET['gender'] : false;

    $day = isset($_GET['day']) ? $_GET['day'] : "";
    if (!empty($name) && !empty($day)) {
        if (createPersons($name, $gender, $day)) {
            header("Location: question03.php");
        } else {
            echo "Tạo người dùng thất bại";
        }
    }

    ?>

    <form action="" method="get">
        Name: <input type="text" name="name" value="<?= htmlspecialchars($name) ?>"><br>
        Gender:
        <label><input type="radio" name="gender" value="Female"> Female</label>
        <label><input type="radio" name="gender" value="Male"> Male</label><br>
        DOB: <input type="date" name="day" value="<?= htmlspecialchars($day) ?>"><br>
        <input type="submit" value="Create">
    </form>
</body>

</html>