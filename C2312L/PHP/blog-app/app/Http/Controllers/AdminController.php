<?php

namespace App\Http\Controllers;

use App\Models\Post;
use App\Models\User;
use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Support\Facades\Gate;

class AdminController extends Controller
{
    public function __construct()
    {
        $this->middleware('auth'); // Ensure user is authenticated
        $this->middleware(function ($request, $next) {
            if (Gate::allows('admin-only', auth()->user())) {
                return $next($request);
            }
            abort(403);
        });
    }

    public function index()
    {
        $posts = Post::all();
        $users = User::all();
        return view('admin.dashboard', compact('posts', 'users'));
    }
}
