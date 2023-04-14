package com.example.tikoshopping.models;

public  class TypeGoods {
    private int IDType ;
    private String NameType ;
    private String IconPath ;


    public TypeGoods(int idType, String nameType, String iconPath) {
        IDType = idType;
        NameType = nameType;
        IconPath = iconPath;
    }

    public String getIconPath() {
        return IconPath;
    }

    public void setIconPath(String iconPath) {
        IconPath = iconPath;
    }

    public String getNameType() {
        return NameType;
    }

    public void setNameType(String nameType) {
        NameType = nameType;
    }

    public int getIDType() {
        return IDType;
    }

    public void setIDType(int IDType) {
        this.IDType = IDType;
    }
}