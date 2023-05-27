package com.example.tikoshopping.Service;

import com.example.tikoshopping.Service.RequestSales.Request;
import com.example.tikoshopping.models.PostSales;

import java.util.ArrayList;

public class ResultAllRequest {
    public ResultAllRequest(ArrayList<Request> listRequest){
        this.data = listRequest;
    }
    public ArrayList<Request>  data ;

    public ArrayList<Request> getData() {
        return data;
    }
}
