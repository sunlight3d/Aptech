<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post List</title>
</head>
<body>
    @if (Auth::check())
        <p>Welcome, {{ Auth::user()->name }}!</p>
        <a href="{{ route('logout') }}">Logout</a>
    @else
        <p>Please <a href="{{ route('users.login') }}">login</a> to access this page.</p>
    @endif
