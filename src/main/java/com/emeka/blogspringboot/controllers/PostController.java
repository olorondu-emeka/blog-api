package com.emeka.blogspringboot.controllers;

import com.emeka.blogspringboot.models.Post;
import com.emeka.blogspringboot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{authorId}")
    public List<Post> getPostsByAuthor(@PathVariable int authorId) {
        return postService.getPostsByAuthor(authorId);
    }

    @PostMapping("/posts")
    public String createPost(@RequestBody Post post, @RequestParam int authorId) {
        return postService.createPost(post, authorId);
    }

    @PutMapping("/posts")
    public String editPost(@RequestBody Post post) {
        return postService.editPost(post);
    }

    @DeleteMapping("posts/{postId}")
    public String deletePost(@PathVariable int postId) {
        return postService.deletePost(postId);
    }
}
