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
    $employee_id = isset($_GET['id']) ? $_GET['id'] : '';

    $employee = getEmployeeById($employee_id);

    $departments = readDepartment();

    //if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $id = isset($_POST['id']) ? $_POST['id'] : '';
        $name = isset($_POST['name']) ? $_POST['name'] : '';
        $age = isset($_POST['age']) ? $_POST['age'] : '';
        $sex = isset($_POST['sex']) ? $_POST['sex'] : '';
        $dept_id = isset($_POST['dept_id']) ? $_POST['dept_id'] : '';
    //}


    $result = updateEmployee($id, $name, $age, $sex, $dept_id);

    if ($result) {
        header("Location: question04.php");
    }else{
        echo 'Cap nhat that bai';
    }
    ?>
    <form action="" method="post">
        <input type="hidden" name="id" value="<?= $employee['id'] ?>">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<?= $employee['name'] ?>">
        <br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" value="<?= $employee['age'] ?>">
        <br>
        <label for="sex">Sex:</label>
        <input type="text" id="sex" name="sex" value="<?= $employee['sex'] ?>">
        <br>
        <label for="dept_id">Department:</label>
        <select id="dept_id" name="dept_id">
            <?php foreach ($departments as $dept) { ?>
                <option value="<?= $dept['id'] ?>" <?= $dept['id'] == $employee['dept_id'] ? 'selected' : '' ?>><?= $dept['name'] ?></option>
            <?php } ?>
        </select>
        <br>
        <input type="submit" value="Update">
    </form>
</body>

</html>