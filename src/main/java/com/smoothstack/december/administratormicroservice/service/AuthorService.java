package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.AuthorDAO;
import com.smoothstack.december.administratormicroservice.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorService {
    @Autowired
    private AuthorDAO authorDAO;

    public Optional<Author> getAuthor(long id) {
        return authorDAO.findById(id);
    }

    public List<Author> getAuthors() {
        return authorDAO.findAll();
    }

    public Author setAuthor(Author author) {
        return authorDAO.save(author);
    }

    public void deleteAuthor(Author author) {
        authorDAO.delete(author);
    }
}
