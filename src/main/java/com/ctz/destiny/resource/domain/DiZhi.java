package com.ctz.destiny.resource.domain;

/**
 * Created by chentz on 2017/11/17.
 * 地支
 * 子代表鼠，丑代表牛，寅代表虎；卯代表兔，辰代表龙，巳代表蛇，午代表马，未代表羊，申代表猴，酉代表鸡，戌代表狗，亥代表猪
 */
public enum DiZhi {
    子(1,"鼠"),
    丑(2,"牛"),
    寅(3,"虎"),
    卯(4,"兔"),
    辰(5,"龙"),
    巳(6,"蛇"),
    午(7,"马"),
    未(8,"羊"),
    申(9,"猴"),
    酉(10,"鸡"),
    戌(11,"狗"),
    亥(12,"猪");
    private int id;

    private String zodiac;
    DiZhi(int id,String zodiac) {
        this.id = id;
        this.zodiac = zodiac;
    }

    public int getId() {
        return id;
    }

    public String getZodiac() {
        return zodiac;
    }

    public static DiZhi getDiZhi(int id){
        if(id<0||id>11){
            return null;
        }
        DiZhi[] diZhis = DiZhi.values();
        for (int i = 0; i < diZhis.length; i++) {
            if(diZhis[i].getId()==id){
                return diZhis[i];
            }
        }
        return null;
    }
}
