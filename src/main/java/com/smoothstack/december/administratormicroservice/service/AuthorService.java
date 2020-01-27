package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.AuthorDAO;
import com.smoothstack.december.administratormicroservice.entity.Author;
import com.smoothstack.december.administratormicroservice.exception.ArgumentMissingException;
import com.smoothstack.december.administratormicroservice.exception.ExtraneousIdException;
import com.smoothstack.december.administratormicroservice.exception.IllegalRelationReferenceException;
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

    public Author getAuthor(long id) {
        Optional<Author> author = authorDAO.findById(id);
        author.orElseThrow(()-> new IllegalRelationReferenceException("No author with id " + id));
        return author.get();
    }

    public List<Author> getAuthors() {
        return authorDAO.findAll();
    }

    public Author setAuthor(Author author) {
        return authorDAO.save(author);
    }

    public void deleteAuthor(long id) {
        Author author = getAuthor(id);
        authorDAO.delete(author);
    }
}
