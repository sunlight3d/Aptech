package phong.aprotrain.com.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import phong.aprotrain.com.R;
import phong.aprotrain.com.model.Reminder;
import phong.aprotrain.com.repositories.IReminderRepository;

public class InsertReminderActivity extends AppCompatActivity {
    public static IReminderRepository reminderRepository;

    private EditText editText;
    private TextView textViewValidate;
    private Button buttonStatus;
    private Button buttonCancel;
    private Button buttonCommit;
    private String textStatus;
    private Boolean isValidInput;

    private String errorText = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_view);
        //reminderRepository = (IReminderRepository) (getIntent().getSerializableExtra("reminderRepository"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        //ánh xạ
        editText = (EditText) findViewById(R.id.editText);
        buttonStatus = (Button) findViewById(R.id.buttonStatus);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCommit = (Button) findViewById(R.id.buttonCommit);
        textViewValidate = (TextView) findViewById(R.id.textViewValidate);


        //hoạt động của text: validate dữ liệu
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = editText.getText().toString().trim();
                isValidInput = (text.length() > 0);
                InsertReminderActivity.this.errorText = isValidInput == true ? "" : "Text must not blank";
                buttonCommit.setEnabled(isValidInput);
                textViewValidate.setText(InsertReminderActivity.this.errorText);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //hủy và back lại sang trang chính
        buttonCancel.setOnClickListener((View view) -> { //thuc thi click trong interface, on click la ban se lam gi do
            //show small alert
                    Intent createIntent = new Intent(InsertReminderActivity.this, MainActivity.class);
                    startActivity(createIntent);
            });

        //chuyển thanh trạng thái
        buttonStatus.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = buttonStatus.getText().toString();
                if(s.contains("Important") ){
                    buttonStatus.setText("Unimportant");
                }else if(s.contains("Unimportant") ) {
                    buttonStatus.setText("Important");
                }
            }
        }));

        //gửi
        buttonCommit.setOnClickListener((View view) -> {
            Log.d("xx", "ddd");
            String status = buttonStatus.getText().toString();
//                String noidung = editText.getText().toString().trim();
//                if(noidung != null){
//                    Boolean newStatus = status.trim().toLowerCase().contains("important");
//                    reminderRepository.insertReminder(new Reminder(noidung, newStatus));
//                    //goback
//                    InsertReminderActivity.this.finish();
//                    //reload Main
//                }

        });
    }
}