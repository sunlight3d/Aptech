<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <?php
    require_once 'crud_functions.php';
    $id = isset($_GET['id']) ? $_GET['id'] : "";
    $person = readPersonById($id);
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        //insert
        $name = isset($_POST['name']) ? $_POST['name'] :'';
        $gender = isset($_POST['gender']) ? $_POST['gender'] :'';
        $dob = isset($_POST['dateOfBirth']) ? $_POST['dateOfBirth'] :'';
        updatePersons($id, $name, $gender, $dob);
    } 
    
    ?>
    <form action="" method="POST">
        Name <input type="text" name="name" value="<?php echo htmlspecialchars($person['Name']); ?>"><br>
        Male <input type="radio" name="gender" value="Male" <?php echo $person['Gender'] == '1' ? 'checked' : ''; ?>>
        Female <input type="radio" name="gender" value="Female" <?php echo $person['Gender'] == '0' ? 'checked' : ''; ?>><br>
        DOB: <input type="date" name="dateOfBirth" value="<?php echo htmlspecialchars($person['DateOfBirth']); ?>"><br>
        <input type="submit" value="Update">
    </form>

</body>

</html>