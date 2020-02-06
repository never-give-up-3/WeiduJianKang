package com.wd.health.model.bean;

import java.io.Serializable;

public class ChaXunShiPin_DataBean implements Serializable {
    private String abstracts;
    private int buyNum;
    private int categoryId;
    private int duration;
    private int id;
    private String originalUrl;
    private int price;
    private String shearUrl;
    private String title;
    private int whetherBuy;
    private int whetherCollection;

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getShearUrl() {
        return shearUrl;
    }

    public void setShearUrl(String shearUrl) {
        this.shearUrl = shearUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWhetherBuy() {
        return whetherBuy;
    }

    public void setWhetherBuy(int whetherBuy) {
        this.whetherBuy = whetherBuy;
    }

    public int getWhetherCollection() {
        return whetherCollection;
    }

    public void setWhetherCollection(int whetherCollection) {
        this.whetherCollection = whetherCollection;
    }
}
