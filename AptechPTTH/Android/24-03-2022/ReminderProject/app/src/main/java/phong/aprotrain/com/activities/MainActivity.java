package phong.aprotrain.com.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import phong.aprotrain.com.R;
import phong.aprotrain.com.adapter.ReminderAdapter;
import phong.aprotrain.com.model.Reminder;
import phong.aprotrain.com.repositories.IReminderRepository;
import phong.aprotrain.com.repositories.ReminderRepository;

public class MainActivity extends AppCompatActivity {
    //Activity -> Repository -> Fake data || Call Web Service || (Database SQLite)
    private ListView listViewReminder;
    private ArrayList<Reminder> reminders; //static: khi doi tuong ton tai mai mai
    private ReminderAdapter reminderAdapter;
    //?
    private Reminder selectedReminder;

    private IReminderRepository reminderRepository = new ReminderRepository();
    //private IReminderRepository reminderRepository = new SqliteRepository();
//    protected static String noidung;
//    protected static boolean quantrong;
//    protected static String positionToEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        listViewReminder = findViewById(R.id.listViewReminder);
        reminders = reminderRepository.getAllReminders();
        reminderAdapter = new ReminderAdapter(this, reminders);listViewReminder.setAdapter(reminderAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.newReminder: {
                Intent intent = new Intent(
                        MainActivity.this,
                        InsertReminderActivity.class);
                //intent.putExtra("reminderRepository", (ReminderRepository)reminderRepository);
                MainActivity.this
                        .startActivity(intent);
                InsertReminderActivity.reminderRepository = reminderRepository;
            }

            case R.id.exit:System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

//    public void onCreateReminder(String textName,boolean status){
//        reminders.add(new Reminder(textName, status));
//    }
//
//    public void onRemoveReminder(int position){
//        reminders.remove(position);
//    }

//    public void onEditViewReminder(int position){
//        Reminder sReminder = reminders.get(position);
//        noidung = sReminder.getNoidung();
//        quantrong = sReminder.isQuantrong();
//        positionToEdit = String.valueOf(position);
//    }
//    public void onEditPostReminder(String position, String textName,boolean status){
//        reminders.set(Integer.parseInt(position), new Reminder(textName, status));
//        //reminders.remove(position);
//    }
}