package com.smoothstack.december.administratormicroservice.dao;

import com.smoothstack.december.administratormicroservice.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerDAO extends JpaRepository<Borrower, Long> {
}
