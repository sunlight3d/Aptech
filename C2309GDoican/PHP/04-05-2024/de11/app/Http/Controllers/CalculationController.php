<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class CalculationController extends Controller
{
    public function index()
    {
        //Tính toán và làm các cv cần thiết        
        return view('sum');//trả về cho trình duyệt view tên là sum.blade.php
    }
}
