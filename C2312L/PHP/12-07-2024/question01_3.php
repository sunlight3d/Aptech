<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>    
    <h1>Days of the weeks</h1>
    <!-- <form method="GET" action="./question01_3.php"> -->
    <form method="GET" action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>">
        <input type="text" name="dayOfTheWeek">
        <input type="submit" value="Go">        
    </form>
    <?php
        if (isset($_GET['dayOfTheWeek'])) {
            $dayOfTheWeek = strtoupper(trim($_GET['dayOfTheWeek']));
            $messages = [
                'MONDAY'    => '<p>Laugh on Monday, laugh for danger</p>',
                'TUESDAY'   => '<p>Laugh on Tuesday, kiss a stranger</p>',
                'WEDNESDAY' => '<p>Laugh on Wednesday, laugh for a letter</p>',
                'THURSDAY'  => '<p>Laugh on Thursday, something better</p>', // Updated message for Thursday
                'FRIDAY'    => '<p>Laugh on Friday, laugh for sorrow</p>',
                'SATURDAY'  => '<p>Laugh on Saturday, joy tomorrow</p>'
            ];        
            echo $messages[$dayOfTheWeek] ?? '<p>Nothing</p>';
        }        
        
       //if()
    ?>
</body>

</html>