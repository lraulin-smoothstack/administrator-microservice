package com.smoothstack.december.administratormicroservice.controller;

import com.smoothstack.december.administratormicroservice.entity.Author;
import com.smoothstack.december.administratormicroservice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/lms/administrator-service")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getBooks() {
        List<Author> response = null;

        try {
            logger.debug("request: {}");
            response = authorService.getAuthors();
            logger.debug("response: {}", response.toString());
        } catch (IllegalRelationReferenceException irre) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, irre.getMessage(), irre);
        } catch (Exception exception) {
            logger.error(exception.toString());
        }

        return new ResponseEntity<List<Author>>(response, HttpStatus.OK);
    }

}
