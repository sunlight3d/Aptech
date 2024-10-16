package nguyenvana.aprotrain.com;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

import nguyenvana.aprotrain.com.models.Reminder;

public class ReminderAdapter extends ArrayAdapter<Reminder> {
    private List<Reminder> reminders;
    public ReminderAdapter(@NonNull Context context, int resource, @NonNull List<Reminder> reminders) {
        super(context, resource, reminders);
        this.reminders = reminders;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.reminder_item, parent, false);
        View viewLeft = view.findViewById(R.id.viewLeft);
        TextView textViewContent = view.findViewById(R.id.textViewContent);

        Reminder reminder = this.reminders.get(position);

        if(reminder.isQuantrong() == true) {
            viewLeft.setBackgroundColor(0xffff0000);
            textViewContent.setBackgroundColor(0xff009688);
        } else {
            viewLeft.setBackgroundColor(0xff003300);
            textViewContent.setBackgroundColor(0x55555555);
        }

        textViewContent.setText(reminder.getNoidung());
        return view;
    }
}
