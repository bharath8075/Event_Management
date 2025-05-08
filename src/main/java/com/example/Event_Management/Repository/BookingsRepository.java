package com.example.Event_Management.Repository;

import com.example.Event_Management.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {

    List<Bookings> findByUserId(long userId);

    Bookings findByUserIdAndEventId(long userId, long eventId);
}
