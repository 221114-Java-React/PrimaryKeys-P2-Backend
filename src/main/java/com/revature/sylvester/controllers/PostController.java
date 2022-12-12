package com.revature.sylvester.controllers;

import com.revature.sylvester.entities.Post;
import com.revature.sylvester.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("userId")
    public List<Post> getByUserId(@RequestParam String userId, HttpServletRequest req) {
        return postService.getAllPostsByUserId(userId);
    }
}
