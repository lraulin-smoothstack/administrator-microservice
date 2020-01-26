package com.smoothstack.december.administratormicroservice.controller;

import com.smoothstack.december.administratormicroservice.AdministratorMicroserviceApplication;
import com.smoothstack.december.administratormicroservice.entity.LibraryBranch;
import com.smoothstack.december.administratormicroservice.exception.ArgumentMissingException;
import com.smoothstack.december.administratormicroservice.exception.IllegalRelationReferenceException;
import com.smoothstack.december.administratormicroservice.service.LibraryBranchService;
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
public class LibraryBranchController {
    private static final Logger logger = LogManager.getLogger(AdministratorMicroserviceApplication.class);

    @Autowired
    private LibraryBranchService libraryBranchService;

    @PostMapping("/libraryBranch")
    public ResponseEntity<LibraryBranch> createLibraryBranch(@RequestBody LibraryBranch libraryBranch){
        LibraryBranch response = null;

        try {
            response = libraryBranchService.setLibraryBranch(libraryBranch);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/libraryBranchs")
    public ResponseEntity<List<LibraryBranch>> readLibraryBranchs() {
        List<LibraryBranch> response = null;

        try {
            response = libraryBranchService.getLibraryBranchs();
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
            //TODO
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/libraryBranch/{id}")
    public ResponseEntity<LibraryBranch> updateLibraryBranch(@PathVariable long id, @RequestBody LibraryBranch libraryBranch){
        LibraryBranch response = null;

        try {
            Optional<LibraryBranch> oldLibraryBranch = libraryBranchService.getLibraryBranch(id);
            oldLibraryBranch.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            response = libraryBranchService.setLibraryBranch(libraryBranch);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/libraryBranch/{id}")
    public ResponseEntity<LibraryBranch> deleteLibraryBranch(@PathVariable long id){
        try {
            Optional<LibraryBranch> libraryBranch = libraryBranchService.getLibraryBranch(id);
            libraryBranch.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            libraryBranchService.deleteLibraryBranch(libraryBranch.get());
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<LibraryBranch>((LibraryBranch) null, HttpStatus.OK);
    }
}
