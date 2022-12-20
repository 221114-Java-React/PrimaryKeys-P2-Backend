package com.revature.sylvester.controllers;

import com.revature.sylvester.dtos.requests.NewReplyRequest;
import com.revature.sylvester.dtos.responses.Principal;
import com.revature.sylvester.entities.Reply;
import com.revature.sylvester.services.ReplyService;
import com.revature.sylvester.services.TokenService;
import com.revature.sylvester.utils.custom_exceptions.InvalidAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/replies")
public class ReplyController {
    private final TokenService tokenService;
    private final ReplyService replyService;

    public ReplyController(TokenService tokenService, ReplyService replyService) {
        this.tokenService = tokenService;
        this.replyService = replyService;
    }

    @PostMapping
    public void create(@RequestBody NewReplyRequest req, HttpServletRequest servReq) {
        String token = servReq.getHeader("authorization");

        if(token == null || token.isEmpty())
            throw new InvalidAuthException("Invalid token");

        Principal principal = tokenService.extractRequesterDetails(token);

        if(principal == null)
            throw new InvalidAuthException("Please log in to create a reply");

        if(!principal.isActive())
            throw new InvalidAuthException("Your account is not active");

        replyService.saveReplyByUserId(req, principal.getUserId());
    }

    @GetMapping("/post")
    public List<Reply> getAllByPostId(@RequestParam String id) {
        return replyService.getAllRepliesByPostId(id);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidAuthException.class)
    public InvalidAuthException handledAuthException (InvalidAuthException e) {
        return e;
    }
}
