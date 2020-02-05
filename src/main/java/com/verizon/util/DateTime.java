package com.verizon.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by vjean on 9/25/2017.
 */
public class DateTime {

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");

    public static String getCurrentDateAndTime() {
        Date date = new Date();
        return sdf.format(date);
    }

    public static String getLocalDate() {
        LocalDate localDate = LocalDate.now();
        return DateTimeFormatter.ofPattern("M/dd/yy").format(localDate);
    }
}
