package com.revature.sylvester.controllers;

import com.revature.sylvester.entities.Like;
import com.revature.sylvester.services.CommentService;
import com.revature.sylvester.services.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final TokenService tokenService;
    private final CommentService commentService;

    public CommentController(TokenService tokenService, CommentService commentService) {
        this.tokenService = tokenService;
        this.commentService = commentService;
    }

    @GetMapping("/post")
    public List<Like> getAllByPostId(@RequestParam String id) {
        return commentService.getAllCommentsByPostId(id);
    }
}
