<!-- resources/views/users/register.blade.php -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    @vite('resources/css/app.css')
    <title>Login</title>    
</head>
<body class="bg-gray-100">

    <div class="flex items-center justify-center min-h-screen bg-gradient-to-r from-purple-400 via-pink-500 to-blue-500">
        <div class="bg-white p-10 rounded-lg shadow-lg w-full max-w-md">
            <h2 class="text-2xl font-semibold mb-6 text-center">Login</h2>
            <form action="{{ route('users.signin') }}" method="POST">
                @csrf
                <div class="mb-4">
                    <label for="email" class="block text-gray-700">Email</label>
                    <input type="email" id="email" name="email" placeholder="Type your email" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
                </div>
                
                <div class="mb-4">
                    <label for="password" class="block text-gray-700">Password</label>
                    <input type="password" id="password" name="password" placeholder="Type your password" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
                    <div class="text-right mt-2">
                        <a href="#" class="text-sm text-blue-500 hover:underline">Forgot password?</a>
                    </div>
                </div>            

                <button type="submit" class="w-full py-2 bg-gradient-to-r from-purple-400 via-pink-500 to-blue-500 text-white rounded-md hover:bg-gradient-to-l">Login</button>
            </form>

            @if ($errors->any())
                <div class="mt-6 bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative">
                    <ul>
                        @foreach ($errors->all() as $error)
                            <li>{{ $error }}</li>
                        @endforeach
                    </ul>
                </div>
            @endif

            @if (session('success'))
                <div class="mt-6 bg-green-100 border border-green-400 text-green-700 px-4 py-3 rounded relative">
                    {{ session('success') }}
                </div>            
            @endif

            <div class="mt-6 text-center">
                <p class="text-gray-700">Or Sign in using</p>
                <div class="flex justify-center mt-2">
                    <a href="#" class="text-blue-600 mx-2"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="text-blue-400 mx-2"><i class="fab fa-twitter"></i></a>
                    <a href="#" class="text-red-600 mx-2"><i class="fab fa-google"></i></a>
                </div>
            </div>

            <div class="mt-6 text-center">
                <p class="text-gray-700">Or Sign up using</p>
                <a href="{{ route('users.register') }}" class="text-blue-500 hover:underline">SIGN UP</a>
            </div>
        </div>
    </div>

    <footer class="bg-gray-800 text-white py-4 mt-10">
        <div class="container mx-auto px-4">
            <p class="text-center">&copy; 2024 Your Website. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
