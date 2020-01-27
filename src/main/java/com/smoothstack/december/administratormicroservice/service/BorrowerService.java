package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.BookLoanDAO;
import com.smoothstack.december.administratormicroservice.dao.BorrowerDAO;
import com.smoothstack.december.administratormicroservice.entity.BookLoan;
import com.smoothstack.december.administratormicroservice.entity.Borrower;
import com.smoothstack.december.administratormicroservice.exception.IllegalRelationReferenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BorrowerService {
    @Autowired
    private BorrowerDAO borrowerDAO;

    @Autowired
    private BookLoanDAO bookLoanDAO;

    public Borrower getBorrower(long id) {
        Optional<Borrower> borrower = borrowerDAO.findById(id);
        borrower.orElseThrow(()-> new IllegalRelationReferenceException("No borrower with id " + id));
        return borrower.get();
    }

    public List<Borrower> getBorrowers() {
        return borrowerDAO.findAll();
    }

    public Borrower setBorrower(Borrower Borrower) {
        return borrowerDAO.save(Borrower);
    }

    public void deleteBorrower(Borrower Borrower) {
        borrowerDAO.delete(Borrower);
    }

    public Optional<BookLoan> getBookLoan(BookLoan.BookLoanId id) {
        return bookLoanDAO.findById(id);
    }

    public BookLoan updateDueDate(BookLoan bookLoan) {
        return bookLoanDAO.save(bookLoan);
    }
}
