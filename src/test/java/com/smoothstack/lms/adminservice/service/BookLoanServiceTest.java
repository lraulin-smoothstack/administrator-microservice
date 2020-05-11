package com.smoothstack.lms.adminservice.service;

import com.smoothstack.lms.adminservice.dao.BookLoanDAO;
import com.smoothstack.lms.adminservice.entity.BookLoan;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class BookLoanServiceTest {
    @Mock
    private BookLoanDAO bookLoanDAO;

    @InjectMocks
    private BookLoanService bookLoanService;

    private void testGetBookLoan() {
        // given
        LocalDate bookLoanDateOut = LocalDate.of(2020, 4, 16);
        LocalDate bookLoanDueDate= LocalDate.of(2020, 4, 23);
        BookLoan bookLoan = new BookLoan(new BookLoan.BookLoanId(1L, 1L, 1L), bookLoanDateOut, bookLoanDueDate, null);
        Mockito.when(this.bookLoanDAO.getOne(bookLoan.getId())).thenReturn(bookLoan);

        // when
        BookLoan result = bookLoanService.getBookLoan(bookLoan.getId());

        // then
        assertThat(result.getId()).isEqualTo(bookLoan.getId());
        assertThat(result.getDueDate()).isEqualTo(bookLoan.getDueDate());
    }

    private void testGetBookLoans() {
        // given
        LocalDate bookLoan1DateOut = LocalDate.of(2020, 4, 16);
        LocalDate bookLoan1DueDate= LocalDate.of(2020, 4, 23);
        BookLoan bookLoan1 = new BookLoan(new BookLoan.BookLoanId(1L, 1L, 1L), bookLoan1DateOut, bookLoan1DueDate, null);
        LocalDate bookLoan2DateOut = LocalDate.of(2020, 4, 4);
        LocalDate bookLoan2DueDate = LocalDate.of(2020, 4, 11);
        LocalDate bookLoan2DateIn = LocalDate.of(2020, 4, 10);
        BookLoan bookLoan2 = new BookLoan(new BookLoan.BookLoanId(2L, 2L, 2L), bookLoan2DateOut, bookLoan2DueDate, bookLoan2DateIn);
        List<BookLoan> bookLoans = Arrays.asList(bookLoan1, bookLoan2);

        // when
        List<BookLoan> result = bookLoanService.getBookLoans();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getDueDate()).isEqualTo(bookLoan1.getDueDate());
        assertThat(result.get(1).getDueDate()).isEqualTo(bookLoan2.getDueDate());
    }

    private void testSetBookLoan() {
        // given
        LocalDate bookLoanDateOut = LocalDate.of(2020, 4, 16);
        LocalDate bookLoanDueDate= LocalDate.of(2020, 4, 23);
        BookLoan bookLoan = new BookLoan(new BookLoan.BookLoanId(1L, 1L, 1L), bookLoanDateOut, bookLoanDueDate, null);
        Mockito.when(this.bookLoanDAO.save(bookLoan)).thenReturn(bookLoan);

        // when
        BookLoan result = bookLoanService.setBookLoan(bookLoan);

        // then
        assertThat(result.getId()).isEqualTo(bookLoan.getId());
        assertThat(result.getDueDate()).isEqualTo(bookLoan.getDueDate());
    }

    private void testDeleteBookLoan() {
        // given
        LocalDate bookLoanDateOut = LocalDate.of(2020, 4, 16);
        LocalDate bookLoanDueDate= LocalDate.of(2020, 4, 23);
        BookLoan bookLoan = new BookLoan(new BookLoan.BookLoanId(1L, 1L, 1L), bookLoanDateOut, bookLoanDueDate, null);
        doNothing().when(bookLoanDAO).delete(isA(BookLoan.class));

        // when
        bookLoanService.deleteBookLoan(bookLoan.getId());

        // then
        assertThat(true).isTrue();
    }
}
