package com.example.tikoshopping.Service;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private ArrayList<User> data ;

    public UserData(ArrayList<User> userList) {
        this.data = userList;
    }

    public ArrayList<User> getUserList() {
        return data;
    }

    public void setUserList(ArrayList<User> userList) {
        this.data = userList;
    }
}
