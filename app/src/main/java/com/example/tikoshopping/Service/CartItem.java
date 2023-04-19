package com.example.tikoshopping.Service;

public class CartItem {

    public CartItem(int IDCart, int Count , int IDPost, String Title, String Description, double Price , float Discount)
    {
        this.IDCart = IDCart;
        this.Count = Count;
        this. IDPost = IDPost;
        this.Title = Title;
        this.Description = Description;
        this. DisCount = Discount;
    }
    public int IDCart ;
    public int Count ;
    public int IDPost ;
    public String Title ;
    public String Description ;
    public double Price ;
    public float DisCount ;

}
