<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Post;
use Illuminate\View\View;

class HomeController extends Controller
{
    public function index(): View
    {
        // Fetch only the latest posts with pagination
        $posts = Post::orderBy('created_at', 'desc')->paginate(6); // Paginate the latest posts, 10 per page

        return view('home', [
            'posts' => $posts
        ]);
    }

    public function show(Request $request)
    {
        // Fetch the post by ID
        $post = Post::findOrFail($request->id);  // Using findOrFail to automatically handle the "post not found" error
        return view('posts.show', compact('post'));
    }
}
