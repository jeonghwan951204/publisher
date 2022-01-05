package com.book.publisher.entity;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class Book {
    @Id @GeneratedValue
    @Column(name = "book_id")
    private long id;

    private String bookTitle;

    private String subTitle;

    private int price;
    private String author;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate publishDate;

    @CreatedDate
    @Column(columnDefinition = "timestamp(0)")
    private Date regDt;
}
