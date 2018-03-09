package com.ctz.destiny.resource.shensha;

import com.ctz.destiny.resource.domain.Bazi;
import com.ctz.destiny.resource.domain.DiZhi;
import com.ctz.destiny.resource.domain.ShenSha;
import com.ctz.destiny.resource.domain.TianGan;

import static com.ctz.destiny.resource.domain.DiZhi.*;
import static com.ctz.destiny.resource.domain.TianGan.*;


/**
 * Created by chentz on 2017/11/17.
 * 学堂 金命见巳，辛巳为正；木命见亥，己亥为正；水命见申，甲申为正；土命见申，戊申为正；火命见寅，丙寅为正
 */
public class XueTang implements ShenSha {

    @Override
    public boolean isLiuNianShenSha(Bazi bazi, int year) {
        return false;
    }

    @Override
    public boolean isShensha(Bazi bazi, DiZhi diZhi, TianGan tianGan) {
        if(bazi.getYearGan().getWuXing().equals("金")||bazi.getDayGan().getWuXing().equals("金")){
            if(tianGan.equals(辛)||diZhi.equals(巳)){

            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "福星贵人";
    }

}
