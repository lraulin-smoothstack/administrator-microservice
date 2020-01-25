package com.smoothstack.december.administratormicroservice.dao;

import com.smoothstack.december.administratormicroservice.entity.BookLoan;
import com.smoothstack.december.administratormicroservice.entity.BookLoanId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoanDAO extends JpaRepository<BookLoan, BookLoanId> {
}
