package com.demo.commentservice.service;

import com.demo.commentservice.model.Comment;
import com.demo.commentservice.model.Status;

import java.util.List;

public interface CommentService {
    public Comment findCommentById(String commentId);

    public List<Comment> findCommentsByUserId(String userId);

    public List<Comment> findCommentsByStatus(Status status);

    public Comment addComment(Comment comment);
}
