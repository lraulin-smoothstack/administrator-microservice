package com.smoothstack.december.administratormicroservice.controller;

import com.smoothstack.december.administratormicroservice.AdministratorMicroserviceApplication;
import com.smoothstack.december.administratormicroservice.entity.Borrower;
import com.smoothstack.december.administratormicroservice.exception.ArgumentMissingException;
import com.smoothstack.december.administratormicroservice.exception.IllegalRelationReferenceException;
import com.smoothstack.december.administratormicroservice.service.BorrowerService;
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
public class BorrowerController {
    private static final Logger logger = LogManager.getLogger(AdministratorMicroserviceApplication.class);

    @Autowired
    private BorrowerService borrowerService;

    @PostMapping("/borrower")
    public ResponseEntity<Borrower> createBorrower(@RequestBody Borrower borrower) {
        Borrower response = null;

        try {
            response = borrowerService.setBorrower(borrower);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(),
                    argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(),
                    illegalRelationReferenceException);
        } catch (Exception exception) {
            logger.error(exception);
        }

        ResponseEntity<Borrower> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @GetMapping("/borrowers")
    public ResponseEntity<List<Borrower>> readBorrowers() {
        List<Borrower> response = null;

        try {
            response = borrowerService.getBorrowers();
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(),
                    illegalRelationReferenceException);
        } catch (Exception exception) {
            logger.error(exception);
        }

        ResponseEntity<List<Borrower>> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @PutMapping("/borrower/{id}")
    public ResponseEntity<Borrower> updateBorrower(@PathVariable long id, @RequestBody Borrower borrower) {
        Borrower response = null;

        try {
            Optional<Borrower> oldBorrower = borrowerService.getBorrower(id);
            oldBorrower.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            response = borrowerService.setBorrower(borrower);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(),
                    argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(),
                    illegalRelationReferenceException);
        } catch (Exception exception) {
            logger.error(exception);
        }
        ResponseEntity<Borrower> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @DeleteMapping("/borrower/{id}")
    public ResponseEntity<Borrower> deleteBorrower(@PathVariable long id) {
        try {
            Optional<Borrower> borrower = borrowerService.getBorrower(id);
            borrower.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            borrowerService.deleteBorrower(borrower.get());
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(),
                    argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(),
                    illegalRelationReferenceException);
        } catch (Exception exception) {
            logger.error(exception);
        }

        ResponseEntity<Borrower> responseEntity = new ResponseEntity<Borrower>((Borrower) null, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }
}
