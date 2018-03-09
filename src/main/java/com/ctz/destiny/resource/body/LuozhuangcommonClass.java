package com.ctz.destiny.resource.body;

/**
 * Created by chentz on 2017/10/19.
 */
public class LuozhuangcommonClass {
    /**
     * 返回甲子纳音
     *
     * @param paramString 甲子
     * @return 纳音
     */
    public static String jiazinaying(String paramString) {
        if ((paramString.equals("甲子")) || (paramString.equals("乙丑"))) {
            return "海中金";
        }
        if ((paramString.equals("丙寅")) || (paramString.equals("丁卯"))) {
            return "炉中火";
        }
        if ((paramString.equals("戊辰")) || (paramString.equals("己巳"))) {
            return "大林木";
        }
        if ((paramString.equals("庚午")) || (paramString.equals("辛未"))) {
            return "路旁土";
        }
        if ((paramString.equals("壬申")) || (paramString.equals("癸酉"))) {
            return "剑锋金";
        }
        if ((paramString.equals("甲戌")) || (paramString.equals("乙亥"))) {
            return "山头火";
        }
        if ((paramString.equals("丙子")) || (paramString.equals("丁丑"))) {
            return "涧下水";
        }
        if ((paramString.equals("戊寅")) || (paramString.equals("己卯"))) {
            return "城头土";
        }
        if ((paramString.equals("庚辰")) || (paramString.equals("辛巳"))) {
            return "白蜡金";
        }
        if ((paramString.equals("壬午")) || (paramString.equals("癸未"))) {
            return "杨柳木";
        }
        if ((paramString.equals("甲申")) || (paramString.equals("乙酉"))) {
            return "泉中水";
        }
        if ((paramString.equals("丙戌")) || (paramString.equals("丁亥"))) {
            return "屋上土";
        }
        if ((paramString.equals("戊子")) || (paramString.equals("己丑"))) {
            return "霹雳火";
        }
        if ((paramString.equals("庚寅")) || (paramString.equals("辛卯"))) {
            return "松柏木";
        }
        if ((paramString.equals("壬辰")) || (paramString.equals("癸巳"))) {
            return "长流水";
        }
        if ((paramString.equals("甲午")) || (paramString.equals("乙未"))) {
            return "沙中金";
        }
        if ((paramString.equals("丙申")) || (paramString.equals("丁酉"))) {
            return "山下火";
        }
        if ((paramString.equals("戊戌")) || (paramString.equals("己亥"))) {
            return "平地木";
        }
        if ((paramString.equals("庚子")) || (paramString.equals("辛丑"))) {
            return "壁上土";
        }
        if ((paramString.equals("壬寅")) || (paramString.equals("癸卯"))) {
            return "金箔金";
        }
        if ((paramString.equals("甲辰")) || (paramString.equals("乙巳"))) {
            return "佛灯火";
        }
        if ((paramString.equals("丙午")) || (paramString.equals("丁未"))) {
            return "天河水";
        }
        if ((paramString.equals("戊申")) || (paramString.equals("己酉"))) {
            return "大驿土";
        }
        if ((paramString.equals("庚戌")) || (paramString.equals("辛亥"))) {
            return "钗钏金";
        }
        if ((paramString.equals("壬子")) || (paramString.equals("癸丑"))) {
            return "桑柘木";
        }
        if ((paramString.equals("甲寅")) || (paramString.equals("乙卯"))) {
            return "大溪水";
        }
        if ((paramString.equals("丙辰")) || (paramString.equals("丁巳"))) {
            return "沙中土";
        }
        if ((paramString.equals("戊午")) || (paramString.equals("己未"))) {
            return "天上火";
        }
        if ((paramString.equals("庚申")) || (paramString.equals("辛酉"))) {
            return "石榴木";
        }
        if ((paramString.equals("壬戌")) || (paramString.equals("癸亥"))) {
            return "大海水";
        }
        return "";
    }

