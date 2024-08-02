<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Contracts\Auth\Authenticatable as AuthenticatableContract;
use Illuminate\Auth\Authenticatable;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Facades\Hash;
class User extends Model implements AuthenticatableContract
{
    use Authenticatable;
    use HasFactory;
    protected $table = 'users';
    // If you want to hash passwords automatically
    protected static function boot()
    {
        parent::boot();

        static::creating(function ($user) {
            $user->password = Hash::make($user->password);
        });
    }
    protected $fillable = [
        'email', 
        'fullname', 
        'role',
        'password'
    ];
}
