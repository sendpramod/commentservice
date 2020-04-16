package com.demo.commentservice.repo;

import com.demo.commentservice.model.Comment;
import com.demo.commentservice.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, String> {

    public List<Comment> findCommentsByUserId(String externalEntityId);

    List<Comment> findCommentsByStatus(Status status);
}
