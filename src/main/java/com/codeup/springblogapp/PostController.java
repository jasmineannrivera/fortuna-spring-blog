package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")

    public String postIndex() {
        return "index";
    }
    @GetMapping("/posts/{id}")
    public String postByID(@PathVariable int id) {
        return "show";
    }



}
