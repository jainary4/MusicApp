package com.example.myapplication;

import android.text.TextUtils;
import android.widget.EditText;

public class Login_Model {
    private final String pattern = "[a-zA-Z0-9._-]+@([a-z]+\\.)+[a-z]+";

    // we need a function to check if the password matches the password in the firebase storage
    // another function to verify that the entered email is reight or wrong
    public boolean is_empty(String email) {
        if(TextUtils.isEmpty(email)){
            return true;
        }
        return false;
    }
    public boolean pattern_match(String email){
        return email.matches(pattern);
    }

    public boolean password_check_length(String password) {
        return (password.length() >= 6);
    }




}
