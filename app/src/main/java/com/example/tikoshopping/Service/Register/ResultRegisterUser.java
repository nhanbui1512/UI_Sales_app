package com.example.tikoshopping.Service.Register;

import com.example.tikoshopping.Service.User;

public class ResultRegisterUser {
    public Boolean result ;
    public String message ;
    public User user ;

    public ResultRegisterUser(Boolean result, String message, User user) {
        this.result = result;
        this.message = message;
        this.user = user;
    }
}
