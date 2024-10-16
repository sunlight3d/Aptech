<?php
/*
{
    name: 'Nguyen Van A',
    class: "C2019L",
    DOB: '1970-12-25',
    gender:'male',
    languages: ['English', 'German']
},
{
    name: 'Ngdmdikjfen Van A',
    class: "C2233L",
    DOB: '2000-12-25',
    gender:'Female',
    languages: ['English', 'Russia']
}
*/
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
    
    echo json_encode(array("students" => $students));
?>