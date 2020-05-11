package com.smoothstack.lms.adminservice.service;


import com.smoothstack.lms.adminservice.dao.BookDAO;
import com.smoothstack.lms.adminservice.entity.Author;
import com.smoothstack.lms.adminservice.entity.Book;
import com.smoothstack.lms.adminservice.entity.Genre;
import com.smoothstack.lms.adminservice.entity.Publisher;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookDAO bookDAO;

    @InjectMocks
    private BookService bookService;

    private void testGetBook() {
        // given
        List<Genre> genres = Collections.singletonList(new Genre(1L, "Nonfiction"));
        Publisher publisher = new Publisher(1L, "Penguin", "New York, NY", "555-5555");
        List<Author> authors = Collections.singletonList(new Author(1L, "Douglas Crockford"));
        Book book = new Book(1L, "How JavaScript Works", publisher, new HashSet<>(authors), new HashSet<>(genres));

        Mockito.when(this.bookDAO.getOne(book.getId())).thenReturn(book);

        // when
        Book result = bookService.getBook(book.getId());

        // then
        assertThat(result.getId()).isEqualTo(book.getId());
        assertThat(result.getTitle()).isEqualTo(book.getTitle());
    }

    private void testGetBooks() {
        // given
        List<Genre> book1genres = Collections.singletonList(new Genre(1L, "Nonfiction"));
        Publisher book1publisher = new Publisher(1L, "Penguin", "New York, NY", "555-5555");
        List<Author> book1authors = Collections.singletonList(new Author(1L, "Douglas Crockford"));
        Book book1 = new Book(1L, "How JavaScript Works", book1publisher, new HashSet<>(book1authors), new HashSet<>(book1genres));

        List<Genre> book2genres = Collections.singletonList(new Genre(2L, "Nonfiction"));
        Publisher book2publisher = new Publisher(2L, "Simon & Shuster", "New York, NY", "555-5555");
        List<Author> book2authors = Collections.singletonList(new Author(2L, "Eric Raymond"));
        Book book2 = new Book(1L, "The Cathedral and the Bazaar", book2publisher, new HashSet<>(book2authors), new HashSet<>(book2genres));

        List<Book> books = Arrays.asList(book1, book2);

        // when
        List<Book> result = bookService.getBooks();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getTitle()).isEqualTo(book1.getTitle());
        assertThat(result.get(1).getTitle()).isEqualTo(book2.getTitle());
    }

    private void testSetBook() {
        // given
        List<Genre> genres = Collections.singletonList(new Genre(1L, "Nonfiction"));
        Publisher publisher = new Publisher(1L, "Penguin", "New York, NY", "555-5555");
        List<Author> authors = Collections.singletonList(new Author(1L, "Douglas Crockford"));
        Book book = new Book(1L, "How JavaScript Works", publisher, new HashSet<>(authors), new HashSet<>(genres));
        Mockito.when(this.bookDAO.save(book)).thenReturn(book);

        // when
        Book result = bookService.setBook(book);

        // then
        assertThat(result.getId()).isEqualTo(book.getId());
        assertThat(result.getTitle()).isEqualTo(book.getTitle());
    }

    private void testDeleteBook() {
        // given
        List<Genre> genres = Collections.singletonList(new Genre(1L, "Nonfiction"));
        Publisher publisher = new Publisher(1L, "Penguin", "New York, NY", "555-5555");
        List<Author> authors = Collections.singletonList(new Author(1L, "Douglas Crockford"));
        Book book = new Book(1L, "How JavaScript Works", publisher, new HashSet<>(authors), new HashSet<>(genres));

        doNothing().when(bookDAO).delete(isA(Book.class));

        // when
        bookService.deleteBook(book.getId());

        // then
        assertThat(true).isTrue();
    }
}
