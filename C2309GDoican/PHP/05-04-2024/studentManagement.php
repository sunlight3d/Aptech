<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Information</title>
</head>
<body>
    <?php       
        $name = '';
        $dob = date('Y-m-d', strtotime('-18 years'));
        $gender = '';
        $selected_subjects = [];
        $selected_class = "";
        //$students = $_GLOBALS['students'] ?? [];
        //validations
        $errors = [];
        $_GLOBALS['students'] = [];
        if ($_SERVER["REQUEST_METHOD"] == "POST") {            
            // Default values or values from form submission
            $name = $_POST["name"];        
            $dob = $_POST["dob"];            
            $gender = $_POST["gender"];        
            //die();
            $selected_subjects = $_POST["subjects"];
            $selected_class = $_POST["class"];
            
            
            if (strlen($name) < 4) {
                array_push($errors,"Name must be at least 4 characters.");            
            }
            $today = new DateTime();        
            $dateOfBirth = new DateTime($dob);                        
            $age = $today->diff($dateOfBirth)->y;        
            /*
            var_dump($age); 
            die();        
            */
            if ($age < 18) {
                array_push($errors,"Age must be 18 or older.");            
            }
            // Validate gender
            if ($gender !== "male" && $gender !== "female") {
                array_push($errors,"Gender must be male or female.");                        
            }
            // Validate selected class
            if (empty($selected_class)) {
                array_push($errors,"Please select a class.");                
            }
            if (count($selected_subjects) < 1) {
                array_push($errors,"Please select at least one subject.");            
            }
            if (!empty($errors)) {
                foreach ($errors as $error) {
                    echo "<p>Error: $error</p>";
                }
                return;                
            }      
            $student = array(
                "name" => $name,
                "dob" => $dob,
                "gender" => $gender,
                "selected_subjects" => $selected_subjects,
                "selected_class" => $selected_class,                
            );
            array_push($_GLOBALS['students'], $student);
        }                 
        var_dump($_GLOBALS['students']);
    ?>
    <h2>Student Information Form</h2>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
        <label for="name">Student Name:</label>
        <input type="text" id="name" name="name"><br><br>

        <label for="dob">Date of Birth:</label>
        <input type="datetime-local" id="dob" name="dob" ><br><br>

        <label>Gender:</label>
        <input type="radio" id="male" name="gender" 
            value="male" <?php if ($gender === "male") echo "checked"; ?> >
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" 
            value="female" <?php if ($gender === "female") echo "checked"; ?>>
        <label for="female">Female</label><br><br>

        <label>Subjects:</label>
        <input type="checkbox" id="math" name="subjects[]" 
            value="Math" 
            <?php if (in_array("Math", $selected_subjects)) echo "checked"; ?>
            >
        <label for="math">Math</label>
        <input type="checkbox" id="physics" 
            name="subjects[]" value="Physics" 
            <?php if (in_array("Physics", $selected_subjects)) echo "checked"; ?>>

        <label for="physics">Physics</label>
        <input type="checkbox" id="chemistry" 
        name="subjects[]" value="Chemistry" 
            <?php if (in_array("Chemistry", $selected_subjects)) echo "checked"; ?>>
        <label for="chemistry">Chemistry</label><br><br>

        <label for="class">Class:</label>
        <select id="class" name="class">
            <option value="class1" 
                <?php if ($selected_class == "class1") echo "selected"; ?>
                >Class 1</option>
            <option value="class2" >Class 2</option>
            <option value="class3" >Class 3</option>
        </select><br><br>
        <input type="submit" value="Insert student">
    </form>

    <h2>Student List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Class</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>Subjects</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($_GLOBALS['students'] as $each_student) {?>                    
                <td><?php echo $each_student['name']; ?></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            <?php } ?>
            <tr>
                
            </tr>
        </tbody>
    </table>
</body>

</html>
