package com.emeka.blogspringboot.services;

import com.emeka.blogspringboot.ResourceNotFoundException;
import com.emeka.blogspringboot.models.Author;
import com.emeka.blogspringboot.models.Comment;
import com.emeka.blogspringboot.models.Post;
import com.emeka.blogspringboot.repositories.AuthorRepository;
import com.emeka.blogspringboot.repositories.CommentRepository;
import com.emeka.blogspringboot.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Comment> getCommentsByPost(int postId) {
        return commentRepository.findByPostId(postId);
    }

    // get a comment by a particular author for a particular post
    public Optional<Comment> getSingleCommentByAuthor(int postId, int authorId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        if(comments.size() > 0) {
           Optional<Comment> desiredComment = comments.stream()
                    .filter(comment -> {
                        int theId = comment.getAuthor().getId();
                        return  theId == authorId;
                    }).findFirst();

           return desiredComment;
        }

        return null;
    }

    public String postComment(Comment comment, int postId, int authorId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("PostId %s not found", postId)));

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("AuthorId %s not found", authorId)));

        comment.setAuthor(author);
        comment.setPost(post);
        commentRepository.save(comment);

        return "Comment saved successfully";
    }

    public String editComment(Comment comment, int commentId) {
        Comment theComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("CommentId %s not found", commentId)));

        theComment.setCommentBody(comment.getCommentBody());
        commentRepository.save(theComment);

        return  "Comment edited successfully";
    }

    public String deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
        return "Comment deleted successfully";
    }
}
