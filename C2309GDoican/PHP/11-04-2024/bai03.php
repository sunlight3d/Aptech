<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Day of the week</h1>
    <form>        
        <p>Please enter a day of the week</p>
        <input type="text" name="inputDay"/>
        <input type="submit" value="Go"> 
    </form>
    <?php
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        switch (trim(strtolower($_POST['inputDay']))) {
            case 'monday':
                echo "Laugh on Monday, laugh for danger";
                break;
            default:
            echo "Invalid";
            break;                
        }
    }
    ?>    
</body>
</html>