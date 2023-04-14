package com.example.tikoshopping.Service;

import com.example.tikoshopping.models.PostSales;

import java.util.ArrayList;

public class ResultPostSales
{
    private Boolean result ;
    private ArrayList<PostSales> data ;

    public ResultPostSales(Boolean result, ArrayList<PostSales> data) {
        this.result = result;
        this.data = data;

    }

    public ArrayList<PostSales> getData() {
        return data;
    }

    public void setData(ArrayList<PostSales> data) {
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
