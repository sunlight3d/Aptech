package com.app.aptech.utilities;

import android.content.Context;
import android.widget.Toast;

public class Utility {
    public static boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.*[a-z]*";
        return email.matches(emailPattern) && email.trim().length() > 0;
    }
    public static void alert(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
