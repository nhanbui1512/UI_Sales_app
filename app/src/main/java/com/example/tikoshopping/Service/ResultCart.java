package com.example.tikoshopping.Service;

import java.util.ArrayList;

public class ResultCart {

    public ResultCart (Boolean result, ArrayList<CartItem> list, Double total){
        this.result = result ;
        this.data = list;
        this.total = total;
    }
    public Boolean result ;
    public ArrayList<CartItem> data ;
    public Double total ;


}
