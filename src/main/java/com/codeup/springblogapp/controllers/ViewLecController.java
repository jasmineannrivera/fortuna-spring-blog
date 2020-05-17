package com.codeup.springblogapp.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewLecController {

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }
}