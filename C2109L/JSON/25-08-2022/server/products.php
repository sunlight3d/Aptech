<?php
    //print_r($_GET); //page = 1, limit = 10
    $students = [
        array(
            "name" => 'Nguyen Van rrrrA',
            "class" => "C2019L",
            "DOB" => '1970-12-25',//never do that, let's convert to iso-string
            "languages" => ['English', 'German']
        ),
        array(
            "name" => 'Nguyen Vdsdfsdan A',
            "class" => "C2339L",
            "DOB" => '2000-08-22',//never do that, let's convert to iso-string
            "languages" => ['Japanese', 'German', 'Russian']
        )
    ];    
    $languages = explode(',', $_POST['languages']);
    var_dump($languages);
    if(isset($_GET["page"])) {
        $page = $_GET['page'];
        $limit = $_GET['limit'];        
        echo json_encode(array(
            "students" => $students,
            "page" => $page,
            "limit" => $limit,
        ));
    } 

?>