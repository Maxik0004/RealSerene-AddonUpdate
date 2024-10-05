package com.aang23.realserene.utils;

import com.aang23.realserene.config.RealSereneSettings;
import org.joda.time.DateTime;

public class SeasonsHelper {
    public static class SeasonsChecker {
        // Summer checks
        public static boolean isEarlySummer() {
            DateTime starting = getDateFromString(RealSereneSettings.start_EARLY_SUMMER.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_EARLY_SUMMER.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isMidSummer() {
            DateTime starting = getDateFromString(RealSereneSettings.start_MID_SUMMER.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_MID_SUMMER.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isLateSummer() {
            DateTime starting = getDateFromString(RealSereneSettings.start_LATE_SUMMER.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_LATE_SUMMER.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        // Autumn checks
        public static boolean isEarlyAutumn() {
            DateTime starting = getDateFromString(RealSereneSettings.start_EARLY_AUTUMN.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_EARLY_AUTUMN.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isMidAutumn() {
            DateTime starting = getDateFromString(RealSereneSettings.start_MID_AUTUMN.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_MID_AUTUMN.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isLateAutumn() {
            DateTime starting = getDateFromString(RealSereneSettings.start_LATE_AUTUMN.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_LATE_AUTUMN.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        // Winter checks
        public static boolean isEarlyWinter() {
            DateTime starting = getDateFromString(RealSereneSettings.start_EARLY_WINTER.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_EARLY_WINTER.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isMidWinter() {
            DateTime starting = getDateFromString(RealSereneSettings.start_MID_WINTER.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_MID_WINTER.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isLateWinter() {
            DateTime starting = getDateFromString(RealSereneSettings.start_LATE_WINTER.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_LATE_WINTER.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        // Spring checks
        public static boolean isEarlySpring() {
            DateTime starting = getDateFromString(RealSereneSettings.start_EARLY_SPRING.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_EARLY_SPRING.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isMidSpring() {
            DateTime starting = getDateFromString(RealSereneSettings.start_MID_SPRING.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_MID_SPRING.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isLateSpring() {
            DateTime starting = getDateFromString(RealSereneSettings.start_LATE_SPRING.get());
            DateTime ending = getDateFromString(RealSereneSettings.stop_LATE_SPRING.get());
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }
    }

    private static DateTime getDateFromString(String input) {
        DateTime toreturn = new DateTime().withDayOfMonth(Integer.parseInt(input.split("/")[0])).withMonthOfYear(Integer.parseInt(input.split("/")[1])).withYear(TimeUtils.getYear());
        return toreturn;
    }

    private static DateTime getCurrentDate() {
        DateTime toreturn = new DateTime().withDayOfMonth(TimeUtils.getDay()).withMonthOfYear(TimeUtils.getMonth()).withYear(TimeUtils.getYear());
        return toreturn;
    }
}
