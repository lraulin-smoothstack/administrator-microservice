package com.smoothstack.december.administratormicroservice.controller;

import com.smoothstack.december.administratormicroservice.AdministratorMicroserviceApplication;
import com.smoothstack.december.administratormicroservice.entity.Borrower;
import com.smoothstack.december.administratormicroservice.service.BorrowerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class BorrowerController {
    private static final Logger logger = LogManager.getLogger(AdministratorMicroserviceApplication.class);

    @Autowired
    private BorrowerService borrowerService;

    @PostMapping("/borrower")
    public ResponseEntity<Borrower> createBorrower(@RequestBody Borrower borrower) {
        Borrower response = borrowerService.setBorrower(borrower);

        ResponseEntity<Borrower> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @GetMapping("/borrowers")
    public ResponseEntity<List<Borrower>> readBorrowers() {
        List<Borrower> response = borrowerService.getBorrowers();

        ResponseEntity<List<Borrower>> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @GetMapping("/borrower/{id}")
    public ResponseEntity<Borrower> readBorrowerById(@PathVariable long id) {
        Borrower response = borrowerService.getBorrower(id);
        ResponseEntity<Borrower> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @PutMapping("/borrower/{id}")
    public ResponseEntity<Borrower> updateBorrower(@PathVariable long id, @RequestBody Borrower borrower) {
        Borrower response = borrowerService.setBorrower(borrower);
        ResponseEntity<Borrower> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @DeleteMapping("/borrower/{id}")
    public ResponseEntity<Borrower> deleteBorrower(@PathVariable long id) {
        borrowerService.deleteBorrower(id);
        ResponseEntity<Borrower> responseEntity = new ResponseEntity<Borrower>((Borrower) null, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }
}
