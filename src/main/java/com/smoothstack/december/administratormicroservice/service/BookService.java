package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.BookDAO;
import com.smoothstack.december.administratormicroservice.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookDAO BookDAO;

    public List<Book> getBooks() {
        return BookDAO.findAll();
    }

    public Book setBook(Book Book) {
        return BookDAO.save(Book);
    }

    public void deleteBook(Book Book) {
        BookDAO.delete(Book);
    }
}
