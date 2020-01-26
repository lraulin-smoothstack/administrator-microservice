package com.smoothstack.december.administratormicroservice.controller;

import com.smoothstack.december.administratormicroservice.AdministratorMicroserviceApplication;
import com.smoothstack.december.administratormicroservice.entity.LibraryBranch;
import com.smoothstack.december.administratormicroservice.entity.Publisher;
import com.smoothstack.december.administratormicroservice.exception.ArgumentMissingException;
import com.smoothstack.december.administratormicroservice.exception.IllegalRelationReferenceException;
import com.smoothstack.december.administratormicroservice.service.PublisherService;
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
public class PublisherController {
    private static final Logger logger = LogManager.getLogger(AdministratorMicroserviceApplication.class);

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/publisher")
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher){
        Publisher response = null;

        try {
            response = publisherService.setPublisher(publisher);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
            logger.error(exception);
        }

        ResponseEntity<Publisher> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @GetMapping("/publishers")
    public ResponseEntity<List<Publisher>> readPublishers() {
        List<Publisher> response = null;

        try {
            response = publisherService.getPublishers();
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
            logger.error(exception);
        }

        ResponseEntity<List<Publisher>> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @PutMapping("/publisher/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable long id, @RequestBody Publisher publisher){
        Publisher response = null;

        try {
            Optional<Publisher> oldPublisher = publisherService.getPublisher(id);
            oldPublisher.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            response = publisherService.setPublisher(publisher);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
            logger.error(exception);
        }

        ResponseEntity<Publisher> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @DeleteMapping("/publisher/{id}")
    public ResponseEntity<Publisher> deletePublisher(@PathVariable long id){
        try {
            Optional<Publisher> publisher = publisherService.getPublisher(id);
            publisher.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            publisherService.deletePublisher(publisher.get());
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
            logger.error(exception);
        }

        ResponseEntity<Publisher> responseEntity = new ResponseEntity<>((Publisher)null, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }
}
