package com.fuhua.time;

import org.junit.Test;

import java.time.*;
import java.util.Date;

/**
 * <p>User: wangjie
 * <p>Date: 5/31/2017
 */
public class LocalDateTest {

    @Test
    public void testDateToJavaTime() {

        //Asia/Kuala_Lumpur +8
        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println("System Default TimeZone : " + defaultZoneId);

        //toString() append +8 automatically.
        Date date = new Date();
        System.out.println("date : " + date);

        //1. Convert Date -> Instant
        Instant instant = date.toInstant();
        System.out.println("instant : " + instant); //Zone : UTC+0

        //2. Instant + system default time zone + toLocalDate() = LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        System.out.println("localDate : " + localDate);

        //3. Instant + system default time zone + toLocalDateTime() = LocalDateTime
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
        System.out.println("localDateTime : " + localDateTime);

        //4. Instant + system default time zone = ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(defaultZoneId);
        System.out.println("zonedDateTime : " + zonedDateTime);
    }
}
