package com.app.aptech.activities.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.aptech.R;
import com.app.aptech.activities.IActivity;
import com.app.aptech.activities.product.ProductListActivity;
import com.app.aptech.utilities.Utility;

public class MainActivity extends AppCompatActivity implements IActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    public void setupUI(){
        //map properties to UI
        editTextEmail = this.findViewById(R.id.editTextEmail);
        editTextPassword = this.findViewById(R.id.editTextPassword);
        btnLogin = this.findViewById(R.id.btnLogin);
        btnRegister = this.findViewById(R.id.btnRegister);
        //fake data
        editTextEmail.setText("hoang@gmail.com");
        editTextPassword.setText("123456");
    }

    @Override
    public void setupActions() {
        btnLogin.setOnClickListener((View v) -> {
            if(!Utility.isValidEmail(editTextEmail.getText().toString().trim())) {
                Utility.alert(getApplicationContext(), "Email is invalid format");
                return;
            }
            if(editTextPassword.getText().length() == 0) {
                Utility.alert(getApplicationContext(), "Password must not be blank");
                return;
            }
            Utility.alert(getApplicationContext(), "Login successful");
            startActivity(new Intent(MainActivity.this, ProductListActivity.class));
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.main_activity);
        setupUI();
        setupActions();
    }
}