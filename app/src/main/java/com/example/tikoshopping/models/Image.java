package com.example.tikoshopping.models;

public class Image {

    private int IDImage ;
    private String Path ;
    private int PostID;

    public Image(int idImage, String path, int postID) {
        IDImage = idImage;
        Path = path;
        PostID = postID;
    }

    public int getIDImage() {
        return IDImage;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int postID) {
        PostID = postID;
    }
}
