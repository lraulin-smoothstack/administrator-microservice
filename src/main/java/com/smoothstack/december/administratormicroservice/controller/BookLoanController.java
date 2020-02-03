package com.smoothstack.december.administratormicroservice.controller;

import com.smoothstack.december.administratormicroservice.AdministratorMicroserviceApplication;
import com.smoothstack.december.administratormicroservice.entity.BookLoan;
import com.smoothstack.december.administratormicroservice.service.BookLoanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "admin")
public class BookLoanController {

    private static final Logger logger = LogManager.getLogger(AdministratorMicroserviceApplication.class);

    @Autowired
    private BookLoanService bookLoanService;

    @PostMapping("/loans")
    public ResponseEntity<BookLoan> createBookLoan(@RequestBody BookLoan bookLoan) {
        BookLoan response = bookLoanService.setBookLoan(bookLoan);
        ResponseEntity<BookLoan> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @GetMapping("/loans")
    public ResponseEntity<List<BookLoan>> readBookLoans() {
        List<BookLoan> response = bookLoanService.getBookLoans();
        ResponseEntity<List<BookLoan>> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @GetMapping("/loan/{id}")
    public ResponseEntity<BookLoan> readBookLoanById(@PathVariable long id) {
        BookLoan response = bookLoanService.getBookLoan(id);
        ResponseEntity<BookLoan> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @PutMapping("/loan")
    public ResponseEntity<BookLoan> updateBookLoan(@RequestBody BookLoan bookLoan) {
        BookLoan response = bookLoanService.setBookLoan(bookLoan);
        ResponseEntity<BookLoan> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }

    @DeleteMapping("/loan")
    public ResponseEntity<BookLoan> deleteBookLoan(@RequestBody BookLoan.BookLoanId id) {
        bookLoanService.deleteBookLoan(id);
        ResponseEntity<BookLoan> responseEntity = new ResponseEntity<>(null, HttpStatus.OK);
        logger.debug(responseEntity);
        return responseEntity;
    }
}
