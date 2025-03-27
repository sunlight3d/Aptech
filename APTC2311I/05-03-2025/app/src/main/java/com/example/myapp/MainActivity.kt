package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myapp.ui.calculation.CalculationScreen
import com.example.myapp.ui.login.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val x:Int = 10;//val = value = immutable
        //x = 12;
        var y:Int = 120; //var = variable
        y = 130;
        val result = sum(x, y);
        println("ket qua la: $result");
        setContent {
            //single view application
            //WelcomeScreen() //Man hinh Welcome la man hinh no-state
            //CounterScreen()
            //LoginScreen()
            CalculationScreen()
        }
    }
}
fun sum(a: Int, b: Int): Int{
    return a + b;
}

