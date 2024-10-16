<?php

namespace App\Http\Controllers;
use Illuminate\Support\Facades\DB;
use Illuminate\Http\Request;

class UserController extends Controller
{
    public function login()
    {   
        
        return view('login');//trả về cho trình duyệt view tên là sum.blade.php
    }  
    public function signin(Request $request)
    {     
        $request->validate([            
            'username' => 'required',
            'password' => 'required',
        ]);
        
        $username = $request->username;
        $password = $request->password;
        //echo "username = $username, password = $password";
        $user = DB::table('users')
                  ->where('name', $username)
                  ->where('password', $password)
                  ->first();
        //print_r($user);
        if(isset($user)) {
            return view('home');    
        }
        return view('login');
    }  

}
