package com.smoothstack.december.administratormicroservice.controller;

import com.smoothstack.december.administratormicroservice.AdministratorMicroserviceApplication;
import com.smoothstack.december.administratormicroservice.entity.Author;
import com.smoothstack.december.administratormicroservice.exception.ArgumentMissingException;
import com.smoothstack.december.administratormicroservice.exception.IllegalRelationReferenceException;
import com.smoothstack.december.administratormicroservice.exception.ItemNotFoundException;
import com.smoothstack.december.administratormicroservice.service.AuthorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/lms/administrator-service")
public class AuthorController {

    private static final Logger logger = LogManager.getLogger(AdministratorMicroserviceApplication.class);

    @Autowired
    private AuthorService authorService;

    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author response = null;

        response = authorService.setAuthor(author);

        ResponseEntity<Author> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> readAuthors() {
        List<Author> response = null;

        response = authorService.getAuthors();
        logger.debug(response);

        ResponseEntity<List<Author>> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> readAuthorById(@PathVariable long id) {
        Optional<Author> response = null;

            response = authorService.getAuthor(id);
            response.orElseThrow(()->new IllegalRelationReferenceException("oops!"));
            logger.debug(response.get());

        ResponseEntity<Author> responseEntity = new ResponseEntity<>(response.get(), HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @PutMapping("/author/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable long id, @RequestBody Author author){
        Author response = null;

        Optional<Author> oldAuthor = authorService.getAuthor(id);
        oldAuthor.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        response = authorService.setAuthor(author);
        logger.debug(response);

        ResponseEntity<Author> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @DeleteMapping(path = "/author/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable long id){
        Optional<Author> author = authorService.getAuthor(id);
        author.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        authorService.deleteAuthor(author.get());

        ResponseEntity<Author> responseEntity = new ResponseEntity<>(null, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }
}
