package com.example.tikoshopping.Service.Order_Model;

import java.sql.Date;
import java.util.ArrayList;

public class Bill {
    public int IDBill ;
    public String UserName ;
    public String Email ;
    public String Address ;
    public Date CreateAt ;
    public Double Total ;
    public ArrayList<Order> orders ;

    public Bill(int IDBill, String userName, String email, String address, Date createAt, Double total, ArrayList<Order> orders) {
        this.IDBill = IDBill;
        UserName = userName;
        Email = email;
        Address = address;
        CreateAt = createAt;
        Total = total;
        this.orders = orders;
    }
}
