package com.example.bookMyShow.service;
import java.util.List;
import java.util.Optional;

import com.example.bookMyShow.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.example.bookMyShow.models.Show;
import com.example.bookMyShow.models.User;
import com.example.bookMyShow.models.ShowSeat;
import com.example.bookMyShow.models.Booking;
import com.example.bookMyShow.repositories.ShowRepository;
import com.example.bookMyShow.repositories.UserRepository;
@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    @Autowired
    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }
    @Transactional(isolation=Isolation.SERIALIZABLE)
    public Booking bookTicket(List<Long>  showSeatIds,
                              Long showIds,
                              Long userIds)
    {
        Optional<User> userOptional = userRepository.findById(userIds);
        if(userOptional.isEmpty())
        {
            throw new RuntimeException("User not found");
        }
        User bookedBy = userOptional.get();
        Optional<Show> showOptional = showRepository.findById(showIds);
        if(showOptional.isEmpty())
        {
            throw new RuntimeException("Show does not exist! ");
        }
        Show savedShow = showOptional.get();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeats)
        {
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.EMPTY))
        }
        return null;
    }
}
