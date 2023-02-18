package com.dzcode.webapp.springmvc.service;

public class LoginSpringService {

    public boolean isUserValid(String name, String password) {
        if (name.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }
}
