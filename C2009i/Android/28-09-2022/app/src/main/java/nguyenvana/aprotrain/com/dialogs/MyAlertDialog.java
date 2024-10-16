package nguyenvana.aprotrain.com.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Date;

import nguyenvana.aprotrain.com.R;
import nguyenvana.aprotrain.com.activities.MainActivity;
import nguyenvana.aprotrain.com.models.Note;

public class MyAlertDialog extends Dialog {

    private Context context;
    private Button btnCommit, btnCancel;
    private EditText editTextContent;
    private CheckBox checkBoxImportant;
    private Note note;

    public MyAlertDialog(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    public Note getNote() {
        return note;
    }
    private boolean isInsert() {
        return note == null;
    }
    public void setNote(Note updatedNote) {
        this.note = updatedNote;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_alert_dialog);
        this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        btnCommit = findViewById(R.id.btnCommit);
        btnCancel = findViewById(R.id.btnCancel);
        editTextContent = findViewById(R.id.editTextContent);
        checkBoxImportant = findViewById(R.id.checkBoxImportant);
        editTextContent.setText(isInsert()  ? "" : note.getContent());
        checkBoxImportant.setChecked(isInsert() ? false : note.isImportant());

        btnCommit.setOnClickListener((View view) -> {
            boolean canEditData = context instanceof MainActivity &&
                    editTextContent.getText().toString().trim().length() > 0;
            if(!canEditData) {
                return;
            }
            if(isInsert()) {
                ((MainActivity) context).insertNote(new Note(
                        editTextContent.getText().toString(),
                        checkBoxImportant.isChecked(),
                        new Date()
                        ));
            } else {
                ((MainActivity) context).updateNote(this.note.getId(), new Note(
                        editTextContent.getText().toString(),
                        checkBoxImportant.isChecked(),
                        new Date()
                ));
            }
            MyAlertDialog.this.dismiss();
        });
        btnCancel.setOnClickListener((View view) -> {
            MyAlertDialog.this.dismiss();
        });
    }
}
