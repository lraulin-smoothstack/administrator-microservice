package com.smoothstack.december.administratormicroservice.controller;

import com.smoothstack.december.administratormicroservice.entity.Book;
import com.smoothstack.december.administratormicroservice.exception.ArgumentMissingException;
import com.smoothstack.december.administratormicroservice.exception.IllegalRelationReferenceException;
import com.smoothstack.december.administratormicroservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/lms/administrator-service")
public class BookController {

    @Autowired
    private BookService bookService;

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> createBook(@PathVariable long id, @RequestBody Book book){
        Book response = null;

        try {
            response = bookService.setBook(book);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> readBooks() {
        List<Book> response = null;

        try {
            response = bookService.getBooks();
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
            //TODO
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book){
        Book response = null;

        try {
            Optional<Book> oldBook = bookService.getBook(id);
            oldBook.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            response = bookService.setBook(book);
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id){
        try {
            Optional<Book> book = bookService.getBook(id);
            book.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            bookService.deleteBook(book.get());
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage(), argumentMissingException);
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, illegalRelationReferenceException.getMessage(), illegalRelationReferenceException);
        } catch (Exception exception) {
//            logger.error(exception.toString());
        }

        return new ResponseEntity<Book>((Book) null, HttpStatus.OK);
    }
}
