package com.fuhuadata.domain.customs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

/**
 * <p>User: wangjie
 * <p>Date: 7/4/2017
 */
public class BarMeter {

    private String name;

    private int year;

    private int month;

    private int day;

    private double value;

    public BarMeter(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public BarMeter(String name, int year, int month) {
        this.name = name;
        this.year = year;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public static List<BarMeter> listMeterOfMonth(LocalDate start, LocalDate end) {

        List<BarMeter> meters = Lists.newArrayList();

        start = start.with(firstDayOfMonth());
        end = end.with(lastDayOfMonth());
        while (start.isBefore(end)) {
            int year = start.getYear();
            int monthValue = start.getMonthValue();

            BarMeter meter = new BarMeter(getMeterName(year, monthValue), year, monthValue);
            meters.add(meter);

            start = start.plusMonths(1);
        }

        return meters;
    }

    public static List<BarMeter> listMetersOfYear(LocalDate start, LocalDate end) {

        List<BarMeter> meters = Lists.newArrayList();
        start = start.with(firstDayOfMonth());
        end = end.with(lastDayOfMonth());

        while (start.isBefore(end)) {
            int year = start.getYear();
            meters.add(new BarMeter(getMeterName(year), year));

            start = start.plusYears(1);
        }

        return meters;
    }

    public static String getMeterName(Integer year) {

        return getMeterName(year, null);
    }

    public static String getMeterName(Integer year, Integer month) {

        return getMeterName(year, month, null);
    }

    public static String getMeterName(Integer year, Integer month, Integer day) {

        Objects.requireNonNull(year);
        StringBuilder buffer = new StringBuilder();
        buffer.append(year);

        if (month != null) {
            buffer.append("-");
            buffer.append(month);
        }

        if (day != null) {
            buffer.append("-");
            buffer.append(day);
        }

        return buffer.toString();
    }

    public static void main(String[] args) throws JsonProcessingException {

        List<BarMeter> meters = listMeterOfMonth(LocalDate.of(2016, 1, 1), LocalDate.now());
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(meters));
    }
}
