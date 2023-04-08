package com.example.tikoshopping.Service;

public class User {
    private int UserID;
    private String UserName ;
    private String Email ;
    private String PhoneNumber ;
    private String AvatarPath ;
    private int Access ;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
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

    public User(int userID, String userName, String email, String phoneNumber, String avatarPath, int access) {
        UserID = userID;
        UserName = userName;
        Email = email;
        PhoneNumber = phoneNumber;
        AvatarPath = avatarPath;
        Access = access;
    }
}
