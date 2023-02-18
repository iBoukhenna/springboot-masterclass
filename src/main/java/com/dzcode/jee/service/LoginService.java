package com.dzcode.jee.service;

public class LoginService {

    public boolean isUserValid(String name, String password) {
        if (name.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }
}
