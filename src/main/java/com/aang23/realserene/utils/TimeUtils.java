package com.aang23.realserene.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.aang23.realserene.config.RealSereneSettings;
import org.joda.time.DateTime;

public class TimeUtils {
    public static int totalSecondTime = (24 * 60 * 60);
    public static int syncValue = 6000;

    public static int getMonth() {
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("MM");
        LocalDateTime time = LocalDateTime.now();
        return Integer.parseInt(hourFormat.format(time));
    }

    public static int getDay() {
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("dd");
        LocalDateTime time = LocalDateTime.now();
        return Integer.parseInt(hourFormat.format(time));
    }

    public static int getRawTickTime() {
        return (int) Math.round(getTimeValue() * 24000);
    }

    public static double getTimeValue() {
        return ((double) getRawSeconds() / (double) totalSecondTime);
    }

    public static int getRawSeconds() {
        return (getHours() * 60 * 60) + (getMinutes() * 60) + getSeconds();
    }

   public static int getHours() {
    LocalDateTime time = LocalDateTime.now();
    int timeShiftValue = RealSereneSettings.timeShift.get(); // Retrieve the integer value
    DateTime currentHour = new DateTime(time).plusHours(timeShiftValue); // Use the integer value
    return currentHour.getHourOfDay();
}

    public static int getMinutes() {
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("mm");
        LocalDateTime time = LocalDateTime.now();
        return Integer.parseInt(hourFormat.format(time));
    }

    public static int getSeconds() {
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("ss");
        LocalDateTime time = LocalDateTime.now();
        return Integer.parseInt(hourFormat.format(time));
    }

    public static int getYear() {
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("YY");
        LocalDateTime time = LocalDateTime.now();
        return Integer.parseInt(hourFormat.format(time));
    }

    // Syncs the time to real since MC's time differs from real. Eg : 24000 is
    // converted to 18000 to match midnight (Unless the value is changed in the
    // config)
public static int syncToReal(int time) {
    int dayTimeSync = RealSereneSettings.dayTimeSyncValue.get();  // Извлечь значение с помощью get()
    time -= dayTimeSync;
    if (time <= 0) {
        int diff = 0 - time;
        time = 24000 - diff;
    }
    return time;
}
}
