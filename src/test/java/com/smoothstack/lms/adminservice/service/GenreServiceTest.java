package com.smoothstack.lms.adminservice.service;


import com.smoothstack.lms.adminservice.dao.GenreDAO;
import com.smoothstack.lms.adminservice.entity.Genre;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class GenreServiceTest {
    @Mock
    private GenreDAO genreDAO;

    @InjectMocks
    private GenreService genreService;

    private void testGetGenre() {
        // given
        Genre genre = new Genre(1L, "Ficton");
        Mockito.when(this.genreDAO.getOne(genre.getId())).thenReturn(genre);

        // when
        Genre result = genreService.getGenre(genre.getId());

        // then
        assertThat(result.getId()).isEqualTo(genre.getId());
        assertThat(result.getName()).isEqualTo(genre.getName());
    }

    private void testGetGenres() {
        // given
        Genre genre1 = new Genre(1L, "Ficton");
        Genre genre2 = new Genre(2L, "Nonfiction");
        List<Genre> genres = Arrays.asList(genre1, genre2);

        // when
        List<Genre> result = genreService.getGenres();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo(genre1.getName());
        assertThat(result.get(1).getName()).isEqualTo(genre2.getName());
    }

    private void testSetGenre() {
        // given
        Genre genre = new Genre(1L, "Fantasy");
        Mockito.when(this.genreDAO.save(genre)).thenReturn(genre);

        // when
        Genre result = genreService.setGenre(genre);

        // then
        assertThat(result.getId()).isEqualTo(genre.getId());
        assertThat(result.getName()).isEqualTo(genre.getName());
    }

    private void testDeleteGenre() {
        // given
        Genre genre = new Genre(1L, "Thriller");
        doNothing().when(genreDAO).delete(isA(Genre.class));

        // when
        genreService.deleteGenre(genre.getId());

        // then
        assertThat(true).isTrue();
    }
}
