package com.ctz.destiny.resource.body;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by chentz on 2017/10/19.
 */
public class Luozhuangdizhang {
    LuozhuangshenshaHehun myLuozhuangshenshaHehun = new LuozhuangshenshaHehun();
    Luozhuangpaipandayun myLuozhuangpaipandayun = new Luozhuangpaipandayun();
    luozhuangpaipanshisheng myluozhuangpaipanshisheng = new luozhuangpaipanshisheng();

    /**
     * 起大运周岁
     * <p>
     * 大运排法: 阳男阴女顺排, 阴男阳女逆排, 离出生日最近的气节。 三天折合一岁计, 即一天折合四个月, 一小时折合五天. 计算时,
     * 如起运总数为18天, 被3除, 等于6, 即为6岁起大运. 如为19天, 则为6岁4个月起大运.
     *
     * @param bazi 八字阳历
     * @return
     */
    public String dayunkaishi(Calendar bazi, String nianzhu, Sex isman) {

        //甲、丙、戊、庚、壬之年为阳，乙、丁、己、辛、癸之年为阴
        //阴年生男子（或阳年生女子），大运逆行否则顺行
        JieQi jieqi = getNearJieQi(bazi.get(Calendar.YEAR), isman.equals(Sex.MAN), "甲丙戊庚壬".contains(nianzhu),bazi.getTime());
        long dayunTime = Math.abs(bazi.getTimeInMillis()-jieqi.getJieQiDate().getTime())*120+bazi.getTimeInMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return String.format("%s,大运附近节气:%s  %s",format.format(new Date(dayunTime)),jieqi.getJieQiName(),format.format(jieqi.getJieQiDate()));
    }

    private static JieQi getNearJieQi(int year, boolean isMan, boolean isYang, Date birthday) {
        List<JieQi> jieQiList = Lunar.Alljieqi(year);
        for (int i = 0; i < jieQiList.size(); i++) {
            if (jieQiList.get(i).getJieQiDate().getTime() > birthday.getTime()) {
                if (isMan == isYang) {
                    return jieQiList.get(i);
                } else {
                    return jieQiList.get(i-1);
                }
            }
        }
        return null;
    }
}
