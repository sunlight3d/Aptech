package nguyenvana.aprotrain.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nguyenvana.aprotrain.com.models.Reminder;

public class MainActivity extends AppCompatActivity {
    private ListView listViewReminder;
    private Toolbar toolbar;
    private List<Reminder> reminders = new ArrayList<Reminder>();
    private ReminderAdapter reminderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        listViewReminder = findViewById(R.id.listViewReminder);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Reminder");
        //fake data
        reminders.add(new Reminder("Buy cream", true));
        reminders.add(new Reminder("Go to school", false));
        reminders.add(new Reminder("Go to football match", true));
        reminders.add(new Reminder("Buy a book", true));
        reminders.add(new Reminder("Buy something", false));
        reminderAdapter = new ReminderAdapter(getApplicationContext(),R.id.listViewReminder,reminders);
        listViewReminder.setAdapter(reminderAdapter);
        //ListView has "context menu"
        listViewReminder.setLongClickable(true);
        registerForContextMenu(listViewReminder);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.listViewReminder) {
            menu.add("Edit Reminder");
            menu.add("Delete Reminder");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        Reminder selectedReminder = reminders.get(info.position);
        if(item.getTitle().equals("Edit Reminder")) {
            return true;
        }else if(item.getTitle().equals("Delete Reminder")) {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Delete");
            alert.setMessage("Are you sure you want to delete?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alert.show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}