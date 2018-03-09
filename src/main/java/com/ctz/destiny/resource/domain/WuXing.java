package com.ctz.destiny.resource.domain;

/**
 * Created by chentz on 2017/11/17.
 * 五行
 */
public enum WuXing {
    金(1),
    木(2),
    水(3),
    火(4),
    土(5);

    private int id;


    WuXing(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
