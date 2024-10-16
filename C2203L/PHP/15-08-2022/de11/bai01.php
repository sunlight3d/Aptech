<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        $message = "";
        $coloredMessage = "";
        $username = "";
        $dayMessage = "";
        if(isset($_GET["submit"])) {
            $username = htmlspecialchars($_GET['username']);
            //convert $username to array
            //Example: Bill Gates => ["Bill", "Gates"]
            $usernames = explode(" ",$username);
            foreach($usernames as $item) {
                $coloredMessage = $coloredMessage.'<span style="color:red;">'.$item[0].'</span>'.substr($item, 1).' ';
            }
        }
        $message = empty($username) ? "" : "Hello $username";
        if(isset($_GET["go"])) {
            $day = strtolower(htmlspecialchars($_GET['day']));
            
            if($day == "monday") {
                $dayMessage = "Laugh on Monday, laugh for danger.";    
            }else if ($day == "tuesday") {
                $dayMessage = "Laugh on Tuesday, kiss a stranger.";    
            }else if ($day == "wednesday") {
                $dayMessage = "Laugh on Wednesday, laugh for a letter.";    
            }
            else if ($day == "thursday") {
                $dayMessage = "Laugh on Thursday, something better.";    
            }
            else if ($day == "friday") {
                $dayMessage = "Laugh on Friday, laugh for sorrow.";    
            }
            else if ($day == "saturday") {
                $dayMessage = "Laugh on Saturday, joy tomorrow";    
            } else {
                $dayMessage = "";
            }
            
            /*
            $days = array(
                "monday" => "Laugh on Monday, laugh for danger.",
                "tuesday" => "Laugh on Tuesday, kiss a stranger.",
                "wednesday" => "Laugh on Wednesday, laugh for a letter.",
                "thursday" => "Laugh on Thursday, something better.",
                "friday" => "Laugh on Friday, laugh for sorrow.",
                "saturday" => "Laugh on Saturday, joy tomorrow",
                "monday" => "Laugh on Monday, laugh for danger.",
            );
            */
            //$dayMessage = isset($days[$day]) ?  $days[$day] : ""; 
            //$dayMessage = $days[$day] ?? ""; //nil coalescing
        }
    ?>
    <h1>Please input your name:</h1>
    <form action="./bai01.php" method="get">
        <input type="text" name="username">    
        <input type="submit" value="Submit name" name = "submit">
    </form>    
    <h1><?php echo $message; ?></h1>
    <p>Result: <?php echo $username;?></p>
    <p><?php echo $coloredMessage; ?></p>

    <form action="./bai01.php" method="get">
        <p>Please enter a day of the week</p>
        <input type="text" name="day">
        <input type="submit" value="Go" name="go">
    </form>
    <p><?php echo $dayMessage; ?></p>    
</body>
</html>