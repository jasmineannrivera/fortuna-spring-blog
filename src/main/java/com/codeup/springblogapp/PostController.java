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
    @GetMapping("/posts")
    public String index(Model model){
        ArrayList<Post> postList = new ArrayList<>();



        for (int i = 1; i <= 5; i++) {
            String fTitle = "Day " + i;
            String fBody = "This is the body of a post for day " + i;
            postList.add(new Post( fTitle, fBody));
        }

        model.addAttribute("posts", postList);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model){
        Post newPost = new Post("Example Post", "This is the body of a post!");
        model.addAttribute("post", newPost);
        return "posts/show";
    }

//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String postCreateForm(){
//        return "Viewing the form to create a post";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createNewPost(){
//        return "Creating a new post";
//    }
}