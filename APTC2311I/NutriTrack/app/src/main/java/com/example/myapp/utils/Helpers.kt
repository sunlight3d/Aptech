package com.example.myapp.utils

import android.content.Context
import android.widget.Toast

fun alert(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show();
}