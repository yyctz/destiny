package com.ctz.destiny.resource.shensha;

import com.ctz.destiny.resource.domain.Bazi;
import com.ctz.destiny.resource.domain.DiZhi;
import com.ctz.destiny.resource.domain.ShenSha;
import com.ctz.destiny.resource.domain.TianGan;


/**
 * Created by chentz on 2017/11/17.
 *  月德贵人 寅午戌月生者见丙, 申子辰月生者见壬,亥卯未月生者见甲,巳酉丑月生者见庚. 凡柱中年月日时干上见者为有月德贵人.
 */
public class YueDe implements ShenSha {

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
        return "月德贵人";
    }

}
