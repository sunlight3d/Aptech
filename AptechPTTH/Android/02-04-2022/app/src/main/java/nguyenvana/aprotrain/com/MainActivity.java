package nguyenvana.aprotrain.com;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import nguyenvana.aprotrain.com.adapters.CustomAdapter;
import nguyenvana.aprotrain.com.database.NoteModify;
import nguyenvana.aprotrain.com.dialogs.NoteAlertDialog;
import nguyenvana.aprotrain.com.models.Note;

public class MainActivity extends AppCompatActivity {
    private ListView listViewNote;
    //mock, fake data
    private ArrayList<Note> notes = new ArrayList<Note>();
    private CustomAdapter customAdapter;
    private NoteModify noteModify;
    private Cursor cursor;
    private int selectedPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        listViewNote = findViewById(R.id.listViewNote);
        noteModify = NoteModify.getInstance(this);
        //data => adapter
//        noteModify.insertNote(new Note("Di shopping", false, new Date()));
//        noteModify.insertNote(new Note("sang nha ban B", true, new Date()));
//        noteModify.insertNote(new Note("go for a walk", false, new Date()));

        cursor = noteModify.getNotesCursor();
        customAdapter = new CustomAdapter(this, cursor, true);
        listViewNote.setAdapter(customAdapter);
        listViewNote.setBackgroundColor(Color.WHITE);
        registerForContextMenu(listViewNote);//trong listview phai co nut bam
        listViewNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Note selectedNote = Note.getNoteFromCursor((Cursor) adapterView.getItemAtPosition(i));
                Toast.makeText(MainActivity.this,
                        selectedNote.toString(), Toast.LENGTH_LONG)
                .show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater menuInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
        //return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemMenu = item.getItemId();
        switch (itemMenu) {
            case R.id.itemAdd:
                //Toast.makeText(this, "You press Add", Toast.LENGTH_LONG).show();
                NoteAlertDialog noteAlertDialog = new NoteAlertDialog(this);
                noteAlertDialog.show();
                break;
            case R.id.itemExit:
                Toast.makeText(this, "You press Exit", Toast.LENGTH_LONG).show();
                MainActivity.this.finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo contextMenuInfo
                = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        selectedPosition = contextMenuInfo.position;
        switch (item.getItemId()){
            case R.id.edit:
                //Show a dialog to edit ?
                Cursor cursor = (Cursor) customAdapter.getItem(selectedPosition);
                Note selectedTaskNote = Note.getNoteFromCursor(cursor);
                NoteAlertDialog noteAlertDialog = new NoteAlertDialog(MainActivity.this,
                        selectedTaskNote, NoteAlertDialog.UPDATE);
                noteAlertDialog.show();
                break;
            case R.id.delete:
                //Show confirmation Dialog
                new AlertDialog.Builder(this).
                        setTitle("Delete TaskNote")
                        .setMessage("Are you sure you want to delete this ?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, (DialogInterface dialog, int whichButton) -> {
                            Cursor selectedCursor = (Cursor) customAdapter.getItem(selectedPosition);
                            if(selectedCursor != null) {
                                //Convert cursor => TaskNote Object ?
                                Note note = Note.getNoteFromCursor(selectedCursor);
                                if(note != null) {
                                    //Delete taskNote
                                    NoteModify.getInstance(MainActivity.this).deleteNote(note.getId());
                                    //You must refresh listview after delete !
                                    refreshListView();
                                }
                            }
                        }).setNegativeButton(android.R.string.no, null).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    public void refreshListView(){
        cursor = NoteModify.getInstance(this).getNotesCursor();
        customAdapter.swapCursor(cursor);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //refreshListView();
    }
}