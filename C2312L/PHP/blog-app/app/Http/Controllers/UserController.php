<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;

class UserController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function login()
    {
        
    }

    /**
     * Show the form for creating a new resource.
     */
    public function register()
    {
        return view('users.register');
    }
    public function store(Request $request)
    {
        // When user press "Register"
        //$request => $_POST
        $request->validate([
            'email' => 'required|email|unique:users,email',
            'fullname' => 'required|max:200',
            'role' => 'required|max:20',
            'password' => 'required|min:8',
        ]);
        // Create a new user
        User::create([
            'email' => $request->email,
            'fullname' => $request->fullname,
            'role' => $request->role,
            'hashed_password' => bcrypt($request->password),
        ]);

        // Redirect to a success page
        return redirect()->route('register')->with('success', 'User registered successfully!');
    }


}
