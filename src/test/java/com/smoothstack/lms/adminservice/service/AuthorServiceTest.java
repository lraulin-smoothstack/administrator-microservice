package com.smoothstack.lms.adminservice.service;

import com.smoothstack.lms.adminservice.dao.AuthorDAO;
import com.smoothstack.lms.adminservice.entity.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @Mock
    private AuthorDAO authorDAO;

    @InjectMocks
    private AuthorService authorService;

    @Test
    public void testGetAuthor() {
        Author author = new Author(1L, "Eric Elliot");
        when(authorDAO.findById(1L)).thenReturn(Optional.of(author));

        Author returned = authorService.getAuthor(1L);

        verify(authorDAO, times(1)).findById(1L);
        verifyNoMoreInteractions(authorDAO);

        assertEquals(author, returned);
    }

    @Test
    public void testGetAuthors() {
        // given
        Author author1 = new Author(1L, "Eric Elliot");
        Author author2 = new Author(2L, "Eric Raymond");
        List<Author> authors = Arrays.asList(author1, author2);
        when(authorDAO.findAll()).thenReturn(authors);

        // when
        List<Author> returned = authorService.getAuthors();

        // then
        verify(authorDAO, times(1)).findAll();
        verifyNoMoreInteractions(authorDAO);
        assertEquals(authors, returned);
    }

    @Test
    public void testSetAuthor() {
        // given
        Author author = new Author(1L, "Zed Shaw");
        when(this.authorDAO.save(author)).thenReturn(author);

        // when
        Author result = authorService.setAuthor(author);

        // then
        assertThat(result.getId()).isEqualTo(author.getId());
        assertThat(result.getName()).isEqualTo(author.getName());
    }

    @Test
    public void testDeleteAuthor() {
        // given
        Author deleted = new Author(1L, "Zed Shaw");
        when(authorDAO.findById(deleted.getId())).thenReturn(Optional.of(deleted));

        // when
        authorService.deleteAuthor(deleted.getId());

        // then
        verify(authorDAO, times(1)).findById(deleted.getId());
        verify(authorDAO, times(1)).delete(deleted);
        verifyNoMoreInteractions(authorDAO);
    }
}
