package com.example.tikoshopping.Service.RequestSales;

public class FormRequest {
    public FormRequest(String nameShop, String addressShop, String email, String phoneNumber) {
        this.nameShop = nameShop;
        this.addressShop = addressShop;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String nameShop ;
    public String addressShop ;
    public String email ;
    public String phoneNumber ;
}
