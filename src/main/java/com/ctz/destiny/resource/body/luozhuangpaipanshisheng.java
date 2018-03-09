package com.ctz.destiny.resource.body;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by chentz on 2017/10/19.
 */
public class luozhuangpaipanshisheng {
    LuozhuangshenshaHehun myLuozhuangshenshaHehun = new LuozhuangshenshaHehun();
    Luozhuanglvhehun myLuozhuanglvhehun = new Luozhuanglvhehun();
    Luozhuangpaipandayun myLuozhuangpaipandayun = new Luozhuangpaipandayun();
    String[][] shisheng = {
            {"日/干", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"},
            {"甲", "比肩", "劫财", "食神", "伤官", "偏财", "正财", "七杀", "正官", "偏印", "正印"},
            {"乙", "劫财", "比肩", "伤官", "食神", "正财", "偏财", "正官", "七杀", "正印", "偏印"},
            {"丙", "偏印", "正印", "比肩", "劫财", "食神", "伤官", "偏财", "正财", "七杀", "正官"},
            {"丁", "正印", "偏印", "劫财", "比肩", "伤官", "食神", "正财", "偏财", "正官", "七杀"},
            {"戊", "七杀", "正官", "偏印", "正印", "比肩", "劫财", "食神", "伤官", "偏财", "正财"},
            {"己", "正官", "七杀", "正印", "偏印", "劫财", "比肩", "伤官", "食神", "正财", "偏财"},
            {"庚", "偏财", "正财", "七杀", "正官", "偏印", "正印", "比肩", "劫财", "食神", "伤官"},
            {"辛", "正财", "偏财", "正官", "七杀", "正印", "偏印", "劫财", "比肩", "伤官", "食神"},
            {"壬", "食神", "伤官", "偏财", "正财", "七杀", "正官", "偏印", "正印", "比肩", "劫财"},
            {"癸", "伤官", "食神", "正财", "偏财", "正官", "七杀", "正印", "偏印", "劫财", "比肩"},};
    String[][] shengwang = {
            {"天干", "长生", "沐浴", "冠带", "临官", "帝旺", "衰", "病", "死", "墓", "绝", "胎", "养"},
            {"甲", "亥", "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌"},
            {"丙", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑"},
            {"戊", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑"},
            {"庚", "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑", "寅", "卯", "辰"},
            {"壬", "申", "酉", "戌", "亥", "子", "丑", "寅", "卯", "辰", "巳", "午", "未"},
            {"乙", "午", "巳", "辰", "卯", "寅", "丑", "子", "亥", "戌", "酉", "申", "未"},
            {"丁", "酉", "申", "未", "午", "巳", "辰", "卯", "寅", "丑", "子", "亥", "戌"},
            {"己", "酉", "申", "未", "午", "巳", "辰", "卯", "寅", "丑", "子", "亥", "戌"},
            {"辛", "子", "亥", "戌", "酉", "申", "未", "午", "巳", "辰", "卯", "寅", "丑"},
            {"癸", "卯", "寅", "丑", "子", "亥", "戌", "酉", "申", "未", "午", "巳", "辰"},};

    /**
     *
     * @param man 生日 yyyy-MM-dd HH
     * @return
     * @throws ParseException
     */
    public String paipan(String man, Sex isman) throws ParseException {

        Calendar mancal;

        try {
            mancal = myLuozhuangshenshaHehun.getCalendarfromString(man, "yyyy-MM-dd HH");
            //原来的private 方法改了下
        } catch (ParseException ex) {
            return "输入不正确" + ex.getMessage();
        }

        return paipan(mancal, isman);

    }

    private String paipan(Calendar cal, Sex isman) throws ParseException {

        BaZi lunar = new BaZi(cal);
        System.out.println("此人农历的日期【" + lunar.toString() + "】");
        /**
         * 很多地方都是按照23：00-1：00为子时这是不对的。
         * 子时24.00－2.00,丑时2.00－4.00,寅时4.00－6.00,卯时6.00－8.00,
         * 辰时8.00－10.00,巳时10.00－12.00,午时12.00－14.00,未时14.00－16.00
         * 申时16.00－18.00,酉时18.00－20.00,戌时20.00－22.00,亥时22.00－24.00
         *
         */
        int time = cal.get(Calendar.HOUR_OF_DAY) / 2;
        System.out.println("此人八字【" + lunar.getYearGanZhi(time) + "】");
        //获取生肖
        System.out.println("此人的农历生肖【" + lunar.animalsYear() + "】");



        String GanZhi = lunar.getYearGanZhi(time);//取八字
        String[] tempchar = GanZhi.split(",");
        //我修改原来的，用,分割
        String ganziyear = tempchar[0];//年柱
        String ganzimonth = tempchar[1];//月柱
        String ganziday = tempchar[2];//日柱
        String ganzitime = tempchar[3];//时柱

        //五行纳音
        System.out.println("");
        String soundyear = myLuozhuangshenshaHehun.getnumsix(ganziyear);
        String soundmonth = myLuozhuangshenshaHehun.getnumsix(ganzimonth);
        String soundday = myLuozhuangshenshaHehun.getnumsix(ganziday);
        String soundtime = myLuozhuangshenshaHehun.getnumsix(ganzitime);
        System.out.println("五行纳音");
        System.out.print(soundyear);
        System.out.print(" ");
        System.out.print(soundmonth);
        System.out.print(" ");
        System.out.print(soundday);
        System.out.print(" ");
        System.out.print(soundtime);
        System.out.print(" ");
        System.out.println("");
        String[] DayunArray = myLuozhuangpaipandayun.Dayun(ganziyear, ganzimonth, isman);


        //排食神生旺死绝
        //用日干 日支分别查找位于表的对应值
        //修改原文的类方法字段属性为public
        //我的表格均是按照顺序比如
        //十天干生旺死绝表 十神概念按顺序排列
        //查找某一行就可以查到对应值
        String[] shengsibiao = {"甲", "丙", "戊", "庚", "壬", "乙", "丁", "己", "辛", "癸"};//十天干生旺死绝表顺序
        //十天干生旺死绝表 用日干查表

        int shengsibiaoshunxu = myLuozhuangpaipandayun.getyuezhuStart(shengsibiao, ganziday.substring(0, 1));
        //十神表按顺序
        int shishengbiaoshunxu = myLuozhuangpaipandayun.getyuezhuStart(BaZi.Gan, ganziday.substring(0, 1));

        shengsibiaoshunxu++;
        shishengbiaoshunxu++;
        String[] DayunArrayshengsi = new String[DayunArray.length];//大运十天干生旺死绝表
        String[] DayunArrayshisheng = new String[DayunArray.length];//大运十神表
        for (int i = 0; i < DayunArray.length; i++) {
            DayunArrayshengsi[i] = shengwang[0][myLuozhuangpaipandayun.getyuezhuStart(shengwang[shengsibiaoshunxu], DayunArray[i].substring(1, 2))]; //十天干生旺死绝表 用干查表

            DayunArrayshisheng[i] = shisheng[shishengbiaoshunxu][myLuozhuangpaipandayun.getyuezhuStart(shisheng[0], DayunArray[i].substring(0, 1))]; //十神表 用支查表
        }
        System.out.println("此人大运");
        myLuozhuangpaipandayun.pringst(DayunArray);
        System.out.println("此人大运生旺死绝");
        myLuozhuangpaipandayun.pringst(DayunArrayshengsi);
        System.out.println("此人大运十神");
        myLuozhuangpaipandayun.pringst(DayunArrayshisheng);
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        luozhuangpaipanshisheng my = new luozhuangpaipanshisheng();
        my.paipan("2000-3-13 11", Sex.MAN);

    }
}
