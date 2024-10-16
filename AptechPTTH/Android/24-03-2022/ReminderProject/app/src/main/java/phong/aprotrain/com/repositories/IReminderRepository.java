package phong.aprotrain.com.repositories;

import java.io.Serializable;
import java.util.ArrayList;

import phong.aprotrain.com.model.Reminder;

public interface IReminderRepository {
    public void insertReminder(Reminder reminder);
    public Reminder updateReminder(String name, Reminder reminder);
    public void deleteReminder(String name);
    public ArrayList<Reminder> getAllReminders();
}
