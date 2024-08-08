package com.task.library_management_system.dtos;

import com.task.library_management_system.entities.BorrowingRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowingRecordDto {
    private Integer id;
    private Integer bookId;   // Reference to the Book entity's ID
    private Integer patronId; // Reference to the Patron entity's ID
    private Date borrowingDate;
    private Date returnDate;

    public static BorrowingRecordDto from (BorrowingRecord myBorrowingRecord){
        return new BorrowingRecordDto(myBorrowingRecord.getId(), myBorrowingRecord.getBook().getId(),
                myBorrowingRecord.getPatron().getId(),myBorrowingRecord.getBorrowingDate(),
                myBorrowingRecord.getReturnDate());
    }
}
