package com.example.tikoshopping.Service.Sales;

import java.io.File;
import java.util.ArrayList;

public class FormCreatePostSales {
    public FormCreatePostSales(ArrayList<File> photos, String title, String description, int id_type) {
        this.photos = photos;
        this.title = title;
        this.description = description;
        this.id_type = id_type;
    }

    public ArrayList<File> photos ;
    public String title ;
    public String description ;
    public int id_type ;

}
