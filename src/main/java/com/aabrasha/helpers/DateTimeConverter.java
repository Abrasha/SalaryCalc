package com.aabrasha.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by abrasha on 12/27/15.
 */
public class DateTimeConverter {

    public static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return  formatter.format(date);

    }

}
