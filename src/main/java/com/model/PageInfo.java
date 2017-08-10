package com.model;

/**
 * Created by bigjsd on 2017/7/7.
 */
public class PageInfo {
    private String name;
    private String[] abstracts;
    private String state;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String[] abstracts) {
        this.abstracts = abstracts;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "name='" + name + '\'' +
                ", abstracts='" + abstracts + '\'' +
                ", state='" + state + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
