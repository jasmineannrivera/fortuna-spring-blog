package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.repositories.PostRepository;
import com.codeup.springblogapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    // Dependency Injection
    private UserRepository userDao;

    // Spring's version of DaoFactory
    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }
}
