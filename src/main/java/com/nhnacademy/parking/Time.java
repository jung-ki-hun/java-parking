package com.nhnacademy.parking;

public class Time {
    private final int day;
    private final int hour;
    private final int minute;
    private final int second;

    public Time(int day,int hour, int minute, int second) {
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Time{" +
            "hour=" + hour +
            ", minute=" + minute +
            ", second=" + second +
            '}';
    }
}
