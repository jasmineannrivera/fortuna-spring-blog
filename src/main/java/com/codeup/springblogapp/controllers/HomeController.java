package com.codeup.springblogapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/roll-dice")
    public String dice() {
        return "roll-dice";
    }
    //make variable for number and get random number and see if they match
    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String guess(@PathVariable int n) {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 6 + 1;
        int randomInt = (int) randomDouble;
        System.out.println(randomInt);
        if (n == randomInt) {
            System.out.println("True");
            return "your number: " + n + " random number: " + randomInt + " yayyy";
        } else {
            System.out.println("False");
            return "your number: " + n + " random number: " + randomInt + " booooo";
        }
    }

}
