package com.task.library_management_system.services;

import com.task.library_management_system.dtos.BookDto;
import com.task.library_management_system.dtos.PatronDto;
import com.task.library_management_system.entities.Book;
import com.task.library_management_system.entities.Patron;
import com.task.library_management_system.repos.BookRepo;
import com.task.library_management_system.repos.PatronRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatronService {
    @Autowired
    private PatronRepo patronRepo;
    public List<PatronDto> getPatron() {
        List<Patron> patronFromDB = patronRepo.findAll();

        return patronFromDB.stream().map(PatronDto::from).collect(Collectors.toList());
    }

    public PatronDto getPatronById(Integer id) {
        Patron patron = patronRepo.findById(id).orElseThrow(() -> new RuntimeException("No Book is founded"));

        return PatronDto.from(patron);
    }

    public  void UpdatePatron(PatronDto patronDto,Integer id) {
        Patron patron = patronRepo.findById(id).orElseThrow(() -> new RuntimeException("No Book is founded"));
        Patron UpdatedPatron = Patron.from(patronDto);
        patronRepo.save(UpdatedPatron);
    }
    public void DeletePatron(Integer id) {
        patronRepo.deleteById(id);
    }
    public void addPatron(PatronDto patronDto) {
        Patron CreatedPatron = Patron.from(patronDto);
        patronRepo.save(CreatedPatron);

    }
}
