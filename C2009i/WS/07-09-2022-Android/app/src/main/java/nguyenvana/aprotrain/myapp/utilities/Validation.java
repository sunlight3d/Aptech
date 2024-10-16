package nguyenvana.aprotrain.myapp.utilities;

import android.util.Patterns;

public class Validation {
    public static boolean isValidEmail(String email) {
        return !email.isEmpty() &&
                Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches();
    }
}
