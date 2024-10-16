<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ItemController;
use App\Http\Controllers\PersonController;

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

Route::get('/', function () {
    return view('welcome');
});
Route::resource('items', ItemController::class)
    ->missing(function (Request $request) {
    return Redirect::route('items.index');
});
Route::resource('people', PersonController::class)
    ->missing(function (Request $request) {
    return Redirect::route('people.index');
});
