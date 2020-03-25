package com.emeka.blogspringboot.controllers;

import com.emeka.blogspringboot.models.Author;
import com.emeka.blogspringboot.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    private List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping("/authors")
    private String createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/authors/{id}")
    private String updateAuthor(@RequestBody Author author, @PathVariable int id) {
        return  authorService.updateAuthor(author, id);
    }

    @DeleteMapping("/authors/{id}")
    private String deleteAuthor(@PathVariable int id) {
        return authorService.deleteAuthor(id);
    }
}
