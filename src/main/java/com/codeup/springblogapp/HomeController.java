package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Create a HomeController class. This class should have one method with a GetMapping for /. It should return a string that says "This is the landing page!".
//This will eventually be the page that users see when they first visit your page. Later on, when we learn about views, you can swap it out for something more fancy.
@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String landing() {
        return "This is the landing page!";
    }

}
