package com.codeup.springblogapp.controllers;
import com.codeup.springblogapp.models.Post;
import com.codeup.springblogapp.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
    //show all the posts
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    //show the individual post the user clicked on
    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model){
        model.addAttribute("post",postDao.getOne(id));
        return "posts/show";
    }
    //show form for editing specific post
    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post postToEdit = postDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }
    //submit the edits and redirect to main posts page
    @PostMapping("/posts/{id}/edit")
    public String edited(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post p = postDao.getOne(id);
        p.setTitle(title);
        p.setBody(body);
        postDao.save(p);
        return "redirect:/posts";
    }

    //show the form for creating a new post
    @GetMapping("/posts/create")
    public String showCreatePostForm(Model model){
        System.out.println("posts/create method");
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    //submit the form and redirect to main post page
    @PostMapping("/posts/create")
    public String createNewPost(@ModelAttribute Post newPost) {
        Post savedPost = postDao.save(newPost);
        System.out.println(savedPost.getId());

        return "redirect:/posts/";
    }
}