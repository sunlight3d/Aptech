<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Person;
use Faker;

class PersonController extends Controller
{
    private function generateFakeData() {
        $faker = Faker\Factory::create();
        for ($i = 0; $i < 100; $i++) {
            $fakeName = $faker->name();
            $person = new Person([
                "name" => $fakeName,
                "gender" => rand(0,1),
                "dateOfBirth" => $faker->dateTimeBetween('1980-01-01', '2000-12-31')
            ]);
            $person->save();
        }
    }
    public function index(Request $request)
    {
        //$this->generateFakeData();
        $people = Person::all()->take(10);
        return view('people.index', [
            "people" => $people,
        ]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        dd("create");
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        dd("store");
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        dd("show");
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        dd("edit");
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        dd("update");
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        dd("destroy");
    }
}
