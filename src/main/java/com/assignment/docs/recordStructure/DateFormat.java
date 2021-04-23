package com.assignment.docs.recordStructure;


import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormat {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH);
}
