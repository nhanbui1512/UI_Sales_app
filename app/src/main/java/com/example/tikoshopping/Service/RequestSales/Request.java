package com.example.tikoshopping.Service.RequestSales;

import java.sql.Date;

public class Request {

    public int IDRequest ;
    public  int IDUser ;
    public String NameShop ;
    public String AddressShop ;
    public String Email ;
    public String PhoneNumber ;
    public Boolean Status ;
    public Date CreateAt ;


    public Request(int IDRequest, int IDUser, String nameShop, String addressShop, String email, String phoneNumber, Boolean status, Date createAt) {
        this.IDRequest = IDRequest;
        this.IDUser = IDUser;
        NameShop = nameShop;
        AddressShop = addressShop;
        Email = email;
        PhoneNumber = phoneNumber;
        Status = status;
        CreateAt = createAt;
    }

}
