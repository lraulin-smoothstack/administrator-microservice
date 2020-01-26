package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.BookLoanDAO;
import com.smoothstack.december.administratormicroservice.entity.BookLoan;
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

    public Optional<BookLoan> getBookLoan(long id) {
        return bookLoanDAO.findById(id);
    }

    public List<BookLoan> getBookLoans() {
        return bookLoanDAO.findAll();
    }

    public BookLoan setBookLoan(BookLoan bookLoan) {
        return bookLoanDAO.save(bookLoan);
    }

    public void deleteBookLoan(BookLoan bookLoan) {
        bookLoanDAO.delete(bookLoan);
    }
}
