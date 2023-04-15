package com.example.tikoshopping.models;

public class User {

    private int IDUser ;
    private String UserName ;
    private String Email;
    private String PhoneNumber ;
    private String AvatarPath ;
    private int Access ;


    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
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

    public String getAvatarPath() {
        return AvatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        AvatarPath = avatarPath;
    }

    public int getAccess() {
        return Access;
    }

    public void setAccess(int access) {
        Access = access;
    }

    public User(int IDUser, String userName, String email, String phoneNumber, String avatarPath, int access) {
        this.IDUser = IDUser;
        UserName = userName;
        Email = email;
        PhoneNumber = phoneNumber;
        AvatarPath = avatarPath;
        Access = access;
    }




}
