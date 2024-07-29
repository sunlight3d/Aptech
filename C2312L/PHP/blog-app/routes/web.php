<?php

use App\Http\Controllers\PostController;
use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});
//http://localhost:port/posts
Route::get('/posts', [PostController::class, 'index']);
Route::get('/users/register', [UserController::class, 'register'])
            ->name('register');
Route::post('/users/register', [UserController::class, 'store'])
            ->name('users.store');

