package com.example.bookMyShow.service;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import com.example.bookMyShow.models.*;
import com.example.bookMyShow.repositories.BookingRepository;
import com.example.bookMyShow.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.example.bookMyShow.repositories.ShowRepository;
import com.example.bookMyShow.repositories.UserRepository;
@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    @Autowired
    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }
    @Transactional(isolation=Isolation.SERIALIZABLE)
    public Booking bookTicket(List<Long>  showSeatIds,
                              Long showIds,
                              Long userIds) {
        Optional<User> userOptional = userRepository.findById(userIds);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User bookedBy = userOptional.get();
        Optional<Show> showOptional = showRepository.findById(showIds);
        if (showOptional.isEmpty()) {
            throw new RuntimeException("Show does not exist! ");
        }
        Show savedShow = showOptional.get();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for (ShowSeat showSeat : showSeats) {
            if (!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.EMPTY) ||
                    (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) &&
                            Duration.between(showSeat.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes() > 15)))
                throw new RuntimeException("Not all selected seats are available");
        }
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeats)
        {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
            showSeatRepository.save(showSeat);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        Booking booking = new Booking();
        booking.setBookedAt(new Date());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShow(savedShow);
        booking.setUser(bookedBy);
        booking.setShowSeats(savedShowSeats);
        booking.setAmount(0);
        booking.setPayment(new ArrayList<>());
        //booking.setShowSeats(showSeats);
        return bookingRepository.save(booking);


    }
}
