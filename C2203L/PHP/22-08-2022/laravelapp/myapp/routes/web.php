<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Question1Controller;
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Route::get('/', function () {
//     return view('xxx');
// });

Route::get('/question01/showName', [Question1Controller::class,'showName']);
Route::get('/question01/showColor', [Question1Controller::class,'showColor']);
