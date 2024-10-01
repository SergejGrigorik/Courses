package com.kciray.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class LoginComtroller {

    @GetMapping("/login")
    public String liginpage(){
        return "user/login";
    }
}
