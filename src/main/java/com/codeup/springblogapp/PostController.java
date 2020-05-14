package com.codeup.springblogapp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//        GET	/posts	posts index page
//        GET	/posts/{id}	view an individual post
//        GET	/posts/create	view the form for creating a post
//        POST	/posts/create	create a new post

@Controller
public class PostController {
    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }



    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model){
        model.addAttribute("post",postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post postToEdit = postDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreateForm(){
        return "Viewing the form to create a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost(){
        return "Creating a new post";
    }
}