package by.x1ss.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static Date stringToDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH).parse(date);
        } catch (ParseException e){
            return null;
        }
    }
}
