package com.dzcode.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginSpringController {

    @RequestMapping(value = "/login")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }
}
