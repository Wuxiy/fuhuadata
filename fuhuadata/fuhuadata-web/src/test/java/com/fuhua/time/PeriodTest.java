package com.fuhua.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * <p>User: wangjie
 * <p>Date: 5/31/2017
 */
public class PeriodTest {

    @Test
    public void testMonthsBetween() {

        LocalDate start = LocalDate.of(2017, 4, 8);
        LocalDate now = LocalDate.now();

        long between = ChronoUnit.MONTHS.between(start, now);
        System.out.println(between);
    }
}
