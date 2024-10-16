package nguyenvana.aprotrain.com;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import nguyenvana.aprotrain.com.dialogs.CustomDialog;
import nguyenvana.aprotrain.com.dialogs.InsertOrUpdate;
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
        reminders.add(new Reminder(1,"Buy cream", true));
        reminders.add(new Reminder(2,"Go to school", false));
        reminders.add(new Reminder(3,"Go to football match", true));
        reminders.add(new Reminder(4,"Buy a book", true));
        reminders.add(new Reminder(5,"Buy something", false));
        reminderAdapter = new ReminderAdapter(getApplicationContext(),R.id.listViewReminder,reminders);
        listViewReminder.setAdapter(reminderAdapter);
        //ListView has "context menu"
        listViewReminder.setLongClickable(true);
        registerForContextMenu(listViewReminder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.more_tab_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.itemAddReminder: {
                CustomDialog customDialog = new CustomDialog(
                        MainActivity.this,
                        new Reminder(),
                        InsertOrUpdate.INSERT);
                customDialog.show();
            }
                break;
            case R.id.itemExit:
                this.finishAffinity();
                break;
        }
        return true;
    }


    public void updateReminder(Reminder reminder) {
        for (Reminder eachReminder : reminders) {
            if (eachReminder.getId() == reminder.getId()) {
                eachReminder.setNoidung(reminder.getNoidung());
                eachReminder.setQuantrong(reminder.isQuantrong());
                break;
            }
        }
        reminderAdapter.notifyDataSetChanged();
    }
    public void insertReminder(Reminder reminder) {
        if(reminder.getNoidung().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "You must enter reminder's name", Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if(reminders.stream()
                .filter(item -> item.getNoidung().toLowerCase().equals(reminder.getNoidung().toLowerCase()))
                .toArray().length > 0) {
            Toast.makeText(getApplicationContext(), "Reminder exists, try another", Toast.LENGTH_LONG)
                    .show();
            return;
        }
        reminders.add(reminder);
        reminderAdapter.notifyDataSetChanged();
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
            //show custom alert dialog
            CustomDialog customDialog = new CustomDialog(MainActivity.this, selectedReminder, InsertOrUpdate.UPDATE);
            customDialog.show();
            return true;
        }else if(item.getTitle().equals("Delete Reminder")) {
            AlertDialog.Builder alert = new AlertDialog.Builder(
                    MainActivity.this);
            alert.setTitle("Delete");
            alert.setMessage("Are you sure you want to delete?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    reminders.remove(selectedReminder);
                    reminderAdapter.notifyDataSetChanged();
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