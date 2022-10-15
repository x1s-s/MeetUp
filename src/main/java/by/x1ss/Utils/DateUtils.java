package by.x1ss.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static Date StingToDate(String date) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH).parse(date);
    }
}
