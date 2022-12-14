package com.revature.sylvester.controllers;

import com.revature.sylvester.dtos.requests.NewPostRequest;
import com.revature.sylvester.dtos.responses.Principal;
import com.revature.sylvester.entities.Post;
import com.revature.sylvester.services.PostService;
import com.revature.sylvester.services.TokenService;
import com.revature.sylvester.utils.custom_exceptions.InvalidAuthException;
import com.revature.sylvester.utils.custom_exceptions.InvalidPostException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final TokenService tokenService;

    public PostController(PostService postService, TokenService tokenService) {
        this.postService = postService;
        this.tokenService = tokenService;
    }

    @PostMapping
    public Post create(@RequestBody NewPostRequest req, HttpServletRequest servReq) {
        String token = servReq.getHeader("authorization");

        if(token == null || token.isEmpty())
            throw new InvalidAuthException("Invalid token");

        Principal principal = tokenService.extractRequesterDetails(token);

        if(principal == null)
            throw new InvalidAuthException("Please sign in to create a post");

        Post createdPost;

        if(postService.isValidContent(req.getContent()))
            createdPost = postService.savePostByUserId(req, principal.getUserId());
        else
            throw new InvalidPostException("Post content must be 128 characters or less");

        return createdPost;
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.getAllPosts();
    }

    @GetMapping("/user")
    public List<Post> getByUserId(@RequestParam String id) {
        return postService.getAllPostsByUserId(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidPostException.class)
    public InvalidPostException handledPostException (InvalidPostException e) {
        return e;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidAuthException.class)
    public InvalidAuthException handledAuthException (InvalidAuthException e) {
        return e;
    }
}
