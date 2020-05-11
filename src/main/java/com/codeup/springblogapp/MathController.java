package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    //addition
    @GetMapping("/add/{numOne}/and/{numTwo}")
    @ResponseBody
    public int add(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne + numTwo;
    }
    //subtraction
    @GetMapping("/add/{numOne}/and/{numTwo}")
    @ResponseBody
    public int subtract(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne - numTwo;
    }
    //multiplication
    @GetMapping("/multiply/{numOne}/and/{numTwo}")
    @ResponseBody
    public int multiply(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne * numTwo;
    }
    //division
    @GetMapping("/divide/{numOne}/and/{numTwo}")
    @ResponseBody
    public int divide(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne / numTwo;
    }



}
