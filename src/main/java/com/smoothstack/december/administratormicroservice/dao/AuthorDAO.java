package com.smoothstack.december.administratormicroservice.dao;

import com.smoothstack.december.administratormicroservice.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorDAO extends JpaRepository<Author, Long> {
}