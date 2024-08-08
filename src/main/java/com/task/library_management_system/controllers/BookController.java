package com.task.library_management_system.controllers;

import com.task.library_management_system.dtos.BookDto;
import com.task.library_management_system.services.BookService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController{
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> getBook(){
        return bookService.getBooks();
    }
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Integer id){
        return  bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@RequestBody BookDto bookDto, @PathVariable Integer id){
        bookService.UpdateBook(bookDto,id);
        return ResponseEntity.ok("Book Updated");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        bookService.DeleteBook(id);
        return ResponseEntity.ok("Book Deleted");
    }
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto){
        try{

            bookService.addBook(bookDto);
            return ResponseEntity.ok("Book added");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
