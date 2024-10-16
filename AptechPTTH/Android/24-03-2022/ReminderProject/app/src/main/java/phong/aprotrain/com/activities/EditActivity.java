package phong.aprotrain.com.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import phong.aprotrain.com.R;

public class EditActivity extends AppCompatActivity {
    private  EditText editText;
    private TextView textViewValidate;
    private  Button buttonStatus;
    private Button buttonCancel;
    private Button buttonCommit;
    private TextView textHiddenId;
    private String textStatus;
    private Boolean isValidInput;

    private String errorText = "";
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));


        editText = (EditText) findViewById(R.id.editText);
        buttonStatus = (Button) findViewById(R.id.buttonStatus);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCommit = (Button) findViewById(R.id.buttonCommit);
        textViewValidate = (TextView) findViewById(R.id.textViewValidate);
        textHiddenId = (TextView) findViewById(R.id.textHiddenId);

        String noidung = MainActivity.noidung;
        boolean quantrong = MainActivity.quantrong;
        String position = MainActivity.positionToEdit;

        textHiddenId.setText(position);
        editText.setText(noidung);
        if(quantrong == false ){
            buttonStatus.setText("Unimportant");
        }else{
            buttonStatus.setText("Important");
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = editText.getText().toString().trim();
                isValidInput = (text.length() > 0);
                EditActivity.this.errorText = isValidInput == true ? "" : "Text must not blank";
                buttonCommit.setEnabled(isValidInput);
                textViewValidate.setText(EditActivity.this.errorText);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        buttonCancel.setOnClickListener((View view) -> { //thuc thi click trong interface, on click la ban se lam gi do
            //show small alert
            Intent createIntent = new Intent(EditActivity.this, MainActivity.class);
            startActivity(createIntent);
        });

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
        buttonCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = buttonStatus.getText().toString();
                String text = editText.getText().toString().trim();
                String statusName = buttonStatus.getText().toString().trim();
                if(text != null){
                    if(s.contains("Important") ){
                        MainActivity.onEditPostReminder(position, text, true);
                    }else if(s.contains("Unimportant") ) {
                        MainActivity.onEditPostReminder(position,text, false);
                    }
                    Intent createIntent = new Intent(EditActivity.this, MainActivity.class);
                    startActivity(createIntent);
                }

            }
        });

    }
    */

}