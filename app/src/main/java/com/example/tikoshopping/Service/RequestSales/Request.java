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

    public int getRequestID() {
        return IDRequest;
    }

    public void setRequestID(int id) {
        IDRequest = id;
    }
    public int getRequestUserID() {
        return IDUser;
    }

    public void setRequestUserID(int id) {
        IDUser = id;
    }

    public String getNameShop() {
        return NameShop;
    }

    public void setNameShop(String name) {
        NameShop = name;
    }
    public String getAddressShop() {
        return AddressShop;
    }

    public void setAddressShop(String name) {
        AddressShop = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public Date getDate() {
        return CreateAt;
    }

    public void setDate(Date date) {
        CreateAt = date;
    }


    public Request(int IDRequest, int IDUser, String nameShop, String addressShop, String email, String phoneNumber, Boolean status, Date createAt) {
        this.IDRequest = IDRequest;
        this.IDUser = IDUser;
        this.NameShop = nameShop;
        this.AddressShop = addressShop;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.Status = status;
        this.CreateAt = createAt;
    }

}
