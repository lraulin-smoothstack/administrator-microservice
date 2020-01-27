package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.BookLoanDAO;
import com.smoothstack.december.administratormicroservice.entity.Author;
import com.smoothstack.december.administratormicroservice.entity.BookLoan;
import com.smoothstack.december.administratormicroservice.exception.IllegalRelationReferenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookLoanService {
    @Autowired
    private BookLoanDAO bookLoanDAO;

    public BookLoan getBookLoan(BookLoan.BookLoanId id) {
        Optional<BookLoan> bookLoan = bookLoanDAO.findById(id);
        bookLoan.orElseThrow(()-> new IllegalRelationReferenceException("No author with id " + id));
        return bookLoan.get();
    }

    public List<BookLoan> getBookLoans() {
        return bookLoanDAO.findAll();
    }

    public BookLoan setBookLoan(BookLoan bookLoan) {
        return bookLoanDAO.save(bookLoan);
    }

    public void deleteBookLoan(long id) {
        bookLoanDAO.delete(id);
    }
}
