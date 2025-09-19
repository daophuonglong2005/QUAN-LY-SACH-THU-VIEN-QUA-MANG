package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final String FORMAT = "yyyy-MM-dd";

    public static String format(Date date) {
        if (date == null) return null;
        return new SimpleDateFormat(FORMAT).format(date);
    }

    public static Date parse(String str) {
        if (str == null || str.isEmpty()) return null;
        try {
            return new SimpleDateFormat(FORMAT).parse(str);
        } catch (ParseException e) {
            return null;
        }
    }
}
