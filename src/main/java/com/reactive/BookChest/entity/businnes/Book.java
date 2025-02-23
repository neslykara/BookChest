package com.reactive.BookChest.entity.businnes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_books")
public class Book
{
    @Id
    @Column("ID")
    private Long id;

    @Column("TITLE")
    private String title;

    @Column("AUTHOR")
    private String author;

    @Column("PUBLISHED_YEAR")
    private int publishedYear;

    @Column("PAGE_COUNT")
    private int pageCount;
}
