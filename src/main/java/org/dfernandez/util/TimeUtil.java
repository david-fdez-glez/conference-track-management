package org.dfernandez.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil {


    public static String getScheduledTime(int minutes) {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("hh:mm a");
        Calendar calendar = Calendar.getInstance();
        int hour = minutes/60;

        minutes -= (hour*60);

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE,minutes);
        calendar.set(Calendar.SECOND,0);

        return dateFormat.format(calendar.getTime());
    }
}
