package com.example.tikoshopping.Service;

public class LoginResult {
    private Boolean result ;
    private String message ;
    private String token ;

    public LoginResult(Boolean result, String message, String token) {
        this.result = result;
        this.message = message;
        this.token = token;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
