package com.aptech.myapp.screens;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.aptech.myapp.R;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvHello;
    private Button btnClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Nạp layout activity_main.xml cho Activity
        setContentView(R.layout.main_activity);

        // Ánh xạ (binding) các View với ID trong layout
        tvHello = findViewById(R.id.tvHello);
        btnClickMe = findViewById(R.id.btnClickMe);

        // Bắt sự kiện click cho nút "Click me!"
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvHello.setText("Bạn vừa bấm nút!");
            }
        });
    }
}
