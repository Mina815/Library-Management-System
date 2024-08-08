package com.task.library_management_system.entities;

import com.task.library_management_system.dtos.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @SequenceGenerator(name = "BOOK_ID_SEQ_GENERATOR", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BOOK_ID_SEQ_GENERATOR")
    private Integer id;


    private String title;

    public static Book from(BookDto bookdto) {
        return new Book(bookdto.getId(), bookdto.getTitle());
    }
}
