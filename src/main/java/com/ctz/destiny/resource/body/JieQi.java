package com.ctz.destiny.resource.body;

import java.util.Date;

/**
 * Created by chentz on 2017/10/20.
 */
public class JieQi {
    private String jieQiName;
    private Date jieQiDate;

    public JieQi(String jieQiName, Date jieQiDate) {
        this.jieQiName = jieQiName;
        this.jieQiDate = jieQiDate;
    }

    public String getJieQiName() {
        return jieQiName;
    }

    public Date getJieQiDate() {
        return jieQiDate;
    }
}
