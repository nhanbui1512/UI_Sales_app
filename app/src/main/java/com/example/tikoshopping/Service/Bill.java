package com.example.tikoshopping.Service;

import java.util.ArrayList;

public class Bill {

    public Bill(Double total, String address, ArrayList<Order> orders)
    {
        this.total = total ;
        this.address = address ;
        this.orders = orders ;
    }

    public Double total ;
    public String address ;
    public ArrayList<Order> orders ;
}
