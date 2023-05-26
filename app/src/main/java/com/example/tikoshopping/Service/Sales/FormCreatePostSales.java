package com.example.tikoshopping.Service.Sales;

import java.io.File;
import java.util.ArrayList;

public class FormCreatePostSales {
    public FormCreatePostSales(ArrayList<File> photos, String title, String description, int id_type, double price , int discount) {
        this.photos = photos;
        this.title = title;
        this.description = description;
        this.id_type = id_type;
        this.price = price;
        this.discount = discount;
    }

    public ArrayList<File> photos ;
    public String title ;
    public String description ;
    public int id_type ;

    public double price ;
    public int discount ;

}
