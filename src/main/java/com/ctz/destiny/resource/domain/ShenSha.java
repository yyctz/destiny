package com.ctz.destiny.resource.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentz on 2017/11/17.
 * 神煞
 */
public interface ShenSha {

    default boolean isLiuNianShenSha(Bazi bazi,int year){
        return false;
    }

    default boolean isYearZhuShenSha(Bazi bazi){
        return isShensha(bazi,bazi.getYearZhi(),bazi.getYearGan());
    }

    default boolean isMonthZhuShenSha(Bazi bazi){
        return isShensha(bazi,bazi.getMonthZhi(),bazi.getMonthGan());
    }

    default boolean isDayZhuShenSha(Bazi bazi){
        return isShensha(bazi,bazi.getDayZhi(),bazi.getDayGan());
    }

    default boolean isHourZhuShenSha(Bazi bazi){
        return isShensha(bazi,bazi.getHourZhi(),bazi.getHourGan());
    }

    boolean isShensha(Bazi bazi,DiZhi dizhi,TianGan tiangan);

    String getDescription();

    default boolean isShenSha(Bazi bazi,DiZhi diZhi,TianGan tiangan,String cheats){
        String[] cheatsString = cheats.split(",");
        if(cheatsString.length==0){
            return false;
        }
        List<String> starts = new ArrayList<>();
        for (int i = 0; i < cheatsString[0].length(); i++) {
            switch (cheatsString[0].charAt(i)){
                case '年':starts.add(bazi.getYearGan().toString());break;
                case '月':starts.add(bazi.getMonthZhi().toString());break;
                case '日':starts.add(bazi.getDayGan().toString());break;
                case '时':starts.add(bazi.getHourGan().toString());break;
            }
        }
        for (int i = 1; i < cheatsString.length; i++) {
            String[] str = cheatsString[i].split("见");
            for (int j = 0; j < starts.size(); j++) {
                if(str[0].contains(starts.get(j))&&(str[1].contains(diZhi.toString())||str[1].contains(tiangan.toString()))){
                    return true;
                }
            }
        }
        return false;
    }
}
