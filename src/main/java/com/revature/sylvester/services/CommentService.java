package com.revature.sylvester.services;

import com.revature.sylvester.dtos.requests.NewCommentRequest;
import com.revature.sylvester.entities.Like;
import com.revature.sylvester.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CommentService {
    private final CommentRepository commentRepo;

    public CommentService(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    public void createComment(NewCommentRequest req, String userId) {
        commentRepo.save(UUID.randomUUID().toString(), req.getReply(), new Date(), userId, req.getPostId());
    }

    public List<Like> getAllCommentsByPostId(String postId) {
        return commentRepo.findAllByPostId(postId);
    }
}
