<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    @vite('resources/css/app.css')
</head>
<body class="bg-blue-500 flex items-center justify-center min-h-screen bg-gradient-to-r from-purple-400 via-pink-500 to-blue-500"> <!-- Assuming the login page has a blue background -->
    <div class="w-full max-w-md p-8 space-y-4 bg-white rounded-lg shadow-lg" > <!-- Matched the card style from the login page -->
        <h2 class="text-2xl font-semibold text-center">Register</h2>
        <form action="{{ route('users.store') }}" method="POST" class="space-y-6">
            @csrf
            <div>
                <label for="email" class="block text-sm font-medium text-gray-700">Email:</label>
                <input type="email" id="email" name="email" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" required>
            </div>
            <div>
                <label for="fullname" class="block text-sm font-medium text-gray-700">Full Name:</label>
                <input type="text" id="fullname" name="fullname" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" required>
            </div>  
            <div>
                <label for="password" class="block text-sm font-medium text-gray-700">Password:</label>
                <input type="password" id="password" name="password" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" required>
            </div>
            <div>
                <label for="password_confirmation" class="block text-sm font-medium text-gray-700">Confirm Password:</label>
                <input type="password" id="password_confirmation" name="password_confirmation" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" required>
            </div>
            <button type="submit" class="w-full flex justify-center py-3 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-gradient-to-r from-purple-400 via-pink-500 to-blue-500 text-white rounded-md hover:bg-gradient-to-l"> <!-- Matching the button style from the login page -->
                Register
            </button>
        </form>
        @if ($errors->any())
            <div class="p-4 mt-4 rounded-md bg-red-50 border border-red-400 text-red-700">
                <ul>
                    @foreach ($errors->all() as $error)
                        <li>{{ $error }}</li>
                    @endforeach
                </ul>
            </div>
        @endif
        @if (session('success'))
            <div class="p-4 mt-4 rounded-md bg-green-50 border border-green-400 text-green-700">
                {{ session('success') }}
            </div>
        @endif
    </div>
</body>
</html>
