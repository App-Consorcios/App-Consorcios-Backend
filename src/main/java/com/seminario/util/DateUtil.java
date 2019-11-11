package com.seminario.util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


public class DateUtil {

    public static LocalDate getLocalDate(String strYearAndMonth) {
        return strYearAndMonth != null ? new LocalDate(strYearAndMonth.concat("-01")) : null;
    }

    public static String getStrDate(LocalDate strYearAndMonth) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM");
        return strYearAndMonth != null ? strYearAndMonth.toString(formatter) : null;
    }

    public static String getStrDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        return dateFormat.format(date);
    }

    public static Date getDate(String strDate) {
        return getLocalDate(strDate).toDate();
    }

    public static Optional<Date> getOptionalDate(String strDate) {
        return Optional.ofNullable(strDate).map(DateUtil::getDate);
    }

}
