package com.ctz.destiny.resource.shensha;

import com.ctz.destiny.resource.domain.*;


/**
 * Created by chentz on 2017/11/17.
 * 天乙贵人 甲戊并牛羊, 乙己鼠猴乡, 丙丁猪鸡位, 壬癸兔蛇藏, 庚辛逢虎马, 此是贵人方. 查 法: 以日干起贵人, 地支见者为是
 */
public class TianYi implements ShenSha {

    private static final String CHEATS="年日,甲戊见丑未,乙己见申子,丙丁见亥酉,壬癸见卯巳,庚辛见午寅";

    @Override
    public boolean isLiuNianShenSha(Bazi bazi, int year) {
        return false;
    }

    @Override
    public boolean isShensha(Bazi bazi, DiZhi diZhi,TianGan tianGan) {
        return isShenSha(bazi,diZhi,tianGan,CHEATS);
    }

    @Override
    public String getDescription() {
        return "天乙贵人";
    }

}
