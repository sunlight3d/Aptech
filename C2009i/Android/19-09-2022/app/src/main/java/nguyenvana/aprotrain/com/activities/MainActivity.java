package nguyenvana.aprotrain.com.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Date;

import nguyenvana.aprotrain.com.R;
import nguyenvana.aprotrain.com.adapters.CustomAdapter;
import nguyenvana.aprotrain.com.database.NoteModify;
import nguyenvana.aprotrain.com.models.Note;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private NoteModify noteModify;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //insert fake data
        noteModify = new NoteModify(this);
//        noteModify.insertNote(new Note("di choi", true, new Date()));
//        noteModify.insertNote(new Note("learn Java", false, new Date()));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_note:

                return true;
            case R.id.exit:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}