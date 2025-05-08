package com.example.Event_Management.controller;


import com.example.Event_Management.Dto.BookingsInfoDto;
import com.example.Event_Management.model.Bookings;
import com.example.Event_Management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book-event/{userId}")
    public ResponseEntity<?> bookEvent(@PathVariable long userId, @RequestParam long eventId){

        try{
           return ResponseEntity.ok(bookService.bookEvent(userId, eventId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/show-book-result/{userId}")
    public ResponseEntity<?> showBookings(@PathVariable long userId){
        try{
            List<BookingsInfoDto> userBookings = bookService.showBookings(userId);
            return ResponseEntity.ok(userBookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
