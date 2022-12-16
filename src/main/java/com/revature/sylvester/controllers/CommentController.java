package com.revature.sylvester.controllers;

import com.revature.sylvester.dtos.requests.NewCommentRequest;
import com.revature.sylvester.dtos.responses.Principal;
import com.revature.sylvester.entities.Comment;
import com.revature.sylvester.services.CommentService;
import com.revature.sylvester.services.TokenService;
import com.revature.sylvester.utils.custom_exceptions.InvalidAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping
    public void create(@RequestBody NewCommentRequest req, HttpServletRequest servReq) {
        String token = servReq.getHeader("authorization");

        if(token == null || token.isEmpty())
            throw new InvalidAuthException("Invalid token");

        Principal principal = tokenService.extractRequesterDetails(token);

        if(principal == null)
            throw new InvalidAuthException("Please log in to create a comment");

        if(!principal.isActive())
            throw new InvalidAuthException("Your account is not active");

        commentService.createComment(req, principal.getUserId());
    }

    @GetMapping("/post")
    public List<Comment> getAllByPostId(@RequestParam String id) {
        return commentService.getAllCommentsByPostId(id);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidAuthException.class)
    public InvalidAuthException handledAuthException (InvalidAuthException e) {
        return e;
    }
}
