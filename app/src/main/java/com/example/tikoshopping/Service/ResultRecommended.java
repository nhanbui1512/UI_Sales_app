package com.example.tikoshopping.Service;

import com.example.tikoshopping.models.RecommendedModel;

import java.util.ArrayList;

public class ResultRecommended {
    private Boolean result ;
    private ArrayList<RecommendedModel> data ;

    public ResultRecommended(Boolean result, ArrayList<RecommendedModel> data) {
        this.result = result;
        this.data = data;

    }

    public ArrayList<RecommendedModel> getData() {
        return data;
    }

    public void setData(ArrayList<RecommendedModel> data) {
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
