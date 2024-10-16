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
    $departments = readDepartment();
    $name = isset($_POST['name']) ? $_POST['name'] :'';
    $age = isset($_POST['age']) ? $_POST['age'] :'';
    $sex = isset($_POST['sex']) ? $_POST['sex'] :'';
    $dept_id = isset( $_POST['dept_id']) ? $_POST['dept_id'] :'';
    if(!empty($name) && !empty($age) && !empty($sex) && !empty($dept_id)){
        $result = createEmployee($name,$age,$sex,$dept_id);
        if($result){
            header("Location: question04.php");
        }else{
            echo 'Tao nhan vien that bai';
        }
           
    }
    ?>
    <form action="" method="post">
        <input type="hidden" name="id">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
        <br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age">
        <br>
        <label for="sex">Sex:</label>
        <input type="text" id="sex" name="sex">
        <br>
        <label for="dept_id">Department:</label>
        <select id="dept_id" name="dept_id">
            <?php foreach ($departments as $dept) { ?>
                <option value="<?= $dept['id'] ?>"><?= $dept['name'] ?></option>
            <?php } ?>
        </select>
        <br>
        <input type="submit" value="Create">
    </form>
</body>

</html>