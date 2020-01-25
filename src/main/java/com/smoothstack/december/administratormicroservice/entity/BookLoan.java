package com.smoothstack.december.administratormicroservice.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class BookLoan {
    @EmbeddedId
    private BookLoanId id;

    @Column
    private LocalDate dateOut;

    @Column
    private LocalDate dateIn;

    @Column
    private LocalDate dueDate;

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public BookLoanId getId() {
        return id;
    }

    public void setBookId(BookLoanId id) {
        this.id = id;
    }
}
