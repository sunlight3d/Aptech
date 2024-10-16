<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        if (!Schema::hasTable('tblPerson')) {
            Schema::create('tblPerson', function (Blueprint $table) {
                $table->increments('id')->start_from(1);
                $table->string('name', 150)->index();
                $table->integer('gender')->default(0);
                $table->date('dateOfBirth');
                $table->timestamps();
            });
        }
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('people');
    }
};
