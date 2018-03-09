package com.ctz.destiny.resource.shensha;

import com.ctz.destiny.resource.domain.Bazi;
import com.ctz.destiny.resource.domain.DiZhi;
import com.ctz.destiny.resource.domain.ShenSha;
import com.ctz.destiny.resource.domain.TianGan;


/**
 * Created by chentz on 2017/11/17.
 * 三奇贵人 天上三奇甲戊庚 中；地下三奇乙丙丁 上；人中三奇壬癸辛 下 天干有乙丙丁或地支有卯巳午，顺行为妙。三奇在什么条件下才能真正为奇？无非是：（一），顺布而排。即年乙月丙日丁，或月乙日丙时丁
 */
public class SanQi implements ShenSha {

    private static final String CHEATS="月,寅午戌见丙,申子辰见壬,亥卯未见甲,巳酉丑见庚";

    @Override
    public boolean isLiuNianShenSha(Bazi bazi, int year) {
        return false;
    }

    @Override
    public boolean isShensha(Bazi bazi, DiZhi diZhi, TianGan tianGan) {
        return isShenSha(bazi,diZhi,tianGan,CHEATS);
    }

    @Override
    public String getDescription() {
        return "三奇贵人";
    }

}
