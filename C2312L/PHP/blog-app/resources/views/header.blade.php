<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post List</title>
    @vite('resources/css/app.css')
</head>
<body>
    <div class="text-right mr-10">
        @if (Auth::check())
            <p>Welcome, {{ Auth::user()->fullname }}!</p>
            <a href="{{ route('logout') }}" class="text-blue-500 hover:text-blue-800">Logout</a>
        @else
            <p>Please <a href="{{ route('users.login') }}" class="text-blue-500 hover:text-blue-800">login</a> to access this page.</p>
        @endif

