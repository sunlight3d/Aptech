<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Post;

class HomeController extends Controller
{
    public function index()
    {
        // Fetch only the latest posts
        $latestPosts = Post::orderBy('created_at', 'desc')->take(10)->get(); // Fetch latest 10 posts        
        return view('home', compact('latestPosts'));
    }
}
