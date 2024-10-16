<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Information</title>
</head>
<body>
    <?php
        // Default values or values from form submission
        $name = $_POST["name"] ?? "";        
        $dob = $_POST["dob"] ?? date('Y-m-d', strtotime('-18 years'));
        
        $gender = $_POST["gender"] ?? "";        
        //die();
        $selected_subjects = $_POST["subjects"] ?? [];
        $selected_class = $_POST["class"] ?? "";
        var_dump($selected_class);
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
            <option value="class2" <?php if ($selected_class == "class2") echo "selected"; ?>>Class 2</option>
            <option value="class3" <?php if ($selected_class == "class3") echo "selected"; ?>>Class 3</option>
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
            <!-- Student list will be displayed here -->
        </tbody>
    </table>
</body>

</html>
