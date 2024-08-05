<?php

use App\Http\Controllers\PostController;
use App\Http\Controllers\UserController;
use App\Http\Controllers\HomeController;
use App\Http\Controllers\AdminController;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Route;


Route::get('/', [HomeController::class, 'index'])->name('home');

Route::get('/users/register', [UserController::class, 'register'])//hien ra form dang ky
            ->name('users.register');
Route::get('/users/login', [UserController::class, 'login'])//hien ra form dang nhap
            ->name('users.login');            

Route::post('/users/login', [UserController::class, 'signin'])//sau khi bam dang nhap
            ->name('users.signin');

Route::post('/users/register', [UserController::class, 'store'])//sau khi bam dang ky
            ->name('users.store');

Route::get('/posts/{id}', [HomeController::class, 'show'])->name('posts.show');

//http://localhost:port/posts
Route::get('/posts', [PostController::class, 'index']);

Route::post('/logout', function () {
    Auth::logout();
    return redirect('/'); // Redirect to homepage or login page after logout
})->name('logout');

Route::group(['middleware' => ['auth']], function () {
    Route::get('/admin', [AdminController::class, 'index'])->name('admin.dashboard');
});
