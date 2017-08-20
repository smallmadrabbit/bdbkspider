package com.model;

import java.util.Arrays;

/**
 * Created by bigjsd on 2017/7/7.
 */
public class PageInfoEntity {

    private String name;
    private String information;
    private String description;
    private String imageUrl;
    private String bkUrl;


    public String getBkUrl() {
        return bkUrl;
    }

    public void setBkUrl(String bkUrl) {
        this.bkUrl = bkUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "PageInfoEntity{" +
                "name='" + name + '\'' +
                ", information='" + information + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
