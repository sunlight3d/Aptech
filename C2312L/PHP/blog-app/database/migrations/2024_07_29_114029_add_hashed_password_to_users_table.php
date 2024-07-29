<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    

     public function up(): void
     {
        
         Schema::table('users', function (Blueprint $table) {
             $table->string('hashed_password', 255)->after('role')->nullable();
         });
     }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('users', function (Blueprint $table) {
            $table->dropColumn('hashed_password');
        });
    }
};
