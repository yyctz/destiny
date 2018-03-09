package com.ctz.destiny.resource.domain;

import com.ctz.destiny.resource.baziutil.BaZiUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.ctz.destiny.resource.baziutil.BaZiUtil.BASE_TIMESTAMP;
import static com.ctz.destiny.resource.baziutil.BaZiUtil.JIA_ZI;

/**
 * Created by chentz on 2017/11/17.
 */
public class Bazi {
    private TianGan yearGan;
    private TianGan monthGan;
    private TianGan dayGan;
    private TianGan hourGan;
    private DiZhi yearZhi;
    private DiZhi monthZhi;
    private DiZhi dayZhi;
    private DiZhi hourZhi;
    private JiaZi naying;
    private String bazi;

    public Bazi(Date birthday) {
        StringBuilder stringBuilder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);
        //年干支
        int year = calendar.get(Calendar.YEAR);
        int idx = (year - 1864) % 60;
        String yearGanZhi = JIA_ZI[idx];
        naying = JiaZi.valueOf(yearGanZhi);
        stringBuilder.append(yearGanZhi);
        yearGan=TianGan.valueOf(yearGanZhi.charAt(0)+"");
        yearZhi=DiZhi.valueOf(yearGanZhi.charAt(1)+"");
        //求的月份的干支
        int monthIdx = (idx + 1) * 2;
        int month = calendar.get(Calendar.MONTH)+1;
        monthIdx = monthIdx == 10?0:monthIdx;
        monthGan = TianGan.getTianGan((monthIdx + month - 1) % 10);
        monthZhi = DiZhi.getDiZhi((month + 2 - 1) % 12);
        stringBuilder.append(monthGan.toString());
        stringBuilder.append(monthZhi.toString());
        //日干支
        /*求出和1900年1月31日甲辰日相差的天数
         * 甲辰日是第四十天
        */
        int offset = (int) ((birthday.getTime() -BASE_TIMESTAMP) / 86400000L);
        offset = (offset + 40) % 60;
        String dayGanZhi = JIA_ZI[offset];
        dayGan=TianGan.valueOf(dayGanZhi.charAt(0)+"");
        dayZhi=DiZhi.valueOf(dayGanZhi.charAt(1)+"");
        stringBuilder.append(dayGanZhi);
        /**
         * 日上起时
         * 甲己还生甲，乙庚丙作初，
         * 丙辛从戊起，丁壬庚子居，
         * 戊癸何方发，壬子是真途。
         */

        offset = (offset % 5) * 2;
        //求得时辰的干支
        int hour = (calendar.get(Calendar.HOUR_OF_DAY)+25)%24 / 2;
        hourGan = TianGan.getTianGan((offset + hour) % 10);
        hourZhi = DiZhi.getDiZhi(hour);
        stringBuilder.append(hourGan.toString());
        stringBuilder.append(hourZhi.toString());
        this.bazi=stringBuilder.toString();
    }

    public TianGan getYearGan() {
        return yearGan;
    }

    public DiZhi getHourZhi() {
        return hourZhi;
    }

    public String getBazi() {
        return bazi;
    }

    public TianGan getMonthGan() {
        return monthGan;
    }

    public TianGan getDayGan() {
        return dayGan;
    }

    public TianGan getHourGan() {
        return hourGan;
    }

    public DiZhi getYearZhi() {
        return yearZhi;
    }

    public DiZhi getMonthZhi() {
        return monthZhi;
    }

    public JiaZi getNaying() {
        return naying;
    }

    public DiZhi getDayZhi() {
        return dayZhi;
    }

    public List<DiZhi> getAllDiZhi(){
        List<DiZhi> result = new ArrayList<>();
        result.add(yearZhi);
        result.add(monthZhi);
        result.add(dayZhi);
        result.add(hourZhi);
        return result;
    }

    public List<TianGan> getAllTianGan(){
        List<TianGan> result = new ArrayList<>();
        result.add(yearGan);
        result.add(monthGan);
        result.add(dayGan);
        result.add(hourGan);
        return result;
    }
}
