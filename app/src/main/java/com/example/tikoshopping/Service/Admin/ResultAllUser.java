package com.example.tikoshopping.Service.Admin;

import com.example.tikoshopping.Service.User;

import java.util.ArrayList;

public class ResultAllUser {

    public ResultAllUser(ArrayList<User> listUser, Boolean result){
        this.data = listUser;
        this.result = result;
    }
    public ArrayList<User>  data ;
    public Boolean result;
}
