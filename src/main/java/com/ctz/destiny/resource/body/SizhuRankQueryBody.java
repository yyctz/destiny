package com.ctz.destiny.resource.body;

/**
 * Created by chentz on 2017/10/11.
 */
public class SizhuRankQueryBody {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int isLunar;
    private int sex;
    private String location;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
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

    public int getIsLunar() {
        return isLunar;
    }

    public int getSex() {
        return sex;
    }

    public String getLocation() {
        return location;
    }
}
