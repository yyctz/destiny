package com.ctz.destiny.resource.domain;

/**
 * Created by chentz on 2017/11/17.
 * 天干
 * 甲木、乙木、丙火、丁火、戊土、己土、庚金、辛金、壬水、癸水，其中甲丙戊庚壬为阳性，乙丁己辛癸为阴性
 */
public enum TianGan {
    甲(1,WuXing.木),
    乙(2,WuXing.木),
    丙(3,WuXing.火),
    丁(4,WuXing.火),
    戊(5,WuXing.土),
    己(6,WuXing.土),
    庚(7,WuXing.金),
    辛(8,WuXing.金),
    壬(9,WuXing.水),
    癸(10,WuXing.水)
    ;

    private int id;

    private WuXing wuXing;

    TianGan(int id, WuXing wuXing) {
        this.id = id;
        this.wuXing = wuXing;
    }

    public WuXing getWuXing() {
        return wuXing;
    }

    public int getId() {
        return id;
    }

    public static TianGan getTianGan(int id){
        if(id<0||id>9){
            return null;
        }
        TianGan[] tianGans = TianGan.values();
        for (int i = 0; i < tianGans.length; i++) {
            if(tianGans[i].getId()==id){
                return tianGans[i];
            }
        }
        return null;
    }

}
