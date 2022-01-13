package com.book.publisher.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Orders extends BaseEntity {

    @Id  @GeneratedValue
    @Column(name = "ORDERS_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ORDERS_BOOK_ID")
    private OrderBook orderBook;

    private String orderState;

    @Embedded
    private Address deliveryAddress;


    /*
    * 여러권을 주문하면 한 권당 한 건의 주문으로 봐야하나
    * */

}
