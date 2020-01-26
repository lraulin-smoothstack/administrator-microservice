package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.GenreDAO;
import com.smoothstack.december.administratormicroservice.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreService {
    @Autowired
    private GenreDAO genreDAO;

    public Optional<Genre> getGenre(long id) {
        return genreDAO.findById(id);
    }

    public List<Genre> getGenres() {
        return genreDAO.findAll();
    }

    public Genre setGenre(Genre genre) {
        return genreDAO.save(genre);
    }

    public void deleteGenre(Genre genre) {
        genreDAO.delete(genre);
    }
}
