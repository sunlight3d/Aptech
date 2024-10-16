package phong.aprotrain.com.repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

import phong.aprotrain.com.model.Reminder;

public class ReminderRepository implements IReminderRepository, Serializable {
    private ArrayList<Reminder> reminders = new ArrayList<>();
    public ReminderRepository() {
        reminders.add(new Reminder(
                "Buy Cream",
                true)
        );
        reminders.add(new Reminder(
                "Buy Cream",
                false)
        );
        reminders.add(new Reminder(
                "Buy sth",
                true)
        );
        reminders.add(new Reminder(
                "Buy sth",
                true)
        );
    }

    public void setReminders(ArrayList<Reminder> reminders) {
        this.reminders = reminders;
    }

    @Override
    public void insertReminder(Reminder reminder) {
        if(reminder.getNoidung().trim().length() > 0) {
            reminders.add(reminder);
        }
    }

    @Override
    public Reminder updateReminder(String name, Reminder reminder) {
        try {
            Reminder foundReminder = reminders.stream()
                    .filter(eachReminder -> eachReminder
                            .getNoidung().trim().toLowerCase()
                            .equals(name.trim().toLowerCase()))
                    .findAny()
                    .orElse(null);
            if(foundReminder != null) {
                foundReminder.setNoidung(reminder.getNoidung());
                foundReminder.setQuantrong(reminder.isQuantrong());
            }
            return foundReminder;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteReminder(String noidung) {
        reminders.removeIf(eachReminder -> eachReminder.getNoidung().equals(noidung));
    }

    @Override
    public ArrayList<Reminder> getAllReminders() {
        return reminders;
    }

}
