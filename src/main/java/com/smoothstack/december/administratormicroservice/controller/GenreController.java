package com.smoothstack.december.administratormicroservice.controller;

import com.smoothstack.december.administratormicroservice.AdministratorMicroserviceApplication;
import com.smoothstack.december.administratormicroservice.entity.Genre;
import com.smoothstack.december.administratormicroservice.exception.ArgumentMissingException;
import com.smoothstack.december.administratormicroservice.exception.IllegalRelationReferenceException;
import com.smoothstack.december.administratormicroservice.service.GenreService;
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
@RequestMapping("/v1/lms/administrator-service")
public class GenreController {

    private static final Logger logger = LogManager.getLogger(AdministratorMicroserviceApplication.class);

    @Autowired
    private GenreService genreService;

    @PostMapping("/genres")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        Genre response = null;

        response = genreService.setGenre(genre);

        ResponseEntity<Genre> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> readGenres() {
        List<Genre> response = null;

        response = genreService.getGenres();
        logger.debug(response);

        ResponseEntity<List<Genre>> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @PutMapping("/genre/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable long id, @RequestBody Genre genre) {
        Genre response = null;

        Optional<Genre> oldGenre = genreService.getGenre(id);
        oldGenre.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        response = genreService.setGenre(genre);
        logger.debug(response);

        ResponseEntity<Genre> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @DeleteMapping("/genre/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable long id) {
        Optional<Genre> genre = genreService.getGenre(id);
        genre.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        genreService.deleteGenre(genre.get());

        ResponseEntity<Genre> responseEntity = new ResponseEntity<>(null, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }
}
