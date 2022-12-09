package com.revature.sylvester.handlers;

import com.revature.sylvester.services.PostService;

public class PostHandler {
    private final PostService postService;

    public PostHandler(PostService postService) {
        this.postService = postService;
    }
}
