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

    public int getIDCart() {
        return IDCart;
    }

    public void setIDCart(int IDCart) {
        this.IDCart = IDCart;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public int getIDPost() {
        return IDPost;
    }

    public void setIDPost(int IDPost) {
        this.IDPost = IDPost;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public float getDisCount() {
        return DisCount;
    }

    public void setDisCount(float disCount) {
        DisCount = disCount;
    }
}
