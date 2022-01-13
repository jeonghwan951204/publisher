package com.book.publisher.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "BOOK_ID")
    private long id;

    private String bookTitle;

    private String subTitle;

    private int price;
    private String author;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate publishDate;

    private String category;

}
