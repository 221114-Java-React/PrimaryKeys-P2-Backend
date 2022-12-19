package com.revature.sylvester.services;

import com.revature.sylvester.dtos.requests.NewReplyRequest;
import com.revature.sylvester.entities.Reply;
import com.revature.sylvester.repositories.ReplyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ReplyService {
    private final ReplyRepository replyRepo;

    public ReplyService(ReplyRepository replyRepo) {
        this.replyRepo = replyRepo;
    }

    public void createReply(NewReplyRequest req, String userId) {
        replyRepo.save(UUID.randomUUID().toString(), req.getReply(), new Date(), userId, req.getPostId());
    }

    public List<Reply> getAllRepliesByPostId(String postId) {
        return replyRepo.findAllByPostId(postId);
    }
}
