package com.task.library_management_system.dtos;

import com.task.library_management_system.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto{
    private int id;
    private String title;


    public static BookDto from (Book myBook){
        return new BookDto(myBook.getId(), myBook.getTitle());
    }
}
