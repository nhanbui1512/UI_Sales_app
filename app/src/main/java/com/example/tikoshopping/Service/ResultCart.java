package com.example.tikoshopping.Service;

import java.util.ArrayList;

public class ResultCart {

    public ResultCart (Boolean result, ArrayList<CartItem> list){
        this.result = result ;
        this.data = list;
    }
    public Boolean result ;
    public ArrayList<CartItem> data ;


}
