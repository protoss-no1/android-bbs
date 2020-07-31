package com.ttit.myapp.entity;

import java.io.Serializable;

/**
 * @author: wei
 * @date: 2020-08-01
 **/
public class NewsEntity implements Serializable {
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