    /**
     *    地支藏干 子藏癸 卯藏乙 午藏丁己  酉藏辛
     *
     *    寅藏 甲丙戊  巳藏 丙庚戊  申藏 庚壬戊  亥藏 甲壬
     *
     *    丑藏 辛癸己 辰藏 癸乙戊  未藏 乙丁己  戌藏 丁辛戊

     * @param dizhi
     * @return
     */
    public static String[] dizhuang(String dizhi) {
        String[] returnstring = new String[3];
        if (dizhi.equals("子")) {
            returnstring[0] = "癸";
        }
        if (dizhi.equals("卯")) {
            returnstring[0] = "乙";
        }

        if (dizhi.equals("午")) {
            returnstring[0] = "丁";
            returnstring[1] = "己";
        }

        if (dizhi.equals("酉")) {
            returnstring[0] = "辛";

        }

        if (dizhi.equals("寅")) {
            returnstring[0] = "甲";
            returnstring[1] = "丙";
            returnstring[2] = "戊";


        }

        if (dizhi.equals("巳")) {

            returnstring[0] = "丙";
            returnstring[1] = "庚";
            returnstring[2] = "戊";
        }

        if (dizhi.equals("申")) {

            returnstring[0] = "庚";
            returnstring[1] = "壬";
            returnstring[2] = "戊";
        }

        if (dizhi.equals("亥")) {

            returnstring[0] = "甲";
            returnstring[1] = "壬";

        }

        if (dizhi.equals("丑")) {

            returnstring[0] = "辛";
            returnstring[1] = "癸";
            returnstring[2] = "己";

        }

        if (dizhi.equals("辰")) {

            returnstring[0] = "癸";
            returnstring[1] = "乙";
            returnstring[2] = "戊";

        }

        if (dizhi.equals("未")) {

            returnstring[0] = "乙";
            returnstring[1] = "丁";
            returnstring[2] = "己";

        }

        if (dizhi.equals("戌")) {
            returnstring[0] = "丁";
            returnstring[1] = "辛";
            returnstring[2] = "戊";

        }

        return returnstring;

    }

