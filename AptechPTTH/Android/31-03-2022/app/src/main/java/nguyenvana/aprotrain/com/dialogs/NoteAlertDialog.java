package nguyenvana.aprotrain.com.dialogs;

import androidx.annotation.NonNull;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import java.util.Date;

import nguyenvana.aprotrain.com.MainActivity;
import nguyenvana.aprotrain.com.R;
import nguyenvana.aprotrain.com.database.NoteModify;
import nguyenvana.aprotrain.com.models.Note;

public class NoteAlertDialog extends AlertDialog {
    private View view;
    public static int INSERT = 0;
    public static int UPDATE = 1;
    int DATA_TYPE = INSERT;
    private Button btnCommit;
    private Button btnCancel;
    private CheckBox checkBoxImportant;
    private EditText txtContent;
    private Note note;

    public NoteAlertDialog(@NonNull Context context) {
        super(context);
        setupUI();
    }
    public NoteAlertDialog(@NonNull Context context, Note note, int dataType) {
        super(context);
        this.note = note;
        this.DATA_TYPE = dataType;
        setupUI();
    }
    private void setupUI() {
        view = this.getLayoutInflater().inflate(R.layout.note_alert_dialog, null);
        btnCommit = view.findViewById(R.id.btnCommit);
        btnCancel = view.findViewById(R.id.btnCancel);
        checkBoxImportant = view.findViewById(R.id.checkBoxImportant);
        txtContent = view.findViewById(R.id.txtName);
        btnCancel.setOnClickListener(v -> {
            this.dismiss();
        });
        btnCommit.setOnClickListener(v->{
            String noidung = txtContent.getText().toString().trim();
            Boolean quantrong = checkBoxImportant.isChecked();
            if(noidung.trim().equals("")) {
                this.dismiss();
                return;
            }
            if(this.DATA_TYPE == NoteAlertDialog.INSERT) {
                Note newNote = new Note(-1, noidung, quantrong, new Date());
                NoteModify.getInstance(this.getContext()).insertNote(newNote);
            } else if(this.DATA_TYPE == NoteAlertDialog.UPDATE) {
                note.setNoidung(noidung);
                note.setQuantrong(quantrong);
                NoteModify.getInstance(this.getContext()).updateNote(note.getId(), note);
            }
            //refresh MainActivity
            MainActivity mainActivity = (MainActivity) ((ContextWrapper)getContext()).getBaseContext();
            mainActivity.refreshListView();
            this.dismiss();
        });
        if(this.DATA_TYPE == NoteAlertDialog.UPDATE){
            fetchDataToUI();
        }
        this.setView(view);
    }
    private void fetchDataToUI() {
        if(note.getNoidung().trim().length() >0){
            txtContent.setText(note.getNoidung());
            checkBoxImportant.setChecked(note.getQuantrong());
        }
    }
}