package com.book.publisher.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class OrderBook {

    @Id @GeneratedValue
    @Column(name = "order_book_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    // 주문 수량
    private int count;

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // 주문 책 생성
    public static OrderBook createOrderBook(Book book, int count){
        OrderBook orderBook = new OrderBook();
        orderBook.setBook(book);
        orderBook.setCount(count);

        book.removeStock(count);

        return orderBook;
    }

    // 주문 책 취소
    public void cancel() {
        this.getBook().addStock(count);
    }

    // 총 책 가격 조회
    public int getTotalPrice(){
        return this.getBook().getPrice() * getCount();
    }
}
