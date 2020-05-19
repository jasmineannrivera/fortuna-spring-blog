package com.codeup.springblogapp;

import com.codeup.springblogapp.models.Post;
import com.codeup.springblogapp.models.User;
import com.codeup.springblogapp.repositories.PostRepository;
import com.codeup.springblogapp.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBlogAppApplication.class)
@AutoConfigureMockMvc
public class PostsIntegrationTests {

    private User testUser;
    private HttpSession httpSession;

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository userDao;

    @Autowired
    PostRepository postsDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setup() throws Exception {

        testUser = userDao.findByUsername("testUser");

        // Creates the test user if not exists
        if (testUser == null) {
            User newUser = new User();
            newUser.setUsername("testUser");
            newUser.setPassword(passwordEncoder.encode("pass"));
            newUser.setEmail("testUser@codeup.com");
            testUser = userDao.save(newUser);
        }

        // Throws a Post request to /login and expect a redirection to the Posts index page after being logged in
        httpSession = this.mvc.perform(post("/login").with(csrf())
                .param("username", "testUser")
                .param("password", "pass"))
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(redirectedUrl("/posts"))
                .andReturn()
                .getRequest()
                .getSession();
    }
    @Test
    public void testEditPost() throws Exception {
        // Gets the first Post for tests purposes
        Post existingPost = postsDao.findAll().get(0);

        // Makes a Post request to /posts/{id}/edit and expect a redirection to the Post show page
        this.mvc.perform(
                post("/posts/" + existingPost.getId() + "/edit").with(csrf())
                        .session((MockHttpSession) httpSession)
                        .param("title", "edited title")
                        .param("description", "edited description"))
                .andExpect(status().is3xxRedirection());

        // Makes a GET request to /posts/{id} and expect a redirection to the Post show page
        this.mvc.perform(get("/posts/" + existingPost.getId()))
                .andExpect(status().isOk())
                // Test the dynamic content of the page
                .andExpect(content().string(containsString("edited title")))
                .andExpect(content().string(containsString("edited description")));
    }
}

