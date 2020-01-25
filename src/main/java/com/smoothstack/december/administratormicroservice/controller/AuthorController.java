package com.smoothstack.december.administratormicroservice.controller;

import com.smoothstack.december.administratormicroservice.entity.Author;
import com.smoothstack.december.administratormicroservice.exception.ArgumentMissingException;
import com.smoothstack.december.administratormicroservice.exception.IllegalRelationReferenceException;
import com.smoothstack.december.administratormicroservice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/v1/lms/administrator-service")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/author/{id}")
    public ResponseEntity<Author> createAuthor(@PathVariable long id, @RequestBody Author author){
        Author response = null;

        try {
            response = authorService.setAuthor(author);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK)
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> readAuthors() {
        List<Author> response = null;

        try {
            response = authorService.getAuthors();
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
            //TODO
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/author/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable long id, @RequestBody Author author){
        Author response = null;

        try {
            Author oldAuthor = authorService.get
            response = authorService.setAuthor(author);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK)
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable long id){
        Author response = null;

        try {
            response = authorService.setAuthor(author);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<Author>(response, HttpStatus.OK)
    }
}
