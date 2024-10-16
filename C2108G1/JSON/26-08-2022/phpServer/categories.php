<?php
/*
{
    category: 'Food',
    description: 'This is test',
    price: 12.3,
    quantity: 5,
},
{
    category: 'Electronics',
    description: 'This is m,fdkjfttest',
    price: 22.3,
    quantity: 21,
},
{
    category: 'Abcdd',
    description: 'Thfdfdis is test',
    price: 33.3,
    quantity: 34,
}
*/
$categories = [
    [
        "category" => 'Food',
        "description"=> 'This is test',
        "price" => 12.3,
        "quantity" => 5,
    ],
    [
        "category" => 'Electronics',
        "description"=> 'Thidsdss is test',
        "price" => 33.3,
        "quantity" => 1,
    ],
    [
        "category" => 'Fruits',
        "description"=> 'This idwdsds test',
        "price" => 12.3,
        "quantity" => 3
    ],
    [
        "category" => 'Laptop And PC',
        "description"=> 'This is tessd.,sdst',
        "price" => 14.3,
        "quantity" => 9,
    ],
];
//convert from PHP plain object => JSON object
// for($i = 0; $i < 1_000_00000; $i++) {
//     $x = 111;
// }
$typedText = isset($_GET['typedText']) 
                ? htmlspecialchars($_GET['typedText']) : '';
$typedText = strtolower($typedText);
$filtered_categories = array_filter(
	$categories,
	fn ($eachCategory) => str_contains(strtolower($eachCategory['category']), $typedText)
                            || str_contains(strtolower($eachCategory['description']), $typedText)
);
echo json_encode(array("categories" => $categories));

?>