package com.dzcode.webapp.springmvc.controller;

import com.dzcode.webapp.springmvc.service.LoginSpringService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginSpringController {

    LoginSpringService loginSpringService = new LoginSpringService();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String sayHello(@RequestParam String password, @RequestParam String name, ModelMap model) {
        if (loginSpringService.isUserValid(name, password)) {
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        } else {
            model.put("errorMessage", "Invalid Credentials!");
            return "login";
        }
    }
}
