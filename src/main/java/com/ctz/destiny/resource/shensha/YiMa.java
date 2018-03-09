package com.ctz.destiny.resource.shensha;

import com.ctz.destiny.resource.domain.Bazi;
import com.ctz.destiny.resource.domain.DiZhi;
import com.ctz.destiny.resource.domain.ShenSha;
import com.ctz.destiny.resource.domain.TianGan;

import static com.ctz.destiny.resource.domain.DiZhi.*;


/**
 * Created by chentz on 2017/11/17.
 * 驿马 以年支或日支为主。申子辰马在寅, 寅午戌马在申,巳酉丑马在亥, 亥卯未马在巳.
 */
public class YiMa implements ShenSha {

    @Override
    public boolean isLiuNianShenSha(Bazi bazi, int year) {
        return false;
    }

    @Override
    public boolean isShensha(Bazi bazi, DiZhi diZhi, TianGan tianGan) {
        String yearZhi = bazi.getYearZhi().toString();
        String dayZhi = bazi.getDayZhi().toString();
        if(("申子辰".contains(yearZhi)||"申子辰".contains(dayZhi))&&dayZhi.equals(寅)){
            return true;
        }
        if(("寅午戌".contains(yearZhi)||"寅午戌".contains(dayZhi))&&dayZhi.equals(申)){
            return true;
        }
        if(("巳酉丑".contains(yearZhi)||"巳酉丑".contains(dayZhi))&&dayZhi.equals(亥)){
            return true;
        }
        if(("亥卯未".contains(yearZhi)||"亥卯未".contains(dayZhi))&&dayZhi.equals(巳)){
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "驿马";
    }

}