    /**
     * 十天干生旺死绝表
     *
     * 天干 长生 沐浴 冠带 临官 帝旺 衰 病 死 墓 绝 胎 养      *
     * 甲 亥 子 丑 寅 卯 辰 巳 午 未 申 酉 戌
     * 丙 寅 卯 辰 巳 午 未 申 酉 戌 亥 子 丑
     * 戊 寅 卯 辰 巳 午 未 申 酉 戌 亥 子 丑
     * 庚 巳 午 未 申 酉 戌 亥 子 丑 寅 卯 辰
     * 壬 申 酉 戌 亥 子 丑 寅 卯 辰 巳 午 未
     * 乙 午 巳 辰 卯 寅 丑 子 亥 戌 酉 申 未
     * 丁 酉 申 未 午 巳 辰 卯 寅 丑 子 亥 戌
     * 己 酉 申 未 午 巳 辰 卯 寅 丑 子 亥 戌
     * 辛 子 亥 戌 酉 申 未 午 巳 辰 卯 寅 丑
     * 癸 卯 寅 丑 子 亥 戌 酉 申 未 午 巳 辰
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public static String shengwang(String paramString1, String paramString2) {
        if (((paramString1.equals("甲")) && (paramString2.equals("亥"))) || ((paramString1.equals("丙")) && (paramString2.equals("寅"))) || ((paramString1.equals("戊")) && (paramString2.equals("寅"))) || ((paramString1.equals("庚")) && (paramString2.equals("巳"))) || ((paramString1.equals("壬")) && (paramString2.equals("申"))) || ((paramString1.equals("乙")) && (paramString2.equals("午"))) || ((paramString1.equals("丁")) && (paramString2.equals("酉"))) || ((paramString1.equals("己")) && (paramString2.equals("酉"))) || ((paramString1.equals("辛")) && (paramString2.equals("子"))) || ((paramString1.equals("癸")) && (paramString2.equals("卯")))) {
            return "长";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("子"))) || ((paramString1.equals("丙")) && (paramString2.equals("卯"))) || ((paramString1.equals("戊")) && (paramString2.equals("卯"))) || ((paramString1.equals("庚")) && (paramString2.equals("午"))) || ((paramString1.equals("壬")) && (paramString2.equals("酉"))) || ((paramString1.equals("乙")) && (paramString2.equals("巳"))) || ((paramString1.equals("丁")) && (paramString2.equals("申"))) || ((paramString1.equals("己")) && (paramString2.equals("申"))) || ((paramString1.equals("辛")) && (paramString2.equals("亥"))) || ((paramString1.equals("癸")) && (paramString2.equals("寅")))) {
            return "沐";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("丑"))) || ((paramString1.equals("丙")) && (paramString2.equals("辰"))) || ((paramString1.equals("戊")) && (paramString2.equals("辰"))) || ((paramString1.equals("庚")) && (paramString2.equals("未"))) || ((paramString1.equals("壬")) && (paramString2.equals("戌"))) || ((paramString1.equals("乙")) && (paramString2.equals("辰"))) || ((paramString1.equals("丁")) && (paramString2.equals("未"))) || ((paramString1.equals("己")) && (paramString2.equals("未"))) || ((paramString1.equals("辛")) && (paramString2.equals("戌"))) || ((paramString1.equals("癸")) && (paramString2.equals("丑")))) {
            return "冠";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("寅"))) || ((paramString1.equals("丙")) && (paramString2.equals("巳"))) || ((paramString1.equals("戊")) && (paramString2.equals("巳"))) || ((paramString1.equals("庚")) && (paramString2.equals("申"))) || ((paramString1.equals("壬")) && (paramString2.equals("亥"))) || ((paramString1.equals("乙")) && (paramString2.equals("卯"))) || ((paramString1.equals("丁")) && (paramString2.equals("午"))) || ((paramString1.equals("己")) && (paramString2.equals("午"))) || ((paramString1.equals("辛")) && (paramString2.equals("酉"))) || ((paramString1.equals("癸")) && (paramString2.equals("子")))) {
            return "临";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("卯"))) || ((paramString1.equals("丙")) && (paramString2.equals("午"))) || ((paramString1.equals("戊")) && (paramString2.equals("午"))) || ((paramString1.equals("庚")) && (paramString2.equals("酉"))) || ((paramString1.equals("壬")) && (paramString2.equals("子"))) || ((paramString1.equals("乙")) && (paramString2.equals("寅"))) || ((paramString1.equals("丁")) && (paramString2.equals("巳"))) || ((paramString1.equals("己")) && (paramString2.equals("巳"))) || ((paramString1.equals("辛")) && (paramString2.equals("申"))) || ((paramString1.equals("癸")) && (paramString2.equals("亥")))) {
            return "帝";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("辰"))) || ((paramString1.equals("丙")) && (paramString2.equals("未"))) || ((paramString1.equals("戊")) && (paramString2.equals("未"))) || ((paramString1.equals("庚")) && (paramString2.equals("戌"))) || ((paramString1.equals("壬")) && (paramString2.equals("丑"))) || ((paramString1.equals("乙")) && (paramString2.equals("丑"))) || ((paramString1.equals("丁")) && (paramString2.equals("辰"))) || ((paramString1.equals("己")) && (paramString2.equals("辰"))) || ((paramString1.equals("辛")) && (paramString2.equals("未"))) || ((paramString1.equals("癸")) && (paramString2.equals("戌")))) {
            return "衰";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("巳"))) || ((paramString1.equals("丙")) && (paramString2.equals("申"))) || ((paramString1.equals("戊")) && (paramString2.equals("申"))) || ((paramString1.equals("庚")) && (paramString2.equals("亥"))) || ((paramString1.equals("壬")) && (paramString2.equals("寅"))) || ((paramString1.equals("乙")) && (paramString2.equals("子"))) || ((paramString1.equals("丁")) && (paramString2.equals("卯"))) || ((paramString1.equals("己")) && (paramString2.equals("卯"))) || ((paramString1.equals("辛")) && (paramString2.equals("午"))) || ((paramString1.equals("癸")) && (paramString2.equals("酉")))) {
            return "病";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("午"))) || ((paramString1.equals("丙")) && (paramString2.equals("酉"))) || ((paramString1.equals("戊")) && (paramString2.equals("酉"))) || ((paramString1.equals("庚")) && (paramString2.equals("子"))) || ((paramString1.equals("壬")) && (paramString2.equals("卯"))) || ((paramString1.equals("乙")) && (paramString2.equals("亥"))) || ((paramString1.equals("丁")) && (paramString2.equals("寅"))) || ((paramString1.equals("己")) && (paramString2.equals("寅"))) || ((paramString1.equals("辛")) && (paramString2.equals("巳"))) || ((paramString1.equals("癸")) && (paramString2.equals("申")))) {
            return "死";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("未"))) || ((paramString1.equals("丙")) && (paramString2.equals("戌"))) || ((paramString1.equals("戊")) && (paramString2.equals("戌"))) || ((paramString1.equals("庚")) && (paramString2.equals("丑"))) || ((paramString1.equals("壬")) && (paramString2.equals("辰"))) || ((paramString1.equals("乙")) && (paramString2.equals("戌"))) || ((paramString1.equals("丁")) && (paramString2.equals("丑"))) || ((paramString1.equals("己")) && (paramString2.equals("丑"))) || ((paramString1.equals("辛")) && (paramString2.equals("辰"))) || ((paramString1.equals("癸")) && (paramString2.equals("未")))) {
            return "墓";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("申"))) || ((paramString1.equals("丙")) && (paramString2.equals("亥"))) || ((paramString1.equals("戊")) && (paramString2.equals("亥"))) || ((paramString1.equals("庚")) && (paramString2.equals("寅"))) || ((paramString1.equals("壬")) && (paramString2.equals("巳"))) || ((paramString1.equals("乙")) && (paramString2.equals("酉"))) || ((paramString1.equals("丁")) && (paramString2.equals("子"))) || ((paramString1.equals("己")) && (paramString2.equals("子"))) || ((paramString1.equals("辛")) && (paramString2.equals("卯"))) || ((paramString1.equals("癸")) && (paramString2.equals("午")))) {
            return "绝";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("酉"))) || ((paramString1.equals("丙")) && (paramString2.equals("子"))) || ((paramString1.equals("戊")) && (paramString2.equals("子"))) || ((paramString1.equals("庚")) && (paramString2.equals("卯"))) || ((paramString1.equals("壬")) && (paramString2.equals("午"))) || ((paramString1.equals("乙")) && (paramString2.equals("申"))) || ((paramString1.equals("丁")) && (paramString2.equals("亥"))) || ((paramString1.equals("己")) && (paramString2.equals("亥"))) || ((paramString1.equals("辛")) && (paramString2.equals("寅"))) || ((paramString1.equals("癸")) && (paramString2.equals("巳")))) {
            return "胎";
        }
        if (((paramString1.equals("甲")) && (paramString2.equals("戌"))) || ((paramString1.equals("丙")) && (paramString2.equals("丑"))) || ((paramString1.equals("戊")) && (paramString2.equals("丑"))) || ((paramString1.equals("庚")) && (paramString2.equals("辰"))) || ((paramString1.equals("壬")) && (paramString2.equals("未"))) || ((paramString1.equals("乙")) && (paramString2.equals("未"))) || ((paramString1.equals("丁")) && (paramString2.equals("戌"))) || ((paramString1.equals("己")) && (paramString2.equals("戌"))) || ((paramString1.equals("辛")) && (paramString2.equals("丑"))) || ((paramString1.equals("癸")) && (paramString2.equals("辰")))) {
            return "养";
        }
        return "";
    }

    /**
     * 判断相害 地支六害 子未害 丑午害 寅巳害 卯辰害 申亥害 酉戌害
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public static boolean xianghai(String paramString1, String paramString2) {
        return ((paramString1.equals("子")) && (paramString2.equals("未"))) || ((paramString1.equals("未")) && (paramString2.equals("子"))) || ((paramString1.equals("丑")) && (paramString2.equals("午"))) || ((paramString1.equals("午")) && (paramString2.equals("丑"))) || ((paramString1.equals("寅")) && (paramString2.equals("巳"))) || ((paramString1.equals("巳")) && (paramString2.equals("寅"))) || ((paramString1.equals("卯")) && (paramString2.equals("辰"))) || ((paramString1.equals("辰")) && (paramString2.equals("卯"))) || ((paramString1.equals("戌")) && (paramString2.equals("酉"))) || ((paramString1.equals("酉")) && (paramString2.equals("戌"))) || ((paramString1.equals("申")) && (paramString2.equals("亥"))) || ((paramString1.equals("亥")) && (paramString2.equals("申")));
    }

    /**
     * 地支相刑 子卯刑 寅巳申刑 丑未戌刑 辰午丑亥自刑
     *
     * @param paramString1
     * @param paramString2
     * @return
     */
    public static boolean xiangxing(String paramString1, String paramString2) {
        return ((paramString1.equals("子")) && (paramString2.equals("卯"))) || ((paramString1.equals("卯")) && (paramString2.equals("子"))) || ((paramString1.equals("丑")) && (paramString2.equals("未"))) || ((paramString1.equals("未")) && (paramString2.equals("丑"))) || ((paramString1.equals("丑")) && (paramString2.equals("戌"))) || ((paramString1.equals("戌")) && (paramString2.equals("丑"))) || ((paramString1.equals("未")) && (paramString2.equals("戌"))) || ((paramString1.equals("戌")) && (paramString2.equals("未"))) || ((paramString1.equals("巳")) && (paramString2.equals("申"))) || ((paramString1.equals("申")) && (paramString2.equals("巳"))) || ((paramString1.equals("巳")) && (paramString2.equals("寅"))) || ((paramString1.equals("寅")) && (paramString2.equals("巳"))) || ((paramString1.equals("申")) && (paramString2.equals("寅"))) || ((paramString1.equals("寅")) && (paramString2.equals("申"))) || ((paramString1.equals("辰")) && (paramString2.equals("辰"))) || ((paramString1.equals("午")) && (paramString2.equals("午"))) || ((paramString1.equals("酉")) && (paramString2.equals("酉"))) || ((paramString1.equals("亥")) && (paramString2.equals("亥")));
    }

