package nguyenvana.aprotrain.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSkip;
    private Button btnNext;
    private TextView textViewHeader;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        btnSkip = findViewById(R.id.btnSkip);
        btnNext = findViewById(R.id.btnNext);
        textViewHeader = findViewById(R.id.textViewHeader);
        textViewHeader.setText("haha");
        btnSkip.setOnClickListener((View view) -> {
            //Log.d(MainActivity.this.getLocalClassName(), "You press Skip");
            Toast.makeText(MainActivity.this, "You press Skip", Toast.LENGTH_LONG)
                    .show();
        });
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                counter++;
                textViewHeader.setText(String.format("%d", counter));
                handler.postDelayed(this, 1000);
            }
        }, 1000); // 1 second delay (takes millis)

        btnNext.setOnClickListener((View view) -> {
            Toast.makeText(MainActivity.this, "You press Next", Toast.LENGTH_LONG)
                    .show();
        });
    }
}