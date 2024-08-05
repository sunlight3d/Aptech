<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog Home</title>
    @vite('resources/css/app.css') <!-- Assuming Tailwind CSS is set up -->
</head>

<body class="bg-gray-100 text-gray-900 font-sans">
    @include('header')

    <!-- Search Bar -->
    <div class="text-center py-6">
        <form action="{{ route('home') }}" method="GET">
            <input type="text" name="query" placeholder="Search posts..."
                class="px-4 py-2 border border-gray-300 rounded-md shadow-sm max-w-md">
            <button type="submit" class="ml-2 px-4 py-2 bg-blue-500 text-white rounded-md hover:bg-blue-600">Search</button>
        </form>
    </div>

    <!-- Hero Section -->
    <div class="hero bg-blue-500 text-white text-center py-20">
        <h1 class="text-4xl font-bold">Welcome to Our Blog</h1>
        <p class="mt-3 text-xl">Your one-stop destination for the latest articles and updates.</p>
        <a href="#latest-posts" class="mt-5 inline-block px-6 py-3 bg-red-600 text-white rounded-lg shadow-lg hover:bg-red-700 transition-colors">Start Reading</a>
    </div>

    <!-- Grid Layout for Posts -->
    <section id="latest-posts" class="py-12 bg-gray-50">
        <h2 class="text-3xl text-center font-semibold mb-10">Latest Posts</h2>
        <div class="grid grid-cols-1 md:grid-cols-3 lg:grid-cols-4 gap-6 max-w-7xl mx-auto px-4">
            @foreach($posts as $post)
            <div class="post bg-white rounded-lg shadow-lg overflow-hidden">
                <div class="p-4">
                    <p class="text-gray-600">{{ Str::limit($post->content, 100) }}</p>
                    <a href="{{ route('posts.show', $post->id) }}" class="inline-block mt-4 text-blue-600 hover:text-blue-800">Read More</a>
                </div>
            </div>
            @endforeach
            <!-- Pagination Links -->

        </div>

    </section>
    <div class="mt-4 flex justify-center">
        {{ $posts->links() }} <!-- This line automatically generates pagination links -->
    </div>

    <!-- Newsletter Subscription Section -->
    <section class="newsletter py-12 bg-white">
        <h2 class="text-3xl text-center font-semibold mb-6">Subscribe to our Newsletter</h2>

    </section>

    @include('footer')
</body>

</html>