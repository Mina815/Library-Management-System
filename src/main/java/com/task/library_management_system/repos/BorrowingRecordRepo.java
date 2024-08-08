package com.task.library_management_system.repos;

import com.task.library_management_system.entities.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRecordRepo extends JpaRepository<BorrowingRecord, Integer> {
}
