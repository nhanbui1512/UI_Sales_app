package com.example.tikoshopping.Service;

public class ResultAddProductIntoCart {

    public ResultAddProductIntoCart(Boolean result, String message)
    {
        this.result = result;
        this.message = message ;
    }
    public Boolean result ;
    public String message ;
}
