package com.task.library_management_system.controllers;

import com.task.library_management_system.dtos.BookDto;
import com.task.library_management_system.dtos.PatronDto;
import com.task.library_management_system.services.BookService;
import com.task.library_management_system.services.PatronService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<PatronDto> getPatron(){
        return patronService.getPatron();
    }

    @GetMapping("/{id}")
    public PatronDto getPatronById(@PathVariable Integer id){

        return  patronService.getPatronById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatron(@Valid @RequestBody PatronDto patronDto, @PathVariable Integer id){
        patronService.UpdatePatron(patronDto,id);
        return ResponseEntity.ok("Patron Updated");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatron(@PathVariable Integer id){
        patronService.DeletePatron(id);
        return ResponseEntity.ok("Patron Deleted");
    }
    @PostMapping
    public ResponseEntity<String> addPatron(@Valid @RequestBody PatronDto patronDto){
        try{

            patronService.addPatron(patronDto);
            return ResponseEntity.ok("Patron added");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
