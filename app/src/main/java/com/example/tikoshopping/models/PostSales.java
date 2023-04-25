package com.example.tikoshopping.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class PostSales implements Serializable
{
    private int IDPost;
    private int IDUser;
    private String UserName;
    private String Title;
    private String Description;
    private Date CreateAt ;
    private Date UpdateAt ;
    private String NameType;
    private ArrayList<Image> images;
    private int Discount;
    private int Price;


    public PostSales(int idPost, int idUser, String userName, String title, String description, Date createAt, Date updateAt, String nameType, ArrayList<Image> images, int discount, int price) {
        IDPost = idPost;
        IDUser = idUser;
        UserName = userName;
        Title = title;
        Description = description;
        CreateAt = createAt;
        UpdateAt = updateAt;
        NameType = nameType;
        Discount = discount;
        this.images = images;
        Price = price;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }

    public int getIDPost() {
        return IDPost;
    }

    public void setIDPost(int IDPost) {
        this.IDPost = IDPost;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public String getUserName() {
        return UserName;
    }


    public void setPrice(int price) {
        Price = price;
    }
    public int getPrice()
    {
        return this.Price;
    }

    public void setUserName(String userName) {
        UserName = userName;
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

    public Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date updateAt) {
        UpdateAt = updateAt;
    }

    public String getNameType() {
        return NameType;
    }

    public void setNameType(String nameType) {
        NameType = nameType;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}
