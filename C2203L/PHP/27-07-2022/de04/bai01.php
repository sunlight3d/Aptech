<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <?php
        include './Operator.php';
        require './calculations.php';
        $firstNumber = isset($_GET['firstNumber']) ? floatval($_GET['firstNumber']) : 0;
        $secondNumber = isset($_GET['secondNumber']) ? floatval($_GET['secondNumber']) : 0;
        $operator = isset($_GET['operator']) ? $_GET['operator'] : "+";
        $operators = [
            new Operator("+", "Cong"),
            new Operator("-", "Tru"),
            new Operator("*", "Nhan"),
            new Operator("/", "Chia"),
            ];
        //print_r($operator);
        $result = calculate($firstNumber, $secondNumber, $operator);
        
        var_export($_GET);
    ?>
</head>
<body>
    <form method="GET" action="./bai01.php">
    <table>
        <tr>
            <td>
                <p>First</p>
            </td>
            <td>
                <input type="text" name="firstNumber" placeholder="Enter first number" >             
            </td>
        </tr>
        <tr>
            <td>
                <p>Second</p>
            </td>
            <td>                
                <input type="text" name="secondNumber" placeholder="Enter second number">
            </td>
        </tr>
        <tr>
            <td>
                <p>Operator</p>
            </td>
            <td>                
            <select name="operator">
                <?php
                    forEach($operators as $eachOperator) {
                        $selected = $operator == $item ? "selected": "";
                        echo "<option value='$eachOperator->sign' $selected>$eachOperator->name</option>";
                    }
                ?>                                
            </select>
            </td>
        </tr>
        <tr>
            <td>                
            </td>
            <td>                
                <input type="submit" value="Compute">
            </td>
        </tr>
    </table>
    <p>Result: <?php echo $result; ?></p>
</form>
</body>
</html>