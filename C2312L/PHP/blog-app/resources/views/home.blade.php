<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog Home</title>
    @vite('resources/css/app.css')
</head>
<body class="bg-gray-100 text-gray-900 font-sans">
    @include('header')

    <!-- Search Bar -->
    <div class="text-center py-6">
        <input type="text" placeholder="Search posts..." class="px-4 py-2 border border-gray-300 rounded-md shadow-sm max-w-md">
    </div>

    <!-- Hero Section -->
    <div class="hero bg-blue-500 text-white text-center py-20">
        <h1 class="text-4xl font-bold">Welcome to Our Blog</h1>
        <p class="mt-3 text-xl">Your one-stop destination for the latest articles and updates.</p>
        <a href="#latest-posts" class="mt-5 inline-block px-6 py-3 bg-red-600 text-white rounded-lg shadow-lg hover:bg-red-700 transition-colors">Start Reading</a>
    </div>

    <!-- Latest Posts -->
    <section id="latest-posts" class="latest-posts py-12 bg-gray-50">
        <h2 class="text-3xl text-center font-semibold mb-10">Latest Posts</h2>
        <div class="posts-grid grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 max-w-6xl mx-auto px-4">
            @foreach($latestPosts as $post)
                <div class="post bg-white rounded-lg shadow overflow-hidden">
                    <img src="{{ $post->thumbnail }}" alt="{{ $post->title }}" class="w-full h-48 object-cover">
                    <div class="p-4">
                        <h3 class="text-xl font-semibold">{{ $post->title }}</h3>
                        <p class="text-gray-600">{{ Str::limit($post->content, 100) }}</p>
                        <a href="{{ route('posts.show', $post->id) }}" class="inline-block mt-4 text-blue-600 hover:text-blue-800">Read More</a>
                    </div>
                </div>
            @endforeach
        </div>
    </section>

    <!-- Newsletter Subscription Section -->
    <section class="newsletter py-12 bg-white">
        <h2 class="text-3xl text-center font-semibold mb-6">Subscribe to our Newsletter</h2>
        
    </section>

    @include('footer')
</body>
</html>
