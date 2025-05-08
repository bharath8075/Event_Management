package com.example.Event_Management.service;

import com.example.Event_Management.Dto.BookingsInfoDto;
import com.example.Event_Management.Repository.BookingsRepository;
import com.example.Event_Management.Repository.EventRepository;
import com.example.Event_Management.Repository.UserRepository;
import com.example.Event_Management.model.Bookings;
import com.example.Event_Management.model.Event;
import com.example.Event_Management.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BookingsRepository bookingsRepo;

    @Autowired
    private EventRepository eventRepo;

    public String bookEvent(long userId, long eventId) {

        Bookings books = bookingsRepo.findByUserIdAndEventId(userId, eventId);
        if(books != null){
            throw new RuntimeException("You have already booked this concert");
        }

        Optional<User> optUser = userRepo.findById(userId);
        if(optUser.isEmpty()){
            throw new RuntimeException("User Not found");
        }

        Optional<Event> optEvent = eventRepo.findById(eventId);
        if(optEvent.isEmpty()){
            throw new RuntimeException("Event Not found");
        }

        Bookings book = new Bookings();
        book.setEventId(eventId);
        book.setUser(optUser.get());
        bookingsRepo.save(book);

        return "Event booked successfully";
    }

    public BookingsInfoDto showBookings(long userId) {
        Optional<User> optUser = userRepo.findById(userId);
        if(optUser.isEmpty()){
            throw new RuntimeException("User Not found");
        }

//        List<Bookings> usersAllBookings = bookingsRepo.findByUserId(userId);
//        List<BookingsInfoDto> userBookings = new ArrayList<>();
//        for( Bookings bookings : usersAllBookings){
//            BookingsInfoDto userBooks = new BookingsInfoDto();
//            userBooks.setUsername(bookings.getUser().getName());
//            Optional<Event> optEvent = eventRepo.findById(bookings.getEventId());
//            userBooks.setEventname(optEvent.get().getName());
//
//            userBookings.add(userBooks);
//        }
//        return userBookings;

        List<Bookings> usersAllBookings = bookingsRepo.findByUserId(userId);
        List<String> eventNames = new ArrayList<>();

        for(Bookings books : usersAllBookings){
            Optional<Event> optEvent = eventRepo.findById(books.getEventId());
            if(optEvent.isPresent()){
            eventNames.add(optEvent.get().getName());
            } else {
                eventNames.add("Unknown Event");
            }
        }
        BookingsInfoDto userBookingsInfo = new BookingsInfoDto(
                optUser.get().getId(),
                optUser.get().getName(),
                 eventNames);
        return userBookingsInfo;
    }
}
