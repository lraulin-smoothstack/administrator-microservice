package com.smoothstack.december.administratormicroservice.entity;

import javax.persistence.*;

@Entity
@Table
public class BookCopy {
    @EmbeddedId
    private BookCopyId id;

    @Column(name = "amount")
    private Long amount;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BookCopyId getId() {
        return id;
    }

    public void setId(BookCopyId id) {
        this.id = id;
    }
}
