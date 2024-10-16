<?php

use App\Http\Controllers\CalculationController;
use Illuminate\Support\Facades\Route;;

Route::get('/', function () {
    return view('welcome');//view ten la welcome
});
//Khi truy cập vào đường dẫn
//http://localhost:8000/sum 
//thì phương thức "index" của SumController sẽ thực hiện yêu cầu(request)
Route::get('/sum', [CalculationController::class, 'index'])->name('sum');
//"class Route"::phương thức static, "get", called Facade
Route::post('/calculate', [CalculationController::class, 'calculate'])->name('calculate');
