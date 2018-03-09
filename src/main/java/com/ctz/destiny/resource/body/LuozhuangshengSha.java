package com.ctz.destiny.resource.body;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by chentz on 2017/10/19.
 */
public class LuozhuangshengSha {

    LuozhuangshenshaHehun myLuozhuangshenshaHehun = new LuozhuangshenshaHehun();
    Luozhuanglvhehun myLuozhuanglvhehun = new Luozhuanglvhehun();
    Luozhuangpaipandayun myLuozhuangpaipandayun = new Luozhuangpaipandayun();


    /**
     * 兄弟是不是男人
     *
     * @param param 性别枚举，不支持无性别
     * @return true表示男人
     */
    public int Manorwoman(Sex param) {
        if (param.equals(Sex.MAN)) {
            return 1;
        }
        return 0;
    }

    public String[] dizhi = {"　", "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

    /**
     * 地支顺序
     *
     * @param paramString 地支
     * @return 序号
     */
    public int dizhiOrder(String paramString) {
        for (int i = 1; ; i++) {
            if (i > 12) {
                i = 0;
                return i;
            } else if (paramString.equals(dizhi[i])) {
                return i;
            }
        }
    }

    public String[] jiazi = {"　", "甲子", "乙丑", "丙寅", "丁卯", "戊辰", "己巳", "庚午", "辛未", "壬申", "癸酉", "甲戌", "乙亥", "丙子", "丁丑", "戊寅", "己卯", "庚辰", "辛巳", "壬午", "癸未", "甲申", "乙酉", "丙戌", "丁亥", "戊子", "己丑", "庚寅", "辛卯", "壬辰", "癸巳", "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥", "庚子", "辛丑", "壬寅", "癸卯", "甲辰", "乙巳", "丙午", "丁未", "戊申", "己酉", "庚戌", "辛亥", "壬子", "癸丑", "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥"};

    /**
     * 算年柱在60甲子顺序，注意顺序1-60
     *
     * @param paramString 年柱
     * @return 年柱在60甲子顺序
     */
    public int chaxunjiazishunxu(String paramString) {

        for (int i = 1; ; i++) {
            if (i > 60) {
                i = 0;
                return i;
            }
            if (paramString.equals(jiazi[i])) {
                return i;
            }
        }
    }

    /**
     * 求年柱，不需要太多类,java日期类有限制只能算到2050年
     *
     * @param paramInt 年分数字
     * @return 年柱
     */
    public String quickgetnianzhu(int paramInt) {
        int i = (1 + (paramInt - 1864)) % 60;
        if (i == 0) {
            i = 60;
        }
        return jiazi[i];
    }


    /**
     * @param yeararray 年数组
     * @param bazi      此人八字
     * @param isman     男人么
     * @return
     */
    public String[] liunianshensha(int[] yeararray, String[] bazi, Sex isman) {

        String[] stringarray = new String[yeararray.length];
        for (int i2 = 0; i2 < yeararray.length; i2++) {
            stringarray[i2] = quickgetnianzhu(yeararray[i2]);

        }
        return liunianshensha(yeararray, stringarray, bazi, isman);
    }


    /**
     * @param yearintarray 年数组数字形式
     * @param yeararray    年数组
     * @param bazi         此人八字
     * @param isman        男人么
     * @return
     */
    private String[] liunianshensha(int[] yearintarray, String[] yeararray, String[] bazi, Sex isman) {
        int ah;//年柱在六十甲子中的顺序

        ah = chaxunjiazishunxu(bazi[1] + bazi[2]);

        String[] returnarray = new String[yeararray.length];
        for (int i2 = 0; ; i2++) {

            if (i2 >= yeararray.length) {
                return returnarray;
            }

            returnarray[i2] = (yearintarray[i2] + yeararray[i2]
                    + "　　神煞：" + shengshadayun(yeararray[i2], bazi, isman) + "\n");
        }
    }

    /**
     * 排大运或者年份神杀
     *
     * @param yearjiazi 年分八字
     * @param bazi      此人八字四柱 bazi[1] = bazi[1];//年干 bazi[2] =
     *                  bazi[2];//年支 bazi[3] = bazi[3];//月干 bazi[4] =
     *                  bazi[4];//月支 bazi[5] = bazi[5];//日干 bazi[6] =
     *                  bazi[6];//日支 bazi[7] = bazi[7];//时干 bazi[8] =
     *                  bazi[8];//时支
     * @param isman     男人么
     * @return 神煞
     */
    public String shengshadayun(String yearjiazi, String[] bazi, Sex isman) {
        StringBuilder sb = new StringBuilder();
        if ((tianyiguiren(bazi[5], yearjiazi.substring(1, 2))) || (tianyiguiren(bazi[1], yearjiazi.substring(1, 2)))) {
            sb.append("天乙");

        }
        if ((taijiguiren(bazi[5], yearjiazi.substring(1, 2))) || (taijiguiren(bazi[1], yearjiazi.substring(1, 2)))) {
            sb.append("太极");

        }
        if (tiandeguiren(bazi[4], yearjiazi.substring(0, 1)) || tiandeguiren(bazi[4], yearjiazi.substring(1, 2))) {
            sb.append("天德");

        }
        if (yuede(bazi[4], yearjiazi.substring(0, 1))) {
            sb.append("月德");

        }
        if ((wenchang(bazi[5], yearjiazi.substring(1, 2))) || (wenchang(bazi[1], yearjiazi.substring(1, 2)))) {
            sb.append("文昌");

        }
        if ((guoying(bazi[5], yearjiazi.substring(1, 2))) || (guoying(bazi[1], yearjiazi.substring(1, 2)))) {
            sb.append("国印");

        }
        if ((yima(bazi[6], yearjiazi.substring(1, 2))) || (yima(bazi[2], yearjiazi.substring(1, 2)))) {
            sb.append("驿马");

        }
        if ((huagai(bazi[6], yearjiazi.substring(1, 2))) || (huagai(bazi[2], yearjiazi.substring(1, 2)))) {
            sb.append("华盖");

        }
        if ((jiangxing(bazi[6], yearjiazi.substring(1, 2))) || (jiangxing(bazi[2], yearjiazi.substring(1, 2)))) {
            sb.append("将星");

        }
        if (jingyu(bazi[5], yearjiazi.substring(1, 2))) {
            sb.append("金舆");

        }
        if (lu(bazi[5], yearjiazi.substring(1, 2))) {
            sb.append("禄");

        }
        if (huoluan(bazi[2], yearjiazi.substring(1, 2))) {
            sb.append("红鸾");

        }
        if (tianxi(bazi[2], yearjiazi.substring(1, 2))) {
            sb.append("天喜");

        }
        if ((tianluo(bazi[6], yearjiazi.substring(1, 2), bazi[1])) || (tianluo(bazi[2], yearjiazi.substring(1, 2), bazi[1]))) {
            sb.append("天罗");

        }
        if ((diwang(bazi[6], yearjiazi.substring(1, 2), bazi[1])) || (diwang(bazi[2], yearjiazi.substring(1, 2), bazi[1]))) {
            sb.append("地网");

        }
        if (yangren(bazi[5], yearjiazi.substring(1, 2))) {
            sb.append("羊刃");

        }
        if ((kongwang(bazi[5] + bazi[6], yearjiazi.substring(1, 2))) || (kongwang(bazi[1] + bazi[2], yearjiazi.substring(1, 2)))) {
            sb.append("空亡");

        }
        if ((taohua(bazi[6], yearjiazi.substring(1, 2))) || (taohua(bazi[2], yearjiazi.substring(1, 2)))) {
            sb.append("咸池");

        }
        if (yuancheng(bazi[2], yearjiazi.substring(1, 2), Manorwoman(isman), dizhiOrder(bazi[2]) % 2)) {
            sb.append("元辰");

        }
        if ((shangmen(bazi[6], yearjiazi.substring(1, 2))) || (shangmen(bazi[2], yearjiazi.substring(1, 2)))) {
            sb.append("丧门");

        }
        if ((diaoke(bazi[6], yearjiazi.substring(1, 2))) || (diaoke(bazi[2], yearjiazi.substring(1, 2)))) {
            sb.append("吊客");

        }
        if ((pima(bazi[6], yearjiazi.substring(1, 2))) || (pima(bazi[2], yearjiazi.substring(1, 2)))) {
            sb.append("披麻");

        }
        return sb.toString();
    }

    /**
     * 排四柱神杀
     *
     * @param bazi  此人八字四柱 bazi[1] = bazi[1];//年干 bazi[2] =
     *              bazi[2];//年支 bazi[3] = bazi[3];//月干 bazi[4] =
     *              bazi[4];//月支 bazi[5] = bazi[5];//日干 bazi[6] =
     *              bazi[6];//日支 bazi[7] = bazi[7];//时干 bazi[8] =
     *              bazi[8];//时支
     * @param isman 男人么
     * @return 神煞
     */


    public String shengsha(String[] bazi, Sex isman) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; ; i++) {
            if (i > 8) {
                return sb.toString();
            }
            if (i == 1) {
                sb.append("年柱:");
            }
            if (i == 3) {
                sb.append("\n月柱:");
            }
            if (i == 5) {
                sb.append("\n日柱:");
            }
            if (i == 7) {
                sb.append("\n时柱:");
            }
            String bs = bazi[i];
            boolean tg = isTianGan(i);

            if (!tg && (tianyiguiren(bazi[5], bs) || tianyiguiren(bazi[1], bs))) {
                sb.append("天乙 ");//以日干起贵人，地支见者为是
            }

            if (!tg && (taijiguiren(bazi[5], bs) || taijiguiren(bazi[1], bs))) {
                sb.append("太极 ");
            }

            if (!tg && tiandeguiren(bazi[4], bs)) {
                sb.append("天德 ");
            }

            if (tg && yuede(bazi[4], bs)) {
                sb.append("月德 ");
            }

            //三奇

            //以年干或日干为主。凡甲丙两干见寅或子，乙癸两干见卯或丑，戊干见申，己干见未，丁干见亥，庚干见午，辛干见巳，壬干见辰是也
            if (!tg && (fuxing(bazi[1], bs) || fuxing(bazi[5], bs))) {
                sb.append("福星 ");
            }

            if (!tg && ((wenchang(bazi[5], bs)) || (wenchang(bazi[1], bs)))) {
                sb.append("文昌 ");
            }

            if ((i == 6) && (kuigang(bazi[5], bs))) {
                sb.append("魁罡 ");
            }

            if (!tg && ((guoying(bazi[5], bs)) || (guoying(bazi[1], bs)))) {
                sb.append("国印 ");
            }

            if (tg && (xuetang(bazi[5], bs, bazi[i + 1]) || xuetang(bazi[1], bs, bazi[i + 1]))) {
                sb.append("学堂 ");
            }

            if (tg && (ciguan(bazi[5], bs, bazi[i + 1]) || ciguan(bazi[1], bs, bazi[i + 1]))) {
                sb.append("词馆 ");
            }

            if((i == 6 ||i==8)&&tongzi(bazi[1],bazi[4],bazi[i])){
                sb.append("童子 ");
            }

            if (tg && dexiu(bazi[4], bs, bazi[i + 1])) {
                sb.append("德秀 ");
            }

            if ((yima(bazi[6], bs)) || (yima(bazi[2], bs))) {
                sb.append("驿马 ");
            }

            if ((huagai(bazi[6], bs)) || (huagai(bazi[2], bs))) {
                sb.append("华盖 ");
            }

            if ((jiangxing(bazi[6], bs)) || (jiangxing(bazi[2], bs))) {
                sb.append("将星 ");
            }

            if (jingyu(bazi[5], bs)) {
                sb.append("金舆 ");
            }

            if (((jingshen(bazi[5], bazi[6])) && (i == 5)) || ((jingshen(bazi[7], bazi[8])) && (i == 7))) {
                sb.append("金神 ");
            }

            if (tg && (wangshen(bazi[2], bs, bazi[i + 1], bazi) || wangshen(bazi[6], bs, bazi[i + 1], bazi))) {
                sb.append("亡神 ");
            }

            if (tianyi(bazi[4], bs)) {
                sb.append("天医 ");
            }

            if (lu(bazi[5], bs)) {
                sb.append("禄神 ");
            }

            if ((tianshe(bazi[4], bazi[5], bazi[6])) && (i == 5)) {
                sb.append("天赦 ");
            }
            if ((huoluan(bazi[2], bs)) && (i >= 4)) {
                sb.append("红鸾 ");
            }
            if ((tianxi(bazi[2], bs))&&!tg) {
                sb.append("天喜 ");
            }
            if ((tianluo(bazi[6], bs, bazi[1])) || (tianluo(bazi[2], bs, bazi[1]))) {
                sb.append("天罗 ");
            }

            if ((diwang(bazi[6], bs, bazi[1])) || (diwang(bazi[2], bs, bazi[1]))) {
                sb.append("地网 ");
            }

            if (yangren(bazi[5], bs)) {
                sb.append("羊刃 ");
            }

            if ((jiesha(bazi[6], bs)) || (jiesha(bazi[2], bs))) {
                sb.append("劫煞 ");

            }

            if ((zaisha(bazi[6], bs)) || (zaisha(bazi[2], bs))) {
                sb.append("灾煞 ");

            }

            //勾绞煞
            //阳男阴女, 命前三辰为勾, 命后三辰为绞.阴男阳女, 命前三辰为绞, 命后三辰为勾.
            //查法: 以年支为主, 查四柱其余地支. 如庚午年生男, 命前三辰为酉为勾,命后三辰为卯为绞.

            int shunxu = dizhiOrder(bazi[2]);
            int shunxuhou = daizhishunxun((shunxu - 3));
            int shunxuqian = daizhishunxun((shunxu + 3) % 12);
            //public String[] dizhi = {"　", "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
            //这里我觉得有点鲛人，庚午年生男, 命前三辰即shunxu-3 应该是卯

            if ((LuozhuangcommonClass.yinyang(bazi[2]).equals("阳") && Manorwoman(isman) == 1) || (LuozhuangcommonClass.yinyang(bazi[2]).equals("阴") && Manorwoman(isman) == 0)) { //阳男阴女
                if ((i % 2 == 0) && (dizhiOrder(bazi[2]) == shunxuqian)) {
                    sb.append("勾煞 ");
                }
                if ((i % 2 == 0) && (dizhiOrder(bazi[2]) == shunxuhou)) {
                    sb.append("绞煞 ");
                }
            } else {
                if ((i % 2 == 0) && (dizhiOrder(bazi[2]) == shunxuqian)) {
                    sb.append("勾煞 ");
                }
                if ((i % 2 == 0) && (dizhiOrder(bazi[2]) == shunxuhou)) {
                    sb.append("绞煞 ");
                }


            }


            if ((yuancheng(bazi[2], bs, Manorwoman(isman), dizhiOrder(bazi[2]) % 2)) && (i >= 4)) {
                sb.append("元辰 ");

            }
            if ((kongwang(bazi[5] + bazi[6], bs)) || (kongwang(bazi[1] + bazi[2], bs))) {
                sb.append("空亡 ");

            }
            if ((gucheng(bazi[2], bs)) && (i >= 4)) {
                sb.append("孤辰 ");

            }
            if ((guashu(bazi[2], bs)) && (i >= 4)) {
                sb.append("寡宿 ");

            }
            if ((wangshen(bazi[6], bs)) || (wangshen(bazi[2], bs))) {
                sb.append("亡神 ");

            }

            if ((shiedabai(bazi[5], bazi[6])) && (i == 5)) {
                sb.append("十恶大败日");

            }
            if ((taohua(bazi[6], bs)) || (taohua(bazi[2], bs))) {
                sb.append("咸池");

            }

            if ((guluan(bazi[5], bazi[6], bazi[7], bazi[8])) && (i == 5)) {
                sb.append("孤鸾煞");

            }
            if ((yingyangchacuo(bazi[5], bazi[6])) && (i == 5)) {
                sb.append("阴阳差错");

            }
            if ((sifei(bazi[4], bazi[5], bazi[6])) && (i == 5)) {
                sb.append("四废");

            }
            //披麻、吊客、丧门
            //披麻查法：年日支后三位为披麻。
            //吊客查法：年日支后两位为吊客。
            //丧门查法：年日支前两位为丧门。
            if (((shangmen(bazi[6], bs)) || (shangmen(bazi[2], bs))) && (i % 2 == 0)) {
                sb.append("丧门 ");

            }
            if (((diaoke(bazi[6], bs)) || (diaoke(bazi[2], bs))) && (i % 2 == 0)) {
                sb.append("吊客 ");

            }
            if (((pima(bazi[6], bs)) || (pima(bazi[2], bs))) && (i % 2 == 0)) {
                sb.append("披麻 " );

            }
        }
    }

    private boolean isTianGan(int i) {
        return i % 2 == 1;
    }

    /**
     * 空亡 甲子 甲戌 甲申 甲午 甲辰 甲寅 乙丑 乙亥 乙酉 乙未 乙巳 乙卯 丙寅 丙子 丙戌 丙申 丙午 丙辰 丁卯 丁丑 丁亥 丁酉 丁未
     * 丁巳 戊辰 戊寅 戊子 戊戌 戊申 戊午 己巳 己卯 己丑 己亥 己酉 己未 庚午 庚辰 庚寅 庚子 庚戌 庚申 辛未 辛巳 辛卯 辛丑 辛亥
     * 辛酉 壬申 壬午 壬辰 壬寅 壬子 壬戌 癸酉 癸未 癸巳 癸卯 癸丑 癸亥 戌亥 申酉 午未 辰巳 寅卯 子丑 查 法: 以日柱为主, 柱中年、
     * 月、 时支见者为空亡.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean kongwang(String paramString1, String paramString2) {
        if ((chaxunjiazishunxu(paramString1) <= 10) && ((paramString2.equals("戌")) || (paramString2.equals("亥")))) ;
        if (((chaxunjiazishunxu(paramString1) > 10) && (chaxunjiazishunxu(paramString1) <= 20) && ((paramString2.equals("申")) || (paramString2.equals("酉")))) || ((chaxunjiazishunxu(paramString1) > 20) && (chaxunjiazishunxu(paramString1) <= 30) && ((paramString2.equals("午")) || (paramString2.equals("未")))) || ((chaxunjiazishunxu(paramString1) > 30) && (chaxunjiazishunxu(paramString1) <= 40) && ((paramString2.equals("辰")) || (paramString2.equals("巳")))) || ((chaxunjiazishunxu(paramString1) > 40) && (chaxunjiazishunxu(paramString1) <= 50) && ((paramString2.equals("寅")) || (paramString2.equals("卯")))) || ((chaxunjiazishunxu(paramString1) > 50) && ((paramString2.equals("子")) || (paramString2.equals("丑"))))) {
            return true;
        }
        return false;
    }

    //以年干或日干为主。凡甲丙两干见寅或子，乙癸两干见卯或丑，戊干见申，己干见未，丁干见亥，庚干见午，辛干见巳，壬干见辰是也
    public boolean fuxing(String tiangan, String dizhi) {
        if ("甲丙".contains(tiangan) && "寅子".contains(dizhi))
            return true;
        if ("乙癸".contains(tiangan) && "卯丑".contains(dizhi))
            return true;
        if ("戊".contains(tiangan) && "申".contains(dizhi))
            return true;
        if ("己".contains(tiangan) && "未".contains(dizhi))
            return true;
        if ("丁".contains(tiangan) && "亥".contains(dizhi))
            return true;
        if ("庚".contains(tiangan) && "午".contains(dizhi))
            return true;
        if ("辛".contains(tiangan) && "巳".contains(dizhi))
            return true;
        if ("壬".contains(tiangan) && "辰".contains(dizhi))
            return true;
        return false;
    }

    /**
     * 咸池 挑花 申 子辰在酉, 寅午戌在卯, 巳酉丑在午, 亥卯未在子. 查法: 以年支或日支查四柱其它地支, 见者为 是.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean taohua(String paramString1, String paramString2) {
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("酉"))) {
            return true;
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && ((paramString2.equals("卯")))) {
            return true;
        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && ((paramString2.equals("午")))) {
            return true;
        }

        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("子"))) {
            return true;
        }

        return false;
    }

    /**
     * 阴阳差错 丙子, 丁丑, 戊寅, 辛卯, 壬辰, 癸巳, 丙午, 丁未,戊申, 辛酉, 壬戌, 癸亥. 查法: 日柱见者为是.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean yingyangchacuo(String paramString1, String paramString2) {
        if (((paramString1.equals("丙")) && (paramString2.equals("子"))) || ((paramString1.equals("丁")) && (paramString2.equals("丑"))) || ((paramString1.equals("戊")) && (paramString2.equals("寅"))) || ((paramString1.equals("辛")) && (paramString2.equals("卯"))) || ((paramString1.equals("壬")) && (paramString2.equals("辰"))) || ((paramString1.equals("癸")) && (paramString2.equals("巳"))) || ((paramString1.equals("丙")) && (paramString2.equals("午"))) || ((paramString1.equals("丁")) && (paramString2.equals("未"))) || ((paramString1.equals("戊")) && (paramString2.equals("申"))) || ((paramString1.equals("辛")) && (paramString2.equals("酉"))) || ((paramString1.equals("壬")) && (paramString2.equals("戌"))) || ((paramString1.equals("癸")) && (paramString2.equals("亥")))) {
            return true;
        }
        return false;
    }

    public String F(String paramString1, String paramString2) {
        if (((paramString1.equals("甲")) || (paramString1.equals("戊"))) && (paramString2.equals("天乙"))) {
            return "丑未";
        }
        if (((paramString1.equals("乙")) || (paramString1.equals("己"))) && (paramString2.equals("天乙"))) {
            return "子申";
        }
        if (((paramString1.equals("丙")) || (paramString1.equals("丁"))) && (paramString2.equals("天乙"))) {
            return "亥酉";
        }
        if (((paramString1.equals("壬")) || (paramString1.equals("癸"))) && (paramString2.equals("天乙"))) {
            return "卯巳";
        }
        if (((paramString1.equals("庚")) || (paramString1.equals("辛"))) && (paramString2.equals("天乙"))) {
            return "寅午";
        }
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("驿马"))) {
            return "寅";
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && (paramString2.equals("驿马"))) {
            return "申";
        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && (paramString2.equals("驿马"))) {
            return "亥";
        }
        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("驿马"))) {
            return "巳";
        }
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("华盖"))) {
            return "辰";
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && (paramString2.equals("华盖"))) {
            return "戌";
        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && (paramString2.equals("华盖"))) {
            return "丑";
        }
        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("华盖"))) {
            return "未";
        }
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("将星"))) {
            return "子";
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && (paramString2.equals("将星"))) {
            return "午";
        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && (paramString2.equals("将星"))) {
            return "酉";
        }
        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("将星"))) {
            return "卯";
        }
        if ((paramString1.equals("甲")) && (paramString2.equals("金舆"))) {
            return "辰";
        }
        if ((paramString1.equals("乙")) && (paramString2.equals("金舆"))) {
            return "巳";
        }
        if (((paramString1.equals("丙")) || (paramString1.equals("戊"))) && (paramString2.equals("金舆"))) {
            return "未";
        }
        if (((paramString1.equals("丁")) || (paramString1.equals("己"))) && (paramString2.equals("金舆"))) {
            return "申";
        }
        if ((paramString1.equals("庚")) && (paramString2.equals("金舆"))) {
            return "戌";
        }
        if ((paramString1.equals("辛")) && (paramString2.equals("金舆"))) {
            return "亥";
        }
        if ((paramString1.equals("壬")) && (paramString2.equals("金舆"))) {
            return "丑";
        }
        if ((paramString1.equals("癸")) && (paramString2.equals("金舆"))) {
            return "寅";
        }
        if ((paramString1.equals("甲")) && (paramString2.equals("禄"))) {
            return "寅";
        }
        if ((paramString1.equals("乙")) && (paramString2.equals("禄"))) {
            return "卯";
        }
        if (((paramString1.equals("丙")) || (paramString1.equals("戊"))) && (paramString2.equals("禄"))) {
            return "巳";
        }
        if (((paramString1.equals("丁")) || (paramString1.equals("己"))) && (paramString2.equals("禄"))) {
            return "午";
        }
        if ((paramString1.equals("庚")) && (paramString2.equals("禄"))) {
            return "申";
        }
        if ((paramString1.equals("辛")) && (paramString2.equals("禄"))) {
            return "酉";
        }
        if ((paramString1.equals("壬")) && (paramString2.equals("禄"))) {
            return "亥";
        }
        if ((paramString1.equals("癸")) && (paramString2.equals("禄"))) {
            return "子";
        }
        if ((paramString1.equals("甲")) && (paramString2.equals("羊刃"))) {
            return "卯";
        }
        if ((paramString1.equals("乙")) && (paramString2.equals("羊刃"))) {
            return "寅";
        }
        if (((paramString1.equals("丙")) || (paramString1.equals("戊"))) && (paramString2.equals("羊刃"))) {
            return "午";
        }
        if (((paramString1.equals("丁")) || (paramString1.equals("己"))) && (paramString2.equals("羊刃"))) {
            return "巳";
        }
        if ((paramString1.equals("庚")) && (paramString2.equals("羊刃"))) {
            return "酉";
        }
        if ((paramString1.equals("辛")) && (paramString2.equals("羊刃"))) {
            return "申";
        }
        if ((paramString1.equals("壬")) && (paramString2.equals("羊刃"))) {
            return "子";
        }
        if ((paramString1.equals("癸")) && (paramString2.equals("羊刃"))) {
            return "亥";
        }
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("劫煞"))) {
            return "巳";
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && (paramString2.equals("劫煞"))) {
            return "亥";
        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && (paramString2.equals("劫煞"))) {
            return "寅";
        }
        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("劫煞"))) {
            return "申";
        }
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("灾煞"))) {
            return "午";
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && (paramString2.equals("灾煞"))) {
            return "子";
        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && (paramString2.equals("灾煞"))) {
            return "卯";
        }
        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("灾煞"))) {
            return "酉";
        }
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("咸池"))) {
            return "酉";
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && (paramString2.equals("咸池"))) {
            return "卯";
        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && (paramString2.equals("咸池"))) {
            return "午";
        }
        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("咸池"))) {
            return "子";
        }
        if ((paramString1.equals("寅")) && (paramString2.equals("天德"))) {
            return "丁";
        }
        if ((paramString1.equals("卯")) && (paramString2.equals("天德"))) {
            return "申";
        }
        if ((paramString1.equals("辰")) && (paramString2.equals("天德"))) {
            return "壬";
        }
        if ((paramString1.equals("巳")) && (paramString2.equals("天德"))) {
            return "辛";
        }
        if ((paramString1.equals("午")) && (paramString2.equals("天德"))) {
            return "亥";
        }
        if ((paramString1.equals("未")) && (paramString2.equals("天德"))) {
            return "甲";
        }
        if ((paramString1.equals("申")) && (paramString2.equals("天德"))) {
            return "癸";
        }
        if ((paramString1.equals("酉")) && (paramString2.equals("天德"))) {
            return "寅";
        }
        if ((paramString1.equals("戌")) && (paramString2.equals("天德"))) {
            return "丙";
        }
        if ((paramString1.equals("亥")) && (paramString2.equals("天德"))) {
            return "乙";
        }
        if ((paramString1.equals("子")) && (paramString2.equals("天德"))) {
            return "巳";
        }
        if ((paramString1.equals("丑")) && (paramString2.equals("天德"))) {
            return "庚";
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && (paramString2.equals("月德"))) {
            return "丙";
        }
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("月德"))) {
            return "壬";
        }
        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("月德"))) {
            return "甲";
        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && (paramString2.equals("月德"))) {
            return "庚";
        }
        return "";
    }

    //寅午戌月，丙丁为德，戊癸为秀。申子辰月，壬癸戊己为德，丙辛甲己为秀。巳酉丑月，庚辛为德，乙庚为秀。亥卯未月，甲乙为德，丁壬为秀。
    public boolean dexiu(String month, String t, String d) {
        if ("寅午戌".contains(month)) {
            return ("丙丁".contains(t) || "丙丁".contains(d)) && "戊癸".contains(d);
        }
        if ("申子辰".contains(month)) {
            return ("壬癸戊己".contains(t) || "壬癸戊己".contains(d)) && "丙辛甲己".contains(d);
        }
        if ("巳酉丑".contains(month)) {
            return ("庚辛".contains(t) || "庚辛".contains(d)) && "乙庚".contains(d);
        }
        if ("亥卯未".contains(month)) {
            return ("甲乙".contains(t) || "甲乙".contains(d)) && "丁壬".contains(d);
        }
        return false;
    }

    /**
     * 天乙贵人 甲戊并牛羊, 乙己鼠猴乡, 丙丁猪鸡位, 壬癸兔蛇藏, 庚辛逢虎马, 此是贵人方. 查 法: 以日干起贵人, 地支见者为是
     *
     * @param paramString1 日干
     * @param paramString2 地支
     * @return
     */
    public boolean tianyiguiren(String paramString1, String paramString2) {
        if (((paramString1.equals("甲")) || (paramString1.equals("戊"))) && ((paramString2.equals("丑")) || (paramString2.equals("未")))) {
            return true;
        }
        if (((paramString1.equals("乙")) || (paramString1.equals("己"))) && ((paramString2.equals("申")) || (paramString2.equals("子")))) {
            return true;
        }
        if (((paramString1.equals("丙")) || (paramString1.equals("丁"))) && ((paramString2.equals("亥")) || (paramString2.equals("酉")))) {
            return true;
        }
        if (((paramString1.equals("壬")) || (paramString1.equals("癸"))) && ((paramString2.equals("卯")) || (paramString2.equals("巳")))) {
            return true;
        }
        if (((paramString1.equals("庚")) || (paramString1.equals("辛"))) && ((paramString2.equals("午")) || (paramString2.equals("寅")))) {
            return true;
        }
        return false;
    }

    /**
     * 太极贵人 甲乙生人子午中, 丙丁鸡兔定亨通,戊己两干临四季,庚辛寅亥禄丰隆,壬癸巳申偏喜美, 值此应当福气 钟,更须贵格来相扶,候封万户到三公.
     *
     * @param paramString1 日干
     * @param paramString2 地支
     * @return
     */
    public boolean taijiguiren(String paramString1, String paramString2) {
        if (((paramString1.equals("甲")) || (paramString1.equals("乙"))) && ((paramString2.equals("子")) || (paramString2.equals("午")))) {
            return true;
        }
        if (((paramString1.equals("丙")) || (paramString1.equals("丁"))) && ((paramString2.equals("酉")) || (paramString2.equals("卯")))) {
            return true;
        }
        if (((paramString1.equals("壬")) || (paramString1.equals("癸"))) && ((paramString2.equals("申")) || (paramString2.equals("巳")))) {
            return true;
        }
        if (((paramString1.equals("戊")) || (paramString1.equals("己"))) && ((LuozhuangcommonClass.dizhiwuxing(paramString2).equals("土")) || (((paramString1.equals("庚")) || (paramString1.equals("辛"))) && ((paramString2.equals("寅")) || (paramString2.equals("亥")))))) {
            return true;
        }
        return false;
    }

    /**
     * 文昌贵人 甲乙巳午报君知, 丙戊申宫丁己鸡.庚猪辛鼠壬逢虎,癸人见卯入云梯. 查法: 以年干或日干为主, 凡四柱中地支所见者为是
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean wenchang(String paramString1, String paramString2) {
        if ((paramString1.equals("甲")) && (paramString2.equals("巳")) || ((paramString1.equals("乙")) && (paramString2.equals("午")))) {
            return true;
        }
        if (((paramString1.equals("丙")) || (paramString1.equals("戊"))) && ((paramString2.equals("申")) || ((paramString1.equals("丁"))) || (paramString1.equals("己")) && (paramString2.equals("酉")))) {
            return true;
        }
        if (((paramString1.equals("庚")) && (paramString2.equals("亥"))) || ((paramString1.equals("辛")) && (paramString2.equals("子"))) || ((paramString1.equals("壬")) && (paramString2.equals("寅")))) {
            return true;
        }
        if (((paramString1.equals("癸")) && (paramString2.equals("卯")))) {
            return true;
        }
        return false;
    }

    /**
     * 魁罡贵人 壬辰庚戌与庚辰, 戊戌魁罡四座神,不见财官刑煞并,身行旺地贵无伦. 查法: 日柱见者为是
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean kuigang(String paramString1, String paramString2) {
        if ((paramString1.equals("壬")) && (paramString2.equals("辰"))) {
            return true;
        }
        if ((paramString1.equals("庚")) && (paramString2.equals("戌"))) {
            return true;
        }
        if ((paramString1.equals("戊")) && (paramString2.equals("戌"))) {
            return true;
        }
        return false;
    }

    /**
     * 驿马 申子辰马在寅, 寅午戌马在申,巳酉丑马在亥, 亥卯未马在巳.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean yima(String paramString1, String paramString2) {
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("寅"))) {
            return true;
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && ((paramString2.equals("申")))) {
            return true;
        }

        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && ((paramString2.equals("亥")))) {
            return true;
        }
        if ((((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("巳")))) {
            return true;
        }

        return false;
    }

    /**
     * 华盖 寅午戌见戌, 亥卯未见未,申子辰见辰, 巳酉丑见丑. 以年支或日支不主, 凡四柱中所见者为有华盖星.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean huagai(String paramString1, String paramString2) {
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("辰"))) {
            return true;
        }

        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && ((paramString2.equals("戌")))) {
            return true;
        }

        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && ((paramString2.equals("丑")))) {
            return true;
        }
        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("未"))) {
            return true;
        }

        return false;
    }

    /**
     * 金舆 甲龙乙蛇丙戊羊, 丁己猴歌庚犬方,辛猪壬牛癸逢虎, 凡人遇此福气昌.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean jingyu(String paramString1, String paramString2) {
        if ((paramString1.equals("甲")) && (paramString2.equals("辰"))) {
            return true;
        }
        if ((paramString1.equals("乙")) && (paramString2.equals("巳"))) {
            return true;
        }
        if ((paramString1.equals("丁")) && (paramString2.equals("申"))) {
            return true;
        }
        if ((paramString1.equals("己")) && (paramString2.equals("申"))) {
            return true;
        }
        if ((paramString1.equals("丙")) && (paramString2.equals("未"))) {
            return true;
        }
        if ((paramString1.equals("戊")) && (paramString2.equals("未"))) {
            return true;
        }
        if ((paramString1.equals("戊")) && (paramString2.equals("未"))) {
            return true;
        }
        if ((paramString1.equals("庚")) && (paramString2.equals("戌"))) {
            return true;
        }
        if ((paramString1.equals("辛")) && (paramString2.equals("亥"))) {
            return true;
        }
        if ((paramString1.equals("壬")) && (paramString2.equals("丑"))) {
            return true;
        }
        if ((paramString1.equals("癸")) && (paramString2.equals("寅"))) {
            return true;
        }


        return false;
    }

    /**
     * 国印贵人 甲见戌, 乙见亥, 丙见丑, 丁见寅,戊见丑, 己见寅, 庚见辰, 辛见巳.壬见未, 癸见申
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean guoying(String paramString1, String paramString2) {
        if ((paramString1.equals("甲")) && (paramString2.equals("戌"))) {
            return true;
        }
        if ((paramString1.equals("乙")) && (paramString2.equals("亥"))) {
            return true;
        }
        if ((paramString1.equals("丙")) && (paramString2.equals("丑"))) {
            return true;
        }
        if ((paramString1.equals("丁")) && (paramString2.equals("寅"))) {
            return true;
        }
        if ((paramString1.equals("戊")) && (paramString2.equals("丑"))) {
            return true;
        }
        if ((paramString1.equals("己")) && (paramString2.equals("寅"))) {
            return true;
        }
        if ((paramString1.equals("庚")) && (paramString2.equals("辰"))) {
            return true;
        }
        if ((paramString1.equals("辛")) && (paramString2.equals("巳"))) {
            return true;
        }
        if ((paramString1.equals("壬")) && (paramString2.equals("未"))) {
            return true;
        }
        if ((paramString1.equals("癸")) && (paramString2.equals("申"))) {
            return true;
        }


        return false;
    }

    /**
     * 将星 寅午戌见午, 巳酉丑见酉, 申子辰见子, 辛卯未见卯. 查法: 以年支或日支查其余各支, 见者为将星.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean jiangxing(String paramString1, String paramString2) {
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("子"))) {
            return true;

        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && ((paramString2.equals("午")))) {
            return true;

        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && ((paramString2.equals("酉")))) {
            return true;

        }

        if ((((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("卯")))) {
            return true;

        }


        return false;
    }

    /**
     * 金神 金神者, 乙丑, 己巳, 癸酉三组干支. 日柱或时柱见者为是.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean jingshen(String paramString1, String paramString2) {
        if ((paramString1.equals("乙")) && (paramString2.equals("丑"))) {
            return true;
        }
        if ((paramString1.equals("己")) && (paramString2.equals("巳"))) {
            return true;
        }

        if ((paramString1.equals("癸")) && (paramString2.equals("酉"))) {
            return true;
        }

        return false;
    }

    /**
     * 孤鸾煞 乙巳, 丁巳, 辛亥, 戊申, 壬寅, 戊午, 壬子, 丙午. 查法: 四柱日时同时出现以上任何两组者为是. 命犯孤鸾煞,
     *
     * @param paramString1
     * @param paramString2
     * @param paramString3
     * @param paramString4
     * @return
     */
    public boolean guluan(String paramString1, String paramString2, String paramString3, String paramString4) {
        if ((paramString1.equals("乙")) && (paramString2.equals("巳")) && (((paramString3.equals("丁")) && (paramString4.equals("巳"))) || ((paramString3.equals("辛")) && (paramString4.equals("亥"))) || ((paramString3.equals("戊")) && (paramString4.equals("申"))) || ((paramString3.equals("壬")) && (paramString4.equals("寅"))) || ((paramString3.equals("戊")) && (paramString4.equals("午"))) || ((paramString3.equals("壬")) && (paramString4.equals("子"))) || ((paramString3.equals("丙")) && (paramString4.equals("午"))))) {
            return true;
        }

        if (((paramString1.equals("丁")) && (paramString2.equals("巳")) && (((paramString3.equals("乙")) && (paramString4.equals("巳"))) || ((paramString3.equals("辛")) && (paramString4.equals("亥"))) || ((paramString3.equals("戊")) && (paramString4.equals("申"))) || ((paramString3.equals("壬")) && (paramString4.equals("寅"))) || ((paramString3.equals("戊")) && (paramString4.equals("午"))) || ((paramString3.equals("壬")) && (paramString4.equals("子"))) || ((paramString3.equals("丙")) && (paramString4.equals("午"))))) || ((paramString1.equals("辛")) && (paramString2.equals("亥")) && (((paramString3.equals("丁")) && (paramString4.equals("巳"))) || ((paramString3.equals("乙")) && (paramString4.equals("巳"))) || ((paramString3.equals("戊")) && (paramString4.equals("申"))) || ((paramString3.equals("壬")) && (paramString4.equals("寅"))) || ((paramString3.equals("戊")) && (paramString4.equals("午"))) || ((paramString3.equals("壬")) && (paramString4.equals("子"))) || ((paramString3.equals("丙")) && (paramString4.equals("午"))))) || ((paramString1.equals("戊")) && (paramString2.equals("申")) && (((paramString3.equals("丁")) && (paramString4.equals("巳"))) || ((paramString3.equals("辛")) && (paramString4.equals("亥"))) || ((paramString3.equals("乙")) && (paramString4.equals("巳"))) || ((paramString3.equals("壬")) && (paramString4.equals("寅"))) || ((paramString3.equals("戊")) && (paramString4.equals("午"))) || ((paramString3.equals("壬")) && (paramString4.equals("子"))) || ((paramString3.equals("丙")) && (paramString4.equals("午"))))) || ((paramString1.equals("壬")) && (paramString2.equals("寅")) && (((paramString3.equals("丁")) && (paramString4.equals("巳"))) || ((paramString3.equals("辛")) && (paramString4.equals("亥"))) || ((paramString3.equals("戊")) && (paramString4.equals("申"))) || ((paramString3.equals("乙")) && (paramString4.equals("巳"))) || ((paramString3.equals("戊")) && (paramString4.equals("午"))) || ((paramString3.equals("壬")) && (paramString4.equals("子"))) || ((paramString3.equals("丙")) && (paramString4.equals("午"))))) || ((paramString1.equals("戊")) && (paramString2.equals("午")) && (((paramString3.equals("丁")) && (paramString4.equals("巳"))) || ((paramString3.equals("辛")) && (paramString4.equals("亥"))) || ((paramString3.equals("戊")) && (paramString4.equals("申"))) || ((paramString3.equals("壬")) && (paramString4.equals("寅"))) || ((paramString3.equals("乙")) && (paramString4.equals("巳"))) || ((paramString3.equals("壬")) && (paramString4.equals("子"))) || ((paramString3.equals("丙")) && (paramString4.equals("午"))))) || ((paramString1.equals("壬")) && (paramString2.equals("子")) && (((paramString3.equals("丁")) && (paramString4.equals("巳"))) || ((paramString3.equals("辛")) && (paramString4.equals("亥"))) || ((paramString3.equals("戊")) && (paramString4.equals("申"))) || ((paramString3.equals("壬")) && (paramString4.equals("寅"))) || ((paramString3.equals("戊")) && (paramString4.equals("午"))) || ((paramString3.equals("乙")) && (paramString4.equals("巳"))) || ((paramString3.equals("丙")) && (paramString4.equals("午"))))) || ((paramString1.equals("丙")) && (paramString2.equals("午")) && (((paramString3.equals("丁")) && (paramString4.equals("巳"))) || ((paramString3.equals("辛")) && (paramString4.equals("亥"))) || ((paramString3.equals("戊")) && (paramString4.equals("申"))) || ((paramString3.equals("壬")) && (paramString4.equals("寅"))) || ((paramString3.equals("戊")) && (paramString4.equals("午"))) || ((paramString3.equals("壬")) && (paramString4.equals("子"))) || ((paramString3.equals("乙")) && (paramString4.equals("巳")))))) {
            return true;
        }
        return false;
    }
    //子、丑、寅、卯、辰、巳、午、未、申、酉、戌、亥
    public boolean shangmen(String paramString1, String paramString2) {
        if ((dizhiOrder(paramString2) - dizhiOrder(paramString1) == 2) || (12 + dizhiOrder(paramString2) - dizhiOrder(paramString1) == 2)) {
            return true;
        }
        return false;
    }

    public boolean diaoke(String paramString1, String paramString2) {
        if ((dizhiOrder(paramString1) - dizhiOrder(paramString2) == 2) || (12 + dizhiOrder(paramString1) - dizhiOrder(paramString2) == 2)) {
            return true;
        }
        return false;
    }

    public boolean pima(String paramString1, String paramString2) {
        if ((dizhiOrder(paramString1) - dizhiOrder(paramString2) == 3) || (12 + dizhiOrder(paramString1) - dizhiOrder(paramString2) == 3)) {
            return true;
        }
        return false;
    }

    public String b(String paramString) {
        if (paramString.equals("乙")) {
            return "辛未";
        }
        if (paramString.equals("丙")) {
            return "壬戌";
        }
        if (paramString.equals("辛")) {
            return "丁丑";
        }
        if (paramString.equals("壬")) {
            return "戊辰";
        }
        return "";
    }

    /**
     * 天德贵人 正月生者见丁, 二月生者见申,三月生者见壬, 四月生者见辛,五月生者见亥, 六月生者见甲,七月生者 见癸, 八月生者见寅,九月生者见丙,
     * 十月生者见乙,十一月生者见巳, 十二月生者见庚. 凡四柱年月日时上见者为有天德贵人.
     *
     * @param paramString1 月支
     * @param paramString2 干
     * @return
     */
    public boolean tiandeguiren(String paramString1, String paramString2) {
        if ((paramString1.equals("寅")) && (paramString2.equals("丁"))) {
            return true;
        }
        if (((paramString1.equals("卯")) && (paramString2.equals("申")))) {
            return true;
        }
        if (((paramString1.equals("辰")) && (paramString2.equals("壬")))) {
            return true;
        }
        if (((paramString1.equals("巳")) && (paramString2.equals("辛")))) {
            return true;
        }
        if (((paramString1.equals("午")) && (paramString2.equals("亥")))) {
            return true;
        }
        if ((paramString1.equals("未")) && (paramString2.equals("甲"))) {
            return true;
        }

        if ((paramString1.equals("申")) && (paramString2.equals("癸"))) {
            return true;
        }
        if ((paramString1.equals("酉")) && (paramString2.equals("寅"))) {
            return true;
        }
        if ((paramString1.equals("戌")) && (paramString2.equals("丙"))) {
            return true;
        }
        if ((paramString1.equals("亥")) && (paramString2.equals("乙"))) {
            return true;
        }
        if ((paramString1.equals("子")) && (paramString2.equals("巳"))) {
            return true;
        }

        if ((paramString1.equals("丑")) && (paramString2.equals("庚"))) {
            return true;
        }
        return false;
    }

    public boolean yuancheng(String paramString1, String paramString2, int paramInt1, int paramInt2) {
        if ((paramString1.equals("子")) && (paramString2.equals("未")) && (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0))))
            ;
        while (((paramString1.equals("丑")) && (paramString2.equals("申")) && (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0)))) || ((paramString1.equals("寅")) && (paramString2.equals("酉")) && (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0)))) || ((paramString1.equals("卯")) && (paramString2.equals("戌")) && (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0)))) || ((paramString1.equals("辰")) && (paramString2.equals("亥")) && (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0)))) || ((paramString1.equals("巳")) && (paramString2.equals("子")) && (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0)))) || ((paramString1.equals("午")) && (paramString2.equals("丑"))
                && (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0)))) || ((paramString1.equals("未")) && (paramString2.equals("寅")) && (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0)))) || ((paramString1.equals("申")) && (paramString2.equals("卯")) && (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0)))) || ((paramString1.equals("酉")) && (paramString2.equals("辰"))
                && (((paramInt1 == 1) && (paramInt2 == 1)) ||
                ((paramInt1 == 0) && (paramInt2 == 0)))) || ((paramString1.equals("戌")) && (paramString2.equals("巳")) &&
                (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0)))) || ((paramString1.equals("亥")) &&
                (paramString2.equals("午")) && (((paramInt1 == 1) && (paramInt2 == 1)) || ((paramInt1 == 0) && (paramInt2 == 0)))) ||
                ((paramString1.equals("子")) && (paramString2.equals("巳")) && (((paramInt1 == 1) && (paramInt2 == 0)) || ((paramInt1 == 0)
                        && (paramInt2 == 1)))) || ((paramString1.equals("丑")) && (paramString2.equals("午")) && (((paramInt1 == 1) &&
                (paramInt2 == 0)) ||
                ((paramInt1 == 0) && (paramInt2 == 1)))) || ((paramString1.equals("寅")) && (paramString2.equals("未")) && (((paramInt1 == 1) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1)))) || ((paramString1.equals("卯")) && (paramString2.equals("申")) && (((paramInt1 == 1) && (paramInt2 == 0))
                || ((paramInt1 == 0) && (paramInt2 == 1)))) || ((paramString1.equals("辰")) && (paramString2.equals("酉")) && (((paramInt1 == 1) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1)))) || ((paramString1.equals("巳")) && (paramString2.equals("戌")) &&
                (((paramInt1 == 1) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1)))) || ((paramString1.equals("午")) &&
                (paramString2.equals("亥")) && (((paramInt1 == 1) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1))))
                || ((paramString1.equals("未")) && (paramString2.equals("子")) && (((paramInt1 == 1) && (paramInt2 == 0)) ||
                ((paramInt1 == 0) && (paramInt2 == 1)))) || ((paramString1.equals("申")) && (paramString2.equals("丑")) &&
                (((paramInt1 == 1) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1))))
                || ((paramString1.equals("酉")) && (paramString2.equals("寅")) && (((paramInt1 == 1) && (paramInt2 == 0)) ||
                ((paramInt1 == 0) && (paramInt2 == 1)))) || ((paramString1.equals("戌")) && (paramString2.equals("卯")) &&
                (((paramInt1 == 1) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1)))) ||
                ((paramString1.equals("亥")) && (paramString2.equals("辰")) && (((paramInt1 == 1) && (paramInt2 == 0)) ||
                        ((paramInt1 == 0) && (paramInt2 == 1))))) {
            return true;
        }
        return false;
    }

    /**
     * 学堂词馆 金命见巳, 辛巳为正; 木命见亥, 己亥为正; 水命见申, 甲申为正; 土命见申, 戊申为正; 火 命见寅, 丙寅为正.
     * 词馆:甲干见庚寅, 乙干见辛卯, 丙干见乙巳, 丁干见戊午, 戊干见丁巳, 己干见庚午, 庚干见壬申,辛干见癸酉, 壬干见癸亥, 癸干见壬戌.
     * 学堂词馆查法, 均以年干或日干为主, 柱中地支临之为是. 学堂词馆其纳音五行, 必与年干日干五行 相一致.
     *
     * @return
     */
    public boolean ciguan(String paramString1, String t, String d) {
        String judgeString = "甲干见庚寅, 乙干见辛卯, 丙干见乙巳, 丁干见戊午, 戊干见丁巳, 己干见庚午, 庚干见壬申,辛干见癸酉, 壬干见癸亥, 癸干见壬戌";
        return quickJudge(paramString1, t, d, judgeString);
    }

    public boolean tongzi(String year, String mz, String z) {

        if (("寅卯辰".contains(mz) || "申酉戌".contains(mz)) && "寅子".contains(z)) {
            return true;
        }
        if (("巳午未".contains(mz) || "亥子丑".contains(mz)) && "卯未".contains(z)) {
            return true;
        }

        if (("甲乙".contains(year) || "庚辛".contains(year)) && "午卯".contains(z)) {
            return true;
        }
        if ("戊己".contains(year) && "辰巳".contains(z)) {
            return true;
        }
        if (("丙丁".contains(year) || "壬癸".contains(year)) && "酉戌".contains(z)) {
            return true;
        }
        return false;
    }

    public boolean wangshen(String paramString1, String t, String d, String[] td) {
        String judgeString = "寅午戌干见巳，亥卯未干见寅，巳酉丑干见申，申子辰干见亥";
        return quickJudge(paramString1, t, d, judgeString) && isSanHeJu(td);
    }

    //申子辰合水局，亥卯未合木局，寅午戌合火局，巳酉丑合金局
    public boolean isSanHeJu(String[] tda) {
        String td = "";
        for (int i = 0; i < tda.length; i++) {
            td += tda[i];
        }
        return (td.contains("申") && td.contains("子") && td.contains("辰")) || (td.contains("亥") && td.contains("卯") && td.contains("未")) ||
                (td.contains("寅") && td.contains("午") && td.contains("戌")) || (td.contains("巳") && td.contains("酉") && td.contains("丑"));
    }

    public boolean xuetang(String paramString1, String day, String year) {
        String param = day + year;
        if ("甲乙".contains(year) && param.contains("己") && paramString1.equals("亥")) {
            return true;
        }
        if ("丙丁".contains(year) && param.contains("丙") && paramString1.equals("寅")) {
            return true;
        }
        if ("戊己".contains(year) && param.contains("戊") && paramString1.equals("申")) {
            return true;
        }
        if ("庚辛".contains(year) && param.contains("辛") && paramString1.equals("巳")) {
            return true;
        }
        if ("壬癸".contains(year) && param.contains("甲") && paramString1.equals("申")) {
            return true;
        }
        return false;
    }

    public boolean quickJudge(String paramString1, String t, String d, String judgeString) {
        String[] judges = judgeString.split(",");
        for (int i = 0; i < judges.length; i++) {
            String judge = judges[i];
            String[] result = judge.split("干见");
            return result[0].contains(paramString1) && (result[1].contains(t) || result[1].contains(d));
        }
        return false;
    }

    /**
     * 月德贵人 寅午戌月生者见丙, 申子辰月生者见壬,亥卯未月生者见甲,巳酉丑月生者见庚. 凡柱中年月日时干上见者为有月德贵人.
     *
     * @param paramString1 月支
     * @param paramString2 年月日时干
     * @return
     */
    public boolean yuede(String paramString1, String paramString2) {
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && (paramString2.equals("丙"))) {
            return true;
        }
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && ((paramString2.equals("壬")))) {
            return true;
        }
        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && ((paramString2.equals("甲")))) {
            return true;
        }

        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && (paramString2.equals("庚"))) {
            return true;
        }
        return false;
    }

    /**
     * 天赦 春戊寅, 夏甲午, 秋戊申, 冬甲子. 查法: 寅卯辰月生戊寅日, 巳午未月生甲午日, 申酉戌月生戊申日, 亥子丑月生甲子日.
     *
     * @param paramString1
     * @param paramString2
     * @param paramString3
     * @return
     */
    public boolean tianshe(String paramString1, String paramString2, String paramString3) {
        if (((paramString1.equals("寅")) || (paramString1.equals("卯")) || (paramString1.equals("辰"))) && (paramString2.equals("戊")) && (paramString3.equals("寅"))) {
            return true;
        }

        if (((paramString1.equals("巳")) || (paramString1.equals("午")) || (paramString1.equals("未"))) && (((paramString2.equals("甲")) && (paramString3.equals("午"))))) {
            return true;
        }

        if (((paramString1.equals("申")) || (paramString1.equals("酉")) || (paramString1.equals("戌"))) && (((paramString2.equals("戊")) && (paramString3.equals("申"))))) {
            return true;
        }

        if (((paramString1.equals("亥")) || (paramString1.equals("子")) || (paramString1.equals("丑"))) && (paramString2.equals("甲")) && (paramString3.equals("子"))) {
            return true;
        }

        return false;
    }

    /**
     * 四废 春庚申, 辛酉, 夏壬子, 癸亥, 秋甲寅, 乙卯, 冬丙午, 丁巳. 查法: 凡四柱日干支生于该季为是.
     *
     * @param paramString1
     * @param paramString2
     * @param paramString3
     * @return
     */
    public boolean sifei(String paramString1, String paramString2, String paramString3) {
        if (((paramString1.equals("寅")) || (paramString1.equals("卯")) || (paramString1.equals("辰"))) && (((paramString2.equals("庚")) && (paramString3.equals("申"))) || ((paramString2.equals("辛")) && (paramString3.equals("酉"))))) {
            return true;
        }

        if (((paramString1.equals("巳")) || (paramString1.equals("午")) || (paramString1.equals("未"))) && (((paramString2.equals("壬")) && (paramString3.equals("子"))) || ((paramString2.equals("癸")) && (paramString3.equals("亥"))))) {
            return true;
        }

        if (((paramString1.equals("申")) || (paramString1.equals("酉")) || (paramString1.equals("戌"))) && (((paramString2.equals("甲")) && (paramString3.equals("寅"))) || ((paramString2.equals("乙")) && (paramString3.equals("卯"))))) {
            return true;
        }

        if (((paramString1.equals("亥")) || (paramString1.equals("子")) || (paramString1.equals("丑"))) && (((paramString2.equals("丙")) && (paramString3.equals("午"))) || ((paramString2.equals("丁")) && (paramString3.equals("巳"))))) {
            return true;
        }

        return false;
    }

    /**
     * 天医 正月生见丑, 二月生见寅, 三月生见卯, 四月生见辰,五月生见巳, 六月生见午, 七月生见未, 八月生见申,九月生见酉, 十月生见戌,
     * 十一月生见亥, 十二月生见子. 查法: 以月支查其它地支, 见者为是.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean tianyi(String paramString1, String paramString2) {
        if ((paramString1.equals("寅")) && (paramString2.equals("丑"))) {
            return true;
        }
        if ((paramString1.equals("卯")) && (paramString2.equals("寅"))) {
            return true;
        }
        if ((paramString1.equals("辰")) && (paramString2.equals("卯"))) {
            return true;
        }
        if ((paramString1.equals("巳")) && (paramString2.equals("辰"))) {
            return true;
        }
        if ((paramString1.equals("午")) && (paramString2.equals("巳"))) {
            return true;
        }
        if ((paramString1.equals("未")) && (paramString2.equals("午"))) {
            return true;
        }
        if ((paramString1.equals("申")) && (paramString2.equals("未"))) {
            return true;
        }

        if ((paramString1.equals("酉")) && (paramString2.equals("申"))) {
            return true;
        }

        if ((paramString1.equals("戌")) && (paramString2.equals("酉"))) {
            return true;
        }

        if ((paramString1.equals("亥")) && (paramString2.equals("戌"))) {
            return true;
        }

        if ((paramString1.equals("子")) && (paramString2.equals("亥"))) {
            return true;
        }

        if ((paramString1.equals("丑")) && (paramString2.equals("子"))) {
            return true;
        }

        return false;
    }

    /**
     * 禄神 甲禄在寅, 乙禄在卯, 丙戊禄在巳, 丁己禄在午,庚禄在申, 辛禄在酉, 壬禄在亥, 癸禄在子. 查法: 以日干查四支, 见之者为是.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean lu(String paramString1, String paramString2) {
        if ((paramString1.equals("甲")) && (paramString2.equals("寅"))) {
            return true;
        }
        if ((paramString1.equals("乙")) && (paramString2.equals("卯"))) {
            return true;
        }

        if ((paramString1.equals("丁")) && (paramString2.equals("午"))) {
            return true;
        }

        if ((paramString1.equals("己")) && (paramString2.equals("午"))) {
            return true;
        }
        if ((paramString1.equals("丙")) && (paramString2.equals("巳"))) {
            return true;
        }
        if ((paramString1.equals("戊")) && (paramString2.equals("巳"))) {
            return true;
        }

        if ((paramString1.equals("庚")) && (paramString2.equals("申"))) {
            return true;
        }

        if ((paramString1.equals("辛")) && (paramString2.equals("酉"))) {
            return true;
        }
        if ((paramString1.equals("壬")) && (paramString2.equals("亥"))) {
            return true;
        }

        if ((paramString1.equals("癸")) && (paramString2.equals("子"))) {
            return true;
        }

        return false;
    }

    /**
     * 红鸾 红鸾查法：以年支查: 子 丑 寅 卯 辰 巳 午 未 申 酉 戌 亥 其他地支见: 卯 寅 丑 子 亥 戌 酉 申 未 午 巳 辰
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean huoluan(String paramString1, String paramString2) {
        if ((paramString1.equals("子")) && (paramString2.equals("卯"))) {
            return true;
        }
        if ((paramString1.equals("丑")) && (paramString2.equals("寅"))) {
            return true;
        }
        if ((paramString1.equals("寅")) && (paramString2.equals("丑"))) {
            return true;
        }
        if ((paramString1.equals("卯")) && (paramString2.equals("子"))) {
            return true;
        }

        if ((paramString1.equals("辰")) && (paramString2.equals("亥"))) {
            return true;
        }

        if ((paramString1.equals("巳")) && (paramString2.equals("戌"))) {
            return true;
        }

        if ((paramString1.equals("午")) && (paramString2.equals("酉"))) {
            return true;
        }
        if ((paramString1.equals("未")) && (paramString2.equals("申"))) {
            return true;
        }
        if ((paramString1.equals("申")) && (paramString2.equals("未"))) {
            return true;
        }

        if ((paramString1.equals("酉")) && (paramString2.equals("午"))) {
            return true;
        }

        if ((paramString1.equals("戌")) && (paramString2.equals("巳"))) {
            return true;
        }

        if ((paramString1.equals("亥")) && (paramString2.equals("辰"))) {
            return true;
        }

        return false;
    }

    /**
     * 天喜 天喜 天喜查法：以年支查: 子 丑 寅 卯 辰 巳 午 未 申 酉 戌 亥 其他地支见: 酉 申 未 午 巳 辰 卯 寅 丑 子 亥 戌
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean tianxi(String paramString1, String paramString2) {
        if ((paramString1.equals("子")) && (paramString2.equals("酉"))) {
            return true;
        }

        if ((paramString1.equals("丑")) && (paramString2.equals("申"))) {
            return true;
        }

        if ((paramString1.equals("寅")) && (paramString2.equals("未"))) {
            return true;
        }
        if ((paramString1.equals("卯")) && (paramString2.equals("午"))) {
            return true;
        }
        if ((paramString1.equals("辰")) && (paramString2.equals("巳"))) {
            return true;
        }

        if ((paramString1.equals("巳")) && (paramString2.equals("辰"))) {
            return true;
        }

        if ((paramString1.equals("午")) && (paramString2.equals("卯"))) {
            return true;
        }

        if ((paramString1.equals("未")) && (paramString2.equals("寅"))) {
            return true;
        }

        if ((paramString1.equals("申")) && (paramString2.equals("丑"))) {
            return true;
        }

        if ((paramString1.equals("酉")) && (paramString2.equals("子"))) {
            return true;
        }

        if ((paramString1.equals("戌")) && (paramString2.equals("亥"))) {
            return true;
        }

        if ((paramString1.equals("亥")) && (paramString2.equals("戌"))) {
            return true;
        }

        return false;
    }

    /**
     * 天罗 辰为天罗, 戌为地网. 火命人逢戌亥为天罗, 水土命逢辰巳为地网. 辰见巳, 巳见辰为地网; 戌见亥, 亥见戌为天罗. 男忌天罗,
     * 女忌地网.查法: 以年支或日支为主, 其它地支见 之者为是.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean tianluo(String paramString1, String paramString2, String year) {
        if (!"丙丁".contains(year)) {
            return false;
        }
        if ((paramString1.equals("戌")) && (paramString2.equals("亥"))) {
            return true;
        }
        if ((paramString1.equals("亥")) && (paramString2.equals("戌"))) {
            return true;
        }
        return false;
    }

    /**
     * 地网 辰为天罗, 戌为地网. 火命人逢戌亥为天罗, 水土命逢辰巳为地网. 辰见巳, 巳见辰为地网; 戌见亥, 亥见戌为天罗. 男忌天罗,
     * 女忌地网.查法: 以年支或日支为主, 其它地支见 之者为是.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean diwang(String paramString1, String paramString2, String year) {
        if (!"壬癸".contains(year)) {
            return false;
        }
        if ((paramString1.equals("辰")) && (paramString2.equals("巳"))) {
            return true;
        }
        if ((paramString1.equals("巳")) && (paramString2.equals("辰"))) {
            return true;
        }
        return false;
    }

    /**
     * 羊刃 羊刃 甲羊刃在卯, 乙羊刃在寅, 丙戊羊刃在午, 丁己羊刃在巳,庚羊刃在酉, 辛羊刃在申, 壬羊刃在子, 癸 羊刃在亥.查法: 以日干为主,
     * 四支见之者为是.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean yangren(String paramString1, String paramString2) {
        if ((paramString1.equals("甲")) && (paramString2.equals("卯"))) {
            return true;
        }

        if ((paramString1.equals("乙")) && (paramString2.equals("寅"))) {
            return true;
        }
        if ((paramString1.equals("丁")) && (paramString2.equals("巳"))) {
            return true;
        }

        if ((paramString1.equals("己")) && (paramString2.equals("巳"))) {
            return true;
        }
        if ((paramString1.equals("丙")) && (paramString2.equals("午"))) {
            return true;
        }

        if ((paramString1.equals("戊")) && (paramString2.equals("午"))) {
            return true;
        }

        if ((paramString1.equals("庚")) && (paramString2.equals("酉"))) {
            return true;
        }

        if ((paramString1.equals("辛")) && (paramString2.equals("申"))) {
            return true;
        }

        if ((paramString1.equals("壬")) && (paramString2.equals("子"))) {
            return true;
        }

        if ((paramString1.equals("癸")) && (paramString2.equals("亥"))) {
            return true;
        }

        return false;
    }

    /**
     * 劫煞 申子辰见巳, 亥卯未见申, 寅午戌见亥, 巳酉丑见寅. 查法: 以年柱或日柱为主, 四柱地支见之者为是.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean jiesha(String paramString1, String paramString2) {
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("巳"))) {
            return true;
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && ((paramString2.equals("亥")))) {
            return true;
        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && ((paramString2.equals("寅")))) {
            return true;
        }
        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("申"))) {
            return true;
        }

        return false;
    }

    /**
     * 灾煞 申子辰见午, 亥卯未见酉, 寅午戌见子, 巳酉丑见卯. 查法: 以年支为主, 四柱地支中见之者为是.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean zaisha(String paramString1, String paramString2) {
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("午"))) {
            return true;
        }

        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && ((paramString2.equals("子")))) {
            return true;
        }

        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && ((paramString2.equals("卯")))) {
            return true;
        }

        if ((((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("酉")))) {
            return true;
        }

        return false;
    }

    /**
     * 孤辰 亥子丑人, 见寅为孤, 见戌为寡.寅卯辰人, 见巳为孤, 见丑为寡.巳午未人, 见申为孤, 见辰为寡.申 酉戌人, 见亥为孤, 见未为寡.
     * 查法: 以年支为准, 四柱其它地支见者为是. 如巳年生人, 见申为孤辰, 见辰为寡宿.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean gucheng(String paramString1, String paramString2) {
        if (((paramString1.equals("亥")) || (paramString1.equals("子")) || (paramString1.equals("丑"))) && (paramString2.equals("寅"))) {
            return true;
        }

        if (((paramString1.equals("寅")) || (paramString1.equals("卯")) || (paramString1.equals("辰"))) && ((paramString2.equals("巳")))) {
            return true;
        }

        if (((paramString1.equals("巳")) || (paramString1.equals("午")) || (paramString1.equals("未"))) && ((paramString2.equals("申")))) {
            return true;
        }

        if ((((paramString1.equals("申")) || (paramString1.equals("酉")) || (paramString1.equals("戌"))) && (paramString2.equals("亥")))) {
            return true;
        }


        return false;
    }

    /**
     * 寡宿 亥子丑人, 见寅为孤, 见戌为寡.寅卯辰人, 见巳为孤, 见丑为寡.巳午未人, 见申为孤, 见辰为寡.申 酉戌人, 见亥为孤, 见未为寡.
     * 查法: 以年支为准, 四柱其它地支见者为是. 如巳年生人, 见申为孤辰, 见辰为寡宿.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean guashu(String paramString1, String paramString2) {
        if (((paramString1.equals("亥")) || (paramString1.equals("子")) || (paramString1.equals("丑"))) && (paramString2.equals("戌"))) {
            return true;
        }

        if (((paramString1.equals("寅")) || (paramString1.equals("卯")) || (paramString1.equals("辰"))) && ((paramString2.equals("丑")))) {
            return true;
        }

        if (((paramString1.equals("巳")) || (paramString1.equals("午")) || (paramString1.equals("未"))) && ((paramString2.equals("辰")))) {
            return true;
        }
        if (((paramString1.equals("申")) || (paramString1.equals("酉")) || (paramString1.equals("戌"))) && (paramString2.equals("未"))) {


            return true;
        }

        return false;
    }

    /**
     * 亡神 寅午戌见巳, 亥卯未见寅, 巳酉丑见申, 申子辰见亥. 查法: 以年支或日支为主, 四柱取三合局为用, 无合局不可用.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean wangshen(String paramString1, String paramString2) {
        if (((paramString1.equals("申")) || (paramString1.equals("子")) || (paramString1.equals("辰"))) && (paramString2.equals("亥"))) {
            return true;
        }
        if (((paramString1.equals("寅")) || (paramString1.equals("午")) || (paramString1.equals("戌"))) && ((paramString2.equals("巳")))) {
            return true;
        }
        if (((paramString1.equals("巳")) || (paramString1.equals("酉")) || (paramString1.equals("丑"))) && ((paramString2.equals("申")))) {
            return true;
        }

        if (((paramString1.equals("亥")) || (paramString1.equals("卯")) || (paramString1.equals("未"))) && (paramString2.equals("寅"))) {
            return true;
        }

        return false;
    }

    /**
     * 十恶大败 甲 辰乙巳与壬申, 丙申丁亥及庚辰, 戊戌癸亥加辛巳, 己丑都来十位神. 查法: 四柱日干支逢之即是 六甲旬中有十个日值禄入空亡.
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public boolean shiedabai(String paramString1, String paramString2) {
        if (((paramString1.equals("甲")) && (paramString2.equals("辰"))) || ((paramString1.equals("乙")) && (paramString2.equals("巳"))) || ((paramString1.equals("壬")) && (paramString2.equals("申"))) || ((paramString1.equals("丙")) && (paramString2.equals("申"))) || ((paramString1.equals("丁")) && (paramString2.equals("亥"))) || ((paramString1.equals("庚")) && (paramString2.equals("辰"))) || ((paramString1.equals("戊")) && (paramString2.equals("戌"))) || ((paramString1.equals("癸")) && (paramString2.equals("亥"))) || ((paramString1.equals("辛")) && (paramString2.equals("巳"))) || ((paramString1.equals("己")) && (paramString2.equals("丑")))) {
            return true;
        }
        return false;
    }

    /**
     * 排勾绞煞用顺序
     *
     * @param order 顺序
     * @return
     */
    public int daizhishunxun(int order) {
        if (order < 1) {
            order = dizhi.length + (order) - 1;
        }
        if (order > dizhi.length) {
            order = order % dizhi.length;
        }

        return order;
    }

    /**
     * @param man 生日 yyyy-MM-dd HH
     * @return
     * @throws ParseException
     */
    public String paipan(String man, Sex isman) throws ParseException {

        Calendar mancal;

        try {
            mancal = myLuozhuangshenshaHehun.getCalendarfromString(man, "yyyy-MM-dd HH");
            //原来的private 方法改了下
        } catch (ParseException ex) {
            return "输入不正确" + ex.getMessage();
        }

        return paipan(mancal, isman);

    }

    private String paipan(Calendar cal, Sex isman) throws ParseException {

        BaZi lunar = new BaZi(cal);
        System.out.println("此人农历的日期【" + lunar.toString() + "】");
        /**
         * 很多地方都是按照23：00-1：00为子时这是不对的。
         * 子时24.00－2.00,丑时2.00－4.00,寅时4.00－6.00,卯时6.00－8.00,
         * 辰时8.00－10.00,巳时10.00－12.00,午时12.00－14.00,未时14.00－16.00
         * 申时16.00－18.00,酉时18.00－20.00,戌时20.00－22.00,亥时22.00－24.00
         *
         */
        int time = cal.get(Calendar.HOUR_OF_DAY) / 2;
        System.out.println("此人八字【" + lunar.getYearGanZhi(time) + "】");
        //获取生肖
        System.out.println("此人的农历生肖【" + lunar.animalsYear() + "】");


        String GanZhi = lunar.getYearGanZhi(time);//取八字
        String[] tempchar = GanZhi.split(",");
        //我修改原来的，用,分割
        String ganziyear = tempchar[0];//年柱
        String ganzimonth = tempchar[1];//月柱
        String ganziday = tempchar[2];//日柱
        String ganzitime = tempchar[3];//时柱

        //五行纳音
        System.out.println("");
        String soundyear = myLuozhuangshenshaHehun.getnumsix(ganziyear);
        String soundmonth = myLuozhuangshenshaHehun.getnumsix(ganzimonth);
        String soundday = myLuozhuangshenshaHehun.getnumsix(ganziday);
        String soundtime = myLuozhuangshenshaHehun.getnumsix(ganzitime);
        System.out.println("五行纳音");
        System.out.print(soundyear);
        System.out.print(" ");
        System.out.print(soundmonth);
        System.out.print(" ");
        System.out.print(soundday);
        System.out.print(" ");
        System.out.print(soundtime);
        System.out.print(" ");
        System.out.println("");

        String[] bazi = new String[9];

        bazi[0] = "";
        bazi[1] = ganziyear.substring(0, 1);//年干
        bazi[2] = ganziyear.substring(1, 2);//年支
        bazi[3] = ganzimonth.substring(0, 1);//月干
        bazi[4] = ganzimonth.substring(1, 2);//月支
        bazi[5] = ganziday.substring(0, 1);//日干
        bazi[6] = ganziday.substring(1, 2);//日支
        bazi[7] = ganzitime.substring(0, 1);//时干
        bazi[8] = ganzitime.substring(1, 2);//时支
        System.out.println(shengsha(bazi, isman));

        System.out.println("此人大运神煞");


        String[] DayunArray = myLuozhuangpaipandayun.Dayun(ganziyear, ganzimonth, isman);

        String[] DayunArrayshengsha = new String[DayunArray.length];//大运神煞
        for (int i = 0; i < DayunArray.length; i++) {

            DayunArrayshengsha[i] = shengshadayun(DayunArray[i], bazi, isman);
        }
        System.out.println("此人大运");


        System.out.println("此人大运神煞");
        myLuozhuangpaipandayun.pringst(DayunArrayshengsha);

        System.out.println("此人流年");

        int[] liunianarray = new int[80];
        int start = lunar.getnumberYear();
        start++;
        for (int i = 0; i < liunianarray.length; i++) {

            liunianarray[i] = start + i;
        }
        myLuozhuangpaipandayun.pringst(liunianshensha(liunianarray, bazi, isman));


        return null;
    }
}
