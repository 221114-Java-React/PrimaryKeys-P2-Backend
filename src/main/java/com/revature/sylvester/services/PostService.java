package com.revature.sylvester.services;

import com.revature.sylvester.daos.PostDAO;

public class PostService {
    private final PostDAO postDAO;

    public PostService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }
}
