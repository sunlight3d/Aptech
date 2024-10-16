package com.aptech;

import java.text.SimpleDateFormat;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class Helper {
    public static String getDateString(String strDate, Locale locale) {
        try {
            String pattern = "dd MMMM yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
            return new SimpleDateFormat("dd MMMM yyyy", locale).format(date).toString();
        }catch (Exception e) {
            return "";
        }
    }
}
