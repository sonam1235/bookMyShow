package com.example.bookMyShow.repositories;

import com.example.bookMyShow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Booking save(Booking entity);


}
