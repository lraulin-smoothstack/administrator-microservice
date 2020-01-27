package com.smoothstack.december.administratormicroservice.dao;

import com.smoothstack.december.administratormicroservice.entity.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookCopyDAO extends JpaRepository<BookCopy, BookCopy.BookCopyId> { }