    /**
     * 子、寅、辰、午、申、戌为阳支；丑卯巳未酉亥为阴支
     *
     * @param paramString
     * @return
     */
    public static String yinyang(String paramString) {
        if ((paramString.equals("子")) || (paramString.equals("寅")) || (paramString.equals("辰")) || (paramString.equals("午")) || (paramString.equals("申")) || (paramString.equals("戌"))) {
            return "阳";
        }
        if ((paramString.equals("丑")) || (paramString.equals("卯")) || (paramString.equals("巳")) || (paramString.equals("未")) || (paramString.equals("酉")) || (paramString.equals("亥"))) {
            return "阴";
        }
        return "";
    }

    /**
     * 天干五行 甲乙同属木, 甲为阳, 乙为阴 丙丁同属火, 丙为阳, 丁为阴 戊己同属土, 戊为阳, 己为阴 庚辛同属金, 庚为阳, 辛为阴
     * 壬癸同属水, 壬为阳, 癸为阴
     *
     * @param paramString
     * @return
     */
    public static String tianganwuxing(String paramString) {
        if ((paramString.equals("甲")) || (paramString.equals("乙"))) {
            return "木";
        }
        if ((paramString.equals("丙")) || (paramString.equals("丁"))) {
            return "火";
        }
        if ((paramString.equals("戊")) || (paramString.equals("己"))) {
            return "土";
        }
        if ((paramString.equals("庚")) || (paramString.equals("辛"))) {
            return "金";
        }
        if ((paramString.equals("壬")) || (paramString.equals("癸"))) {
            return "水";
        }
        return "";
    }

