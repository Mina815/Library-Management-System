package com.task.library_management_system.services;

import com.task.library_management_system.dtos.BorrowingRecordDto;
import com.task.library_management_system.entities.Book;
import com.task.library_management_system.entities.BorrowingRecord;
import com.task.library_management_system.entities.Patron;
import com.task.library_management_system.repos.BookRepo;
import com.task.library_management_system.repos.BorrowingRecordRepo;
import com.task.library_management_system.repos.PatronRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BorrowingRecordService {
    @Autowired
    private BorrowingRecordRepo borrowingRecordRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private PatronRepo patronRepo;

    @Transactional
    public BorrowingRecordDto borrowBook(Integer bookId, Integer patronId) {
        // Fetch the Book entity
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Fetch the Patron entity
        Patron patron = patronRepo.findById(patronId)
                .orElseThrow(() -> new RuntimeException("Patron not found"));

        // Create a new BorrowingRecord
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowingDate(new Date());
        borrowingRecord.setReturnDate(null);  // Assuming the book is not returned yet

        // Save the BorrowingRecord to the database
        borrowingRecord = borrowingRecordRepo.save(borrowingRecord);

        // Convert the entity to DTO and return
        return BorrowingRecordDto.from(borrowingRecord);
    }

    @Transactional
    public BorrowingRecordDto returnBook(Integer bookId, Integer patronId) {
        // Fetch the BorrowingRecord based on bookId and patronId
        BorrowingRecord borrowingRecord = borrowingRecordRepo
                .findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId)
                .orElseThrow(() -> new RuntimeException("Borrowing record not found or book already returned"));

        // Update the return date to the current date
        borrowingRecord.setReturnDate(new Date());

        // Save the updated BorrowingRecord
        borrowingRecord = borrowingRecordRepo.save(borrowingRecord);

        // Convert the entity to DTO and return
        return BorrowingRecordDto.from(borrowingRecord);
    }

}
