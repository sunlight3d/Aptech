<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <center>
        <h1>Input employee Management</h1>
    <form method="POST" action="question02.php">
    <table>
        <tr>
            <td>
                Employee No
            </td>
            <td>
                <input type="text" name="employeeNo" />
            </td>
        </tr>
        <tr>
            <td>
                Name
            </td>
            <td>
                <input type="text" name="name" />
            </td>
        </tr>
        <tr>
            <td>
                Place of work
            </td>
            <td>
                <input type="text" name="placeOfWork"/>
            </td>
        </tr>
        <tr>
            <td>
                Phone no
            </td>
            <td>
                <input type="text" name="phoneNo" />
            </td>
        </tr>        
        <tr>
            <td>
                <input type="submit" value="Add New"/>
            </td>
            <td>
            <a href="#">Back to List</a>
        </tr>        
    </table>
    </form>
    <?php
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $employeeNo = $_POST['employeeNo'] ?? '';
        $name = $_POST['name'] ?? '';
        $placeOfWork = $_POST['placeOfWork'] ?? '';
        $phoneNo = $_POST['phoneNo'] ?? '';
        echo "<ul>";
        if(strlen(trim($employeeNo)) == 0){
            echo "<li style='color: red'>You must input employee number</li>";
        }
        if(strlen(trim($name)) == 0){
            echo "<li style='color: red'>You must input employee name</li>";
        }
        if(strlen(trim($placeOfWork)) == 0){
            echo "<li style='color: red'>You must input placeofwork</li>";
        }
        if(strlen(trim($phoneNo)) == 0){
            echo "<li style='color: red'>You must input phone no</li>";
        }

        echo "</4ul>";
    }
        

    ?>
</body>
</html>