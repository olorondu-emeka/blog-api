package com.emeka.blogspringboot.controllers;

import com.emeka.blogspringboot.models.Comment;
import com.emeka.blogspringboot.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getCommentsByPost(@PathVariable int postId) {
        return commentService.getCommentsByPost(postId);
    }

    @GetMapping("/posts/{postId}/comment")
    public Optional<Comment> getSingleCommentByAuthor(@PathVariable int postId, @RequestParam int authorId) {
        return commentService.getSingleCommentByAuthor(postId, authorId);
    }

    @PostMapping("/posts/{postId}/comments")
    public String postComment(@RequestBody Comment comment, @PathVariable int postId, @RequestParam int authorId) {
        return commentService.postComment(comment, postId, authorId);
    }

    @PutMapping("/posts/{postId}/comments")
    public String editComment(@RequestBody Comment comment, @RequestParam int commentId) {
        return commentService.editComment(comment, commentId);
    }

    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable int commentId) {
        return commentService.deleteComment(commentId);
    }
}
