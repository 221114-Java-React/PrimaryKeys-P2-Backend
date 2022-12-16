package com.revature.sylvester.services;

import com.revature.sylvester.entities.Like;
import com.revature.sylvester.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepo;

    public CommentService(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    public List<Like> getAllCommentsByPostId(String postId) {
        return commentRepo.findAllByPostId(postId);
    }
}