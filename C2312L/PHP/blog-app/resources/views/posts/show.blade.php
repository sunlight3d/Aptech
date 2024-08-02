<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>{{ $post->title }}</title>
    <link rel="stylesheet" href="{{ asset('css/app.css') }}">
</head>
<body>
    <div class="container mx-auto px-4 py-6">
        <h1 class="text-3xl font-bold mb-3">{{ $post->title }}</h1>
        <p>{{ $post->content }}</p>
        <a href="{{ url('/') }}" class="mt-4 inline-block text-blue-600 hover:text-blue-800">Back to Home</a>
    </div>
</body>
</html>
