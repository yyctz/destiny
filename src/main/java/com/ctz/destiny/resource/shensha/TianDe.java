package com.ctz.destiny.resource.shensha;

import com.ctz.destiny.resource.domain.Bazi;
import com.ctz.destiny.resource.domain.DiZhi;
import com.ctz.destiny.resource.domain.ShenSha;
import com.ctz.destiny.resource.domain.TianGan;


/**
 * Created by chentz on 2017/11/17.
 *  天德贵人 正月生者见丁, 二月生者见申,三月生者见壬, 四月生者见辛,五月生者见亥, 六月生者见甲,七月生者 见癸, 八月生者见寅,九月生者见丙,
 * 十月生者见乙,十一月生者见巳, 十二月生者见庚. 凡四柱年月日时上见者为有天德贵人.
 */
public class TianDe implements ShenSha {

    private static final String CHEATS="月,寅见丁,卯见申,辰见壬,巳见辛,午见亥,未见甲,申见癸,酉见寅,戌见丙,亥见乙,子见巳,丑见庚";

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
        return "太极贵人";
    }

}
