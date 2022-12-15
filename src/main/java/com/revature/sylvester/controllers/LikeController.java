package com.revature.sylvester.controllers;

import com.revature.sylvester.dtos.responses.Principal;
import com.revature.sylvester.entities.Like;
import com.revature.sylvester.services.LikeService;
import com.revature.sylvester.services.TokenService;
import com.revature.sylvester.utils.custom_exceptions.InvalidAuthException;
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
    public Like likePost(@RequestParam String postId, HttpServletRequest servReq) {
        String token = servReq.getHeader("authorization");

        if(token == null || token.isEmpty())
            throw new InvalidAuthException("Invalid token");

        Principal principal = tokenService.extractRequesterDetails(token);

        if(principal == null)
            throw new InvalidAuthException("Please sign in to like a post");

        Like newLike = likeService.saveByUserAndPostIds(postId, principal.getUserId());

        return newLike;
    }

    @GetMapping("/user")
    public List<Like> getAllByUserId(@RequestParam String id) {
        return likeService.getAllLikesByUserId(id);
    }

    @GetMapping("/post")
    public List<Like> getAllByPostId(@RequestParam String id) {
        return likeService.getAllLikesByPostId(id);
    }
}
