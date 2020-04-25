package com.smoothstack.lms.adminservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.lms.adminservice.entity.BookLoan;
import com.smoothstack.lms.adminservice.entity.BookLoan.BookLoanId;

@Repository
public interface BookLoanDAO extends JpaRepository<BookLoan, BookLoan.BookLoanId> {
}
