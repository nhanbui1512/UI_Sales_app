package com.example.tikoshopping.Service;

import com.example.tikoshopping.models.Image;

import java.util.ArrayList;

public class CartItem {

    public CartItem(int IDCart, int Count , int IDPost, String Title, String Description,ArrayList<Image> images, int Price , float Discount)
    {
        this.IDCart = IDCart;
        this.Count = Count;
        this. IDPost = IDPost;
        this.Title = Title;
        this.Description = Description;
        this. DisCount = Discount;
        this.Price = Price;
        this.images = images;
    }

    public int IDCart ;
    public int Count ;
    public int IDPost ;
    public String Title ;
    public String Description ;
    public int Price ;
    public float DisCount ;
    private ArrayList<Image> images;

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

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

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public float getDisCount() {
        return DisCount;
    }

    public void setDisCount(float disCount) {
        DisCount = disCount;
    }
}
