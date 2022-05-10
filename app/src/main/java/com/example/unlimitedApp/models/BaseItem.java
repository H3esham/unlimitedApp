package com.example.unlimitedApp.models;

import java.io.Serializable;

public class BaseItem implements Serializable {
    private String uniqueId;
    private String name;
    private String description;
    private int image;

    public BaseItem(String uniqueId, String name, String description, int image) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
