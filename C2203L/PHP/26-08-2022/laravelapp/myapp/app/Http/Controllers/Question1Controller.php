<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class Question1Controller extends Controller
{
    //DI = Dependency Injection
    public function showName(Request $request) {
        //print_r($request);
        $username = $request->input('username');
        return view('question01.showName', [
            'username' => $username,
        ]);
    }
    public function showColor(Request $request) {
        //print_r($request);
        $message = $request->input('message');
        $messages = explode(" ",$message);
        print_r($messages);
        return view('question01.showColor', [
            'messages' => $messages,
        ]);
    }
}