    /**
     * 地支五行 亥子属水，巳午属火，寅卯属木，申酉属金，辰丑未戌属土，丑未为阴土，辰戌为阳土，辰丑为湿土，未戌为燥土。
     *
     * @param paramString
     * @return
     */
    public static String dizhiwuxing(String paramString) {
        if ((paramString.equals("寅")) || (paramString.equals("卯"))) {
            return "木";
        }
        if ((paramString.equals("巳")) || (paramString.equals("午"))) {
            return "火";
        }
        if ((paramString.equals("丑")) || (paramString.equals("辰")) || (paramString.equals("未")) || (paramString.equals("戌"))) {
            return "土";
        }
        if ((paramString.equals("申")) || (paramString.equals("酉"))) {
            return "金";
        }
        if ((paramString.equals("亥")) || (paramString.equals("子"))) {
            return "水";
        }
        return "";
    }

    /**
     * 甲、丙、戊、庚、壬为阳；乙、丁、己、辛、癸为阴
     *
     * @param paramString
     * @return
     */
    public static String tianganyinyang(String paramString) {
        if ((paramString.equals("甲")) || (paramString.equals("丙")) || (paramString.equals("戊")) || (paramString.equals("庚")) || (paramString.equals("壬"))) {
            return "阳";
        }
        if ((paramString.equals("乙")) || (paramString.equals("丁")) || (paramString.equals("己")) || (paramString.equals("辛")) || (paramString.equals("癸"))) {
            return "阴";
        }
        return "";
    }

