package com.fuhuadata.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * <p>User: wangjie
 * <p>Date: 5/31/2017
 */
public class TimeUtils {

    /**
     * Date to LocalDate
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {

        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
