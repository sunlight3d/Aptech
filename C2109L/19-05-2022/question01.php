<?php
    
    $result = 0;
    $x_error = '';
    $y_error = '';
    //associative array = object
    $person = [
        'name' => 'Hoang',
        'age' => 18
    ];
    //print_r($person);
    /*
    for($i = 0; $i < 10; $i++) {
        if($i % 2 != 0) {
            continue;//donot run to 10
        }
        echo "i = $i<br>";
    }
    */
    //print_r($_SERVER);
    //super global - bien toan cuc co san 
    //server receives data from client
    /*
    if(isset($_GET['submit'])) {
        $x = empty($_GET['x']) ? 0 : $_GET['x'];
        //default value         
        $y = empty($_GET['y']) ? 0 : $_GET['y'];                        
        $operator = $_GET['operator'] ;
        if($operator == '+') {
            $result = $x + $y;
        } else if($operator == '-') {
            $result = $x - $y;
        } else if($operator == '*') {
            $result = $x * $y;
        } else if($operator == '/') {
            $result = $y == 0 ? 0 : $x / $y;
        }
    }
    */
    if(isset($_POST['submit'])) {  
        $x = empty($_POST['x']) ? 0 : $_POST['x']; 
        //default value         
        $y = empty($_POST['y']) ? 0 : $_POST['y'];                        
        //validations
        if(!is_numeric($x)) {
            $x_error = 'x must be a number';
        }        
        if(!is_numeric($y)) {
            $y_error = 'y must be a number';            
        }
        
        $is_valid = $x_error == '' && $y_error == '';        
        //var_dump($is_valid);
        if($is_valid) {
            $operator = $_POST['operator'] ;
            if($operator == '+') {
                $result = $x + $y;
            } else if($operator == '-') {
                $result = $x - $y;
            } else if($operator == '*') {
                $result = $x * $y;
            } else if($operator == '/') {
                $result = $y == 0 ? 0 : $x / $y;
            }    
        }        
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method='POST'>
    <table>
        <tr>
            <td>First</td>
            <td><input type="text" name="x" placeholder="Enter x"></td>
            <td>
                <p style="color: red;"><?php echo $x_error; ?></p>
            </td>
        </tr>
        <tr>
            <td>Second</td>
            <td><input type="text" name="y" placeholder="Enter y"></td>
            <td>
                <p style="color: red;"><?php echo $y_error; ?></p>
            </td>
        </tr>
        <tr>
            <td>Operator</td>
            <td>
            <select name="operator">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
            </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Compute" name="submit"></td>
        </tr>
        <tr>
            <td>Result</td>
            <td><input type="text" value="<?php echo $result; ?>"></td>
        </tr>
    </table>
    
</form>
</body>
</html>