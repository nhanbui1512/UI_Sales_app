package com.example.tikoshopping.Service.Order_Model;

public class Order {
    public int IDOrder ;
    public int IDPost ;
    public String Title ;
    public String Description ;
    public int Count ;
    public Double Price ;

    public Order(int IDOrder, int IDPost, String title, String description, int count, Double price) {
        this.IDOrder = IDOrder;
        this.IDPost = IDPost;
        Title = title;
        Description = description;
        Count = count;
        Price = price;
    }
}
