package nguyenvana.aprotrain.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import nguyenvana.aprotrain.myapp.utilities.Alert;
import nguyenvana.aprotrain.myapp.utilities.Validation;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnLogin;
    private TextView textViewErrorEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        this.editTextEmail = findViewById(R.id.editTextEmail);
        this.editTextPassword = findViewById(R.id.editTextPassword);
        this.btnLogin = findViewById(R.id.btnLogin);
        textViewErrorEmail = findViewById(R.id.textViewErrorEmail);

        this.btnLogin.setOnClickListener((View view) -> {
            //validate here
            if (Validation.isValidEmail(editTextEmail.getText().toString())) {
                Alert.show(this, "Error", "You must enter correct email address");
                return;
            }
        });
        this.editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String email = editTextEmail.getText().toString();
                textViewErrorEmail.setText(!Validation.isValidEmail(email) ? "Invalid email address" : "");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}