    /**
     * 桃花位:
     *
     * @param
     */
    public static void taohua(String[] bazi) {
        String returnString = null;
        if ((bazi[2].equals("寅")) || (bazi[2].equals("午")) || (bazi[2].equals("戌"))) {
            returnString += "卯";
        }
        if ((bazi[2].equals("申")) || (bazi[2].equals("子")) || (bazi[2].equals("辰"))) {
            returnString += "酉";
        }
        if ((bazi[2].equals("亥")) || (bazi[2].equals("卯")) || (bazi[2].equals("未"))) {
            returnString += "子";
        }
        if ((bazi[2].equals("巳")) || (bazi[2].equals("酉")) || (bazi[2].equals("丑"))) {
            returnString += "午";
        }
    }

    /**
     * 六十甲子太岁神
     *
     * @param paramString 年柱
     * @return
     */
    public static String tianshui(String paramString) {
        if (paramString.equals("甲子")) {
            return "金办将军";
        }
        if (paramString.equals("乙丑")) {
            return "陈材将军";
        }
        if (paramString.equals("丙寅")) {
            return "耿章将军";
        }
        if (paramString.equals("丁卯")) {
            return "沈兴将军";
        }
        if (paramString.equals("戊辰")) {
            return "赵达将军";
        }
        if (paramString.equals("己巳")) {
            return "郭灿将军";
        }
        if (paramString.equals("庚午")) {
            return "王清将军";
        }
        if (paramString.equals("辛未")) {
            return "李素将军";
        }
        if (paramString.equals("壬申")) {
            return "刘旺将军";
        }
        if (paramString.equals("癸酉")) {
            return "康志将军";
        }
        if (paramString.equals("甲戌")) {
            return "施广将军";
        }
        if (paramString.equals("乙亥")) {
            return "任保将军";
        }
        if (paramString.equals("丙子")) {
            return "郭嘉将军";
        }
        if (paramString.equals("丁丑")) {
            return "汪文将军";
        }
        if (paramString.equals("戊寅")) {
            return "曾光将军";
        }
        if (paramString.equals("己卯")) {
            return "龙仲将军";
        }
        if (paramString.equals("庚辰")) {
            return "董德将军";
        }
        if (paramString.equals("辛巳")) {
            return "郑但将军";
        }
        if (paramString.equals("壬午")) {
            return "陆明将军";
        }
        if (paramString.equals("癸未")) {
            return "魏仁将军";
        }
        if (paramString.equals("甲申")) {
            return "方杰将军";
        }
        if (paramString.equals("乙酉")) {
            return "蒋崇将军";
        }
        if (paramString.equals("丙戌")) {
            return "白敏将军";
        }
        if (paramString.equals("丁亥")) {
            return "封济将军";
        }
        if (paramString.equals("戊子")) {
            return "邹镗将军";
        }
        if (paramString.equals("己丑")) {
            return "潘佐将军";
        }
        if (paramString.equals("庚寅")) {
            return "邬桓将军";
        }
        if (paramString.equals("辛卯")) {
            return "范宁将军";
        }
        if (paramString.equals("壬辰")) {
            return "彭泰将军";
        }
        if (paramString.equals("癸巳")) {
            return "徐华将军";
        }
        if (paramString.equals("甲午")) {
            return "章词将军";
        }
        if (paramString.equals("乙未")) {
            return "杨仙将军";
        }
        if (paramString.equals("丙申")) {
            return "管仲将军";
        }
        if (paramString.equals("丁酉")) {
            return "唐杰将军";
        }
        if (paramString.equals("戊戌")) {
            return "姜武将军";
        }
        if (paramString.equals("己亥")) {
            return "谢焘将军";
        }
        if (paramString.equals("庚子")) {
            return "虞起将军";
        }
        if (paramString.equals("辛丑")) {
            return "杨信将军";
        }
        if (paramString.equals("壬寅")) {
            return "贤谔将军";
        }
        if (paramString.equals("癸卯")) {
            return "皮时将军";
        }
        if (paramString.equals("甲辰")) {
            return "李诚将军";
        }
        if (paramString.equals("乙巳")) {
            return "吴遂将军";
        }
        if (paramString.equals("丙午")) {
            return "文哲将军";
        }
        if (paramString.equals("丁未")) {
            return "缪丙将军";
        }
        if (paramString.equals("戊申")) {
            return "徐浩将军";
        }
        if (paramString.equals("己酉")) {
            return "程宝将军";
        }
        if (paramString.equals("庚戌")) {
            return "倪秘将军";
        }
        if (paramString.equals("辛亥")) {
            return "叶坚将军";
        }
        if (paramString.equals("壬子")) {
            return "丘德将军";
        }
        if (paramString.equals("癸丑")) {
            return "朱得将军";
        }
        if (paramString.equals("甲寅")) {
            return "张朝将军";
        }
        if (paramString.equals("乙卯")) {
            return "万清将军";
        }
        if (paramString.equals("丙辰")) {
            return "辛亚将军";
        }
        if (paramString.equals("丁巳")) {
            return "杨彦将军";
        }
        if (paramString.equals("戊午")) {
            return "黎卿将军";
        }
        if (paramString.equals("己未")) {
            return "傅党将军";
        }
        if (paramString.equals("庚申")) {
            return "毛梓将军";
        }
        if (paramString.equals("辛酉")) {
            return "石政将军";
        }
        if (paramString.equals("壬戌")) {
            return "洪充将军";
        }
        if (paramString.equals("癸亥")) {
            return "虞程将军";
        }
        return "";
    }

