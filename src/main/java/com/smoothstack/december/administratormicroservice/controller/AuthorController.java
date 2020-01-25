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
import java.util.Optional;

@RestController
@RequestMapping("/v1/lms/administrator-service")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PutMapping("/author/{id}")
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

        return new ResponseEntity<>(response, HttpStatus.OK);
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
            Optional<Author> oldAuthor = authorService.getAuthor(id);
            oldAuthor.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            response = authorService.setAuthor(author);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable long id){
        try {
            Optional<Author> author = authorService.getAuthor(id);
            author.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            authorService.deleteAuthor(author.get());
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<Author>((Author) null, HttpStatus.OK);
    }
}
