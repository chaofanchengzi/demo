package com.zc.bar.bean;

public class Chair {

    /**
     * 名称
     */
    private String chairName;

    /**
     * 颜色
     */
    private String chairColor;

    public String getChairName() {
        return chairName;
    }

    public void setChairName(String chairName) {
        this.chairName = chairName;
    }

    public String getChairColor() {
        return chairColor;
    }

    public void setChairColor(String chairColor) {
        this.chairColor = chairColor;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "chairName='" + chairName + '\'' +
                ", chairColor='" + chairColor + '\'' +
                '}';
    }
}
