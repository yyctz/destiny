package com.ctz.destiny.resource.shensha;

import com.ctz.destiny.resource.domain.Bazi;
import com.ctz.destiny.resource.domain.DiZhi;
import com.ctz.destiny.resource.domain.ShenSha;
import com.ctz.destiny.resource.domain.TianGan;


/**
 * Created by chentz on 2017/11/17.
 * 魁罡贵人 壬辰庚戌与庚辰, 戊戌魁罡四座神,不见财官刑煞并,身行旺地贵无伦. 查法: 日柱见者为是
 */
public class KuiGang implements ShenSha {

    private static final String CHEATS="日,壬见辰,庚见戌,庚见辰,戊见戌";

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
        return "魁罡贵人";
    }

}
