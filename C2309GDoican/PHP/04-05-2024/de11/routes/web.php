<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\CalculationController;

Route::get('/', function () {
    return view('welcome');//view ten la welcome
});
//Khi truy cập vào đường dẫn
//http://localhost:8000/sum 
//thì phương thức "index" của SumController sẽ thực hiện yêu cầu(request)
Route::get('/sum', [CalculationController::class, 'index']);
//"class Route"::phương thức static, "get", called Facade
