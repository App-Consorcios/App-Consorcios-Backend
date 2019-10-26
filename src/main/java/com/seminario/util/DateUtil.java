package com.seminario.util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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

    public static Optional<Date> getOptionalDate(String strDate) {
        return Optional.ofNullable(strDate).map(d -> getLocalDate(d).toDate());
    }
}
