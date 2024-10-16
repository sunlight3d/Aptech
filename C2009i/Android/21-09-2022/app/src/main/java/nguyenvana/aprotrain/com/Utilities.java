package nguyenvana.aprotrain.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
    private static String MY_DATE_FORMAT = "dd-MM-yyyy hh:mm:ss";
    public static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(MY_DATE_FORMAT);
        return dateFormat.format(date);
    }
    public static Date convertStrignToDate(String strDate){
        try {
            return new SimpleDateFormat(MY_DATE_FORMAT).parse(strDate);
        } catch (Exception e) {
            return new Date();
        }

    }
}
