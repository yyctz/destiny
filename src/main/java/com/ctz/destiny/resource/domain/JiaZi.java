package com.ctz.destiny.resource.domain;

/**
 * Created by chentz on 2017/11/22.
 */
public enum  JiaZi {
    甲子(WuXing.金),
    乙丑(WuXing.金),
    丙寅(WuXing.火),
    丁卯(WuXing.火),
    戊辰(WuXing.木),
    己巳(WuXing.木),
    庚午(WuXing.土),
    辛未(WuXing.土),
    壬申(WuXing.金),
    癸酉(WuXing.金),
    甲戌(WuXing.火),
    乙亥(WuXing.火),
    丙子(WuXing.水),
    丁丑(WuXing.水),
    戊寅(WuXing.土),
    己卯(WuXing.土),
    庚辰(WuXing.金),
    辛巳(WuXing.金),
    壬午(WuXing.木),
    癸未(WuXing.木),
    甲申(WuXing.水),
    乙酉(WuXing.水),
    丙戌(WuXing.土),
    丁亥(WuXing.土),
    戊子(WuXing.火),
    己丑(WuXing.火),
    庚寅(WuXing.木),
    辛卯(WuXing.木),
    壬辰(WuXing.水),
    癸巳(WuXing.水),
    甲午(WuXing.金),
    乙未(WuXing.金),
    丙申(WuXing.火),
    丁酉(WuXing.火),
    戊戌(WuXing.木),
    己亥(WuXing.木),
    庚子(WuXing.土),
    辛丑(WuXing.土),
    壬寅(WuXing.金),
    癸卯(WuXing.金),
    甲辰(WuXing.火),
    乙巳(WuXing.火),
    丙午(WuXing.水),
    丁未(WuXing.水),
    戊申(WuXing.土),
    己酉(WuXing.土),
    庚戌(WuXing.金),
    辛亥(WuXing.金),
    壬子(WuXing.木),
    癸丑(WuXing.木),
    甲寅(WuXing.水),
    乙卯(WuXing.水),
    丙辰(WuXing.土),
    丁巳(WuXing.土),
    戊午(WuXing.火),
    己未(WuXing.火),
    庚申(WuXing.木),
    辛酉(WuXing.木),
    壬戌(WuXing.水),
    癸亥(WuXing.水);
    
    private WuXing wuXing;

    JiaZi(WuXing wuXing) {
        this.wuXing = wuXing;
    }

    public WuXing getWuXing() {
        return wuXing;
    }
}
