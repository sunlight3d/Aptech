package com.example.myapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapp.R;
import com.example.myapp.models.Person;

public class WelcomeActivity extends AppCompatActivity {
    private Button btnNavigateToLogin;
    private Button btnNavigateToPersonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        btnNavigateToLogin = findViewById(R.id.btnNavigateToLogin);
        btnNavigateToPersonList = findViewById(R.id.btnNavigateToPersonList);

        Person personA = new Person(1, "Hoang", "hoang@gmail.com", "111111111");
        btnNavigateToLogin.setOnClickListener((View view) -> {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("x", 1);
            intent.putExtra("y", 2);
            intent.putExtra("personA", personA);
            startActivity(intent);
        });
        btnNavigateToPersonList.setOnClickListener((View view) -> {
            Intent intent = new Intent(this, PersonListActivity.class);
            startActivity(intent);
        });
    }
}