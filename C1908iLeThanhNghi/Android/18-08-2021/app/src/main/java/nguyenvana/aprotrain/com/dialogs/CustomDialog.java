package nguyenvana.aprotrain.com.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.app.DialogCompat;

import nguyenvana.aprotrain.com.MainActivity;
import nguyenvana.aprotrain.com.R;
import nguyenvana.aprotrain.com.models.Reminder;

public class CustomDialog extends Dialog {
    private Reminder reminder;

    private EditText txtNoidung;
    private TextView txtImportant;
    private Button btnCommit;
    private Button btnCancel;
    private Context context;

    public CustomDialog(Context context, Reminder reminder) {
        super(context);
        this.reminder = reminder;
        this.context = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        txtNoidung = findViewById(R.id.txtNoidung);
        txtImportant = findViewById(R.id.txtImportant);
        btnCommit = findViewById(R.id.btnCommit);
        btnCancel = findViewById(R.id.btnCancel);
        btnCommit.setOnClickListener((View view) -> {
            MainActivity mainActivity = (MainActivity)(CustomDialog.this.context);
            reminder.setNoidung(txtNoidung.getText().toString());
            mainActivity.updateReminder(reminder);
            this.dismiss();
        });
        btnCancel.setOnClickListener((View view) -> {
            CustomDialog.this.dismiss();
        });
        int screenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.getWindow().setLayout((int)(0.9 * screenWidth), 700);
        fetchDataToUI();


    }
    private void fetchDataToUI() {
        txtNoidung.setText(reminder.getNoidung());
        txtImportant.setText(reminder.isQuantrong() ? "Important" : "Not important");
    }
}
