package com.example.tikoshopping.Service.Register;

public class FormRegisterUser {
    public String user_name ;
    public String password ;
    public String email ;
    public String phone_number ;

    public FormRegisterUser(String user_name, String password, String email, String phone_number) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
    }
}
