package nguyenvana.aprotrain.com.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import nguyenvana.aprotrain.com.R;
import nguyenvana.aprotrain.com.models.Note;

public class DetailActivity extends AppCompatActivity {
    private TextView textViewContent;
    private TextView textViewCreatedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        Intent intent = this.getIntent();
        Note selectedNote = (Note)intent.getExtras()
                .getSerializable("selectedNote");
        textViewContent = findViewById(R.id.textViewContent);
        textViewCreatedDate = findViewById(R.id.textViewCreatedDate);

    }
}