package com.example.bookMyShow.controllers;

import com.example.bookMyShow.dtos.BookMovieRequestDTO;
import com.example.bookMyShow.dtos.BookMovieResponseDTO;
import com.example.bookMyShow.dtos.ResponseStatus;
import com.example.bookMyShow.models.Booking;
import com.example.bookMyShow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

    @Controller
    public class BookingController {
        BookingService bookingService;

        @Autowired
        public BookingController(BookingService bookingService){
            this.bookingService = bookingService;
        }
        public BookMovieResponseDTO bookTicket(BookMovieRequestDTO bookMovieRequestDTO){
            BookMovieResponseDTO response = new BookMovieResponseDTO();
            try {
                Booking booking = bookingService.bookTicket(
                        bookMovieRequestDTO.getShowSeatIds(),
                        bookMovieRequestDTO.getShowId(),
                        bookMovieRequestDTO.getUserId().getId()
                );
                response.setBookingId(booking.getId())
                        .setAmount(booking.getAmount())
                        .setResponseStatus(ResponseStatus.SUCCESS);
            } catch (Exception ex){
                response.setResponseStatus(ResponseStatus.FAILURE);
            }
            return response;
        }
    }
}
