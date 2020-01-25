package com.smoothstack.december.administratormicroservice.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookCopyId implements Serializable {
    @Column
    private Long bookId;

    @Column
    private Long branchId;

    public BookCopyId(Long bookId, Long branchId) {
        this.bookId = bookId;
        this.branchId = branchId;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getBranchId() {
        return branchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookCopyId)) return false;
        BookCopyId that = (BookCopyId) o;
        return Objects.equals(getBookId(), that.getBookId()) &&
                Objects.equals(getBranchId(), that.getBranchId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBranchId());
    }
}