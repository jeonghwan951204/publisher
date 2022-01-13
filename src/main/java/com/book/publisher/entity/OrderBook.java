package com.book.publisher.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderBook {

    @Id @GeneratedValue
    @Column(name = "ORDERS_BOOK_ID")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "ORDERS_ID")
    private Orders orders;

    private int bookCount;
}
