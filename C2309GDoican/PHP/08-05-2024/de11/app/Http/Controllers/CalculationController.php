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

    public function calculate(Request $request)
    {
        $request->validate([
            //hàm validate của đối tượng $request trong Laravel
            //trong php thuần ko có
            'number1' => 'required|numeric',
            'number2' => 'required|numeric',
        ]);
        
        $number1 = $request->number1; //$_POST['number1']
        $number2 = $request->number2;
        $sum = $number1 + $number2;
        echo "haha, this is in calulate function";
        print_r($sum);        
        return view('sum', ['sum' => $sum]);
        //return back()->with('result', 'Tổng của hai số là: ' . $sum);
    }
}
