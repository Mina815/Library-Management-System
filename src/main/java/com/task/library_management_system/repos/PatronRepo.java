package com.task.library_management_system.repos;

import com.task.library_management_system.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepo extends JpaRepository<Patron, Integer> {
}