    /**
     * 所谓命主文昌位，就是根据个人的生辰八字来推算，按照这个方法推算出来的文昌位是跟随个人，永不改变的。个人的命主文昌位如何确定?有这样一个推算的歌诀：甲岁亥巳曲与昌，乙逢马鼠焕文章，丙戊申寅庚亥巳，六丁鸡兔贵非常，壬遇虎猴癸兔西，辛宜子上马名扬。歌诀的意思是：出生在甲年的人，文昌位在东南。出生在乙年，文昌位在正南。出生在丙年，文昌位在西南。出生在丁年，文昌位在正西。出生在戊年，文昌位在西南。出生在己年，文昌位在正西。出生在庚年，文昌位在西北。出生在辛年，文昌位在正北。出生在壬年，文昌位在东北。出生在癸年，文昌位在正东。
     * 人又是如何得知自己出生在那年？这里有一套公式可以推算。凡尾数是4的年份，如2004年，即是甲年。以此类推，尾数是5的年份，即是乙年。尾数是6的年份，即是丙年。尾数是7的年份，即是丁年。尾数是8的年份，即是戊年。尾数是9的年份，即是己年。尾数是0的年份，即是庚年。尾数是1的年份，即是辛年。尾数是2的年份，即是壬年。尾数是3的年份，即是癸年。例如1013年，即是癸年。以自己的出生年份对应上面两个公式来推算，即可知道自己的命主文昌位在哪个位置。
     *
     * @param year 年份
     * @return 文昌位:
     */
    public static String wenchangwei(String year) {
        String returnString = "文昌位:";
        if (String.valueOf(year).substring(3, 4).equals("4")) {
            returnString += "东南";
        }
        if (String.valueOf(year).substring(3, 4).equals("5")) {
            returnString += "南方";
        }
        if (String.valueOf(year).substring(3, 4).equals("6")) {
            returnString += "西南";
        }
        if (String.valueOf(year).substring(3, 4).equals("8")) {
            returnString += "西南";
        }
        if (String.valueOf(year).substring(3, 4).equals("7")) {
            returnString += "西方";
        }
        if (String.valueOf(year).substring(3, 4).equals("9")) {
            returnString += "西方";
        }
        if (String.valueOf(year).substring(3, 4).equals("0")) {
            returnString += "西北";
        }
        if (String.valueOf(year).substring(3, 4).equals("1")) {
            returnString += "北方";
        }
        if (String.valueOf(year).substring(3, 4).equals("2")) {
            returnString += "东北";
        }
        if (String.valueOf(year).substring(3, 4).equals("3")) {
            returnString += "东方";
        }
        return returnString;
    }
}
