package com.example.myapp01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfoActivity extends AppCompatActivity {
    private Button btnSend;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo_activity);
        btnSend = findViewById(R.id.btnSend);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);

        btnSend.setOnClickListener((View view) ->{
            //Toast.makeText(getApplicationContext(), "You pressed me!",Toast.LENGTH_LONG).show();
            String message = String.format("Firstname: %s, lastName: %s, email: %s",
                    editTextFirstName.getText().toString(),
                    editTextLastName.getText().toString(),
                    editTextEmail.getText().toString()
            );
            new AlertDialog.Builder(UserInfoActivity.this)
                    .setTitle("Your Alert")
                    .setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("ok", (DialogInterface dialog, int which) -> {

                }).show();
        });
    }
}