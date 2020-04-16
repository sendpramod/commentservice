package com.demo.commentservice.controller;

import com.demo.commentservice.exception.DataNotFoundException;
import com.demo.commentservice.model.Comment;
import com.demo.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable("commentId") String commentId, @RequestBody Comment comment) {
        comment.setCommentId(commentId);
        return commentService.addComment(comment);
    }

    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable("commentId") String commentId) {
        Comment comment = commentService.findCommentById(commentId);
        if (comment == null) {
            throw new DataNotFoundException("Invalid commentId id " + commentId);
        }
        return comment;
    }

    @GetMapping("/user/{userId}")
    public List<Comment> getCommentByUserId(@PathVariable("userId") String userId) {
        List<Comment> comments = commentService.findCommentsByUserId(userId);
        if (comments == null) {
            throw new DataNotFoundException("Comments for userid " + userId + " not found.");
        }
        return comments;
    }
}
