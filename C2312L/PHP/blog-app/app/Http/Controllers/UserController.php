<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Support\Facades\Auth;

class UserController extends Controller
{
    
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
            'password' => 'required|min:8|confirmed',
        ]);
        
        // Create a new user
        User::create([
            'email' => $request->email,
            'fullname' => $request->fullname,
            'role' => 'user',
            'hashed_password' => bcrypt($request->password),
        ]);

        // Redirect to a success page
        return redirect()->route('users.register')->with('success', 'User registered successfully!');
    }
    public function login() {//giao dien login
        return view('users.login');
    }

    public function signin(Request $request)
    {        
        // Validate the incoming request data
        $request->validate([
            'email' => 'required|email'            
        ]);

        // Attempt to authenticate the user
        $credentials = $request->only('email', 'password');

        if (Auth::attempt($credentials)) {
            // Authentication passed, save user data to session
            $request->session()->regenerate();

            // Redirect to a success page
            return redirect()->route('users.login')->with('success', 'Login user successfully!');
        }

        // Authentication failed, redirect back with error
        return redirect()->route('users.login')->withErrors([
            'email' => 'The provided credentials do not match our records.',
        ])->withInput($request->except('password'));
    }
}
