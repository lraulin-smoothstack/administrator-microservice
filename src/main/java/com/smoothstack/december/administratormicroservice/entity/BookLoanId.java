package com.smoothstack.december.administratormicroservice.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookLoanId implements Serializable {
    @Column
    private Long bookId;

    @Column
    private Long borrowerId;

    @Column
    private Long branchId;

    public BookLoanId(long bookId, long borrowerId, long branchId) {
        this.bookId = bookId;
        this.borrowerId = borrowerId;
        this.branchId = branchId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BookLoanId))
            return false;
        BookLoanId that = (BookLoanId) o;
        return Objects.equals(getBookId(), that.getBookId()) && Objects.equals(getBranchId(), that.getBranchId())
                && Objects.equals(getBorrowerId(), that.getBorrowerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBranchId(), getBorrowerId());
    }
}