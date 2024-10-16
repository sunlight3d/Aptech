<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Employee;

class EmployeeController extends Controller
{
    public function index(Request $request) {
        //generate_fake_data();
        $employees = Employee::all();
        return view('question02.index', [
            //"dbname" => env('DB_DATABASE')
            "employees" => $employees
        ]);
    }
    private function generate_fake_data() {
        //make fake employees
        $some_fake_customers = [
            [
                'employee_name' => 'JOHNnuds juds',
                'salary' => 72000,
                'post' => 'dsmfd fdijf do'
            ],
            [
                'employee_name' => 'JddsOHNnuds juds',
                'salary' => 4000,
                'post' => 'xxdsmfd fdijf do'
            ],
            [
                'employee_name' => 'JOHNnuds juds',
                'salary' => 1000,
                'post' => 'yydsssmfd fdijf do'
            ],
            [
                'employee_name' => 'JOHNnuds juds',
                'salary' => 1500,
                'post' => 'zzdssssmfd fdijf do'
            ]
        ];
        foreach($some_fake_customers as $some_fake_customer) {
            $employee = Employee::create($some_fake_customer);
            $employee->save();
        }
    }
    public function create(Request $request) {
        //validate ?
        $employee = Employee::create([
            'employee_name' => $request->input('employee_name'),
            'salary' => $request->input('salary'),
            'post' => $request->input('post'),
        ]);
        $employee->save();
        return redirect('/employees');
    }
    public function edit(Request $request, $id) {
        //find Employee by ID
        $employee = Employee::find($id);
        //dd($employee);
        return view('question02.edit', [
            //"dbname" => env('DB_DATABASE')
            "employee" => $employee
        ]);
    }
    public function update(Request $request, $id) {
        //find Employee by ID
        dd("haha");
        $employee = Employee::find($id);
    }
}
