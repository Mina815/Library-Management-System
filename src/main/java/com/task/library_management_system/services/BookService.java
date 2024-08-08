package com.task.library_management_system.services;

import com.task.library_management_system.dtos.BookDto;
import com.task.library_management_system.entities.Book;
import com.task.library_management_system.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    public List<BookDto> getBooks() {
        List<Book> booksFromDB = bookRepo.findAll();

        return booksFromDB.stream().map(BookDto::from).collect(Collectors.toList());
    }

    public BookDto getBookById(Integer id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("No Book is founded"));

        return BookDto.from(book);
    }

    public  void UpdateBook(BookDto bookDto,Integer id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("No Book is founded"));
        Book UpdatedBook = Book.from(bookDto);
        bookRepo.save(UpdatedBook);
    }
    public void DeleteBook(Integer id) {
        bookRepo.deleteById(id);
    }
    public void addBook(BookDto bookDto) {
        Book CreatedBook = Book.from(bookDto);
        bookRepo.save(CreatedBook);

    }
}
