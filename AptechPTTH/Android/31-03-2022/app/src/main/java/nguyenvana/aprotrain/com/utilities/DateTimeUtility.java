package nguyenvana.aprotrain.com.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtility {
    private static String ISO8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static String convertDateToString(Date date) {
        //return date.toString();
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat(ISO8601_FORMAT);
        df.setTimeZone(tz);
        return df.format(new Date());
    }
    public static Date convertStringToDate(String strDate) {
        //return date.toString();
        try {
            DateFormat df1 = new SimpleDateFormat(ISO8601_FORMAT);
            String string1 = "2001-07-04T12:08:56.235-0700";
            return df1.parse(string1);
        }catch (ParseException e) {
            return new Date();
        }

    }
}
