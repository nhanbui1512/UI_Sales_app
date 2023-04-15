package com.example.tikoshopping.Service;

import com.example.tikoshopping.Service.User;

import java.util.ArrayList;

public class ResultMyProfile {
    private Boolean result ;
    private User data ;

    public ResultMyProfile(Boolean result, User data) {
        this.result = result;
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
