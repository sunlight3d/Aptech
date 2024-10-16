package nguyenvana.aprotrain.com.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;

import nguyenvana.aprotrain.com.R;
import nguyenvana.aprotrain.com.adapters.CustomAdapter;
import nguyenvana.aprotrain.com.database.NoteModify;
import nguyenvana.aprotrain.com.dialogs.MyAlertDialog;
import nguyenvana.aprotrain.com.models.Note;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private NoteModify noteModify;
    private CustomAdapter customAdapter;
    private MyAlertDialog myAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        myAlertDialog = new MyAlertDialog(this);
        //insert fake data
        noteModify = new NoteModify(this);
//        noteModify.insertNote(new Note("di choi", true, new Date()));
//        noteModify.insertNote(new Note("learn Java", false, new Date()));

        listView = findViewById(R.id.listView);
        Cursor cursor = noteModify.getAllNotes();
        customAdapter = new CustomAdapter(this, cursor, false);

        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Enter your choice");
        menu.add("Edit");
        menu.add("Delete");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo contextMenuInfo
                = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int selectedPosition = contextMenuInfo.position;
        long nodeId = contextMenuInfo.id;
        Cursor cursor = (Cursor) customAdapter.getItem(selectedPosition);
        Note selectedNote = Note.getNoteFromCursor(cursor);
        if (item.getTitle().equals("Edit")) {
            myAlertDialog.setNote(selectedNote);
            myAlertDialog.show();
            return true;
        } else if (item.getTitle().equals("Delete")) {
            noteModify.deleteNote(nodeId);
            refreshListView();
            return true;
        } else {
            return false;
        }
    }

    public void insertNote(Note note) {
        this.noteModify.insertNote(note);
        this.refreshListView();
    }
    private void refreshListView() {
        Cursor cursor = noteModify.getAllNotes();
        customAdapter = new CustomAdapter(this, cursor, false);
        listView.setAdapter(customAdapter);
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
                myAlertDialog.show();
                return true;
            case R.id.exit:
                this.finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}