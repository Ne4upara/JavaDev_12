package sergey.goit.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeFormatter {
    private static String timezone = "GMT";

    public static String getTimezone() {
        return timezone;
    }

    public static String formatTime(Date currentTime, String timezone) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(validTimeZone(timezone)));
        return dateFormat.format(currentTime);
    }

    private static String validTimeZone(String timezoneParam) {
        if (timezoneParam.isEmpty()) {
            return timezone;
        } else {
            timezoneParam = timezoneParam.replace("+", "");
            int tz = Integer.parseInt(timezoneParam);
            if (-1 < tz) {
                timezone = "GMT+" + timezoneParam;
                return timezone;
            } else {
                timezone = "GMT" + timezoneParam;
                return timezone;
            }
        }
    }
}
