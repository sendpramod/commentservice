package com.demo.commentservice.service;

import com.demo.commentservice.model.Comment;
import com.demo.commentservice.model.Status;
import com.demo.commentservice.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public Comment findCommentById(String commentId) {

        Optional<Comment> optionalComment = commentRepo.findById(commentId);
        return optionalComment.orElseGet(() -> null);
    }

    @Override
    public List<Comment> findCommentsByUserId(String userId) {
        return commentRepo.findCommentsByUserId(userId);
    }

    @Override
    public List<Comment> findCommentsByStatus(Status status) {
        return commentRepo.findCommentsByStatus(status);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepo.save(comment);
    }
}
