<?php

use App\Http\Controllers\PostController;
use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});


Route::get('/users/register', [UserController::class, 'register'])//hien ra form dang ky
            ->name('users.register');
Route::get('/users/login', [UserController::class, 'login'])//hien ra form dang nhap
            ->name('users.login');            

Route::post('/users/login', [UserController::class, 'signin'])//sau khi bam dang nhap
            ->name('users.signin');

Route::post('/users/register', [UserController::class, 'store'])//sau khi bam dang ky
            ->name('users.store');


//http://localhost:port/posts
Route::get('/posts', [PostController::class, 'index']);

