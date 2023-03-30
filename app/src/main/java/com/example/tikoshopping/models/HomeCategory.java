package com.example.tikoshopping.models;

public class HomeCategory {
    String name;
    String imd_url;
    String type;

    public HomeCategory() {
    }

    public HomeCategory(String name, String imd_url, String type) {
        this.name = name;
        this.imd_url = imd_url;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImd_url() {
        return imd_url;
    }

    public void setImd_url(String imd_url) {
        this.imd_url = imd_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
