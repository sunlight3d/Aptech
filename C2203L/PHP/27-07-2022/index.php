<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- <script>        
        alert("this is js")
    </script> -->
    <?php
        include './Point.php';
        include './configuration.php';
        $email = isset($_POST['email']) ? htmlspecialchars($_POST['email']) : '';        
        $password = isset($_POST['password']) ? htmlspecialchars($_POST['password']) : '';        
        //echo "haha, email is ${email}, password is : $password<br>";
        $p1 = new Point(1, 2, 3);
        //$p2 = new Point(5, 6, 7);
        $p3 = $p1; //reference to another object
        $p1->x = 99;
        //echo "hahha     ";        
        //print_r($p3);
        $a = 12;
        $b = $a; //assignment 
        $a = 333333;
        //echo $b;
        $p4 = NULL;
        /*
        if($p4 != NULL) {
            $p4->doSomething();
        }
        */
        //$p4?->doSomething();        
        $isGood = false;
        //var_dump($isGood);
        //print_r($p1);
        echo "server's name is : ".SERVER_NAME."<br>";
    ?>
</head>
<body>
    <h1>This is a php file</h1>
    <form action="./index.php" method='post'>
        <input type="text" name="email" ><br>
        <input type="password" name="password" ><br>
        <input type="submit" value="Login to your account">
    </form>
</body>
</html>