package com.clickear.sample;

/**
 * Created by Administrator on 2016/11/17.
 */
public class TestClass {
    @Override
    public String toString() {
        return  value +":" + onclick;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOnclick() {
        return onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    private String value;
    private String onclick;

}
