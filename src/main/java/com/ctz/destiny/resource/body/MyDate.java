package com.ctz.destiny.resource.body;

/**
 * Created by chentz on 2017/10/19.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyDate {

    private static int[] dayMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int day;
    public int dayCyl;
    public boolean isLeap;
    public int monCyl;
    public int month;
    public int year;
    public int yearCyl;

    public MyDate() {
    }

    public MyDate(int paramInt1, int paramInt2, int paramInt3) {
        this.year = paramInt1;
        this.month = paramInt2;
        this.day = paramInt3;
    }

    public static int GetNumDayOfMonth(int paramInt1, int paramInt2) {
        int i = dayMonth[(paramInt2 - 1)];
        if ((IsBigYear(paramInt1)) && (paramInt2 == 2)) {
            i++;
        }
        return i;
    }

    public static boolean IsBigYear(int paramInt) {
        if (paramInt % 400 == 0) {
            return true;
        }
        return (paramInt % 4 == 0) && (paramInt % 100 != 0);
    }

    // 求2个日期的天数

    public static long DateDays(String date1, String date2) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long myTime;
        Date aDate2;
        Date aDate;
        long myTime2;
        long days = 0;

        aDate = formatter.parse(date1);// 任意日期，包括当前日期
        myTime = (aDate.getTime() / 1000);

        // SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
        aDate2 = formatter.parse(date2);// 任意日期，包括当前日期
        myTime2 = (aDate2.getTime() / 1000);

        if (myTime > myTime2) {
            days = (myTime - myTime2) / (1 * 60 * 60 * 24);
        } else {
            days = (myTime2 - myTime) / (1 * 60 * 60 * 24);
        }



        return days;

    }

    // 求2个日期的天数
    public static long DateDays2(int year1, int month1, int day1, int year2,
                                 int month2, int day2) throws ParseException {

        String date1;
        String date2;
        date1 = year1 + "-" + month1 + "-" + day1;
        date2 = year2 + "-" + month2 + "-" + day2;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long myTime;
        Date aDate;
        Date aDate2;
        long myTime2;
        long days = 0;

        aDate = formatter.parse(date1);// 任意日期，包括当前日期
        myTime = (aDate.getTime() / 1000);

        // SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
        aDate2 = formatter.parse(date2);// 任意日期，包括当前日期
        myTime2 = (aDate2.getTime() / 1000);

        if (myTime > myTime2) {
            days = (myTime - myTime2) / (1 * 60 * 60 * 24);
        } else {
            days = (myTime2 - myTime) / (1 * 60 * 60 * 24);
        }


        return days;

    }

    public int GetNumDayFrom19000101() {
        int day = 0;
        try {
            day = (int) DateDays2(this.year, this.month, this.day, 1900, 1, 1);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return day;
    }

    public long GetSFrom19000101() {
        return 86400L * (1L + GetNumDayFrom19000101());
    }
}
