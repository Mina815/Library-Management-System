package com.task.library_management_system.controllers;

import com.task.library_management_system.dtos.BorrowingRecordDto;
import com.task.library_management_system.services.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BorrowingRecordController {
    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecordDto> borrowBook(
            @PathVariable Integer bookId,
            @PathVariable Integer patronId) {
        BorrowingRecordDto borrowingRecordDTO = borrowingRecordService.borrowBook(bookId, patronId);
        return ResponseEntity.ok(borrowingRecordDTO);
    }
    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecordDto> returnBook(
            @PathVariable Integer bookId,
            @PathVariable Integer patronId) {
        BorrowingRecordDto borrowingRecordDTO = borrowingRecordService.returnBook(bookId, patronId);
        return ResponseEntity.ok(borrowingRecordDTO);
    }
}
