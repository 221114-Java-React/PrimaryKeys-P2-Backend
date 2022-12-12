package com.revature.sylvester.controllers;

import com.revature.sylvester.services.PostService;

public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
}
