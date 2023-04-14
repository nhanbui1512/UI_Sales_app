package com.example.tikoshopping.Service;

import com.example.tikoshopping.models.PopularModel;
import com.example.tikoshopping.models.TypeGoods;

import java.util.ArrayList;

public class ResultTypeGoods {
    private  Boolean result ;
    private ArrayList<TypeGoods> data ;

    public ResultTypeGoods(Boolean result, ArrayList<TypeGoods> data) {
        this.result = result;
        this.data = data;

    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public ArrayList<TypeGoods> getData() {
        return data;
    }

    public void setData(ArrayList<TypeGoods> data) {
        this.data = data;
    }
}
