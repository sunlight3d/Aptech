<?php

namespace App\Http\Controllers;

use App\Http\Requests\StoreItemRequest;
use App\Http\Requests\UpdateItemRequest;
use App\Models\Item;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Redirect;
use Faker;

class ItemController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    private function generateFakeData() {
        $faker = Faker\Factory::create();
        for ($i = 0; $i < 1000_000; $i++) {
            $fakeName = $faker->name();
            if(Item::where('name', $fakeName)->first() == null) {
                $item = new Item([
                    "name" => $fakeName
                ]);
                $item->save();
            }
        }
    }
    public function index(Request $request)
    {
        //$this->generateFakeData();
        $totalRecords = Item::count();
        $page = $request->input('page') ?? 2;
        $limit = $request->input('limit') ?? 20;
        $totalPages = ceil($totalRecords / $limit);

        $items = Item::skip($page*$limit)
                    ->take($limit)->get();
        return view('items.index', [
            "items" => $items,
            "totalPages" => $totalPages
        ]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \App\Http\Requests\StoreItemRequest  $request
     * @return \Illuminate\Http\Response
     */
    public function store(StoreItemRequest $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Item  $item
     * @return \Illuminate\Http\Response
     */
    public function show(Item $item)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Item  $item
     * @return \Illuminate\Http\Response
     */
    public function edit(Item $item)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \App\Http\Requests\UpdateItemRequest  $request
     * @param  \App\Models\Item  $item
     * @return \Illuminate\Http\Response
     */
    public function update(UpdateItemRequest $request, Item $item)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Item  $item
     * @return \Illuminate\Http\Response
     */
    public function destroy(Item $item)
    {
        //
    }
}
