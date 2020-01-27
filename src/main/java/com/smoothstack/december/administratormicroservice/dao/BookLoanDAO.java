package com.smoothstack.december.administratormicroservice.dao;

import com.smoothstack.december.administratormicroservice.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoanDAO extends JpaRepository<BookLoan, BookLoan.BookLoanId> {
}
