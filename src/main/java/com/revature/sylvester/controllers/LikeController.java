package com.revature.sylvester.controllers;

import com.revature.sylvester.dtos.responses.Principal;
import com.revature.sylvester.entities.Like;
import com.revature.sylvester.services.LikeService;
import com.revature.sylvester.services.TokenService;
import com.revature.sylvester.utils.custom_exceptions.InvalidAuthException;
import com.revature.sylvester.utils.custom_exceptions.InvalidLikeException;
import com.revature.sylvester.utils.custom_exceptions.InvalidPostException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/likes")
public class LikeController {
    private final LikeService likeService;
    private final TokenService tokenService;

    public LikeController(LikeService likeService, TokenService tokenService) {
        this.likeService = likeService;
        this.tokenService = tokenService;
    }

    @PostMapping
    public void likePost(@RequestParam String id, HttpServletRequest servReq) {
        String token = servReq.getHeader("authorization");

        if(token == null || token.isEmpty())
            throw new InvalidAuthException("Invalid token");

        Principal principal = tokenService.extractRequesterDetails(token);

        if(principal == null)
            throw new InvalidAuthException("Please log in to like a post");

        String userId = principal.getUserId();

        if(likeService.isLiked(userId, id))
            likeService.saveLikeByUserIdAndPostId(userId, id);
        else
            throw new InvalidLikeException("You have already liked this post");
    }

    @DeleteMapping
    public void unlikePost(@RequestParam String id, HttpServletRequest servReq) {
        String token = servReq.getHeader("authorization");

        if(token == null || token.isEmpty())
            throw new InvalidAuthException("Invalid token");

        Principal principal = tokenService.extractRequesterDetails(token);

        if(principal == null)
            throw new InvalidAuthException("You are not logged in");

        String userId = principal.getUserId();

        if(likeService.isLiked(userId, id))
            likeService.deleteLikeByUserIdAndPostId(userId, id);
        else
            throw new InvalidLikeException();
    }

    @GetMapping("/user")
    public List<Like> getAllByUserId(@RequestParam String id) {
        return likeService.getAllLikesByUserId(id);
    }

    @GetMapping("/post")
    public List<Like> getAllByPostId(@RequestParam String id) {
        return likeService.getAllLikesByPostId(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidLikeException.class)
    public InvalidLikeException handledLikeException (InvalidLikeException e) {
        return e;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidAuthException.class)
    public InvalidAuthException handledAuthException (InvalidAuthException e) {
        return e;
    }
}
