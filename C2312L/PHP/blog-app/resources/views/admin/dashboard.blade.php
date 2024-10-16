<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="{{ asset('css/app.css') }}" rel="stylesheet">
</head>
<body class="bg-gray-100">
    <div class="min-h-screen flex">
        <!-- Sidebar -->
        <div class="w-60 bg-blue-800 text-white p-5">
            <h2 class="font-bold text-lg mb-5">Admin Panel</h2>
            <ul>
                <li class="mb-3">
                    <a href="#" class="hover:text-gray-300">Dashboard</a>
                </li>
                <li class="mb-3">
                    <a href="#" class="hover:text-gray-300">Manage Users</a>
                </li>
                <li class="mb-3">
                    <a href="#" class="hover:text-gray-300">Manage Posts</a>
                </li>
            </ul>
        </div>

        <!-- Main Content -->
        <div class="flex-1">
            <div class="p-6">
                <h1 class="text-2xl font-bold text-gray-800">Dashboard</h1>
                
                <!-- Users Table -->
                <div class="mt-4 bg-white p-6 shadow rounded-lg">
                    <h2 class="text-xl font-semibold mb-4">Users</h2>
                    <table class="w-full text-sm text-left text-gray-500">
                        <thead class="text-xs text-gray-700 uppercase bg-gray-50">
                            <tr>
                                <th scope="col" class="py-3 px-6">User ID</th>
                                <th scope="col" class="py-3 px-6">Name</th>
                                <th scope="col" class="py-3 px-6">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="bg-white border-b hover:bg-gray-50">
                                <td class="py-4 px-6">1</td>
                                <td class="py-4 px-6">John Doe</td>
                                <td class="py-4 px-6">
                                    <a href="#" class="text-blue-500 hover:text-blue-600">Edit</a>
                                    |
                                    <a href="#" class="text-red-500 hover:text-red-600">Delete</a>
                                </td>
                            </tr>
                            <tr class="bg-white border-b hover:bg-gray-50">
                                <td class="py-4 px-6">2</td>
                                <td class="py-4 px-6">Jane Smith</td>
                                <td class="py-4 px-6">
                                    <a href="#" class="text-blue-500 hover:text-blue-600">Edit</a>
                                    |
                                    <a href="#" class="text-red-500 hover:text-red-600">Delete</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <!-- Posts Table -->
                <div class="mt-4 bg-white p-6 shadow rounded-lg">
                    <h2 class="text-xl font-semibold mb-4">Posts</h2>
                    <table class="w-full text-sm text-left text-gray-500">
                        <thead class="text-xs text-gray-700 uppercase bg-gray-50">
                            <tr>
                                <th scope="col" class="py-3 px-6">Post ID</th>
                                <th scope="col" class="py-3 px-6">Title</th>
                                <th scope="col" class="py-3 px-6">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="bg-white border-b hover:bg-gray-50">
                                <td class="py-4 px-6">101</td>
                                <td class="py-4 px-6">How to Start with Laravel</td>
                                <td class="py-4 px-6">
                                    <a href="#" class="text-blue-500 hover:text-blue-600">Edit</a>
                                    |
                                    <a href="#" class="text-red-500 hover:text-red-600">Delete</a>
                                </td>
                            </tr>
                            <tr class="bg-white border-b hover:bg-gray-50">
                                <td class="py-4 px-6">102</td>
                                <td class="py-4 px-6">Tips for Vue.js</td>
                                <td class="py-4 px-6">
                                    <a href="#" class="text-blue-500 hover:text-blue-600">Edit</a>
                                    |
                                    <a href="#" class="text-red-500 hover:text-red-600">Delete</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
