package com.zc.bar.bean;

public class Desk {

    /**
     * 品牌
     */
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
