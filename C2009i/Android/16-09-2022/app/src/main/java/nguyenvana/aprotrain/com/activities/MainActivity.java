package nguyenvana.aprotrain.com.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import nguyenvana.aprotrain.com.R;
import nguyenvana.aprotrain.com.adapters.CustomAdapter;
import nguyenvana.aprotrain.com.database.NoteModify;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private NoteModify noteModify;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        listView = findViewById(R.id.listView);
        noteModify = new NoteModify(this);
        Cursor cursor = noteModify.getAllNotes();
        customAdapter = new CustomAdapter(this, cursor, false);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}