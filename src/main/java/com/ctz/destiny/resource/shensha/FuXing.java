package com.ctz.destiny.resource.shensha;

import com.ctz.destiny.resource.domain.Bazi;
import com.ctz.destiny.resource.domain.DiZhi;
import com.ctz.destiny.resource.domain.ShenSha;
import com.ctz.destiny.resource.domain.TianGan;


/**
 * Created by chentz on 2017/11/17.
 * 福星贵人 以年干或日干为主。凡甲丙两干见寅或子，乙癸两干见卯或丑，戊干见申，己干见未，丁干见亥，庚干见午，辛干见巳，壬干见辰是也
 */
public class FuXing implements ShenSha {

    private static final String CHEATS="年日,甲丙见寅子,乙癸见卯丑,戊见申,己见未,丁见亥,庚见午,辛见巳,壬见辰";

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
        return "福星贵人";
    }

}
