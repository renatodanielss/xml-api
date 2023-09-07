package br.com.xml.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeComparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings("unused")
public class DateUtils {

    /**
     * Utility method to check if date1 is equal or greater than today
     *
     * @param date - java.util.Date Object
     * @return a Boolean
     */
    public static Boolean lessThanToday(Date date) {
        return lessThan(date, new Date());
    }

    /**
     * Utility method to check if date1 is equal or greater than date2
     *
     * @param date1 - java.util.Date Object
     * @param date2 - java.util.Date Object
     * @return a Boolean
     */
    @SuppressWarnings("unused")
    public static Boolean equalOrGreater(Date date1, Date date2) {
        DateTimeComparator dateTimeComparator = DateTimeComparator.getDateOnlyInstance();

        int retVal = dateTimeComparator.compare(date1, date2);
        return retVal == 0 || retVal > 0;
    }

    /**
     * Utility method to check if date1 is less than date2
     *
     * @param date1 - java.util.Date Object
     * @param date2 - java.util.Date Object
     * @return a Boolean
     */
    public static Boolean lessThan(Date date1, Date date2) {
        DateTimeComparator dateTimeComparator = DateTimeComparator.getDateOnlyInstance();

        int retVal = dateTimeComparator.compare(date1, date2);
        return retVal < 0;
    }

    /**
     * Utility method to get month int value
     *
     * @param date - java.util.Date Object
     * @return a Integer
     */
    public static Integer getMonth(Date date) {
        return getDateUnit(date, Calendar.MONTH);
    }

    /**
     * Utility method to get year int value
     *
     * @param date - java.util.Date Object
     * @return a Integer
     */
    public static Integer getYear(Date date) {
        return getDateUnit(date, Calendar.YEAR);
    }

    /**
     * Utility method to get date int value
     *
     * @param date - java.util.Date Object
     * @return a Integer
     */
    public static Integer getDate(Date date) {
        return getDateUnit(date, Calendar.DATE);
    }

    private static Integer getDateUnit(Date date, int calendarUnit) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(calendarUnit);
    }

    public static Date addDay(Date date, Integer day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }

    public static Period getInterval(Date minDate, Date maxDate) {
        LocalDate minLocalDate = new Date(minDate.getTime()).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate maxLocalDate = new Date(maxDate.getTime()).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return Period.between(minLocalDate, maxLocalDate);
    }

    public enum FormatType {
        HH_MM("HH:mm", null), DD_MM_YYYY("dd/MM/yyyy", 2), MM_YYYY("MM/yyyy", 1), YYYY_MM("yyyy-MM", 0), DD_MM_YYYY_HH_MM("dd/MM/yyyy HH:mm", null), YYYY_MM_DD("yyyy-MM-dd", 2), YYYY_MM_DD_HH_MM_ISO("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", null), YYYY_MM_DD_HH_MM("yyyy-MM-dd'T'HH:mm", null);

        private final String format;

        private final Integer yearIndex;

        FormatType(String format, Integer yearIndex) {
            this.format = format;
            this.yearIndex = yearIndex;
        }

        public String getFormat() {
            return this.format;
        }

        public String prepareDate(String formattedDate) {
            try {
                return prepare(formattedDate);
            } catch (Exception e) {
                return null;
            }
        }

        private String prepare(String formattedDate) {
            if (this.yearIndex == null) {
                return formattedDate;
            }

            String[] splitted = formattedDate.split("/");
            Integer year = Integer.valueOf(splitted[yearIndex]);

            if (year < 1900) {
                if (year > 30)
                    year = 1900 + year;
                else
                    year = 2000 + year;
            }

            splitted[yearIndex] = String.valueOf(year);
            return StringUtils.join(splitted, "/");
        }
    }

    /**
     * Utility method to format Date object into String by FormatType passed
     *
     * @param date   - java.util.Date Object
     * @param format - FormatType enum
     * @return a String containing the Date value
     */
    public static String format(Date date, FormatType format) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format.getFormat()).format(date);
    }

    /**
     * Utility method to parse a String to a Date object by FormatType passed
     *
     * @param dateString - String object containing the date to be parsed
     * @param format     - FormatType enum
     * @return java.util.Date object
     */
    public static Date parse(String dateString, FormatType format) throws ParseException {
        return new SimpleDateFormat(format.getFormat()).parse(dateString);
    }

    /**
     * Utility method to format a date string by sql format (YYYY-MM-DD)
     *
     * @param dateString       - String containing the date value
     * @param formatType - FormatType of the date string passed
     * @return a String containing the date formatted to sql format (YYYY-MM-DD)
     */
    @SuppressWarnings("unused")
    public static String formatDateStringToMongoFormat(String dateString, FormatType formatType) {
        dateString = formatType.prepareDate(dateString);
        if (dateString == null) {
            return null;
        }

        return formatDate(dateString, formatType.getFormat());
    }

    @SuppressWarnings("unused")
    public static Integer formatTimeToString(String timeString) {
        if (timeString == null)
            return null;

        String[] splitted = timeString.split(":");
        if (splitted.length != 2)
            return null;

        try {
            int hour = Integer.parseInt(splitted[0]);
            int minute = Integer.parseInt(splitted[1]);
            return hour * 3600 + minute * 60;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static String formatDate(String filterValue, String format) {

        SimpleDateFormat sdf_parse = new SimpleDateFormat(format);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T00:00:00.000Z'");

        if (StringUtils.isEmpty(filterValue)) {
            return StringUtils.EMPTY;
        }

        filterValue = filterValue.trim();
        try {
            return sdf.format(sdf_parse.parse(filterValue));
        } catch (ParseException e) {
            return StringUtils.EMPTY;
        }
    }

    @SuppressWarnings("unused")
    public static Long calculateAge(Date date) {
        Calendar cal = Calendar.getInstance(new Locale("pt-BR"));
        cal.setTime(date);
        LocalDate start = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));
        LocalDate end = LocalDate.now();
        return ChronoUnit.YEARS.between(start, end);
    }

    @SuppressWarnings("unused")
    public static Calendar DateToCalendar(Date date, boolean setTimeToZero) {

        if (date == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (setTimeToZero) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        }

        return calendar;
    }

    public static boolean compareByMonthAndYearWithCurrentDate(Integer month, Integer year) {
        Calendar c = Calendar.getInstance();

        if (month != null && year != null) {
            return year > c.get(Calendar.YEAR) || (year == c.get(Calendar.YEAR) && month > c.get(Calendar.MONTH));
        }

        return false;
    }

    public static boolean verifyIfDateIsNotPast(Date date) {

        Calendar today = Calendar.getInstance();

        Calendar inDate = Calendar.getInstance();
        inDate.setTime(date);

        if (inDate.get(Calendar.YEAR) < today.get(Calendar.YEAR))
            return false;
        else if (inDate.get(Calendar.YEAR) > today.get(Calendar.YEAR))
            return true;

        else if (inDate.get(Calendar.MONTH) < today.get(Calendar.MONTH))
            return false;
        else if (inDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))
            return true;
        else return inDate.get(Calendar.DAY_OF_MONTH) >= today.get(Calendar.DAY_OF_MONTH);
    }
}
