import java.util.Date;
import java.text.SimpleDateFormat;

public class Helper {
    public static Date convertStringToDate(String stringDate) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
            //vd co 10 dong
        } catch (Exception exception) {
            return new Date();
        }
    }

}
