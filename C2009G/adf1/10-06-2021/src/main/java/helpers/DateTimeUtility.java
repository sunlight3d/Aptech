package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateTimeUtility {
    //ko can tao object DateTimeUtility moi khi goi ham
    public static Date convertStringToDateTime(String stringDateTime) {
        try {
            System.out.println("haha");
            return new SimpleDateFormat("dd/MM/yyyy").parse(stringDateTime);
        }catch (ParseException exception) {
            //return new Date();
            return null;
        }

    }
}
